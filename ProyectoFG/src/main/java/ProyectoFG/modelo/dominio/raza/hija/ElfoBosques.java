package ProyectoFG.modelo.dominio.raza.hija;

import ProyectoFG.modelo.dominio.Atributo;
import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.competencia.TipoCompetencia;
import ProyectoFG.modelo.dominio.dote.DoteRacial;
import ProyectoFG.modelo.dominio.dote.TipoDote;
import ProyectoFG.modelo.dominio.raza.padre.Elfo;

public class ElfoBosques extends Elfo {

	public ElfoBosques(Personaje personaje) {
		super(personaje, "Elfo de los bosques");
		aplicarRaciales();
	}

	@Override
	protected void aplicarRaciales() {
		if (!isSubracialesAplicadas()) {
			setSubracialesAplicadas(true);
			Personaje personaje = getPersonaje();
			personaje.getDotes().anadir(new DoteRacial(TipoDote.MEJORA_CARACTERISTICA_SUBRAZA,"Tu puntuación de Sabiduría aumenta en 1. Máximo 20."));
			if (personaje.getCaracteristicas().buscar(Atributo.SABIDURIA).getPuntuacion() < 20) {
				personaje.getCaracteristicas().buscar(Atributo.SABIDURIA).aumentarCaracteristica(1);
			}
			personaje.getDotes().anadir(new DoteRacial(TipoDote.ENTRENAMIENTO_ARMAS_ELFICAS,"Eres competente con espadas cortas, espadas largas y arcos."));
			personaje.getCompetencias().aumentarMaximoCompetencias(3);
			personaje.getCompetencias().ganarCompetencia(TipoCompetencia.ESPADAS_CORTAS);
			personaje.getCompetencias().ganarCompetencia(TipoCompetencia.ESPADAS_LARGAS);
			personaje.getCompetencias().ganarCompetencia(TipoCompetencia.ARCOS);
			personaje.setVelocidad(35);
			personaje.getDotes().anadir(new DoteRacial(TipoDote.MASCARA_DE_LA_NATURALEZA,"Puedes intentar esconderte incluso cuando estés en un lugar solo ligeramente oscuro, siempre que lo que te tape sea follaje, una lluvia fuerte, nieve que cae, niebla o cualquier otro fenómeno natural."));
			super.aplicarRaciales();
		} else {
			throw new IllegalArgumentException("Las subraciales ya han sido aplicadas al personaje.");
		}
	}

}
