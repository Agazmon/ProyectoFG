package ProyectoFG.modelo.dominio.raza;

public enum TamanoRaza {
	DIMINUTA("Diminuta", 2.5f), PEQUENA("Pequeña", 5), MEDIANA("Mediana", 5), GRANDE("Grande", 10),
	ENORME("Enorme", 15), GARGANTUESCA("Gargantuesca", 20), OTRO("Otro", 1000);
	private String nombreTamano;
	private float espacioOcupadoPiesLado;
	private TamanoRaza(String nombreTamano, float espacioOcupadoPiesLado) {
		setNombreTamano(nombreTamano);
		setEspacioOcupadoPiesLado(espacioOcupadoPiesLado);
	}
	public String getNombreTamano() {
		return nombreTamano;
	}
	private void setNombreTamano(String nombreTamano) {
		this.nombreTamano = nombreTamano;
	}
	public float getEspacioOcupadoPiesLado() {
		return espacioOcupadoPiesLado;
	}
	private void setEspacioOcupadoPiesLado(float espacioOcupadoPiesLado) {
		this.espacioOcupadoPiesLado = espacioOcupadoPiesLado;
	}
	
	
}
