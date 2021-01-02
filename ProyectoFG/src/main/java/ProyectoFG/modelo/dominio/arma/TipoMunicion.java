package ProyectoFG.modelo.dominio.arma;

public enum TipoMunicion {
	FLECHA("Flecha"), VIROTE("Virote"), PIEDRA("Piedra"), VIROTE_PESADO("Virote Pesado"), DARDO("Dardo");

	private String nombreTipo;

	private TipoMunicion(String nombreTipo) {
		setNombreTipo(nombreTipo);
	}

	void setNombreTipo(String nombreTipo) {
		if (nombreTipo == null) {
			throw new IllegalArgumentException("El nombre de un tipo de munici�n no puede ser nulo.");
		} else if (nombreTipo.isBlank()) {
			throw new IllegalArgumentException("El nombre de un tipo de munici�n no puede estar vac�o.");
		} else {
			this.nombreTipo = nombreTipo;
		}
	}

	public String getNombreTipo() {
		return this.nombreTipo;
	}
}
