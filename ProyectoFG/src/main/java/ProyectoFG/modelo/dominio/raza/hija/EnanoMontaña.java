package ProyectoFG.modelo.dominio.raza.hija;

import ProyectoFG.modelo.dominio.Atributo;
import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.competencia.TipoCompetencia;
import ProyectoFG.modelo.dominio.dote.DoteRacial;
import ProyectoFG.modelo.dominio.dote.TipoDote;
import ProyectoFG.modelo.dominio.raza.padre.Enano;

public class EnanoMontaña extends Enano {

	protected EnanoMontaña(Personaje personaje, TipoCompetencia competenciaHerramienta) {
		super(personaje, "Enano de las montañas", competenciaHerramienta);
		aplicarRaciales();
	}
	@Override
	protected void aplicarRaciales() {
		if(!isSubracialesAplicadas()) {
			setSubracialesAplicadas(true);
			Personaje personaje = getPersonaje();
			personaje.getDotes().anadir(new DoteRacial(TipoDote.MEJORA_CARACTERISTICA_SUBRAZA, "Tu puntuación de Fuerza aumenta en 2. Máximo 20."));
			if(personaje.getCaracteristicas().buscar(Atributo.FUERZA).getPuntuacion()<19) {
				personaje.getCaracteristicas().buscar(Atributo.FUERZA).aumentarCaracteristica(1);
			}
			if(personaje.getCaracteristicas().buscar(Atributo.FUERZA).getPuntuacion()<20) {
				personaje.getCaracteristicas().buscar(Atributo.FUERZA).aumentarCaracteristica(1);
			}
			personaje.getDotes().anadir(new DoteRacial(TipoDote.ENTRENAMIENTO_CON_ARMADURAS_ENANAS, "Eres competente con armaduras ligeras y medias."));
			personaje.getCompetencias().aumentarMaximoCompetencias(2);
			personaje.getCompetencias().ganarCompetencia(TipoCompetencia.ARMADURA_LIGERA);
			personaje.getCompetencias().ganarCompetencia(TipoCompetencia.ARMADURA_MEDIA);
			super.aplicarRaciales();
		} else {
			throw new IllegalArgumentException("Las subraciales ya han sido aplicadas al personaje.");
		}
	}
	
}
