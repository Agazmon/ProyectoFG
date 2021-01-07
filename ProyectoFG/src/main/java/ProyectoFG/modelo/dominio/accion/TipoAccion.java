package ProyectoFG.modelo.dominio.accion;

public enum TipoAccion {
	ACCION("Acci�n"), ACCION_ADICIONAL("Acci�n adicional"), REACCION("Reacci�n");

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
