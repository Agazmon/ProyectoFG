package ProyectoFG.modelo.dominio.armadura;

public enum TipoArmadura {
	ARMADURA_LIGERA("Armadura ligera"),
	ARMADURA_MEDIA("Armadura media"),
	ARMADURA_PESADA("Armadura pesada"),
	ESCUDOS("Escudos");
	String nombreTipoArmadura;
	private TipoArmadura(String nombreTipoArmadura) {
		setNombreTipoArmadura(nombreTipoArmadura);
	}

	private void setNombreTipoArmadura(String nombreTipoArmadura) {
		this.nombreTipoArmadura = nombreTipoArmadura;
	}
	
}
