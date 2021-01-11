package ProyectoFG.modelo.dominio.competencia;

public enum TipoCompetencia {
	ARMADURA_SENCILLA("Armadura Sencilla"), ARMADURA_LIGERA("Armadura Ligera"), ARMADURA_MEDIA("Armadura Media"),
	ARMADURA_PESADA("Armadura Pesada"), ESCUDOS("Escudos"), ARMAS_SENCILLAS("Armas sencillas"),
	ARMAS_MARCIALES("Armas marciales"), ESPADAS_CORTAS("Espadas cortas"), ESPADAS_LARGAS("Espadas largas"),
	ESTOQUES("Estoques"), BASTONES("Bastones"), CIMITARRAS("Cimitarras"), DAGAS("Dagas"), DARDOS("Dardos"),
	GARROTES("Garrotes"), HOCES("Hoces"), HONDAS("Hondas"), JABALINAS("Jabalinas"), LANZAS("Lanzas"), MAZAS("Mazas"),
	BALLESTA_LIGERA("Ballesta Ligera"), BALLESTAS_DE_MANO("Ballestas de mano"), BALLESTA_PESADA("Ballestas pesadas"),
	HACHAS("Hachas"), MARTILLOS("Martillos"), ARCOS("Arcos"), ARMAS_DE_ASTA("Armas de asta"), ESPADONES("Espadones"),
	LATIGOS("L�tigos"), PICOS("Picos"), TRIDENTES("Tridentes"), REDES("Redes"),
	CAPACIDAD_LANZAR_HECHIZOS("Capacidad de lanzar hechizos."), ARMAS_IMPROVISADAS("Armas improvisadas"),
	// HERRAMIENTAS
	HERRAMIENTAS_ALBA�IL("Herramientas de Alba�il"), HERRAMIENTAS_ALFARERO("Herramientas de Alfarero"),
	HERRAMIENTAS_CARPINTERO("Herramientas de Carpintero"), HERRAMIENTAS_CARTOGRAFO("Herramientas de Cart�grafo"),
	HERRAMIENTAS_CURTIDOR("Herramientas de Curtidor"), HERRAMIENTAS_EBANISTA("Herramientas de Ebanista"),
	HERRAMIENTAS_HERRERO("Herramientas de Herrero"), HERRAMIENTAS_JOYERO("Herramientas de Joyero"),
	HERRAMIENTAS_MANITAS("Herramientas de Manitas"), HERRAMIENTAS_SOPLADOR_VIDRIO("Herramientas de Soplador de Vidrio"),
	HERRAMIENTAS_TEJEDOR("Herramientas de Tejedor"), HERRAMIENTAS_ZAPATERO("Herramientas de Zapatero"),
	HERRAMIENTAS_ALQUIMISTA("Herramientas de Alquimista"), HERRAMIENTAS_CALIGRAFO("Herramientas de Cal�grafo"),
	HERRAMIENTAS_CERVECERO("Herramientas de Cervecero"), HERRAMIENTAS_PINTOR("Herramientas de Pintor"),
	HERRAMIENTAS_LADRON("Herramientas de Ladr�n"), HERRAMIENTAS_NAVEGANTE("Herramientas de Navegante"),
	UTILES_COCINERO("�tiles de Cocinero"), UTILES_ENVENENADOR("�tiles de Envenenador"),
	UTILES_HERBORISTA("�tiles de Herborista"), UTILES_DISFRAZ("�tiles para disfrazarse"),
	UTILES_FALSIFICAR("�tiles para falsificar"),
	// INSTRUMENTOS
	INSTRUMENTO_CHIRIMIA("Chirim�a"), INSTRUMENTO_CUERNO("Cuerno"), INSTRUMENTO_DULCEMELE("Dulc�mele"),
	INSTRUMENTO_FLAUTA("Flauta"), INSTRUMENTO_FLAUTA_PAN("Flauta de pan"), INSTRUMENTO_GAITA("Gaita"),
	INSTRUMENTO_LAUD("La�d"), INSTRUMENTO_LIRA("Lira"), INSTRUMENTO_TAMBOR("Tambor"), INSTRUMENTO_VIOLA("Viola"),
	JUEGO_AJEDREZ_DRAGON("Ajedr�z Drag�n"), JUEGO_APUESTA_TRES_DRAGONES("Apuesta de los Tres Dragones"),
	JUEGO_DADOS("Dados"), JUEGO_NAIPES("Naipes"),
	// VEHICULOS
	VEHICULOS_TERRESTRES("Veh�culos Terrestres"), VEHICULOS_ACUATICOS("Veh�culos Acu�ticos");

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
