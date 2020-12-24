package ProyectoFG.modelo.dominio;

public enum Atributo {
	FUERZA("Fuerza"), DESTREZA("Destreza"), CONSTITUCION("Constituci�n"), INTELIGENCIA("Inteligencia"),
	SABIDURIA("Sabidur�a"), CARISMA("Carisma");

	String nombre;

	private Atributo(String nombre) {
		setNombre(nombre);
	}

	private void setNombre(String nombre) {
		if (nombre.trim().isEmpty()) {
			throw new IllegalArgumentException("El nombre de un Atributo no puede estar vacio o ser nulo.");
		} else {
			this.nombre = nombre;
		}
	}

}
