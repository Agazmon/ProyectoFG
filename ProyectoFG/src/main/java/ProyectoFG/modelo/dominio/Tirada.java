package ProyectoFG.modelo.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tirada {
	// Atributos
	private Dado dado;
	private int numeroVeces;
	private int resultado;
	private Integer bonificador;
	private int resultadoConBonificador;
	private List<Integer> tiradas;

	// ER para comprobar el comando para lanzar dado
	private static final String ER_DADO = "(\\d+d\\d+((\\+|\\-)\\d+)*)";
	private static final String ER_DIVISION = "\\+|\\-)";

	// Constructores

	public Tirada(Dado dadoTirada, int numeroVeces) {
		setDado(dadoTirada);
		setNumeroVeces(numeroVeces);
		setBonificador(0);
		this.tiradas = new ArrayList<>();
	}

	public Tirada(Dado dadoTirada, int numeroVeces, int bonificador) {
		setDado(dadoTirada);
		setNumeroVeces(numeroVeces);
		setBonificador(bonificador);
		this.tiradas = new ArrayList<>();
	}

	public Tirada(String cadena) {
		if (!cadena.matches(ER_DADO)) {
			throw new IllegalArgumentException("La cadena para crear el dado no tiene un formato válido.");
		} else {
			String[] cadenas = cadena.split("d");
			setNumeroVeces(Integer.parseInt(cadenas[0]));
			//Coger primer numero despues de la d
			
			
			if(cadenas[1].contains("+")||cadenas[1].contains("-")) {
				//Esto esta mal
				String[] operadores =cadenas[1].split("\\d+");
				
				String[] numeros = cadenas[1].split("\\+|\\-");
				setDado(new Dado(Integer.parseInt(numeros[0])));
				calcular(operadores, numeros);
				
			} else {
				//No tiene modificadores
				setDado(new Dado(Integer.parseInt(cadenas[1])));
			}
			
			
			
		}
	}

	private void calcular(String[] operadores, String[] numeros) {
		int calculo = 0;
		//ESTO HAY QUE MIRARLO
		for (int i = 1; i < numeros.length; i++) {
			if(operadores[i].equals("-")) {
				calculo -= Integer.parseInt(numeros[i]);
			} else if(operadores[i].equals("+")) {
				calculo += Integer.parseInt(numeros[i]);
			} else {
				throw new IllegalArgumentException("Operador no válido");
			}
		}
		setBonificador(calculo);
		
	}

	// Getter y setter
	public Dado getDado() {
		return dado;
	}

	private void setDado(Dado dado) {
		this.dado = dado;
	}

	public Integer getBonificador() {
		return this.bonificador;
	}

	private void setBonificador(Integer bonificador) {
		this.bonificador = bonificador;
	}

	public int getNumeroVeces() {
		return numeroVeces;
	}

	public void setNumeroVeces(int numeroVeces) {
		if (numeroVeces <= 0) {
			throw new IllegalArgumentException("No se puede tirar un dado 0 veces o un numero de veces negativas.");
		} else {
			this.numeroVeces = numeroVeces;
		}
	}

	public int getResultado() {
		return this.resultado;
	}

	private void setResultado(int resultado) {
		this.resultado = resultado;
	}
	public int getResultadoConBonificador() {
		return this.resultadoConBonificador;
	}

	private void setResultadoConBonificador(int resultadoConBonificador) {
		this.resultadoConBonificador = resultadoConBonificador;
	}

	public List<Integer> getTiradas() {
		return this.tiradas;
	}

	private void setTiradas(List<Integer> tiradas) {
		this.tiradas = tiradas;
	}

	// Funcionalidad
	public void tirar() {
		int total = 0;
		List<Integer> tiradas = new ArrayList<>();
		for (int i = 1; i <= getNumeroVeces(); i++) {
			int iteracion = getDado().lanzar();
			tiradas.add(iteracion);
			total += iteracion;
		}
		setResultado(total);
		setResultadoConBonificador(total + getBonificador());
		setTiradas(tiradas);
	}

	@Override
	public int hashCode() {
		return Objects.hash(bonificador, dado, numeroVeces, resultado, tiradas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tirada other = (Tirada) obj;
		return bonificador == other.bonificador && Objects.equals(dado, other.dado) && numeroVeces == other.numeroVeces
				&& resultado == other.resultado && Objects.equals(tiradas, other.tiradas);
	}

	@Override
	public String toString() {
		String mensajeTiradas = "Tiradas: ";
		for (Integer integer : tiradas) {
			mensajeTiradas += integer + " + ";
		}
		if(getBonificador()!=null) {
			if(getBonificador()>0) {
				return "Tirada [" + mensajeTiradas + getBonificador() + " Resultado = " + getResultadoConBonificador() + "]";
			} else if(getBonificador()<0){
				int index = mensajeTiradas.lastIndexOf("+");
				mensajeTiradas = mensajeTiradas.substring(0,index-1);
				mensajeTiradas = mensajeTiradas.concat(" -");
				String modString = ""+getBonificador();
				modString = modString.substring(1,modString.length());
				return "Tirada [" + mensajeTiradas + " "+ modString + " Resultado = " + getResultadoConBonificador() + "]";
			} else {
				int index = mensajeTiradas.lastIndexOf("+");
				mensajeTiradas = mensajeTiradas.substring(0,index-1);
				return "Tirada [" + mensajeTiradas + " Resultado = " + getResultadoConBonificador() + "]";
			}
			
		} else {
			int index = mensajeTiradas.lastIndexOf("+");
			mensajeTiradas = mensajeTiradas.substring(0,index-1);
			return "Tirada [" + mensajeTiradas + " Resultado = " + getResultadoConBonificador() + "]";
		}
		
		
	}

}
