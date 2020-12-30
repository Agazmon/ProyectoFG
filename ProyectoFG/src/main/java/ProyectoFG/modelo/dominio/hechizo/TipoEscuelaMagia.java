package ProyectoFG.modelo.dominio.hechizo;

public enum TipoEscuelaMagia {
	ABJURACION("Abjuraci�n"),
	ADIVINACION("Adivinaci�n"),
	CONJURACION("Conjuraci�n"),
	ENCANTAMIENTO("Encantamiento"),
	EVOCACION("Evocaci�n"),
	ILUSIONISMO("Ilusionismo"),
	NIGROMANCIA("Nigromancia"),
	TRANSMUTACION("Transmutaci�n");
	
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
			throw new IllegalArgumentException("El nombre de la escuela de magia no puede estar vac�o.");
		} else {
			this.nombreEscuela = nombreEscuela;
		}
	}
	
}
