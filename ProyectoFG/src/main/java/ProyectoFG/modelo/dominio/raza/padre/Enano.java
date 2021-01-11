package ProyectoFG.modelo.dominio.raza.padre;

import ProyectoFG.modelo.dominio.Atributo;
import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.competencia.TipoCompetencia;
import ProyectoFG.modelo.dominio.dote.DoteRacial;
import ProyectoFG.modelo.dominio.dote.TipoDote;
import ProyectoFG.modelo.dominio.idioma.TipoIdioma;
import ProyectoFG.modelo.dominio.raza.Raza;
import ProyectoFG.modelo.dominio.raza.TamanoRaza;

public abstract class Enano extends Raza {
	private TipoCompetencia competenciaHerramientaObtenida;

	protected Enano(Personaje personaje, String subraza, TipoCompetencia competenciaHerramienta) {
		super(personaje, "Enano", subraza, TamanoRaza.MEDIANA);
		setCompetenciaHerramientaObtenida(competenciaHerramienta);
	}

	private TipoCompetencia getCompetenciaHerramientaObtenida() {
		return competenciaHerramientaObtenida;
	}

	private void setCompetenciaHerramientaObtenida(TipoCompetencia competenciaHerramientaObtenida) {
		if (competenciaHerramientaObtenida == null) {
			throw new IllegalArgumentException("La competencia obtenida por la Raza no puede ser nula");
		} else {
			if (competenciaHerramientaObtenida != TipoCompetencia.HERRAMIENTAS_ALBAÑIL
					&& competenciaHerramientaObtenida != TipoCompetencia.HERRAMIENTAS_HERRERO
					&& competenciaHerramientaObtenida != TipoCompetencia.HERRAMIENTAS_CERVECERO) {
				throw new IllegalArgumentException(
						"La únicas competencias que puede obtener el personaje son de: Herramientas de Albañil, Herramientas de Herrero o Suministros de Cervecero");
			} else {
				this.competenciaHerramientaObtenida = competenciaHerramientaObtenida;
			}
		}

	}

	@Override
	protected void aplicarRaciales() {
		if (!isRacialesAplicadas()) {
			setRacialesAplicadas(true);
			Personaje personaje = getPersonaje();
			personaje.getDotes().anadir(new DoteRacial(TipoDote.MEJORA_CARACTERISTICA,"Tu puntuación de Constitución aumenta en 2."));
			if(personaje.getCaracteristicas().buscar(Atributo.CONSTITUCION).getPuntuacion()<19) {
				personaje.getCaracteristicas().buscar(Atributo.CONSTITUCION).aumentarCaracteristica(1);
			}
			if(personaje.getCaracteristicas().buscar(Atributo.CONSTITUCION).getPuntuacion()<20) {
				personaje.getCaracteristicas().buscar(Atributo.CONSTITUCION).aumentarCaracteristica(1);
			}
			personaje.setVelocidad(25);
			personaje.getDotes().anadir(new DoteRacial(TipoDote.VISION_EN_LA_OSCURIDAD,
					"Acostumbrado a la vida bajo tierra, puedes ver bien en la oscuridad o con poca luz. Eres capaz de percibir hasta a 60 pies en luz tenue como si hubiera luz brillante, y esa misma distancia en la oscuridad como si hubiera luz tenue. Eso sí, no puedes distinguir colores en la oscuridad, solo tonos de gris.",
					personaje));
			personaje.getDotes().anadir(new DoteRacial(TipoDote.RESISTENCIA_ENANA,
					"Tienes ventaja en las tiradas de salvación contra veneno y posees resitencia al daño de veneno.",
					personaje));
			personaje.getDotes().anadir(new DoteRacial(TipoDote.ENTRENAMIENTO_DE_COMBATE_ENANO,
					"Eres competente con hachas de guerra, hachas de mano, martillos de guerra y martillos ligeros.",
					personaje));
			
			personaje.getCompetencias().aumentarMaximoCompetencias(1);
			personaje.getCompetencias().ganarCompetencia(getCompetenciaHerramientaObtenida());
			personaje.getDotes().anadir(new DoteRacial(TipoDote.COMPETENCIA_HERRAMIENTAS,"Eres competente con las herramientas de artesano que elijas de entre las siguientes: Herramientas de albañil, herramientas de herrero o suministros de cervecero", personaje));
			personaje.getDotes().anadir(new DoteRacial(TipoDote.AFINIDAD_PIEDRA,"Cuando hagas una prueba de Inteligencia (Historia) que tenga relación con el origen de un trabajo en piedra, se te considerará competente en la ahbilidad Historia y añadirás dos veces tu bonificador por competencia a la tirada, en lugar de solo una. Tendrás que realizar la tirada correspondiente y luego sumarle el doble de tu bonificador por competencia.",personaje));
			personaje.getDotes().anadir(new DoteRacial(TipoDote.IDIOMAS_RACIALES,"Puedes hablar, leer y escribir en común y enano. El idioma enano está lleno de consonantes duras y sonidos guturales, y estas peculiaridades se traslucen en la forman que tienen los enanos de pronunciar cualquier otro lenguaje que conozcan.", personaje));
			personaje.getIdiomas().aumentarNumeroMaximoIdiomas(2);
			personaje.getIdiomas().anadir(TipoIdioma.ENANO);
			personaje.getIdiomas().anadir(TipoIdioma.COMUN);
		} else {
			throw new IllegalArgumentException("Las raciales ya han sido aplicadas al personaje.");
		}
	}

	@Override
	public String toString() {
		return "Enano [competenciaHerramientaObtenida=" + competenciaHerramientaObtenida + ", nombreRaza=" + nombreRaza
				+ ", nombreSubraza=" + nombreSubraza + ", tamanoRaza=" + tamanoRaza + "]";
	}

	

	

}
