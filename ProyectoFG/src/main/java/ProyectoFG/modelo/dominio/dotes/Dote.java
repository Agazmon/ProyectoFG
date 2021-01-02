package ProyectoFG.modelo.dominio.dotes;

import java.util.List;

import ProyectoFG.modelo.dominio.Atributo;
import ProyectoFG.modelo.dominio.Caracteristica;
import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.competencia.TipoCompetencia;
import ProyectoFG.modelo.dominio.contador.Contador;

public class Dote {
	TipoDote tipoDote;
	String descripcion;
	List<String> puntos;
	List<Caracteristica> requisitoCaracteristica;
	boolean requisitoCapacidadLanzarConjuro;

	public Dote(TipoDote tipoDote, String descripcion) {
		setTipoDote(tipoDote);
		setDescripcion(descripcion);
	}

	public Dote(TipoDote tipoDote, String descripcion, List<String> puntos) {
		setTipoDote(tipoDote);
		setDescripcion(descripcion);
		setPuntos(puntos);
	}

	public Dote(Dote dote) {
		setTipoDote(dote.getTipoDote());
		setDescripcion(dote.getDescripcion());
		setPuntos(dote.getPuntos());
	}

	public void setTipoDote(TipoDote tipoDote) {
		if (tipoDote == null) {
			throw new IllegalArgumentException("El nombre de una dote no puede ser nulo.");
		} else {
			this.tipoDote = tipoDote;
		}

	}

	public TipoDote getTipoDote() {
		return tipoDote;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		if (descripcion == null) {
			throw new IllegalArgumentException("La descripcion de una dote no puede ser nulo.");
		} else if (descripcion.isBlank()) {
			throw new IllegalArgumentException("La descripcion de una dote no puede estar vacío.");
		} else {
			this.descripcion = descripcion;
		}
	}

	public List<String> getPuntos() {
		return puntos;
	}

	public void setPuntos(List<String> puntos) {
		this.puntos = puntos;
	}

	// false no cumple la dote, true cumple la dote y se han añadido los daots
	public boolean aplicarDote(Personaje pj, int extra) {
		if (pj.getDotes().buscar(getTipoDote()) != null) {
			throw new IllegalArgumentException("La dote ya ha sido aplicada al personaje.");
		} else {
			boolean anadir = false;
			String mensajeFallo = "";
			String mensajeAdvertencia = "";
			switch (getTipoDote()) {
			case ACECHADOR:
				if (pj.getCaracteristicas().buscar(Atributo.DESTREZA).getPuntuacion() >= 13) {
					anadir = true;
				} else
					mensajeFallo += "El personaje no tiene cumple el requisito de puntuación de destreza: Mínimo 13.";
			case ACTOR:
				if (pj.getCaracteristicas().buscar(Atributo.CARISMA).getPuntuacion() < 20) {
					pj.getCaracteristicas().buscar(Atributo.CARISMA).aumentarCaracteristica(1);
					anadir = true;
				} else {
					anadir = true;
					mensajeAdvertencia += "No se ha aplicado la subida de característica pero el resto de condiciones si se aplican.";
				}
				break;
			case AFORTUNADO:
				if (pj.getContadores().buscar("Afortunado") == null) {
					pj.getContadores().anadir(new Contador("Afortunado", 3, 3));
					anadir = true;
				} else {
					mensajeFallo += "El personaje ya tiene un contador llamado Afortunado";
				}
				break;
			case ALERTA:
				pj.setIniciativa(pj.getIniciativa() + 5);
				anadir = true;
				break;
			case APRESADOR:
				if (pj.getCaracteristicas().buscar(Atributo.FUERZA).getPuntuacion() >= 13) {
					anadir = true;
				} else {
					mensajeFallo += "El personaje no tiene cumple el requisito de puntuación de Fuerza: Mínimo 13.";
				}
				break;
			case ATACANTE_A_LA_CARGA:
				anadir = true;
				// TODO hacer los modificadores de daño
				break;
			case ATLETA:
				if (extra == 0) {
					if (pj.getCaracteristicas().buscar(Atributo.FUERZA).getPuntuacion() >= 20) {
						mensajeAdvertencia += "No se va a aumentar el atributo de Fuerza porque ya está al máximo. Pero se aplica el resto de la dote. ";
					} else {
						pj.getCaracteristicas().buscar(Atributo.FUERZA).aumentarCaracteristica(1);
					}
					anadir = true;

				} else if (extra == 1) {
					if (pj.getCaracteristicas().buscar(Atributo.DESTREZA).getPuntuacion() >= 20) {
						mensajeAdvertencia += "No se va a aumentar el atributo de Fuerza porque ya está al máximo. Pero se aplica el resto de la dote. ";
					} else {
						pj.getCaracteristicas().buscar(Atributo.DESTREZA).aumentarCaracteristica(1);
					}
					anadir = true;
				} else {
					mensajeFallo += "El parámetro para seleccionar entre fuerza o destreza para la subida de característica no ha sido bien proporcionado";
				}
				break;
				
			case COMBATIENTE_CON_DOS_ARMAS:
				
				break;
				
				
			case ATACANTE_SALVAJE:
			case AZOTE_DE_MAGOS:
			case CENTINELA:
				anadir = true;
				break;
			
			case COMBATIENTE_MONTADO:
				break;
			case DUELISTA_DEFENSIVO:
				break;
			case DURO:
				break;
			case EXPERTO_EN_BALLESTAS:
				break;
			case EXPLORADOR_DE_MAZMORRAS:
				break;
			case HABILIDOSO:
				break;
			case INICIADO_EN_LA_MAGIA:
				break;
			case LANZADOR_EN_COMBATE:
				break;
			case LANZADOR_PRECISO:
				break;
			case LANZADOR_RITUAL:
				break;
			case LIDER_INSPIRADOR:
				break;
			case LIGERAMENTE_ACORAZADO:
				break;
			case LINGUISTA:
				break;
			case MAESTRO_DE_ARMAS:
				break;
			case MAESTRO_EN_ARMADURAS_MEDIAS:
				break;
			case MAESTRO_EN_ARMADURAS_PESADAS:
				break;
			case MAESTRO_EN_ARMAS_DE_ASTA:
				break;
			case MAESTRO_EN_ARMAS_PESADAS:
				break;
			case MAESTRO_EN_ESCUDOS:
				break;
			case MATON_DE_TABERNA:
				break;
			case MENTE_AGUDA:
				break;
			case MODERADAMENTE_ACORAZADO:
				break;
			case MOVIL:
				break;
			case MUY_ACORAZADO:
				break;
			case OBSERVADOR:
				break;
			case RESILIENTE:
				break;
			case RESISTENTE:
				break;
			case SANADOR:
				break;
			case TIRADOR_DE_PRIMERA:
				break;
			case VERSADO_EN_LAS_ARMAS:
				break;
			case VERSADO_EN_UN_ELEMENTO:
				break;
			default:
				break;
			}
			if (anadir) {
				pj.getDotes().anadir(new Dote(getTipoDote(), getDescripcion()));
			}
			return anadir;
		}

	}
}
