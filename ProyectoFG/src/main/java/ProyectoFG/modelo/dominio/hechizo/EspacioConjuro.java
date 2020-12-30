package ProyectoFG.modelo.dominio.hechizo;

import java.util.Objects;

public class EspacioConjuro {

	private NivelHechizo nivelEspacioHechizo;
	private int cantidadEspaciosHechizo;
	private int cantidadActualEspacios;

	public EspacioConjuro(NivelHechizo nivelHechizo, int cantidad, int cantidadActual) {
		setNivelEspacioHechizo(nivelHechizo);
		setCantidadEspaciosHechizo(cantidad);
		setCantidadActualEspacios(cantidadActual);
	}
	public EspacioConjuro(EspacioConjuro espacioConjuro) {
		setNivelEspacioHechizo(espacioConjuro.getNivelEspacioHechizo());
		setCantidadEspaciosHechizo(espacioConjuro.getCantidadEspaciosHechizo());
		setCantidadActualEspacios(espacioConjuro.getCantidadActualEspacios());
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
	
	public boolean comprobarEspacios() {
		if(getNivelEspacioHechizo()==NivelHechizo.TRUCO) {
			return true;
		} else {
			if(getCantidadActualEspacios()==0) {
				return false;
			} else {
				return true;
			}
		}
	}
	

	public void consumirEspacio() {
		if(getCantidadActualEspacios()==0) {
			throw new IllegalArgumentException("No se pueden consumir mas espacios de conjuro de este nivel, no quedan.");
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
		return "EspacioConjuro [Nivel del Espacio:" + nivelEspacioHechizo + ", Cantidad de espacios=" + cantidadActualEspacios + "]";
	}
	
	
}
