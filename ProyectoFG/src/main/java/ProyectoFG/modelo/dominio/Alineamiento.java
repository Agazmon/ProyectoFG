package ProyectoFG.modelo.dominio;

public enum Alineamiento {
	LEGAL_BUENO("Legal Bueno", "Realiza lo que la sociecad considera como correcto"),
	LEGAL_NEUTRAL("Legal Neutral", "Se comportan de acuerdo a la ley, tradici�n o c�digos de conducta personales"),
	LEGAL_MALVADO("Legal Malvado",
			"Toman lo que quieren, siempre de forma met�dica y dentro de los limites, marcados por tradici�n, organizaci�n o lealtad"),
	NEUTRAL_BUENO("Neutral Bueno", "Har�n lo que puedan para ayudar a los dem�s de acuerdo a sus necesidades"),
	NEUTRAL("Neutral",
			" Es el alineamineto de aquellos que prefieren evitar las cuestiones �ticas y no toman partido, haciendo lo que les parece mejor en cada momento."),
	NEUTRAL_MALVADO("Neutral Malvado",
			"Es el alineamiento de los que se salen con la suya siempre que presenta la oportunidad, sin compasi�n o remordimiento alguno"),
	CAOTICO_BUENO("Ca�tico Bueno",
			"Act�an siguiendo los dictados de sus conciencias sin preocuparles lo que otros esperan de ellas."),
	CAOTICO_NUETRAL("Ca�tico Neutral",
			"Persiguen sus caprichos, valorando su libertad como individuo por encima de cualquier otra cosa"),
	CAOTICO_MALVADO("Ca�tico Malvado",
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
			throw new IllegalArgumentException("La descripci�n del alineamiento no puede ser null o estar vacia.");
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
