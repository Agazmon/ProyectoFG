package ProyectoFG.modelo.dominio.moneda;

public enum TipoMoneda {
	MONEDA_COBRE("Cobre", 1),
	MONEDA_PLATA("Plata",10),
	MONEDA_ELECTRUM("Electrum",50),
	MONEDA_ORO("Oro",100),
	MONEDA_PLATINO("Platino",1000);
	
	private String nombreMoneda;
	private int valorEnCobre;
	
	private TipoMoneda(String nombreMoneda, int valorEnCobre) {
		setNombreMoneda(nombreMoneda);
		setValorEnCobre(valorEnCobre);
	}
	private void setNombreMoneda(String nombreMoneda) {
		this.nombreMoneda = nombreMoneda;
	}
	public String getNombreMoneda() {
		return this.nombreMoneda;
	}
	private void setValorEnCobre(int valorEnCobre) {
		this.valorEnCobre = valorEnCobre;
	}
	public int getValorEnCobre() {
		return this.valorEnCobre;
	}
}
