package ProyectoFG.modelo.dominio.raza.padre;

import ProyectoFG.modelo.dominio.Atributo;
import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.dote.DoteRacial;
import ProyectoFG.modelo.dominio.dote.TipoDote;
import ProyectoFG.modelo.dominio.habilidad.TipoHabilidad;
import ProyectoFG.modelo.dominio.idioma.TipoIdioma;
import ProyectoFG.modelo.dominio.raza.Raza;
import ProyectoFG.modelo.dominio.raza.TamanoRaza;

public class Elfo extends Raza {

	protected Elfo(Personaje personaje, String nombreSubraza) {
		super(personaje, "Elfo", nombreSubraza, TamanoRaza.MEDIANA);
	}

	@Override
	protected void aplicarRaciales() {
		if(!isRacialesAplicadas()) {
			setRacialesAplicadas(true);
			Personaje personaje = getPersonaje();
			personaje.getDotes().anadir(new DoteRacial(TipoDote.MEJORA_CARACTERISTICA, "Tu puntuación de Destreza aumenta en 2. Máximo 20."));
			if(personaje.getCaracteristicas().buscar(Atributo.DESTREZA).getPuntuacion()<19){
				personaje.getCaracteristicas().buscar(Atributo.DESTREZA).aumentarCaracteristica(1);
			}if(personaje.getCaracteristicas().buscar(Atributo.DESTREZA).getPuntuacion()<20){
				personaje.getCaracteristicas().buscar(Atributo.DESTREZA).aumentarCaracteristica(1);
			}
			if(personaje.getVelocidad()==0) {
				personaje.setVelocidad(30);
			}
			personaje.getDotes().anadir(new DoteRacial(TipoDote.VISION_EN_LA_OSCURIDAD,"Acostumbrado a la prenumbra de los bosques y el cielo nocturno, puedes ver bien en la oscuridad o con poca luz. Hasta un máximo de 60 pies, eres capaz de ver con luz tenue como si hubiera luz brillante y en la oscuridad como si hubiera luz tenue. Eso sí, no puedes distinguir colores en la oscuridad, solo tonos de gris."));
			personaje.getDotes().anadir(new DoteRacial(TipoDote.SENTIDOS_AGUDOS,"Eres competente en percepción"));
			personaje.getHabilidades().aumentarMaximoCompetencias(1);
			personaje.getHabilidades().ganarCompetencia(TipoHabilidad.PERCEPCION);
			personaje.getDotes().anadir(new DoteRacial(TipoDote.LINAJE_FEERICO,"Tienes ventaja en las tiradas de salvación para evitar ser hechizado y la magia no puede dormirte."));
			personaje.getDotes().anadir(new DoteRacial(TipoDote.TRANCE,"Los elfos no necesitan dormir. Meditan profundamente, en un estado semiconsciente, durante 4 horas al día. La palabra en común para referirse a esta meditación es \"Trance\". Mientras meditas, experimentas algo parecido a sueños que en realidad son ejercicios mentales que se han vuelto automáticos tras años de práctica. Este trance es suficiente para obtener los mismos beneficios que un humano recibe de 8 horas de sueño."));
			personaje.getDotes().anadir(new DoteRacial(TipoDote.IDIOMAS_RACIALES,"Puedes hablar, leer y escribir en común y elfo. El idioma elfo es fluido, con entonaciones sutiles y una gramática compleja. Muchos bardos aprenden este idioma para poder añadir baladas élficas a sus repertorios."));
			personaje.getIdiomas().aumentarNumeroMaximoIdiomas(2);
			personaje.getIdiomas().anadir(TipoIdioma.ELFO);
			personaje.getIdiomas().anadir(TipoIdioma.COMUN);
		} else {
			throw new IllegalArgumentException("Las raciales ya han sido aplicadas al personaje.");
		}
	}

	@Override
	public String toString() {
		return "Elfo [nombreRaza=" + nombreRaza + ", nombreSubraza=" + nombreSubraza + ", tamanoRaza=" + tamanoRaza
				+ "]";
	}
	
}
