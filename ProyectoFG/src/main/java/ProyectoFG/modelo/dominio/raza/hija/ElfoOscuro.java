package ProyectoFG.modelo.dominio.raza.hija;

import ProyectoFG.modelo.dao.bibliotecas.BibliotecaHechizos;
import ProyectoFG.modelo.dominio.Atributo;
import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.clase.TipoClase;
import ProyectoFG.modelo.dominio.competencia.TipoCompetencia;
import ProyectoFG.modelo.dominio.dote.DoteRacial;
import ProyectoFG.modelo.dominio.dote.TipoDote;
import ProyectoFG.modelo.dominio.hechizo.Hechizo;
import ProyectoFG.modelo.dominio.raza.padre.Elfo;

public class ElfoOscuro extends Elfo {

	protected ElfoOscuro(Personaje personaje) {
		super(personaje, "Elfo Oscuro (Drow)");
		aplicarRaciales();
	}
	@Override
	protected void aplicarRaciales() {
		if (!isSubracialesAplicadas()) {
			setSubracialesAplicadas(true);
			Personaje personaje = getPersonaje();
			personaje.getDotes().anadir(new DoteRacial(TipoDote.MEJORA_CARACTERISTICA_SUBRAZA,"Tu puntuación de Carisma aumenta en 1. Máximo 20."));
			if(personaje.getCaracteristicas().buscar(Atributo.CARISMA).getPuntuacion()<20) {
				personaje.getCaracteristicas().buscar(Atributo.CARISMA).aumentarCaracteristica(1);
			}
			personaje.getDotes().anadir(new DoteRacial(TipoDote.VISION_EN_LA_OSCURIDAD_MEJORADA,"Tu vVisión en la Oscuridad posee un radio de 120 pies."));
			personaje.getDotes().anadir(new DoteRacial(TipoDote.SENSIBILIDAD_A_LA_LUZ_SOLAR,"Tienes desventaja en las tiradas de ataque y las pruebas de Sabiduría (Percepción) que dependan de la vista realizadas cuando tú , el objetivo de tu ataque o lo que sea que intentas percibir esté bajo la luz solar directa."));
			personaje.getDotes().anadir(new DoteRacial(TipoDote.MAGIA_DROW,"Conoces el truco luces danzantes.. Cuando llegas a nivel 3, puedes lanzar el conjuro fuego feérico una vez usando este atributo y recuperas la capacidad para hacerlo tras realizar un descanso largo. Cuando alcanzas el nivel 5, eres ccapaz de lanza el conjuro oscuridad una vez empleando este atributo y recuperas la capacidad para hacerlo tras realizar un descanso largo. El carisma es tu aptituod mágica para estos conjuros."));
			Hechizo lucesDanzantes = BibliotecaHechizos.buscar("Dancing Lights");
			personaje.getHechizos().anadir(lucesDanzantes, false, getPersonaje(), TipoClase.BARBARO);
			Hechizo fuegoFeerico = BibliotecaHechizos.buscar("Faerie Fire");
			personaje.getHechizos().prepararAnadirHechizoANivelX(fuegoFeerico,3);
			Hechizo oscuridad = BibliotecaHechizos.buscar("Darkness");
			personaje.getHechizos().prepararAnadirHechizoANivelX(oscuridad,5);
			personaje.getDotes().anadir(new DoteRacial(TipoDote.ENTRENAMIENTO_ARMAS_DROW,"Eres competente con estoques y espadas cortas y ballesta de mano"));
			personaje.getCompetencias().buscar(TipoCompetencia.ESTOQUES).setCompetente(true);
			personaje.getCompetencias().buscar(TipoCompetencia.ESPADAS_CORTAS).setCompetente(true);
			personaje.getCompetencias().buscar(TipoCompetencia.BALLESTAS_DE_MANO).setCompetente(true);
			super.aplicarRaciales();
		} else {
			throw new IllegalArgumentException("Las subraciales ya han sido aplicadas al personaje.");
		}
		
	}

}
