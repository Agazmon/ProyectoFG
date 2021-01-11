package ProyectoFG.modelo.dominio.competencia;

public enum TipoCompetencia {
	ARMADURA_SENCILLA("Armadura Sencilla"), ARMADURA_LIGERA("Armadura Ligera"), ARMADURA_MEDIA("Armadura Media"),
	ARMADURA_PESADA("Armadura Pesada"), ESCUDOS("Escudos"), ARMAS_SENCILLAS("Armas sencillas"),
	ARMAS_MARCIALES("Armas marciales"), ESPADAS_CORTAS("Espadas cortas"), ESPADAS_LARGAS("Espadas largas"),
	ESTOQUES("Estoques"), BASTONES("Bastones"), CIMITARRAS("Cimitarras"), DAGAS("Dagas"), DARDOS("Dardos"),
	GARROTES("Garrotes"), HOCES("Hoces"), HONDAS("Hondas"), JABALINAS("Jabalinas"), LANZAS("Lanzas"), MAZAS("Mazas"),
	BALLESTA_LIGERA("Ballesta Ligera"), BALLESTAS_DE_MANO("Ballestas de mano"), BALLESTA_PESADA("Ballestas pesadas"),
	HACHAS("Hachas"), MARTILLOS("Martillos"), ARCOS("Arcos"), ARMAS_DE_ASTA("Armas de asta"), ESPADONES("Espadones"),
	LATIGOS("Látigos"), PICOS("Picos"), TRIDENTES("Tridentes"), REDES("Redes"),
	CAPACIDAD_LANZAR_HECHIZOS("Capacidad de lanzar hechizos."), ARMAS_IMPROVISADAS("Armas improvisadas"),
	// HERRAMIENTAS
	HERRAMIENTAS_ALBAÑIL("Herramientas de Albañil"), HERRAMIENTAS_ALFARERO("Herramientas de Alfarero"),
	HERRAMIENTAS_CARPINTERO("Herramientas de Carpintero"), HERRAMIENTAS_CARTOGRAFO("Herramientas de Cartógrafo"),
	HERRAMIENTAS_CURTIDOR("Herramientas de Curtidor"), HERRAMIENTAS_EBANISTA("Herramientas de Ebanista"),
	HERRAMIENTAS_HERRERO("Herramientas de Herrero"), HERRAMIENTAS_JOYERO("Herramientas de Joyero"),
	HERRAMIENTAS_MANITAS("Herramientas de Manitas"), HERRAMIENTAS_SOPLADOR_VIDRIO("Herramientas de Soplador de Vidrio"),
	HERRAMIENTAS_TEJEDOR("Herramientas de Tejedor"), HERRAMIENTAS_ZAPATERO("Herramientas de Zapatero"),
	HERRAMIENTAS_ALQUIMISTA("Herramientas de Alquimista"), HERRAMIENTAS_CALIGRAFO("Herramientas de Calígrafo"),
	HERRAMIENTAS_CERVECERO("Herramientas de Cervecero"), HERRAMIENTAS_PINTOR("Herramientas de Pintor"),
	HERRAMIENTAS_LADRON("Herramientas de Ladrón"), HERRAMIENTAS_NAVEGANTE("Herramientas de Navegante"),
	UTILES_COCINERO("Útiles de Cocinero"), UTILES_ENVENENADOR("Útiles de Envenenador"),
	UTILES_HERBORISTA("Útiles de Herborista"), UTILES_DISFRAZ("Útiles para disfrazarse"),
	UTILES_FALSIFICAR("Útiles para falsificar"),
	// INSTRUMENTOS
	INSTRUMENTO_CHIRIMIA("Chirimía"), INSTRUMENTO_CUERNO("Cuerno"), INSTRUMENTO_DULCEMELE("Dulcémele"),
	INSTRUMENTO_FLAUTA("Flauta"), INSTRUMENTO_FLAUTA_PAN("Flauta de pan"), INSTRUMENTO_GAITA("Gaita"),
	INSTRUMENTO_LAUD("Laúd"), INSTRUMENTO_LIRA("Lira"), INSTRUMENTO_TAMBOR("Tambor"), INSTRUMENTO_VIOLA("Viola"),
	JUEGO_AJEDREZ_DRAGON("Ajedréz Dragón"), JUEGO_APUESTA_TRES_DRAGONES("Apuesta de los Tres Dragones"),
	JUEGO_DADOS("Dados"), JUEGO_NAIPES("Naipes"),
	// VEHICULOS
	VEHICULOS_TERRESTRES("Vehículos Terrestres"), VEHICULOS_ACUATICOS("Vehículos Acuáticos");

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
