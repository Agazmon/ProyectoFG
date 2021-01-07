package ProyectoFG.modelo.dominio.accion;

public enum TipoOrigen {
	RAZA("Raza"),DOTE("Dote"),CLASE("Clase"),TRASFONDO("Trasfondo"),OTRO("Otro tipo de origen");
	private String nombreOrigen;
	private TipoOrigen(String nombreOrigen) {
		
	}
	public String getNombreOrigen() {
		return nombreOrigen;
	}
	private void setNombreOrigen(String nombreOrigen) {
		this.nombreOrigen = nombreOrigen;
	}
}
