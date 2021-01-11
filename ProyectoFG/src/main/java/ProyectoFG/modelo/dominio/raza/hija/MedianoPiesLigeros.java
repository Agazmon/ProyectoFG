package ProyectoFG.modelo.dominio.raza.hija;

import ProyectoFG.modelo.dominio.Atributo;
import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.dote.DoteRacial;
import ProyectoFG.modelo.dominio.dote.TipoDote;
import ProyectoFG.modelo.dominio.raza.padre.Mediano;

public class MedianoPiesLigeros extends Mediano {

	protected MedianoPiesLigeros(Personaje personaje) {
		super(personaje, "Piesligeros");
		aplicarRaciales();
	}
	@Override
	protected void aplicarRaciales() {
		if(!isSubracialesAplicadas()) {
			setSubracialesAplicadas(true);
			Personaje personaje = getPersonaje();
			personaje.getDotes().anadir(new DoteRacial(TipoDote.MEJORA_CARACTERISTICA_SUBRAZA,"Tu puntuación de Carisma aumenta en 1. Máximo 20."));
			if(personaje.getCaracteristicas().buscar(Atributo.CARISMA).getPuntuacion()<20){
				personaje.getCaracteristicas().buscar(Atributo.CARISMA).aumentarCaracteristica(1);
			}
			personaje.getDotes().anadir(new DoteRacial(TipoDote.SIGILOSO_POR_NATURALEZA,"Puedes intentar esconderte incluso tras una criatura cuyo tamaño sea al menos una categoría superior al tuyo."));
			super.aplicarRaciales();
		} else {
			throw new IllegalArgumentException("Las subraciales ya han sido aplicadas al personaje.");
		}
	}

}
