package ProyectoFG.modelo.dominio.tirada;

public enum TipoTirada {
	NEUTRA("Neutra"),
	VENTAJA("Ventaja"),
	DESVENTAJA("Desventaja");
	
	private String tipoTirada;
	private TipoTirada(String tipo) {
		setTipoTirada(tipo);
	}
	private void setTipoTirada(String tipo) {
		this.tipoTirada=tipo;
	}
}
