package ProyectoFG.modelo.dominio.tirada;

import java.util.Random;

public class Dado {
	private int numeroCaras;
	private Random aleatorio;

	public Dado(int numeroCaras) {
		iniciarAleatorio();
		setNumeroCaras(numeroCaras);
	}

	public Dado(Dado dado) {
		iniciarAleatorio();
		setNumeroCaras(dado.getCaras());
	}

	private void setNumeroCaras(int numeroCaras) {
		if (numeroCaras < 1) {
			throw new IllegalArgumentException("El número mínimo de caras para lanzar un dado es de 1.");
		} else if (numeroCaras >= 101) {
			throw new IllegalArgumentException("El número máximo de caras para lanzar un dado es de 100.");
		} else {
			this.numeroCaras = numeroCaras;
		}
	}

	public int getCaras() {
		return this.numeroCaras;
	}

	private void iniciarAleatorio() {
		this.aleatorio = new Random();
	}

	private Random getAleatorio() {
		return this.aleatorio;
	}

	public int lanzar() {
		return getAleatorio().nextInt(getCaras()) + 1;
	}

}
