package ProyectoFG.modelo.dominio.raza.padre;

import ProyectoFG.modelo.dominio.Atributo;
import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.dote.DoteRacial;
import ProyectoFG.modelo.dominio.dote.TipoDote;
import ProyectoFG.modelo.dominio.idioma.TipoIdioma;
import ProyectoFG.modelo.dominio.raza.Raza;
import ProyectoFG.modelo.dominio.raza.TamanoRaza;

public class Mediano extends Raza{

	protected Mediano(Personaje personaje, String nombreSubraza) {
		super(personaje, "Mediano", nombreSubraza, TamanoRaza.PEQUENA);
	}

	@Override
	protected void aplicarRaciales() {
		if (!isRacialesAplicadas()) {
			setRacialesAplicadas(true);
			Personaje personaje = getPersonaje();
			personaje.getDotes().anadir(new DoteRacial(TipoDote.MEJORA_CARACTERISTICA,"Tu puntuación de Destreza aumenta en 2. Máximo 20."));
			if(personaje.getCaracteristicas().buscar(Atributo.DESTREZA).getPuntuacion()<19) {
				personaje.getCaracteristicas().buscar(Atributo.DESTREZA).aumentarCaracteristica(1);
			}
			if(personaje.getCaracteristicas().buscar(Atributo.DESTREZA).getPuntuacion()<20) {
				personaje.getCaracteristicas().buscar(Atributo.DESTREZA).aumentarCaracteristica(1);
			}
			personaje.getDotes().anadir(new DoteRacial(TipoDote.AFORTUNADO, "Cuando saques un 1 en el dado al hacer una tirada de ataque, prueba de característica o tirada de salvación, pueds volver a tirar el dado pero tendrás que utilizar el resultado nuevo."));
			personaje.getDotes().anadir(new DoteRacial(TipoDote.VALIENTE,"Posees ventaja en las tiradas de salvación para evitar ser asustado."));
			personaje.getDotes().anadir(new DoteRacial(TipoDote.AGILIDAD_DE_MEDIANO,"Puedes moverte a través del espacio ocupado por una criatura cuyo tamaño sea, al menos, una categoría superior al tuyo."));
			personaje.getDotes().anadir(new DoteRacial(TipoDote.IDIOMAS_RACIALES,"Puedes hablar, leer y escribir en común y mediano. El idioma de los medianos no es secreto, pero son reticentes a compartirlo con otros."));
			personaje.getIdiomas().aumentarNumeroMaximoIdiomas(2);
			personaje.getIdiomas().anadir(TipoIdioma.COMUN);
			personaje.getIdiomas().anadir(TipoIdioma.MEDIANO);
		} else {
			throw new IllegalArgumentException("Las raciales ya han sido aplicadas al personaje.");
		}
	}

	@Override
	public String toString() {
		return "Mediano [nombreRaza=" + nombreRaza + ", nombreSubraza=" + nombreSubraza + ", tamanoRaza=" + tamanoRaza
				+ "]";
	}

}
