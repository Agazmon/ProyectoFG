package ProyectoFG.modelo.dominio;

public enum Alineamiento {
	LEGAL_BUENO("Legal Bueno", "Realiza lo que la sociecad considera como correcto"),
	LEGAL_NEUTRAL("Legal Neutral", "Se comportan de acuerdo a la ley, tradición o códigos de conducta personales"),
	LEGAL_MALVADO("Legal Malvado",
			"Toman lo que quieren, siempre de forma metódica y dentro de los limites, marcados por tradición, organización o lealtad"),
	NEUTRAL_BUENO("Neutral Bueno", "Harán lo que puedan para ayudar a los demás de acuerdo a sus necesidades"),
	NEUTRAL("Neutral",
			" Es el alineamineto de aquellos que prefieren evitar las cuestiones éticas y no toman partido, haciendo lo que les parece mejor en cada momento."),
	NEUTRAL_MALVADO("Neutral Malvado",
			"Es el alineamiento de los que se salen con la suya siempre que presenta la oportunidad, sin compasión o remordimiento alguno"),
	CAOTICO_BUENO("Caótico Bueno",
			"Actúan siguiendo los dictados de sus conciencias sin preocuparles lo que otros esperan de ellas."),
	CAOTICO_NUETRAL("Caótico Neutral",
			"Persiguen sus caprichos, valorando su libertad como individuo por encima de cualquier otra cosa"),
	CAOTICO_MALVADO("Caótico Malvado",
			"Recurren a la violencia arbirariamente, movidos por la codicia, el odio, o el ansia de sangre");

	private String nombre;
	private String descripcion;

	private Alineamiento(String nombre, String descripcion) {
		setNombre(nombre);
		setDescripcion(descripcion);
	}

	private void setNombre(String nombre) {
		if (nombre == null || nombre.trim().equals("")) {
			throw new IllegalArgumentException("El nombre del alineamiento no puede ser null o estar vacio.");
		} else {
			this.nombre = nombre;
		}

	}

	private void setDescripcion(String descripcion) {
		if (descripcion != null && descripcion.trim().equals("")) {
			throw new IllegalArgumentException("La descripción del alineamiento no puede ser null o estar vacia.");
		} else {
			this.descripcion = descripcion;
		}

	}

	public String getNombre() {
		return this.nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	@Override
	public String toString() {
		return getNombre() + ": " + getDescripcion();
	}
}
