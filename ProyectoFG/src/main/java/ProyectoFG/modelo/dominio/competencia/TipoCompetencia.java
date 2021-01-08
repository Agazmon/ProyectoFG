package ProyectoFG.modelo.dominio.competencia;

public enum TipoCompetencia {
	ARMADURA_SENCILLA("Armadura Sencilla"), ARMADURA_LIGERA("Armadura Ligera"), ARMADURA_MEDIA("Armadura Media"),
	ARMADURA_PESADA("Armadura Pesada"), ESCUDOS("Escudos"), ARMAS_SENCILLAS("Armas sencillas"),
	ARMAS_MARCIALES("Armas marciales"), ESPADAS_CORTAS("Espadas cortas"), ESPADAS_LARGAS("Espadas largas"),
	ESTOQUES("Estoques"), BASTONES("Bastones"), CIMITARRAS("Cimitarras"), DAGAS("Dagas"), DARDOS("Dardos"),
	GARROTES("Garrotes"), HOCES("Hoces"), HONDAS("Hondas"), JABALINAS("Jabalinas"), LANZAS("Lanzas"), MAZAS("Mazas"),
	BALLESTA_LIGERA("Ballesta Ligera"), BALLESTAS_DE_MANO("Ballestas de mano"),BALLESTA_PESADA("Ballestas pesadas"), HACHAS("Hachas"),
	MARTILLOS("Martillos"), ARCOS("Arcos"), ARMAS_DE_ASTA("Armas de asta"), ESPADONES("Espadones"), LATIGOS("Látigos"),
	PICOS("Picos"), TRIDENTES("Tridentes"), REDES("Redes"),CAPACIDAD_LANZAR_HECHIZOS("Capacidad de lanzar hechizos."), ARMAS_IMPROVISADAS("Armas improvisadas");

	private String competencia;

	private TipoCompetencia(String tipoCompetencia) {
		setCompetencia(tipoCompetencia);
	}

	private void setCompetencia(String competencia) {
		this.competencia = competencia;
	}

	public String getTipoCompetenciaCadena() {
		return this.competencia;
	}

}
