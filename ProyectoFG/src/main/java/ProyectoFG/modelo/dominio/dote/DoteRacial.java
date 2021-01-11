package ProyectoFG.modelo.dominio.dote;

import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.competencia.TipoCompetencia;

public class DoteRacial extends Dote {
	public DoteRacial(TipoDote tipoDote, String descripcion) {
		super(tipoDote, descripcion);
	}
	public DoteRacial(TipoDote tipoDote, String descripcion, Personaje personaje) {
		super(tipoDote, descripcion);
		aplicarDote(personaje);
	}
	public DoteRacial(DoteRacial dote) {
		super(dote.getTipoDote(), dote.getDescripcion());
	}
	
	protected void aplicarDote(Personaje personaje) {
		if(personaje!=null) {
			switch (getTipoDote()) {
			case ENTRENAMIENTO_DE_COMBATE_ENANO:
				personaje.getCompetencias().aumentarMaximoCompetencias(2);
				personaje.getCompetencias().ganarCompetencia(TipoCompetencia.HACHAS);
				personaje.getCompetencias().ganarCompetencia(TipoCompetencia.MARTILLOS);
				break;
			default:
				break;
			}
		}
		
	}

}
