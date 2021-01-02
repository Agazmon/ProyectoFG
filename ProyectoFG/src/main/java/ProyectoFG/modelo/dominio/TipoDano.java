package ProyectoFG.modelo.dominio;

public enum TipoDano {
	ACIDO("�cido"), CONTUNDENTE("Contundente"), CORTANTE("Cortante"), FRIO("Fr�o"), FUEGO("Fuego"), FUERZA("Fuerza"),
	NECROTICO("Necr�tico"), PERFORANTE("Perforante"), PSIQUICO("Ps�quico"), RADIANTE("Radiante"),
	RELAMPAGO("Rel�mpago"), TRUENO("Trueno"), VENENO("Veneno"), NINGUNO("Sin tipo de da�o");

	String nombreTipo;

	private TipoDano(String nombreTipo) {
		setNombreTipo(nombreTipo);
	}

	private void setNombreTipo(String nombreTipo) {
		if (nombreTipo == null) {
			throw new IllegalArgumentException("El nombre del tipo de da�o no puede ser nulo.");
		} else if (nombreTipo.isBlank()) {
			throw new IllegalArgumentException("El nombre del tipo de da�o no puede estar vac�o.");
		} else {
			this.nombreTipo = nombreTipo;
		}

	}
}
