package ProyectoFG.modelo.dominio.hechizo;

public enum TipoEscuelaMagia {
	ABJURACION("Abjuración"),
	ADIVINACION("Adivinación"),
	CONJURACION("Conjuración"),
	ENCANTAMIENTO("Encantamiento"),
	EVOCACION("Evocación"),
	ILUSIONISMO("Ilusionismo"),
	NIGROMANCIA("Nigromancia"),
	TRANSMUTACION("Transmutación");
	
	private String nombreEscuela;
	
	private TipoEscuelaMagia(String nombreEscuela) {
		setNombreEscuelaMagia(nombreEscuela);
	}
	public String getNombreEscuelaMagia() {
		return this.nombreEscuela;
	}

	private void setNombreEscuelaMagia(String nombreEscuela) {
		if(nombreEscuela==null) {
			throw new IllegalArgumentException("El nombre de la escuela de magia no puede ser nulo.");
		} else if(nombreEscuela.isBlank()) {
			throw new IllegalArgumentException("El nombre de la escuela de magia no puede estar vacío.");
		} else {
			this.nombreEscuela = nombreEscuela;
		}
	}
	
}
