package ProyectoFG.modelo.dominio.armadura;

import ProyectoFG.modelo.dominio.competencia.TipoCompetencia;

public enum TipoArmadura {
	ARMADURA_LIGERA("Armadura ligera", TipoCompetencia.ARMADURA_LIGERA),
	ARMADURA_MEDIA("Armadura media", TipoCompetencia.ARMADURA_MEDIA),
	ARMADURA_PESADA("Armadura pesada", TipoCompetencia.ARMADURA_MEDIA), ESCUDOS("Escudos", TipoCompetencia.ESCUDOS);

	private String nombreTipoArmadura;
	private TipoCompetencia competenciaRequerida;

	private TipoArmadura(String nombreTipoArmadura, TipoCompetencia competenciaRequerida) {
		setNombreTipoArmadura(nombreTipoArmadura);
		setCompetenciaRequerida(competenciaRequerida);
	}

	private void setCompetenciaRequerida(TipoCompetencia competenciaRequerida) {
		this.competenciaRequerida = competenciaRequerida;

	}

	public TipoCompetencia getCompetenciaRequerida() {
		return competenciaRequerida;
	}

	private void setNombreTipoArmadura(String nombreTipoArmadura) {
		this.nombreTipoArmadura = nombreTipoArmadura;
	}

	public String getNombreTipoArmadura() {
		return nombreTipoArmadura;
	}

}
