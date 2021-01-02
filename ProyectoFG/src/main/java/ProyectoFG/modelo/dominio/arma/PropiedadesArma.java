package ProyectoFG.modelo.dominio.arma;

public enum PropiedadesArma {
	A_DOS_MANOS("A dos manos", "Requiere el uso de las dos manos")
	, ALCANCE("Alcance", "Puede hacer ataques a distancia, al primer alcance ataque normal, al segundo desventaja"),
	ARROJADIZA("Arrojadiza","Puede ser lanzada para realizar un ataque usando, puedes usar algunas propiedades de la arma si es cuerpo a cuerpo"),
	LANZA_CABALLERIA("Especial","Desventaja al atacar a un objetivo a 4 pies o menos de tí. Además de requerír las dos manos en caso de no estar sobre una montura."),
	RED("Especial", "Usa tu acción de ataque, criaturas sin forma definida o que sean de Tamaño enorme o mayor no se verán afectadas. La criatura afectada o un externo puede hacer una prueba de salvación de fuerza para liberarse. O bien haciendo 5 puntos de daño teniendo la red una CA de 10 destruyendola, sin causar daño a la criatura en el interior. La criatura atrapada solo puede realizar una acción con la red."),
	GRAN_ALCANCE("Gran Alcance","Tu alcance de ataque con el arma aumenta en 5 pies, tanto para ataque como para ataques de oportunidad"),
	LIGERA("Ligera","Es pequeña y facil de manejar, ideal para le combate a dos armas"),
	MUNICION("Municion","Solo se puede realizar un ataque a distancia por turno con un arma con esta propiedad, consumiendo la municion que use por cada ataque. Se necesita una mano libre para recargar."),
	PESADA("Pesada","Las criaturas de tamaño pequeño tienen desventaja en las tiradas de ataque con armas pesadas."),
	RECARGA("Recarga","Solo se puede realizar un ataque por turno, dado que requiere tiempo para ser recargada."),
	SUTIL("Sutíl","Podrás elegir realizar la tirada de ataque y daño con el modificador de Fuerza o Destreza (Se cogerá automaticamente el mas alto)."),
	VERSATIL("Versátil","Estas armas pueden utilizarse con una o dos manos aumentando el daño cuando se emplee a dos manos");

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
			throw new IllegalArgumentException("El nombre de la propiedad para armas no puede estar vacío.");
		} else {
			this.nombrePropiedad = nombrePropiedad;
		}

	}

	public String getDescripcionPropiedad() {
		return descripcionPropiedad;
	}

	private void setDescripcionPropiedad(String descripcionPropiedad) {
		if (descripcionPropiedad == null) {
			throw new IllegalArgumentException("La descripción de la propiedad para armas no puede ser nula.");
		} else if (descripcionPropiedad.isBlank()) {
			throw new IllegalArgumentException("La descripción de la propiedad para armas no puede estar vacío.");
		} else {
			this.descripcionPropiedad = descripcionPropiedad;
		}
	}

}
