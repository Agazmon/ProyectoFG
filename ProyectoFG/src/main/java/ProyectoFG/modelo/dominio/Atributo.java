package ProyectoFG.modelo.dominio;

public enum Atributo {
	FUERZA("Fuerza"), DESTREZA("Destreza"), CONSTITUCION("Constitución"), INTELIGENCIA("Inteligencia"),
	SABIDURIA("Sabiduría"), CARISMA("Carisma");

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
