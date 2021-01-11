package ProyectoFG.modelo.dominio.hechizo;

import java.util.HashMap;
import java.util.Objects;

import ProyectoFG.modelo.dominio.accion.TiempoRecuperacion;
import ProyectoFG.modelo.dominio.clase.TipoClase;

public class EspacioConjuro {

	private NivelHechizo nivelEspacioHechizo;
	private int cantidadEspaciosHechizo;
	private int cantidadActualEspacios;
	private HashMap<TipoClase, Integer> cantidadHechizosParaAprender;
	private TiempoRecuperacion tiempoRecuperacion;

	public EspacioConjuro(NivelHechizo nivelHechizo, int cantidad, int cantidadActual, TipoClase clase,
			int cantidadHechizosParaAprender, TiempoRecuperacion tiempo) {
		setNivelEspacioHechizo(nivelHechizo);
		setCantidadEspaciosHechizo(cantidad);
		setCantidadActualEspacios(cantidadActual);
		HashMap<TipoClase, Integer> mapa = new HashMap<>();
		mapa.put(clase, cantidadHechizosParaAprender);
		setCantidadHechizosParaAprender(mapa);
		setTiempoRecuperacion(tiempo);
	}

	public EspacioConjuro(EspacioConjuro espacioConjuro) {
		setNivelEspacioHechizo(espacioConjuro.getNivelEspacioHechizo());
		setCantidadEspaciosHechizo(espacioConjuro.getCantidadEspaciosHechizo());
		setCantidadActualEspacios(espacioConjuro.getCantidadActualEspacios());
		setCantidadHechizosParaAprender(espacioConjuro.getCantidadHechizosParaAprender());
		setTiempoRecuperacion(espacioConjuro.getTiempoRecuperacion());
	}

	public NivelHechizo getNivelEspacioHechizo() {
		return nivelEspacioHechizo;
	}

	private void setNivelEspacioHechizo(NivelHechizo nivelEspacioHechizo) {
		if (nivelEspacioHechizo == null) {
			throw new IllegalArgumentException("El nivel de un Espacio de Hechizo no puede ser nulo.");
		} else {
			this.nivelEspacioHechizo = nivelEspacioHechizo;
		}
	}

	public int getCantidadEspaciosHechizo() {
		return cantidadEspaciosHechizo;
	}

	private void setCantidadEspaciosHechizo(int cantidadEspaciosHechizo) {
		if (cantidadEspaciosHechizo < 0) {
			throw new IllegalArgumentException(
					"La cantidad de espacios que puede tener un nivel de espacios de hechizo no puede ser menor que 0.");
		} else {
			this.cantidadEspaciosHechizo = cantidadEspaciosHechizo;
		}
	}

	public int getCantidadActualEspacios() {
		return cantidadActualEspacios;
	}

	private void setCantidadActualEspacios(int cantidadActualEspacios) {
		this.cantidadActualEspacios = cantidadActualEspacios;
	}

	public HashMap<TipoClase, Integer> getCantidadHechizosParaAprender() {
		return cantidadHechizosParaAprender;
	}

	private void setCantidadHechizosParaAprender(HashMap<TipoClase, Integer> cantidadHechizosParaAprender) {
		this.cantidadHechizosParaAprender = cantidadHechizosParaAprender;
	}

	public TiempoRecuperacion getTiempoRecuperacion() {
		return tiempoRecuperacion;
	}

	private void setTiempoRecuperacion(TiempoRecuperacion tiempoRecuperacion) {
		if (tiempoRecuperacion == null) {
			throw new IllegalArgumentException("El tiempo de recuperación de un espacio de conjuro no puede ser nulo.");
		} else {
			this.tiempoRecuperacion = tiempoRecuperacion;
		}
	}

	public void aumentarCapacidadHechizosParaAprender(TipoClase claseAumento, int aumento) {
		if (aumento <= 0) {
			throw new IllegalArgumentException(
					"El mínimo de cantidad para aumentar los hechizos que se puede aprender es 1.");
		} else {
			if (!this.cantidadHechizosParaAprender.containsKey(claseAumento)) {
				this.cantidadHechizosParaAprender.put(claseAumento, aumento);
			} else {
				int nuevaCantidad = getCantidadHechizosParaAprender().get(claseAumento) + aumento;
				this.cantidadHechizosParaAprender.put(claseAumento, nuevaCantidad);
			}
		}
	}

	public void decrementarCapacidadHechizosParaAprender(TipoClase claseDecremento, int decremento) {
		if (decremento <= 0) {
			throw new IllegalArgumentException(
					"El mínimo de cantidad para decrementar los hechizos que se puede aprender es 1.");
		} else {
			if (!this.cantidadHechizosParaAprender.containsKey(claseDecremento)) {
				this.cantidadHechizosParaAprender.put(claseDecremento, decremento);
			} else {
				int nuevaCantidad = getCantidadHechizosParaAprender().get(claseDecremento) - decremento;
				this.cantidadHechizosParaAprender.put(claseDecremento, nuevaCantidad);
			}
		}
	}

	public boolean comprobarEspacios() {
		if (getNivelEspacioHechizo() == NivelHechizo.TRUCO) {
			return true;
		} else {
			if (getCantidadActualEspacios() == 0) {
				return false;
			} else {
				return true;
			}
		}
	}

	public void consumirEspacio() {
		if (getCantidadActualEspacios() == 0) {
			throw new IllegalArgumentException(
					"No se pueden consumir mas espacios de conjuro de este nivel, no quedan.");
		} else {
			this.cantidadActualEspacios--;
		}
	}

	public void recargarEspacios() {
		setCantidadActualEspacios(getCantidadEspaciosHechizo());
	}

	@Override
	public int hashCode() {
		return Objects.hash(nivelEspacioHechizo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EspacioConjuro other = (EspacioConjuro) obj;
		return nivelEspacioHechizo == other.nivelEspacioHechizo;
	}

	@Override
	public String toString() {
		return "EspacioConjuro [Espacio=" + nivelEspacioHechizo + ", Cantidad máxima de Espacios="
				+ cantidadEspaciosHechizo + ", Cantidad restante de espacios=" + cantidadActualEspacios
				+ ", Quedan por aprender=" + cantidadHechizosParaAprender + ", Se recuperan en="
				+ tiempoRecuperacion + "]";
	}

	

}
