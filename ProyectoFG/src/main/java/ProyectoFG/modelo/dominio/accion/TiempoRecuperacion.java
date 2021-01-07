package ProyectoFG.modelo.dominio.accion;

public enum TiempoRecuperacion {
	RONDA("Se recupera al inicio de la pr�xima ronda."),
	DESCANSO_CORTO("Se recupera al finalizar el pr�ximo descanso corto."),
	DESCANSO_LARGO("Se recupera al finalizar el pr�ximo descanso largo.");
	
	private String tiempoRecuperacion;
	private TiempoRecuperacion(String tiempoRecuperacion) {
		setTiempoRecuperacion(tiempoRecuperacion);
	}
	public String getTiempoRecuperacion() {
		return tiempoRecuperacion;
	}
	private void setTiempoRecuperacion(String tiempoRecuperacion) {
		this.tiempoRecuperacion = tiempoRecuperacion;
	}
	
}
