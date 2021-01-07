package ProyectoFG.modelo.dominio.habilidad;

import java.util.Objects;

import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.armadura.TipoArmadura;
import ProyectoFG.modelo.dominio.dote.TipoDote;
import ProyectoFG.modelo.dominio.tirada.Dado;
import ProyectoFG.modelo.dominio.tirada.TipoTirada;
import ProyectoFG.modelo.dominio.tirada.Tirada;

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
	public Tirada pruebaDeHabilidad(Personaje personaje, TipoTirada tipoTirada) {
		Tirada tirada;
		if (tipoTirada != TipoTirada.DESVENTAJA && getHabilidad() == TipoHabilidad.SIGILO)
			tipoTirada = comprobarSigilo(personaje, tipoTirada);
		if (isCompetencia()) {
			tirada = new Tirada(new Dado(20), 1, (personaje.getModificadorCompetencia()
					+ personaje.getCaracteristicas().buscar(getHabilidad().getAtributoRelacionado()).getModificador()),tipoTirada);
		} else {
			tirada = new Tirada(new Dado(20), 1,
					personaje.getCaracteristicas().buscar(getHabilidad().getAtributoRelacionado()).getModificador(),tipoTirada);
		}
		tirada.tirar();
		return tirada;
	}

	private TipoTirada comprobarSigilo(Personaje personaje, TipoTirada tipoTirada) {
		if (personaje.getArmadura() != null) {
			if (personaje.getArmadura().isDesventajaSigilo()) {
				if (personaje.getArmadura().getTipoArmadura() == TipoArmadura.ARMADURA_MEDIA) {
					if (personaje.getDotes().buscar(TipoDote.MAESTRO_EN_ARMADURAS_MEDIAS) == null) {
						if (tipoTirada == TipoTirada.VENTAJA) {
							tipoTirada = TipoTirada.NEUTRA;
						} else {
							tipoTirada = TipoTirada.DESVENTAJA;
						}
					}
				}
			}
		}
		return tipoTirada;
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
