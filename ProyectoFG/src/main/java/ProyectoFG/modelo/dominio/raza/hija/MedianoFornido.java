package ProyectoFG.modelo.dominio.raza.hija;

import ProyectoFG.modelo.dominio.Atributo;
import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.dote.DoteRacial;
import ProyectoFG.modelo.dominio.dote.TipoDote;
import ProyectoFG.modelo.dominio.raza.padre.Mediano;

public class MedianoFornido extends Mediano {

	protected MedianoFornido(Personaje personaje) {
		super(personaje, "Fornido");
		aplicarRaciales();
	}
	@Override
	protected void aplicarRaciales() {
		if(!isSubracialesAplicadas()) {
			setSubracialesAplicadas(true);
			Personaje personaje = getPersonaje();
			personaje.getDotes().anadir(new DoteRacial(TipoDote.MEJORA_CARACTERISTICA_SUBRAZA,"Tu puntuación de Constitución aumenta en 1. Máximo 20."));
			if(personaje.getCaracteristicas().buscar(Atributo.CONSTITUCION).getPuntuacion()<20){
				personaje.getCaracteristicas().buscar(Atributo.CONSTITUCION).aumentarCaracteristica(1);
			}
			personaje.getDotes().anadir(new DoteRacial(TipoDote.RESISTENCIA_FORNIDO,"Tienes ventaja en las tiradas de salvación contra veneno y posees resistencia al daño de veneno."));
			super.aplicarRaciales();
		} else {
			throw new IllegalArgumentException("Las subraciales ya han sido aplicadas al personaje.");
		}
	}

}
