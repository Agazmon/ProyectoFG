package ProyectoFG.modelo.dominio;

import java.util.Objects;

public class Caracteristica {
	private Atributo atributo;
	private int puntuacion;
	public static final int PUNTUACION_MINIMA = 1;
	public static final int PUNTUACION_MAXIMA = 30;

	// Constructor
	public Caracteristica(Atributo atributo, int puntuacion) {
		setAtributo(atributo);
		setPuntuacion(puntuacion);
	}

	// Constructor copia
	public Caracteristica(Caracteristica caracteristica) {
		setAtributo(caracteristica.getAtributo());
		setPuntuacion(caracteristica.getPuntuacion());
	}

	public Atributo getAtributo() {
		return atributo;
	}

	private void setAtributo(Atributo atributo) {
		if (atributo == null) {
			throw new IllegalArgumentException("Atributo no puede ser nulo, debe ser uno de los tipos existentes");
		} else {
			this.atributo = atributo;
		}

	}

	public int getPuntuacion() {
		return this.puntuacion;
	}

	private void setPuntuacion(int puntuacion) {
		if (puntuacion < PUNTUACION_MINIMA) {
			throw new IllegalArgumentException("La puntuación no puede ser menor de: " + PUNTUACION_MINIMA
					+ " la puntuación introducida fué: " + puntuacion);
		} else if (puntuacion > PUNTUACION_MAXIMA) {
			throw new IllegalArgumentException("La puntuación no puede ser mayor de: " + PUNTUACION_MAXIMA
					+ " la puntuación introducida fué: " + puntuacion);
		} else {
			this.puntuacion = puntuacion;
		}
	}

	public int getModificador() {
		switch (getPuntuacion()) {
		case 1:
			return -5;
		case 2:
		case 3:
			return -4;
		case 4:
		case 5:
			return -3;
		case 6:
		case 7:
			return -2;
		case 8:
		case 9:
			return -1;
		case 10:
		case 11:
			return 0;
		case 12:
		case 13:
			return 1;
		case 14:
		case 15:
			return 2;
		case 16:
		case 17:
			return 3;
		case 18:
		case 19:
			return 4;
		case 20:
		case 21:
			return 5;
		case 22:
		case 23:
			return 6;
		case 24:
		case 25:
			return 7;
		case 26:
		case 27:
			return 8;
		case 28:
		case 29:
			return 9;
		case 30:
			return 10;
		default:
			throw new IllegalArgumentException(
					"El valor de la puntuación no está contemplado, se sale de los limites supeior o inferior. El valor es:"
							+ getPuntuacion());
		}
	}

	// Método para aumentar o disminuir la característica
	public void modificarCaracteristica(int modificacion) {
		if (getPuntuacion() + modificacion > PUNTUACION_MAXIMA || getPuntuacion() + modificacion < PUNTUACION_MINIMA) {
			throw new IllegalArgumentException(
					"La modificación a la característica se sale de los límites establecidos");
		} else {
			setPuntuacion(getPuntuacion() + modificacion);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(atributo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Caracteristica other = (Caracteristica) obj;
		return atributo == other.atributo;
	}

	@Override
	public String toString() {
		return "Caracteristica [atributo=" + atributo + ", puntuacion=" + puntuacion + ", modificador="
				+ getModificador() + "]";
	}

}
