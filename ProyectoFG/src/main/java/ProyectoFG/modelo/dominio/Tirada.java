package ProyectoFG.modelo.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tirada {
	// Atributos
	private Dado dado;
	private int numeroVeces;
	private int resultado;
	private int bonificador;
	private List<Integer> tiradas;

	// ER para comprobar el comando para lanzar dado
	private static final String ER_DADO = "(\\d+d\\d+)";

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
			setDado(new Dado(Integer.parseInt(cadenas[1])));
			this.tiradas = new ArrayList<Integer>();
		}
	}

	// Getter y setter
	public Dado getDado() {
		return dado;
	}

	private void setDado(Dado dado) {
		this.dado = dado;
	}

	public int getBonificador() {
		return this.bonificador;
	}

	private void setBonificador(int bonificador) {
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
		setResultado(total + getBonificador());
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
		return "Tirada [" + mensajeTiradas + getBonificador() + " Resultado = " + getResultado() + "]";
	}

}
