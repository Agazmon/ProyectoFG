package ProyectoFG.modelo.dominio.dote;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import ProyectoFG.modelo.dominio.Atributo;
import ProyectoFG.modelo.dominio.Caracteristica;
import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.TipoDano;
import ProyectoFG.modelo.dominio.accion.TiempoRecuperacion;
import ProyectoFG.modelo.dominio.arma.Arma;
import ProyectoFG.modelo.dominio.arma.PropiedadesArma;
import ProyectoFG.modelo.dominio.arma.TipoArma;
import ProyectoFG.modelo.dominio.clase.TipoClase;
import ProyectoFG.modelo.dominio.competencia.TipoCompetencia;
import ProyectoFG.modelo.dominio.contador.Contador;
import ProyectoFG.modelo.dominio.contador.ContadorRecuperacion;
import ProyectoFG.modelo.dominio.contador.TipoContador;
import ProyectoFG.modelo.dominio.hechizo.NivelHechizo;
import ProyectoFG.modelo.dominio.moneda.Moneda;
import ProyectoFG.modelo.dominio.moneda.TipoMoneda;
import ProyectoFG.modelo.dominio.salvacion.TipoSalvacion;
import ProyectoFG.modelo.dominio.tirada.Dado;
import ProyectoFG.modelo.dominio.tirada.Tirada;

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
							"El personaje ya tiene la dote Maestro de Armas. No puede volver a cogerla con otro tipo.");
				}
			}
			if (getTipoDote() == TipoDote.MATON_DE_TABERNA_CONSTITUCION
					|| getTipoDote() == TipoDote.MATON_DE_TABERNA_FUERZA) {
				if (pj.getDotes().buscar(TipoDote.MATON_DE_TABERNA_CONSTITUCION) != null
						|| pj.getDotes().buscar(TipoDote.MATON_DE_TABERNA_FUERZA) != null) {
					throw new IllegalArgumentException(
							"El personaje ya tiene la dote Matón de Taberna. No puede volver a cogerla con otro tipo.");
				}
			}
			if (getTipoDote() == TipoDote.OBSERVADOR_INTELIGENCIA || getTipoDote() == TipoDote.OBSERVADOR_SABIDURIA) {
				if (pj.getDotes().buscar(TipoDote.OBSERVADOR_INTELIGENCIA) != null
						|| pj.getDotes().buscar(TipoDote.OBSERVADOR_SABIDURIA) != null) {
					throw new IllegalArgumentException(
							"El personaje ya tiene la dote Observador. No puede volver a cogerla con otro tipo.");
				}
			}
			if (getTipoDote() == TipoDote.RESILIENTE_FUERZA || getTipoDote() == TipoDote.RESILIENTE_DESTREZA
					|| getTipoDote() == TipoDote.RESILIENTE_CONSTITUCION
					|| getTipoDote() == TipoDote.RESILIENTE_INTELIGENCIA
					|| getTipoDote() == TipoDote.RESILIENTE_SABIDURIA || getTipoDote() == TipoDote.RESILIENTE_CARISMA) {
				if (pj.getDotes().buscar(TipoDote.RESILIENTE_FUERZA) != null
						|| pj.getDotes().buscar(TipoDote.RESILIENTE_DESTREZA) != null
						|| pj.getDotes().buscar(TipoDote.RESILIENTE_CONSTITUCION) != null
						|| pj.getDotes().buscar(TipoDote.RESILIENTE_INTELIGENCIA) != null
						|| pj.getDotes().buscar(TipoDote.RESILIENTE_SABIDURIA) != null
						|| pj.getDotes().buscar(TipoDote.RESILIENTE_CARISMA) != null) {
					throw new IllegalArgumentException("El personaje ya tiene la dote de Resiliente. No puede volver a cogerla con otro tipo.");
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
			} else if (pj.getCaracteristicas().buscar(Atributo.FUERZA).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.FUERZA).aumentarCaracteristica(1);
			}
			pj.getDotes().anadir(new Dote(this));
			break;
		case ATLETA_FUERZA:
			if (pj.getCaracteristicas().buscar(Atributo.FUERZA).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.FUERZA).aumentarCaracteristica(1);
			} else if (pj.getCaracteristicas().buscar(Atributo.DESTREZA).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.DESTREZA).aumentarCaracteristica(1);
			}
			pj.getDotes().anadir(new Dote(this));
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
			pj.getCompetencias().ganarCompetencia(TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS);
			pj.getDotes().anadir(new Dote(this));
			break;
		case INICIADO_EN_LA_MAGIA_BRUJO:
			pj.getEspaciosPersonaje().buscar(NivelHechizo.TRUCO).aumentarCapacidadHechizosParaAprender(TipoClase.BRUJO,
					2);
			pj.getEspaciosPersonaje().buscar(NivelHechizo.NIVEL_1)
					.aumentarCapacidadHechizosParaAprender(TipoClase.BRUJO, 1);
			pj.getCompetencias().ganarCompetencia(TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS);
			pj.getDotes().anadir(new Dote(this));
			break;
		case INICIADO_EN_LA_MAGIA_CLERIGO:
			pj.getEspaciosPersonaje().buscar(NivelHechizo.TRUCO)
					.aumentarCapacidadHechizosParaAprender(TipoClase.CLERIGO, 2);
			pj.getEspaciosPersonaje().buscar(NivelHechizo.NIVEL_1)
					.aumentarCapacidadHechizosParaAprender(TipoClase.CLERIGO, 1);
			pj.getCompetencias().ganarCompetencia(TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS);
			pj.getDotes().anadir(new Dote(this));
			break;
		case INICIADO_EN_LA_MAGIA_DRUIDA:
			pj.getEspaciosPersonaje().buscar(NivelHechizo.TRUCO).aumentarCapacidadHechizosParaAprender(TipoClase.DRUIDA,
					2);
			pj.getEspaciosPersonaje().buscar(NivelHechizo.NIVEL_1)
					.aumentarCapacidadHechizosParaAprender(TipoClase.DRUIDA, 1);
			pj.getCompetencias().ganarCompetencia(TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS);
			pj.getDotes().anadir(new Dote(this));
			break;
		case INICIADO_EN_LA_MAGIA_HECHICERO:
			pj.getEspaciosPersonaje().buscar(NivelHechizo.TRUCO)
					.aumentarCapacidadHechizosParaAprender(TipoClase.HECHICERO, 2);
			pj.getEspaciosPersonaje().buscar(NivelHechizo.NIVEL_1)
					.aumentarCapacidadHechizosParaAprender(TipoClase.HECHICERO, 1);
			pj.getCompetencias().ganarCompetencia(TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS);
			pj.getDotes().anadir(new Dote(this));
			break;
		case INICIADO_EN_LA_MAGIA_MAGO:
			pj.getEspaciosPersonaje().buscar(NivelHechizo.TRUCO).aumentarCapacidadHechizosParaAprender(TipoClase.MAGO,
					2);
			pj.getEspaciosPersonaje().buscar(NivelHechizo.NIVEL_1).aumentarCapacidadHechizosParaAprender(TipoClase.MAGO,
					1);
			pj.getCompetencias().ganarCompetencia(TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS);
			pj.getDotes().anadir(new Dote(this));
			break;
		case LIGERAMENTE_ACORAZADO_DESTREZA:
			if (pj.getCaracteristicas().buscar(Atributo.DESTREZA).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.DESTREZA).aumentarCaracteristica(1);
			} else if (pj.getCaracteristicas().buscar(Atributo.FUERZA).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.FUERZA).aumentarCaracteristica(1);
			}
			pj.getCompetencias().aumentarMaximoCompetencias(1);
			pj.getCompetencias().ganarCompetencia(TipoCompetencia.ARMADURA_LIGERA);
			pj.getDotes().anadir(new Dote(this));
			break;
		case LIGERAMENTE_ACORAZADO_FUERZA:
			if (pj.getCaracteristicas().buscar(Atributo.FUERZA).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.FUERZA).aumentarCaracteristica(1);
			} else if (pj.getCaracteristicas().buscar(Atributo.DESTREZA).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.DESTREZA).aumentarCaracteristica(1);
			}
			pj.getCompetencias().aumentarMaximoCompetencias(1);
			pj.getCompetencias().ganarCompetencia(TipoCompetencia.ARMADURA_LIGERA);
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
			if (pj.getCaracteristicas().buscar(Atributo.DESTREZA).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.DESTREZA).aumentarCaracteristica(1);
			} else if (pj.getCaracteristicas().buscar(Atributo.FUERZA).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.FUERZA).aumentarCaracteristica(1);
			}
			pj.getCompetencias().aumentarMaximoCompetencias(4);
			pj.getDotes().anadir(new Dote(this));
			break;
		case MAESTRO_EN_ARMAS_DE_ASTA:
			pj.getInventarioPersonaje()
					.anadirObjeto(new Arma("Lado opuesto del arma", 0, 1, new Moneda(TipoMoneda.MONEDA_COBRE, 0),
							TipoCompetencia.ARMAS_DE_ASTA, TipoCompetencia.ARMAS_MARCIALES, TipoArma.CUERPO_A_CUERPO,
							TipoDano.CONTUNDENTE, Arrays.asList(PropiedadesArma.LADO_OPUESTO),
							new Tirada(new Dado(4))));
			pj.getDotes().anadir(new Dote(this));
			break;
		case MATON_DE_TABERNA_CONSTITUCION:
			if (pj.getCaracteristicas().buscar(Atributo.CONSTITUCION).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.CONSTITUCION).aumentarCaracteristica(1);
			} else if (pj.getCaracteristicas().buscar(Atributo.FUERZA).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.FUERZA).aumentarCaracteristica(1);
			}
			pj.getCompetencias().aumentarMaximoCompetencias(1);
			pj.getCompetencias().ganarCompetencia(TipoCompetencia.ARMAS_IMPROVISADAS);
			pj.getInventarioPersonaje()
					.anadirObjeto(new Arma("Ataque sin armas", 0, 1, new Moneda(TipoMoneda.MONEDA_COBRE, 0),
							TipoCompetencia.ARMAS_IMPROVISADAS, TipoCompetencia.ARMAS_IMPROVISADAS,
							TipoArma.CUERPO_A_CUERPO, TipoDano.CONTUNDENTE, null, new Tirada(new Dado(4))));
			pj.getDotes().anadir(new Dote(this));
			break;
		case MATON_DE_TABERNA_FUERZA:
			if (pj.getCaracteristicas().buscar(Atributo.FUERZA).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.FUERZA).aumentarCaracteristica(1);
			} else if (pj.getCaracteristicas().buscar(Atributo.CONSTITUCION).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.CONSTITUCION).aumentarCaracteristica(1);
			}
			pj.getCompetencias().aumentarMaximoCompetencias(1);
			pj.getCompetencias().ganarCompetencia(TipoCompetencia.ARMAS_IMPROVISADAS);
			pj.getInventarioPersonaje()
					.anadirObjeto(new Arma("Ataque sin armas", 0, 1, new Moneda(TipoMoneda.MONEDA_COBRE, 0),
							TipoCompetencia.ARMAS_IMPROVISADAS, TipoCompetencia.ARMAS_IMPROVISADAS,
							TipoArma.CUERPO_A_CUERPO, TipoDano.CONTUNDENTE, null, new Tirada(new Dado(4))));
			pj.getDotes().anadir(new Dote(this));
			break;
		case MENTE_AGUDA:
			if (pj.getCaracteristicas().buscar(Atributo.INTELIGENCIA).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.INTELIGENCIA).aumentarCaracteristica(1);
			}
			pj.getDotes().anadir(new Dote(this));
			break;
		case MOVIL:
			pj.setVelocidad(pj.getVelocidad() + 10);
			pj.getDotes().anadir(new Dote(this));
			break;
		case OBSERVADOR_INTELIGENCIA:
			if (pj.getCaracteristicas().buscar(Atributo.INTELIGENCIA).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.INTELIGENCIA).aumentarCaracteristica(1);
			} else if (pj.getCaracteristicas().buscar(Atributo.SABIDURIA).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.SABIDURIA).aumentarCaracteristica(1);
			}
			pj.getDotes().anadir(new Dote(this));
			break;
		case OBSERVADOR_SABIDURIA:
			if (pj.getCaracteristicas().buscar(Atributo.SABIDURIA).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.SABIDURIA).aumentarCaracteristica(1);
			} else if (pj.getCaracteristicas().buscar(Atributo.INTELIGENCIA).getPuntuacion() < 20) {
				pj.getCaracteristicas().buscar(Atributo.INTELIGENCIA).aumentarCaracteristica(1);
			}
			pj.getDotes().anadir(new Dote(this));
			break;
		case RESILIENTE_FUERZA:
			if(pj.getSalvaciones().buscar(TipoSalvacion.SALVACION_FUERZA).isCompetencia() && pj.getCaracteristicas().buscar(Atributo.FUERZA).getPuntuacion()==20) {
				throw new IllegalArgumentException("Ya eres competente con la salvación de Fuerza y tienes al máximo la puntuación de Fuerza, escoge otra dote.");
			}
			if(pj.getCaracteristicas().buscar(Atributo.FUERZA).getPuntuacion()<20) {
				pj.getCaracteristicas().buscar(Atributo.FUERZA).aumentarCaracteristica(1);
			}
			pj.getSalvaciones().buscar(TipoSalvacion.SALVACION_FUERZA).setCompetencia(true);
			pj.getDotes().anadir(new Dote(this));
			break;
		case RESILIENTE_DESTREZA:
			if(pj.getSalvaciones().buscar(TipoSalvacion.SALVACION_DESTREZA).isCompetencia() && pj.getCaracteristicas().buscar(Atributo.DESTREZA).getPuntuacion()==20) {
				throw new IllegalArgumentException("Ya eres competente con la salvación de Destreza y tienes al máximo la puntuación de Destreza, escoge otra dote.");
			}
			if(pj.getCaracteristicas().buscar(Atributo.DESTREZA).getPuntuacion()<20) {
				pj.getCaracteristicas().buscar(Atributo.DESTREZA).aumentarCaracteristica(1);
			}
			pj.getSalvaciones().buscar(TipoSalvacion.SALVACION_DESTREZA).setCompetencia(true);
			pj.getDotes().anadir(new Dote(this));
			break;
		case RESILIENTE_CONSTITUCION:
			if(pj.getSalvaciones().buscar(TipoSalvacion.SALVACION_CONSTITUCION).isCompetencia() && pj.getCaracteristicas().buscar(Atributo.CONSTITUCION).getPuntuacion()==20) {
				throw new IllegalArgumentException("Ya eres competente con la salvación de Constitución y tienes al máximo la puntuación de Constitución, escoge otra dote.");
			}
			if(pj.getCaracteristicas().buscar(Atributo.CONSTITUCION).getPuntuacion()<20) {
				pj.getCaracteristicas().buscar(Atributo.CONSTITUCION).aumentarCaracteristica(1);
			}
			pj.getSalvaciones().buscar(TipoSalvacion.SALVACION_CONSTITUCION).setCompetencia(true);
			pj.getDotes().anadir(new Dote(this));
			break;
		case RESILIENTE_INTELIGENCIA:
			if(pj.getSalvaciones().buscar(TipoSalvacion.SALVACION_INTELIGENCIA).isCompetencia() && pj.getCaracteristicas().buscar(Atributo.INTELIGENCIA).getPuntuacion()==20) {
				throw new IllegalArgumentException("Ya eres competente con la salvación de Inteligencia y tienes al máximo la puntuación de Inteligencia, escoge otra dote.");
			}
			if(pj.getCaracteristicas().buscar(Atributo.INTELIGENCIA).getPuntuacion()<20) {
				pj.getCaracteristicas().buscar(Atributo.INTELIGENCIA).aumentarCaracteristica(1);
			}
			pj.getSalvaciones().buscar(TipoSalvacion.SALVACION_INTELIGENCIA).setCompetencia(true);
			pj.getDotes().anadir(new Dote(this));
			break;
		case RESILIENTE_SABIDURIA:
			if(pj.getSalvaciones().buscar(TipoSalvacion.SALVACION_SABIDURIA).isCompetencia() && pj.getCaracteristicas().buscar(Atributo.SABIDURIA).getPuntuacion()==20) {
				throw new IllegalArgumentException("Ya eres competente con la salvación de Sabiduría y tienes al máximo la puntuación de Sabiduría, escoge otra dote.");
			}
			if(pj.getCaracteristicas().buscar(Atributo.SABIDURIA).getPuntuacion()<20) {
				pj.getCaracteristicas().buscar(Atributo.SABIDURIA).aumentarCaracteristica(1);
			}
			pj.getSalvaciones().buscar(TipoSalvacion.SALVACION_SABIDURIA).setCompetencia(true);
			pj.getDotes().anadir(new Dote(this));
			break;
		case RESILIENTE_CARISMA:
			if(pj.getSalvaciones().buscar(TipoSalvacion.SALVACION_CARISMA).isCompetencia() && pj.getCaracteristicas().buscar(Atributo.CARISMA).getPuntuacion()==20) {
				throw new IllegalArgumentException("Ya eres competente con la salvación de Carisma y tienes al máximo la puntuación de Carisma, escoge otra dote.");
			}
			if(pj.getCaracteristicas().buscar(Atributo.CARISMA).getPuntuacion()<20) {
				pj.getCaracteristicas().buscar(Atributo.CARISMA).aumentarCaracteristica(1);
			}
			pj.getSalvaciones().buscar(TipoSalvacion.SALVACION_CARISMA).setCompetencia(true);
			pj.getDotes().anadir(new Dote(this));
			break;
		case RESISTENTE:
			if(pj.getCaracteristicas().buscar(Atributo.CONSTITUCION).getPuntuacion()<20) {
				pj.getCaracteristicas().buscar(Atributo.CONSTITUCION).aumentarCaracteristica(1);
			}
			pj.getDotes().anadir(new Dote(this));
			break;
		case VERSADO_EN_LAS_ARMAS:
			pj.getManiobrasPersonaje().aumentarCantidadRestanteManiobrasPorAprender(2);
			if(pj.getManiobrasPersonaje().getDadoSupremacia().equals(new Dado(1))) {
				pj.getManiobrasPersonaje().anadirDadoSupremacia(new Dado(6));
				pj.getManiobrasPersonaje().anadirCantidadDadoSupremacia(1);
			}
			pj.getDotes().anadir(new Dote(this));
			break;
		case ALERTA:
		case ATACANTE_A_LA_CARGA:
		case ATACANTE_SALVAJE:
		case AZOTE_DE_MAGOS:
		case CENTINELA:
		case COMBATIENTE_MONTADO:
		case EXPLORADOR_DE_MAZMORRAS:
		case MAESTRO_EN_ARMAS_PESADAS:
		case MAESTRO_EN_ESCUDOS:
		case SANADOR:
			// Do nothing, solo contiene texto.
		case COMBATIENTE_CON_DOS_ARMAS:
		case TIRADOR_DE_PRIMERA:
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
