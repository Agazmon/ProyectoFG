package ProyectoFG.modelo.dominio.raza.hija;

import ProyectoFG.modelo.dominio.Atributo;
import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.accion.TiempoRecuperacion;
import ProyectoFG.modelo.dominio.clase.TipoClase;
import ProyectoFG.modelo.dominio.competencia.TipoCompetencia;
import ProyectoFG.modelo.dominio.dote.DoteRacial;
import ProyectoFG.modelo.dominio.dote.TipoDote;
import ProyectoFG.modelo.dominio.hechizo.EspacioConjuro;
import ProyectoFG.modelo.dominio.hechizo.Hechizo;
import ProyectoFG.modelo.dominio.hechizo.NivelHechizo;
import ProyectoFG.modelo.dominio.idioma.TipoIdioma;
import ProyectoFG.modelo.dominio.raza.padre.Elfo;

public class ElfoAlto extends Elfo {
	private TipoIdioma idiomaAdicional;

	public ElfoAlto(Personaje personaje, TipoIdioma idiomaAdicional) {
		super(personaje, "Alto Elfo");
		setIdiomaAdicional(idiomaAdicional);
		aplicarRaciales();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void aplicarRaciales() {
		if (!isSubracialesAplicadas()) {
			setSubracialesAplicadas(true);
			Personaje personaje = getPersonaje();
			
			personaje.getDotes().anadir(new DoteRacial(TipoDote.MEJORA_CARACTERISTICA_SUBRAZA,
					"Tu puntuación de Inteligencia aumenta en 1. Máximo 20."));
			
			if (personaje.getCaracteristicas().buscar(Atributo.INTELIGENCIA).getPuntuacion() < 20) {
				
				personaje.getCaracteristicas().buscar(Atributo.INTELIGENCIA).aumentarCaracteristica(1);
				
			}
			
			personaje.getDotes().anadir(new DoteRacial(TipoDote.ENTRENAMIENTO_ARMAS_ELFICAS,
					"Eres competente con espadas cortas, espadas largas y arcos."));
		
			personaje.getCompetencias().aumentarMaximoCompetencias(3);
			personaje.getCompetencias().ganarCompetencia(TipoCompetencia.ESPADAS_CORTAS);
			
			personaje.getCompetencias().ganarCompetencia(TipoCompetencia.ESPADAS_LARGAS);
			
			personaje.getCompetencias().ganarCompetencia(TipoCompetencia.ARCOS);
			
			personaje.getDotes().anadir(new DoteRacial(TipoDote.TRUCO,
					"Conoces un truco de tu elección escogido de entre los de la lista de conjuros de mago. Inteligencia es la aptitud de lanzamiento de este."));
			EspacioConjuro espacioElfoAlto = new EspacioConjuro(NivelHechizo.TRUCO, 1, 1, TipoClase.MAGO, 1,
					TiempoRecuperacion.DESCANSO_CORTO);
			personaje.getEspacios().insertar(espacioElfoAlto);
			personaje.getDotes().anadir(new DoteRacial(TipoDote.IDIOMAS_SUBRACIALES,
					"Puedes hablar, leer y escibribir un idioma adicional"));
			personaje.getIdiomas().aumentarNumeroMaximoIdiomas(1);
			personaje.getIdiomas().anadir(getIdiomaAdicional());
			super.aplicarRaciales();
		} else {
			throw new IllegalArgumentException("Las subraciales ya han sido aplicadas al personaje.");
		}

	}

	public TipoIdioma getIdiomaAdicional() {
		return idiomaAdicional;
	}

	public void setIdiomaAdicional(TipoIdioma idiomaAdicional) {
		if (getPersonaje().getIdiomas().buscar(idiomaAdicional) != null) {
			throw new IllegalArgumentException("El personaje ya conoce el idioma, escoge otro en su lugar.");
		} else {
			if (idiomaAdicional == TipoIdioma.COMUN || idiomaAdicional == TipoIdioma.ELFO) {
				throw new IllegalArgumentException(
						"El idioma seleccionado ya es proporcionado por ser de la Raza elfo");
			} else {
				this.idiomaAdicional = idiomaAdicional;
			}
		}
	}

	@Override
	public String toString() {
		return "ElfoAlto [idiomaAdicional=" + idiomaAdicional + ", nombreRaza=" + nombreRaza + ", nombreSubraza="
				+ nombreSubraza + ", tamanoRaza=" + tamanoRaza + "]";
	}
	
	

}
