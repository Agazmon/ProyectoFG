package ProyectoFG.modelo.dominio.accion;

public enum TipoAccion {
	ACCION("Acción"), ACCION_ADICIONAL("Acción adicional"), REACCION("Reacción");

	private String nombreAccion;

	private TipoAccion(String nombreAccion) {
		setNombreAccion(nombreAccion);
	}

	public String getNombreAccion() {
		return nombreAccion;
	}

	private void setNombreAccion(String nombreAccion) {
		this.nombreAccion = nombreAccion;
	}

}
