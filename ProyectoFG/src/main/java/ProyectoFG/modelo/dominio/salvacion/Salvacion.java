package ProyectoFG.modelo.dominio.salvacion;

import java.util.Objects;

import ProyectoFG.modelo.dominio.Dado;
import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.Tirada;

/**
 * Salvacion.
 *
 * @author Alex Gázquez
 * @version 0.1
 * @since 24-12-2020
 */

public class Salvacion {

	private TipoSalvacion tipoSalvacion;
	private boolean competencia;

	// Constructores
	public Salvacion(TipoSalvacion salvacion) {
		setSalvacion(salvacion);
		setCompetencia(false);
	}

	public Salvacion(TipoSalvacion salvacion, boolean competencia) {
		setSalvacion(salvacion);
		setCompetencia(competencia);
	}

	public Salvacion(Salvacion salvacion) {
		setSalvacion(salvacion.getSalvacion());
		setCompetencia(salvacion.isCompetencia());
	}

	public TipoSalvacion getSalvacion() {
		return tipoSalvacion;
	}

	private void setSalvacion(TipoSalvacion salvacion) {
		this.tipoSalvacion = salvacion;
	}

	public boolean isCompetencia() {
		return competencia;
	}

	public void setCompetencia(boolean competencia) {
		this.competencia = competencia;
	}

	// Funcionalidad
	public Tirada pruebaDeSalvacion(Personaje personaje) {
		Tirada tirada;
		if (isCompetencia()) {
			tirada = new Tirada(new Dado(20), 1, (personaje.getModificadorCompetencia()
					+ personaje.getCaracteristicas().buscar(getSalvacion().getAtributoRelacionad()).getModificador()));
		} else {
			tirada = new Tirada(new Dado(20), 1,
					personaje.getCaracteristicas().buscar(getSalvacion().getAtributoRelacionad()).getModificador());
		}
		tirada.tirar();
		return tirada;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tipoSalvacion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salvacion other = (Salvacion) obj;
		return tipoSalvacion == other.tipoSalvacion;
	}

	@Override
	public String toString() {
		return "Salvacion [tipoSalvacion=" + tipoSalvacion + ", competencia=" + competencia + "]";
	}

}
