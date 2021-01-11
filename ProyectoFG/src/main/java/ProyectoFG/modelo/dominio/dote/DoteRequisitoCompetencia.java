package ProyectoFG.modelo.dominio.dote;

import ProyectoFG.modelo.dominio.Atributo;
import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.clase.TipoClase;
import ProyectoFG.modelo.dominio.competencia.TipoCompetencia;
import ProyectoFG.modelo.dominio.hechizo.NivelHechizo;

public class DoteRequisitoCompetencia extends Dote {

	TipoCompetencia competenciaRequerida;

	public DoteRequisitoCompetencia(TipoDote tipoDote, String descripcion, TipoCompetencia competenciaRequerida) {
		super(tipoDote, descripcion);
		this.competenciaRequerida = competenciaRequerida;
	}

	public DoteRequisitoCompetencia(DoteRequisitoCompetencia dote) {
		super(dote.getTipoDote(), dote.getDescripcion());
		setCompetenciaRequerida(dote.getCompetenciaRequerida());
	}

	public TipoCompetencia getCompetenciaRequerida() {
		return competenciaRequerida;
	}

	public void setCompetenciaRequerida(TipoCompetencia competenciaRequerida) {
		if (competenciaRequerida == null) {
			throw new IllegalArgumentException(
					"La competencia requerida por una dote no puede ser nula. Para ello existen las dotes sin requisito de competencia.");
		} else {
			this.competenciaRequerida = competenciaRequerida;
		}
	}

	@Override
	public void anadirDote(Personaje pj) {
		if (comprobarRequisito(pj)) {
			aplicarDote(pj);
		}
	}

