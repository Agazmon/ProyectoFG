package ProyectoFG.modelo.dominio.tirada;

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
	private List<Resultado> resultadosConseguidos;
	private TipoTirada tipoTirada;

	// ER para comprobar el comando para lanzar dado
	private static final String ER_DADO = "(\\d+d\\d+((\\+|\\-)\\d+)*)";
	private static final String ER_DIVISION = "\\+|\\-)";

	// Constructores
	public Tirada(Dado dadoTirada, TipoTirada tipoTirada) {
		setDado(dadoTirada);
		setNumeroVeces(1);
		setBonificador(0);
		this.resultadosConseguidos = new ArrayList<>();
		setTipoTirada(tipoTirada);
	}

	public Tirada(Dado dadoTirada) {
		setDado(dadoTirada);
		setNumeroVeces(1);
		setBonificador(0);
		this.resultadosConseguidos = new ArrayList<>();
		setTipoTirada(TipoTirada.NEUTRA);
	}

	public Tirada(Dado dadoTirada, int numeroVeces, TipoTirada tipoTirada) {
		setDado(dadoTirada);
		setNumeroVeces(numeroVeces);
		setBonificador(0);
		this.resultadosConseguidos = new ArrayList<>();
		setTipoTirada(tipoTirada);
	}

	public Tirada(Dado dadoTirada, int numeroVeces) {
		setDado(dadoTirada);
		setNumeroVeces(numeroVeces);
		setBonificador(0);
		this.resultadosConseguidos = new ArrayList<>();
		setTipoTirada(TipoTirada.NEUTRA);
	}

	public Tirada(Dado dadoTirada, int numeroVeces, int bonificador, TipoTirada tipoTirada) {
		setDado(dadoTirada);
		setNumeroVeces(numeroVeces);
		setBonificador(bonificador);
		this.resultadosConseguidos = new ArrayList<>();
		setTipoTirada(tipoTirada);
	}

	public Tirada(Dado dadoTirada, int numeroVeces, int bonificador) {
		setDado(dadoTirada);
		setNumeroVeces(numeroVeces);
		setBonificador(bonificador);
		this.resultadosConseguidos = new ArrayList<>();
		setTipoTirada(TipoTirada.NEUTRA);
	}

	public Tirada(String cadena) {
		if (!cadena.matches(ER_DADO)) {
			throw new IllegalArgumentException("La cadena para crear el dado no tiene un formato válido.");
		} else {
			String[] cadenas = cadena.split("d");
			setNumeroVeces(Integer.parseInt(cadenas[0]));
			// Coger primer numero despues de la d

			if (cadenas[1].contains("+") || cadenas[1].contains("-")) {
				// Esto esta mal
				String[] operadores = cadenas[1].split("\\d+");

				String[] numeros = cadenas[1].split("\\+|\\-");
				setDado(new Dado(Integer.parseInt(numeros[0])));
				calcular(operadores, numeros);

			} else {
				// No tiene modificadores
				setDado(new Dado(Integer.parseInt(cadenas[1])));
			}

		}
	}
	public Tirada(Tirada tirada) {
		setDado(tirada.getDado());
		setNumeroVeces(tirada.getNumeroVeces());
		setBonificador(tirada.getBonificador());
		setResultadosConseguidos(tirada.getResultadosConseguidos());
		setTipoTirada(tirada.getTipoTirada());
	}

	private void calcular(String[] operadores, String[] numeros) {
		int calculo = 0;
		// ESTO HAY QUE MIRARLO
		for (int i = 1; i < numeros.length; i++) {
			if (operadores[i].equals("-")) {
				calculo -= Integer.parseInt(numeros[i]);
			} else if (operadores[i].equals("+")) {
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


	public List<Resultado> getResultadosConseguidos() {
		return resultadosConseguidos;
	}

	public void setResultadosConseguidos(List<Resultado> resultadosConseguidos) {
		this.resultadosConseguidos = resultadosConseguidos;
	}

	public TipoTirada getTipoTirada() {
		return tipoTirada;
	}

	public void setTipoTirada(TipoTirada tipoTirada) {
		this.tipoTirada = tipoTirada;
	}

	// Funcionalidad
	public void tirar() {
		int total = 0;
		int iteraciones = 1;
		switch (tipoTirada) {
		case DESVENTAJA:
		case VENTAJA:
			iteraciones = 2;
			break;
		case NEUTRA:
		default:
			iteraciones = 1;
			break;
		}
		for(int i=1; i<=iteraciones; i++) {
			List<Integer> tiradasRealizadas = new ArrayList<>();
			for(int j = 1; j<=getNumeroVeces();j++) {
				int tiradaIteracion = getDado().lanzar();
				tiradasRealizadas.add(tiradaIteracion);
			}
			resultadosConseguidos.add(new Resultado(tiradasRealizadas, getBonificador()));
		}
	}


	@Override
	public String toString() {
		String mensajeTiradas = "Tiradas: ";
		for (Resultado resultado : resultadosConseguidos) {
			for (Integer dado : resultado.getDadosSacados()) {
				mensajeTiradas += dado + " + ";
			}
			if (getBonificador() != null) {
				if (getBonificador() > 0) {
					return "Tirada [" + mensajeTiradas + getBonificador() + " Resultado = " + resultado.getResultado()
							+ "]";
				} else if (getBonificador() < 0) {
					int index = mensajeTiradas.lastIndexOf("+");
					mensajeTiradas = mensajeTiradas.substring(0, index - 1);
					mensajeTiradas = mensajeTiradas.concat(" -");
					String modString = "" + getBonificador();
					modString = modString.substring(1, modString.length());
					return "Tirada [" + mensajeTiradas + " " + modString + " Resultado = " + resultado.getResultado()
							+ "]";
				} else {
					int index = mensajeTiradas.lastIndexOf("+");
					mensajeTiradas = mensajeTiradas.substring(0, index - 1);
					return "Tirada [" + mensajeTiradas + " Resultado = " + resultado.getResultado() + "]";
				}

			} else {
				int index = mensajeTiradas.lastIndexOf("+");
				mensajeTiradas = mensajeTiradas.substring(0, index - 1);
				return "Tirada [" + mensajeTiradas + " Resultado = " + resultado.getResultado() + "]";
			}
		}
		return mensajeTiradas;
			
		
		

	}

}
