package ProyectoFG.modelo.dominio.salvacion;

import ProyectoFG.modelo.dominio.Atributo;

public enum TipoSalvacion {
	SALVACION_FUERZA("Salvaci�n de Fuerza",Atributo.FUERZA),
	SALVACION_DESTREZA("Salvaci�n de Destreza",Atributo.DESTREZA),
	SALVACION_CONSTITUCION("Salvaci�n de Constituci�n",Atributo.CONSTITUCION),
	SALVACION_INTELIGENCIA("Salvaci�n de Inteligencia",Atributo.INTELIGENCIA),
	SALVACION_SABIDURIA("Salvaci�n de Sabidur�a",Atributo.SABIDURIA),
	SALVACION_CARISMA("Salvaci�n de Carisma",Atributo.CARISMA);

	
	//Atributos de la clase
	private String nombre;
	private Atributo atributoRelacionado;
	
	private TipoSalvacion(String nombre, Atributo atributoRelacionado) {
		setNombre(nombre);
		setAtributoRelacionado(atributoRelacionado);
	}
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return this.nombre;
	}
	private void setAtributoRelacionado(Atributo atributoRelacionado) {
		this.atributoRelacionado = atributoRelacionado;
	}
	public Atributo getAtributoRelacionad() {
		return this.atributoRelacionado;
	}

}
