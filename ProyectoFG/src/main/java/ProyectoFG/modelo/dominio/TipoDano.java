package ProyectoFG.modelo.dominio;

public enum TipoDano {
	ACIDO("Ácido"), CONTUNDENTE("Contundente"), CORTANTE("Cortante"), FRIO("Frío"), FUEGO("Fuego"), FUERZA("Fuerza"),
	NECROTICO("Necrótico"), PERFORANTE("Perforante"), PSIQUICO("Psíquico"), RADIANTE("Radiante"),
	RELAMPAGO("Relámpago"), TRUENO("Trueno"), VENENO("Veneno"), NINGUNO("Sin tipo de daño");

	String nombreTipo;

	private TipoDano(String nombreTipo) {
		setNombreTipo(nombreTipo);
	}

	private void setNombreTipo(String nombreTipo) {
		if (nombreTipo == null) {
			throw new IllegalArgumentException("El nombre del tipo de daño no puede ser nulo.");
		} else if (nombreTipo.isBlank()) {
			throw new IllegalArgumentException("El nombre del tipo de daño no puede estar vacío.");
		} else {
			this.nombreTipo = nombreTipo;
		}

	}
}
