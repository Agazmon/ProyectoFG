package ProyectoFG.modelo.dominio.contador;

public enum TipoContador {
	PERSONALIZADO("Personalizado por el jugador.",0), AFORTUNADO("Afortunado",3);
	private String origenContador;
	private int cargasPorDefecto;
	private TipoContador(String origen, int cargasPorDefecto) {
		setOrigenContador(origen);
		setCargasPorDefecto(cargasPorDefecto);
	}
	public String getOrigenContador() {
		return origenContador;
	}
	private void setOrigenContador(String origenContador) {
		this.origenContador = origenContador;
	}
	public int getCargasPorDefecto() {
		return cargasPorDefecto;
	}
	private void setCargasPorDefecto(int cargasPorDefecto) {
		this.cargasPorDefecto = cargasPorDefecto;
	}
}
