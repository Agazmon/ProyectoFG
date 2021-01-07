package ProyectoFG.modelo.dominio.accion;

import java.util.Objects;

public class Accion {
	private TipoAccion tipoAccion;
	private TipoOrigen origenAccion;
	private int cantidadUsosMaxima;
	private int cantidadUsosActuales;

	public Accion(TipoAccion tipoAccion, TipoOrigen origenAccion, int cantidadUsos) {
		setTipoAccion(tipoAccion);
		setOrigenAccion(origenAccion);
		setCantidadUsos(cantidadUsos);
		setCantidadUsosMaxima(cantidadUsos);
	}

	public Accion(TipoAccion tipoAccion, TipoOrigen origenAccion, int cantidadUsosActuales, int cantidadUsosMaxima) {
		setTipoAccion(tipoAccion);
		setOrigenAccion(origenAccion);
		setCantidadUsos(cantidadUsosActuales);
		setCantidadUsosMaxima(cantidadUsosMaxima);
	}

	public TipoAccion getTipoAccion() {
		return tipoAccion;
	}

	private void setTipoAccion(TipoAccion tipoAccion) {
		this.tipoAccion = tipoAccion;
	}

	public TipoOrigen getOrigenAccion() {
		return origenAccion;
	}

	private void setOrigenAccion(TipoOrigen origenAccion) {
		this.origenAccion = origenAccion;
	}

	public int getCantidadUsosMaxima() {
		return cantidadUsosMaxima;
	}

	private void setCantidadUsosMaxima(int cantidadUsosMaxima) {
		this.cantidadUsosMaxima = cantidadUsosMaxima;
	}

	public int getCantidadUsosActuales() {
		return cantidadUsosActuales;
	}

	private void setCantidadUsos(int cantidadUsosActuales) {
		this.cantidadUsosActuales = cantidadUsosActuales;
	}

	public void consumirAccion() {
		if (this.cantidadUsosActuales <= 0) {
			throw new IllegalArgumentException(
					"No se pueden consumir mas acciones de este tipo. No quedan, tendrás que esperar al siguiente turno.");
		} else {
			this.cantidadUsosActuales -= 1;
		}
	}

	public void recargarAcciones() {
		setCantidadUsos(getCantidadUsosMaxima());
	}

	public void aumentarCantidadDeUsosMaximo(int cantidad) {
		if (cantidad <= 0) {
			throw new IllegalArgumentException("La cantidad mínima de usos a incrementar es 1.");
		} else {
			setCantidadUsosMaxima(getCantidadUsosMaxima() + cantidad);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(tipoAccion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Accion other = (Accion) obj;
		return tipoAccion == other.tipoAccion;
	}
	

}
