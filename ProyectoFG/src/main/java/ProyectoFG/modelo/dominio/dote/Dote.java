package ProyectoFG.modelo.dominio.dote;

import java.util.List;
import java.util.Objects;

import ProyectoFG.modelo.dominio.Atributo;
import ProyectoFG.modelo.dominio.Caracteristica;
import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.accion.TiempoRecuperacion;
import ProyectoFG.modelo.dominio.clase.TipoClase;
import ProyectoFG.modelo.dominio.competencia.TipoCompetencia;
import ProyectoFG.modelo.dominio.contador.Contador;
import ProyectoFG.modelo.dominio.contador.ContadorRecuperacion;
import ProyectoFG.modelo.dominio.contador.TipoContador;
import ProyectoFG.modelo.dominio.hechizo.NivelHechizo;

public class Dote {
	TipoDote tipoDote;
	String descripcion;

	public Dote(TipoDote tipoDote, String descripcion) {
		setTipoDote(tipoDote);
		setDescripcion(descripcion);
	}

	public Dote(Dote dote) {
		setTipoDote(dote.getTipoDote());
		setDescripcion(dote.getDescripcion());
	}

	public TipoDote getTipoDote() {
		return tipoDote;
	}

	public void setTipoDote(TipoDote tipoDote) {
		if (tipoDote == null) {
			throw new IllegalArgumentException("El nombre de una dote no puede ser nulo.");
		} else {
			this.tipoDote = tipoDote;
		}

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

	public void anadirDote(Personaje pj) {
		if (pj == null) {
			throw new IllegalArgumentException("El personaje al que se le está intentando añadir la dote es nulo.");
		}
		if (pj.getDotes().buscar(getTipoDote()) != null) {
			throw new IllegalArgumentException("El personaje ya tiene la dote.");
		} else {
			if (getTipoDote() == TipoDote.ATLETA_DESTREZA || getTipoDote() == TipoDote.ATLETA_FUERZA) {
				if (pj.getDotes().buscar(TipoDote.ATLETA_DESTREZA) != null
						|| pj.getDotes().buscar(TipoDote.ATLETA_FUERZA) != null) {
					throw new IllegalArgumentException("El personaje ya tiene la dote de Atleta.");
				}
			}
			if (getTipoDote() == TipoDote.INICIADO_EN_LA_MAGIA_BARDO
					|| getTipoDote() == TipoDote.INICIADO_EN_LA_MAGIA_BRUJO
					|| getTipoDote() == TipoDote.INICIADO_EN_LA_MAGIA_CLERIGO
					|| getTipoDote() == TipoDote.INICIADO_EN_LA_MAGIA_DRUIDA
					|| getTipoDote() == TipoDote.INICIADO_EN_LA_MAGIA_HECHICERO
					|| getTipoDote() == TipoDote.INICIADO_EN_LA_MAGIA_MAGO) {
				if (pj.getDotes().buscar(TipoDote.INICIADO_EN_LA_MAGIA_BARDO) != null
						|| pj.getDotes().buscar(TipoDote.INICIADO_EN_LA_MAGIA_BRUJO) != null
						|| pj.getDotes().buscar(TipoDote.INICIADO_EN_LA_MAGIA_CLERIGO) != null
						|| pj.getDotes().buscar(TipoDote.INICIADO_EN_LA_MAGIA_DRUIDA) != null
						|| pj.getDotes().buscar(TipoDote.INICIADO_EN_LA_MAGIA_HECHICERO) != null
						|| pj.getDotes().buscar(TipoDote.INICIADO_EN_LA_MAGIA_MAGO) != null) {
					throw new IllegalArgumentException(
							"El personaje ya tiene la dote de Iniciado en la magia. No puede volver a cogerla con otro tipo.");
				}
			}
			if (getTipoDote() == TipoDote.LIGERAMENTE_ACORAZADO_DESTREZA
					|| getTipoDote() == TipoDote.LIGERAMENTE_ACORAZADO_FUERZA) {
				if (pj.getDotes().buscar(TipoDote.LIGERAMENTE_ACORAZADO_DESTREZA) != null
						|| pj.getDotes().buscar(TipoDote.LIGERAMENTE_ACORAZADO_FUERZA) != null) {
					throw new IllegalArgumentException(
							"El personaje ya tiene la dote de Ligeramente acorazado. No puede volver a cogerla con otro tipo.");
				}
			}
			if (getTipoDote() == TipoDote.MAESTRO_DE_ARMAS_DESTREZA
					|| getTipoDote() == TipoDote.MAESTRO_DE_ARMAS_FUERZA) {
				if (pj.getDotes().buscar(TipoDote.MAESTRO_DE_ARMAS_DESTREZA) != null
						|| pj.getDotes().buscar(TipoDote.MAESTRO_DE_ARMAS_FUERZA) != null) {
					throw new IllegalArgumentException(
							"El personaje ya tiene la dote Maestro de Armas. No pueve volver a cogerla con otro tipo.");
				}
			}
			aplicarDote(pj);
		}

	}

	protected void aplicarDote(Personaje pj) {
		if (pj == null) {
			throw new IllegalArgumentException("El personaje al que se le está intentando aplicar la dote es nulo.");
		}

		switch (getTipoDote()) {

		case ACTOR:
			if (pj.getCaracteristicas().buscar(Atributo.CARISMA).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.CARISMA).aumentarCaracteristica(1);
			}
			pj.getDotes().anadir(new Dote(this));
			break;
		case AFORTUNADO:
			if (pj.getContadores().buscar("Afortunado") != null) {
				throw new IllegalArgumentException(
						"No se puede añadir el contador de Afortuando, ya tienes uno con el mismo nombre.");
			} else {
				pj.getContadores().anadir(
						new ContadorRecuperacion("Dote", TipoContador.AFORTUNADO, TiempoRecuperacion.DESCANSO_LARGO));
				pj.getDotes().anadir(new Dote(this));
			}
			break;
		case ATLETA_DESTREZA:
			if (pj.getCaracteristicas().buscar(Atributo.DESTREZA).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.DESTREZA).aumentarCaracteristica(1);
				pj.getDotes().anadir(new Dote(this));
			} else if (pj.getCaracteristicas().buscar(Atributo.FUERZA).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.FUERZA).aumentarCaracteristica(1);
				pj.getDotes().anadir(new Dote(this));
			} else {
				pj.getDotes().anadir(new Dote(this));
				throw new IllegalArgumentException(
						"No se ha podido incrementar ninguna de las dos características ambas están al máximo pero el resto de la dote se aplica.");
			}
			break;
		case ATLETA_FUERZA:
			if (pj.getCaracteristicas().buscar(Atributo.FUERZA).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.FUERZA).aumentarCaracteristica(1);
				pj.getDotes().anadir(new Dote(this));
			} else if (pj.getCaracteristicas().buscar(Atributo.DESTREZA).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.DESTREZA).aumentarCaracteristica(1);
				pj.getDotes().anadir(new Dote(this));
			} else {
				pj.getDotes().anadir(new Dote(this));
				throw new IllegalArgumentException(
						"No se ha podido incrementar ninguna de las dos características ambas están al máximo pero el resto de la dote se aplica.");
			}
			break;
		case DURO:
			pj.setPuntosDeGolpeMaximos(pj.getPuntosDeGolpeMaximos() + (pj.getNivelPersonaje() * 2));
			pj.getDotes().anadir(new Dote(this));
			break;
		case INICIADO_EN_LA_MAGIA_BARDO:
			pj.getEspaciosPersonaje().buscar(NivelHechizo.TRUCO).aumentarCapacidadHechizosParaAprender(TipoClase.BARDO,
					2);
			pj.getEspaciosPersonaje().buscar(NivelHechizo.NIVEL_1)
					.aumentarCapacidadHechizosParaAprender(TipoClase.BARDO, 1);
			pj.getDotes().anadir(new Dote(this));
			break;
		case INICIADO_EN_LA_MAGIA_BRUJO:
			pj.getEspaciosPersonaje().buscar(NivelHechizo.TRUCO).aumentarCapacidadHechizosParaAprender(TipoClase.BRUJO,
					2);
			pj.getEspaciosPersonaje().buscar(NivelHechizo.NIVEL_1)
					.aumentarCapacidadHechizosParaAprender(TipoClase.BRUJO, 1);
			pj.getDotes().anadir(new Dote(this));
			break;
		case INICIADO_EN_LA_MAGIA_CLERIGO:
			pj.getEspaciosPersonaje().buscar(NivelHechizo.TRUCO)
					.aumentarCapacidadHechizosParaAprender(TipoClase.CLERIGO, 2);
			pj.getEspaciosPersonaje().buscar(NivelHechizo.NIVEL_1)
					.aumentarCapacidadHechizosParaAprender(TipoClase.CLERIGO, 1);
			pj.getDotes().anadir(new Dote(this));
			break;
		case INICIADO_EN_LA_MAGIA_DRUIDA:
			pj.getEspaciosPersonaje().buscar(NivelHechizo.TRUCO).aumentarCapacidadHechizosParaAprender(TipoClase.DRUIDA,
					2);
			pj.getEspaciosPersonaje().buscar(NivelHechizo.NIVEL_1)
					.aumentarCapacidadHechizosParaAprender(TipoClase.DRUIDA, 1);
			pj.getDotes().anadir(new Dote(this));
			break;
		case INICIADO_EN_LA_MAGIA_HECHICERO:
			pj.getEspaciosPersonaje().buscar(NivelHechizo.TRUCO)
					.aumentarCapacidadHechizosParaAprender(TipoClase.HECHICERO, 2);
			pj.getEspaciosPersonaje().buscar(NivelHechizo.NIVEL_1)
					.aumentarCapacidadHechizosParaAprender(TipoClase.HECHICERO, 1);
			pj.getDotes().anadir(new Dote(this));
			break;
		case INICIADO_EN_LA_MAGIA_MAGO:
			pj.getEspaciosPersonaje().buscar(NivelHechizo.TRUCO).aumentarCapacidadHechizosParaAprender(TipoClase.MAGO,
					2);
			pj.getEspaciosPersonaje().buscar(NivelHechizo.NIVEL_1).aumentarCapacidadHechizosParaAprender(TipoClase.MAGO,
					1);
			pj.getDotes().anadir(new Dote(this));
			break;
		case LIGERAMENTE_ACORAZADO_DESTREZA:
			if (pj.getCaracteristicas().buscar(Atributo.DESTREZA).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.DESTREZA).aumentarCaracteristica(1);
			} else if (pj.getCaracteristicas().buscar(Atributo.FUERZA).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.FUERZA).aumentarCaracteristica(1);
			}
			pj.getCompetencias().buscar(TipoCompetencia.ARMADURA_LIGERA).setCompetente(true);
			pj.getDotes().anadir(new Dote(this));
			break;
		case LIGERAMENTE_ACORAZADO_FUERZA:
			if (pj.getCaracteristicas().buscar(Atributo.FUERZA).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.FUERZA).aumentarCaracteristica(1);
			} else if (pj.getCaracteristicas().buscar(Atributo.DESTREZA).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.DESTREZA).aumentarCaracteristica(1);
			}
			pj.getCompetencias().buscar(TipoCompetencia.ARMADURA_LIGERA).setCompetente(true);
			pj.getDotes().anadir(new Dote(this));
			break;
		case LINGUISTA:
			if (pj.getCaracteristicas().buscar(Atributo.INTELIGENCIA).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.INTELIGENCIA).aumentarCaracteristica(1);
			}
			pj.getIdiomas().aumentarNumeroMaximoIdiomas(3);
			pj.getDotes().anadir(new Dote(this));
			break;
		case MAESTRO_DE_ARMAS_FUERZA:
			if (pj.getCaracteristicas().buscar(Atributo.FUERZA).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.FUERZA).aumentarCaracteristica(1);
			} else if (pj.getCaracteristicas().buscar(Atributo.DESTREZA).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.DESTREZA).aumentarCaracteristica(1);
			}
			pj.getCompetencias().aumentarMaximoCompetencias(4);
			pj.getDotes().anadir(new Dote(this));
			break;
		case MAESTRO_DE_ARMAS_DESTREZA:
			break;
		case ALERTA:
		case ATACANTE_A_LA_CARGA:
		case ATACANTE_SALVAJE:
		case AZOTE_DE_MAGOS:
		case CENTINELA:
		case COMBATIENTE_MONTADO:
		case EXPLORADOR_DE_MAZMORRAS:
			// Do nothing, solo contiene texto.
		case COMBATIENTE_CON_DOS_ARMAS:
			// Se encarga las armas y el personaje.
		case EXPERTO_EN_BALLESTAS:
			// Se encargan las armas a distancia.

		default:
			pj.getDotes().anadir(new Dote(this));
			break;
		}

	}

	@Override
	public int hashCode() {
		return Objects.hash(tipoDote);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Dote))
			return false;
		Dote other = (Dote) obj;
		return tipoDote == other.tipoDote;
	}

	@Override
	public String toString() {
		return "Dote [tipoDote=" + tipoDote + ", descripcion=" + descripcion + "]";
	}

}