	@Override
	protected void aplicarDote(Personaje pj) {
		switch (getTipoDote()) {
		case MUY_ACORAZADO:
			if (pj.getCaracteristicas().buscar(Atributo.FUERZA).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.FUERZA).aumentarCaracteristica(1);
			}
			pj.getDotes().anadir(new DoteRequisitoCompetencia(this));
			break;
		case MODERADAMENTE_ACORAZADO_FUERZA:
			if (pj.getCaracteristicas().buscar(Atributo.FUERZA).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.FUERZA).aumentarCaracteristica(1);
			} else if (pj.getCaracteristicas().buscar(Atributo.DESTREZA).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.DESTREZA).aumentarCaracteristica(1);
			}
			pj.getCompetencias().aumentarMaximoCompetencias(2);
			pj.getCompetencias().ganarCompetencia(TipoCompetencia.ARMADURA_MEDIA);
			pj.getCompetencias().ganarCompetencia(TipoCompetencia.ESCUDOS);
			pj.getDotes().anadir(new DoteRequisitoCompetencia(this));
			break;
		case MODERADAMENTE_ACORAZADO_DESTREZA:
			if (pj.getCaracteristicas().buscar(Atributo.DESTREZA).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.DESTREZA).aumentarCaracteristica(1);
			} else if (pj.getCaracteristicas().buscar(Atributo.FUERZA).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.FUERZA).aumentarCaracteristica(1);
			}
			pj.getCompetencias().aumentarMaximoCompetencias(2);
			pj.getCompetencias().ganarCompetencia(TipoCompetencia.ARMADURA_MEDIA);
			pj.getCompetencias().ganarCompetencia(TipoCompetencia.ESCUDOS);
			pj.getDotes().anadir(new DoteRequisitoCompetencia(this));
			break;
		case MAESTRO_EN_ARMADURAS_PESADAS:
			if (pj.getCaracteristicas().buscar(Atributo.FUERZA).getPuntuacion() < 20) {
				pj.getCaracteristicas().aumentarCaracteristica(Atributo.FUERZA, 1);
			}
			break;
		case LANZADOR_PRECISO_BARDO:
			pj.getCompetencias().aumentarMaximoCompetencias(1);
			pj.getCompetencias().ganarCompetencia(TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS);
			pj.getEspacios().buscar(NivelHechizo.TRUCO).aumentarCapacidadHechizosParaAprender(TipoClase.BARDO,
					1);
			break;
		case LANZADOR_PRECISO_BRUJO:
			pj.getCompetencias().aumentarMaximoCompetencias(1);
			pj.getCompetencias().ganarCompetencia(TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS);
			pj.getEspacios().buscar(NivelHechizo.TRUCO).aumentarCapacidadHechizosParaAprender(TipoClase.BRUJO,
					1);
			break;
		case LANZADOR_PRECISO_CLERIGO:
			pj.getCompetencias().aumentarMaximoCompetencias(1);
			pj.getCompetencias().ganarCompetencia(TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS);
			pj.getEspacios().buscar(NivelHechizo.TRUCO)
					.aumentarCapacidadHechizosParaAprender(TipoClase.CLERIGO, 1);
			break;
		case LANZADOR_PRECISO_DRUIDA:
			pj.getCompetencias().aumentarMaximoCompetencias(1);
			pj.getCompetencias().ganarCompetencia(TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS);
			pj.getEspacios().buscar(NivelHechizo.TRUCO).aumentarCapacidadHechizosParaAprender(TipoClase.DRUIDA,
					1);
			break;
		case LANZADOR_PRECISO_HECHICERO:
			pj.getCompetencias().aumentarMaximoCompetencias(1);
			pj.getCompetencias().ganarCompetencia(TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS);
			pj.getEspacios().buscar(NivelHechizo.TRUCO)
					.aumentarCapacidadHechizosParaAprender(TipoClase.HECHICERO, 1);
			break;
		case LANZADOR_PRECISO_MAGO:
			pj.getCompetencias().aumentarMaximoCompetencias(1);
			pj.getCompetencias().ganarCompetencia(TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS);
			pj.getEspacios().buscar(NivelHechizo.TRUCO).aumentarCapacidadHechizosParaAprender(TipoClase.MAGO,
					1);
			break;
		// Dotes con requisito de competencia con solo texto
		case LANZADOR_EN_COMBATE:
			// Se encarga las propias armaduras de comprobarlo.
		case MAESTRO_EN_ARMADURAS_MEDIAS:
		case VERSADO_EN_UN_ELEMENTO_ACIDO:
		case VERSADO_EN_UN_ELEMENTO_FRIO:
		case VERSADO_EN_UN_ELEMENTO_FUEGO:
		case VERSADO_EN_UN_ELEMENTO_RELAMPAGO:
		case VERSADO_EN_UN_ELEMENTO_TRUENO:
		default:
			pj.getDotes().anadir(new DoteRequisitoCompetencia(this));
			break;
		}

	}

	public boolean comprobarRequisito(Personaje pj) {
		if (!pj.getCompetencias().buscar(getCompetenciaRequerida()).isCompetente()) {
			throw new IllegalArgumentException(
					"El personaje no es competente con el requisito de esta dote. El requisito de la dote es: "
							+ getCompetenciaRequerida().toString());
		} else {
			if (pj.getDotes().getListaDotes().contains(this)) {
				throw new IllegalArgumentException("El personaje no puede aprender dos veces esta dote.");
			} else {
				if (this.getTipoDote() == TipoDote.MODERADAMENTE_ACORAZADO_DESTREZA
						|| this.getTipoDote() == TipoDote.MODERADAMENTE_ACORAZADO_FUERZA) {
					if (pj.getDotes().buscar(TipoDote.MODERADAMENTE_ACORAZADO_DESTREZA) != null
							|| pj.getDotes().buscar(TipoDote.MODERADAMENTE_ACORAZADO_FUERZA) != null) {
						return false;
					} else {
						return true;
					}
				}
				if (this.getTipoDote() == TipoDote.LANZADOR_PRECISO_BARDO
						|| this.getTipoDote() == TipoDote.LANZADOR_PRECISO_BRUJO
						|| this.getTipoDote() == TipoDote.LANZADOR_PRECISO_CLERIGO
						|| this.getTipoDote() == TipoDote.LANZADOR_PRECISO_DRUIDA
						|| this.getTipoDote() == TipoDote.LANZADOR_PRECISO_HECHICERO
						|| this.getTipoDote() == TipoDote.LANZADOR_PRECISO_MAGO) {
					if (pj.getDotes().buscar(TipoDote.LANZADOR_PRECISO_BARDO) != null
							|| pj.getDotes().buscar(TipoDote.LANZADOR_PRECISO_BRUJO) != null
							|| pj.getDotes().buscar(TipoDote.LANZADOR_PRECISO_CLERIGO) != null
							|| pj.getDotes().buscar(TipoDote.LANZADOR_PRECISO_DRUIDA) != null
							|| pj.getDotes().buscar(TipoDote.LANZADOR_PRECISO_HECHICERO) != null
							|| pj.getDotes().buscar(TipoDote.LANZADOR_PRECISO_MAGO) != null) {
						throw new IllegalArgumentException("El personaje no puede aprender esta dote.");
					} else {
						return true;
					}
				} else {
					return true;
				}
			}
		}
	}

}
