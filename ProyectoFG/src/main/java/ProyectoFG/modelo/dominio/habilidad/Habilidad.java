package ProyectoFG.modelo.dominio.habilidad;

import java.util.Objects;

import ProyectoFG.modelo.dominio.Dado;
import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.Tirada;

public class Habilidad {

	private TipoHabilidad tipoHabilidad;
	private boolean competencia;

	// Constructores
	public Habilidad(TipoHabilidad habilidad) {
		setHabilidad(habilidad);
		setCompetencia(false);
	}

	public Habilidad(TipoHabilidad habilidad, boolean competencia) {
		setHabilidad(habilidad);
		setCompetencia(competencia);
	}

	public Habilidad(Habilidad habilidad) {
		setHabilidad(habilidad.getHabilidad());
		setCompetencia(habilidad.isCompetencia());
	}

	// GETTER Y SETTER

	public TipoHabilidad getHabilidad() {
		return tipoHabilidad;
	}

	private void setHabilidad(TipoHabilidad habilidad) {
		this.tipoHabilidad = habilidad;
	}

	public boolean isCompetencia() {
		return competencia;
	}

	public void setCompetencia(boolean competencia) {
		this.competencia = competencia;
	}

	// Funcionalidad
	public Tirada pruebaDeHabilidad(Personaje personaje) {
		Tirada tirada;
		if (isCompetencia()) {
			tirada = new Tirada(new Dado(20), 1, (personaje.getModificadorCompetencia()
					+ personaje.getCaracteristicas().buscar(getHabilidad().getAtributoRelacionado()).getModificador()));
		} else {
			tirada = new Tirada(new Dado(20), 1,
					personaje.getCaracteristicas().buscar(getHabilidad().getAtributoRelacionado()).getModificador());
		}
		tirada.tirar();
		return tirada;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tipoHabilidad);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Habilidad other = (Habilidad) obj;
		return tipoHabilidad == other.tipoHabilidad;
	}

	@Override
	public String toString() {
		String mensajeCompetencia = "";
		if (isCompetencia()) {
			mensajeCompetencia = "competente";
		} else {
			mensajeCompetencia = "sin competencia";
		}
		return "Habilidad [Habilidad=" + tipoHabilidad.getNombre() + ", competencia=" + mensajeCompetencia + "]";
	}

}
