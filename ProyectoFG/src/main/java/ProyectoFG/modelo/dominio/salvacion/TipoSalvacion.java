package ProyectoFG.modelo.dominio.salvacion;

import ProyectoFG.modelo.dominio.Atributo;

public enum TipoSalvacion {
	SALVACION_FUERZA("Salvación de Fuerza",Atributo.FUERZA),
	SALVACION_DESTREZA("Salvación de Destreza",Atributo.DESTREZA),
	SALVACION_CONSTITUCION("Salvación de Constitución",Atributo.CONSTITUCION),
	SALVACION_INTELIGENCIA("Salvación de Inteligencia",Atributo.INTELIGENCIA),
	SALVACION_SABIDURIA("Salvación de Sabiduría",Atributo.SABIDURIA),
	SALVACION_CARISMA("Salvación de Carisma",Atributo.CARISMA);

	
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
