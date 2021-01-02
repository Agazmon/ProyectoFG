package ProyectoFG.modelo.dominio.raza;

public class Raza {
	private String nombreRaza;
	private TamanoRaza tamanoRaza;

	public Raza(String nombreRaza, TamanoRaza tamanoRaza) {
		setNombreRaza(nombreRaza);
		setTamanoRaza(tamanoRaza);
	}

	public String getNombreRaza() {
		return nombreRaza;
	}

	private void setNombreRaza(String nombreRaza) {
		this.nombreRaza = nombreRaza;
	}

	public TamanoRaza getTamanoRaza() {
		return tamanoRaza;
	}

	private void setTamanoRaza(TamanoRaza tamanoRaza) {
		this.tamanoRaza = tamanoRaza;
	}
	
}
