package ProyectoFG.modelo.dominio.habilidad;

import ProyectoFG.modelo.dominio.Atributo;

public enum TipoHabilidad {
	// Habilidades de FUERZA
	ATLETISMO("Atletismo", Atributo.FUERZA),
	// Habilidades de DESTREZA
	ACROBACIAS("Acrobacias", Atributo.DESTREZA), JUEGO_DE_MANOS("Juego de manos", Atributo.DESTREZA),
	SIGILO("Sigilo", Atributo.DESTREZA),
	// Habilidades de INTELIGENCIA
	CONOCIMIENTO_ARCANO("Conocimiento arcano", Atributo.INTELIGENCIA), HISTORIA("Historia", Atributo.INTELIGENCIA),
	INVESTIGACION("Investigacion", Atributo.INTELIGENCIA), NATURALEZA("Naturaleza", Atributo.INTELIGENCIA),
	RELIGION("Religi�n", Atributo.INTELIGENCIA),
	// Habilidades de SABIDURIA
	MEDICINA("Medicina", Atributo.SABIDURIA), PERCEPCION("Percepci�n", Atributo.SABIDURIA),
	PERSPICACIA("Perspicacia", Atributo.SABIDURIA), SUPERVIVENCIA("Supervivencia", Atributo.SABIDURIA),
	TRATO_CON_ANIMALES("Trato con animales", Atributo.SABIDURIA),
	// Habilidades de CARISMA
	ENGANO("Enga�o", Atributo.CARISMA), INTERPRETACION("Interpretaci�n", Atributo.CARISMA),
	INTIMIDACION("Intimidaci�n", Atributo.CARISMA), PERSUASION("Persuasi�n", Atributo.CARISMA);

	// Atributos de la clase
	String nombre;
	Atributo atributoRelacionado;

	private TipoHabilidad(String nombre, Atributo atributoRelacionado) {
		setNombre(nombre);
		setAtributoRelacionado(atributoRelacionado);
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private void setAtributoRelacionado(Atributo atributoRelacionado) {
		if (atributoRelacionado == null) {
			throw new IllegalArgumentException("No se permite que el atributo relacionado a una habilidad sea nulo.");
		} else {
			this.atributoRelacionado = atributoRelacionado;
		}
	}

	public Atributo getAtributoRelacionado() {
		return this.atributoRelacionado;
	}

	public String getNombre() {
		return this.nombre;
	}
}
