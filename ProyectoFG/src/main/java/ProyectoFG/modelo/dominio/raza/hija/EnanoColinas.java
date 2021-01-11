package ProyectoFG.modelo.dominio.raza.hija;

import ProyectoFG.modelo.dominio.Atributo;
import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.competencia.TipoCompetencia;
import ProyectoFG.modelo.dominio.dote.DoteRacial;
import ProyectoFG.modelo.dominio.dote.TipoDote;
import ProyectoFG.modelo.dominio.raza.padre.Enano;

public class EnanoColinas extends Enano {

	public EnanoColinas(Personaje personaje, TipoCompetencia competenciaHerramienta) {
		super(personaje, "Enano de las colinas", competenciaHerramienta);
		aplicarRaciales();
	}

	@Override
	protected void aplicarRaciales() {
		if (!isSubracialesAplicadas()) {
			setSubracialesAplicadas(true);
			Personaje personaje = getPersonaje();
			personaje.getDotes().anadir(
					new DoteRacial(TipoDote.MEJORA_CARACTERISTICA_SUBRAZA, "Tu puntuación de Sabiduría aumenta en 1."));
			if (personaje.getCaracteristicas().buscar(Atributo.SABIDURIA).getPuntuacion() < 20) {
				personaje.getCaracteristicas().buscar(Atributo.SABIDURIA).aumentarCaracteristica(1);
			}
			personaje.getDotes().anadir(new DoteRacial(TipoDote.AGUANTE_ENANO,
					"Tus puntos de golpe máximos se incrementan en 1, y aumentarán en 1 mas cada vez que subas un nivel."));
			personaje.setPuntosDeGolpeMaximos(personaje.getPuntosDeGolpeMaximos() + 1);
			super.aplicarRaciales();
		} else {
			throw new IllegalArgumentException("Las subraciales ya han sido aplicadas al personaje.");
		}
	}

	
}
