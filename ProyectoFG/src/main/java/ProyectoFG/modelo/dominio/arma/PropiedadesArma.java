package ProyectoFG.modelo.dominio.arma;

public enum PropiedadesArma {
	A_DOS_MANOS("A dos manos", "Requiere el uso de las dos manos")
	, ALCANCE("Alcance", "Puede hacer ataques a distancia, al primer alcance ataque normal, al segundo desventaja"),
	ARROJADIZA("Arrojadiza","Puede ser lanzada para realizar un ataque usando, puedes usar algunas propiedades de la arma si es cuerpo a cuerpo"),
	LANZA_CABALLERIA("Especial","Desventaja al atacar a un objetivo a 4 pies o menos de t�. Adem�s de requer�r las dos manos en caso de no estar sobre una montura."),
	RED("Especial", "Usa tu acci�n de ataque, criaturas sin forma definida o que sean de Tama�o enorme o mayor no se ver�n afectadas. La criatura afectada o un externo puede hacer una prueba de salvaci�n de fuerza para liberarse. O bien haciendo 5 puntos de da�o teniendo la red una CA de 10 destruyendola, sin causar da�o a la criatura en el interior. La criatura atrapada solo puede realizar una acci�n con la red."),
	GRAN_ALCANCE("Gran Alcance","Tu alcance de ataque con el arma aumenta en 5 pies, tanto para ataque como para ataques de oportunidad"),
	LIGERA("Ligera","Es peque�a y facil de manejar, ideal para le combate a dos armas"),
	MUNICION("Municion","Solo se puede realizar un ataque a distancia por turno con un arma con esta propiedad, consumiendo la municion que use por cada ataque. Se necesita una mano libre para recargar."),
	PESADA("Pesada","Las criaturas de tama�o peque�o tienen desventaja en las tiradas de ataque con armas pesadas."),
	RECARGA("Recarga","Solo se puede realizar un ataque por turno, dado que requiere tiempo para ser recargada."),
	SUTIL("Sut�l","Podr�s elegir realizar la tirada de ataque y da�o con el modificador de Fuerza o Destreza (Se coger� automaticamente el mas alto)."),
	VERSATIL("Vers�til","Estas armas pueden utilizarse con una o dos manos aumentando el da�o cuando se emplee a dos manos");

	String nombrePropiedad;
	String descripcionPropiedad;

	private PropiedadesArma(String nombrePropiedad, String descripcionPropiedad) {
		setNombrePropiedad(nombrePropiedad);
		setDescripcionPropiedad(descripcionPropiedad);
	}

	public String getNombrePropiedad() {
		return nombrePropiedad;
	}

	private void setNombrePropiedad(String nombrePropiedad) {
		if (nombrePropiedad == null) {
			throw new IllegalArgumentException("El nombre de la propiedad para armas no puede ser nula.");
		} else if (nombrePropiedad.isBlank()) {
			throw new IllegalArgumentException("El nombre de la propiedad para armas no puede estar vac�o.");
		} else {
			this.nombrePropiedad = nombrePropiedad;
		}

	}

	public String getDescripcionPropiedad() {
		return descripcionPropiedad;
	}

	private void setDescripcionPropiedad(String descripcionPropiedad) {
		if (descripcionPropiedad == null) {
			throw new IllegalArgumentException("La descripci�n de la propiedad para armas no puede ser nula.");
		} else if (descripcionPropiedad.isBlank()) {
			throw new IllegalArgumentException("La descripci�n de la propiedad para armas no puede estar vac�o.");
		} else {
			this.descripcionPropiedad = descripcionPropiedad;
		}
	}

}
