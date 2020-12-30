package ProyectoFG.modelo.dominio.hechizo;

public enum NivelHechizo {
	TRUCO("Truco",0),
	RITUAL("Ritual",10),
	NO_RITUAL("No Ritual",11),
	NIVEL_1("Nivel 1",1),
	NIVEL_2("Nivel 2",2),
	NIVEL_3("Nivel 3",3),
	NIVEL_4("Nivel 4",4),
	NIVEL_5("Nivel 5",5),
	NIVEL_6("Nivel 6",6),
	NIVEL_7("Nivel 7",7),
	NIVEL_8("Nivel 8",8),
	NIVEL_9("Nivel 9",9);
	
	private String nivelHechizo;
	private int valorNivelHechizo;
	
	private NivelHechizo(String nivel, int valorNivel) {
		setNivelHechizo(nivel);
		setValorNivelHechizo(valorNivel);
	}
	
	private void setNivelHechizo(String nivel) {
		if(nivel==null) {
			throw new IllegalArgumentException("El nivel de un hechizo no puede ser nulo");
		} else if(nivel.isBlank()) {
			throw new IllegalArgumentException("El nivel de un hechizo no puede estar vacío.");
		} else {
			this.nivelHechizo = nivel;
		}
	}
	public String getNivelHechizo() {
		return this.nivelHechizo;
	}
	public void setValorNivelHechizo(int valor) {
		if(valor<0) {
			throw new IllegalArgumentException("El nivel de un hechizo no puede ser inferior a 0");
		} else {
			this.valorNivelHechizo = valor;
		}
	}
	public int getValorNivelHechizo() {
		return this.valorNivelHechizo;
	}
}
