package ProyectoFG.modelo.dominio.arma;

public enum TipoArma {
	CUERPO_A_CUERPO("Cuerpo a cuerpo"), A_DISTANCIA("A distancia");
	String nombreTipo;
	private TipoArma(String nombreTipo) {
		setNombreTipo(nombreTipo);
	}
	public String getNombreTipo() {
		return nombreTipo;
	}
	private void setNombreTipo(String nombreTipo) {
		this.nombreTipo = nombreTipo;
	}
	
}
