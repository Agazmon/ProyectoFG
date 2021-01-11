package ProyectoFG.modelo.dominio.dote;

public enum TipoDote {
	ACECHADOR("Acechador"), ACTOR("Actor"), AFORTUNADO("Afortunado"), ALERTA("Alerta"), APRESADOR("Apresador"),
	ATACANTE_A_LA_CARGA("Atacante a la carga"), ATACANTE_SALVAJE("Atacante salvaje"),
	ATLETA_FUERZA("Atleta, +1 Fuerza"), ATLETA_DESTREZA("Atleta, +1 Destreza"), AZOTE_DE_MAGOS("Azote de magos"),
	CENTINELA("Centinela"), COMBATIENTE_CON_DOS_ARMAS("Combatiente con dos armas"),
	COMBATIENTE_MONTADO("Combatiente montado"), DUELISTA_DEFENSIVO("Duelista defensivo"), DURO("Duro"),
	EXPERTO_EN_BALLESTAS("Experto en ballestas"), EXPLORADOR_DE_MAZMORRAS("Explorador de mazmorras"),
	HABILIDOSO("Habilidoso"), INICIADO_EN_LA_MAGIA_BARDO("Iniciado en la magia, Hechizos de Bardo"),
	INICIADO_EN_LA_MAGIA_BRUJO("Iniciado en la magia, Hechizos de Bardo"),
	INICIADO_EN_LA_MAGIA_CLERIGO("Iniciado en la magia, Hechizos de Clérigo"),
	INICIADO_EN_LA_MAGIA_DRUIDA("Iniciado en la magia, Hechizos de Druida"),
	INICIADO_EN_LA_MAGIA_HECHICERO("Iniciado en la magia, Hechizos de Hechicero"),
	INICIADO_EN_LA_MAGIA_MAGO("Iniciado en la magia, Hechizos de Mago"), LANZADOR_EN_COMBATE("Lanzador en combate"),
	LANZADOR_PRECISO_BARDO("Lanzador preciso, Hechizo de Bardo"),
	LANZADOR_PRECISO_BRUJO("Lanzador preciso, Hechizo de Brujo"),
	LANZADOR_PRECISO_CLERIGO("Lanzador preciso, Hechizo de Clérigo"),
	LANZADOR_PRECISO_DRUIDA("Lanzador preciso, Hechizo de Druida"),
	LANZADOR_PRECISO_HECHICERO("Lanzador preciso, Hechizo de Hechicero"),
	LANZADOR_PRECISO_MAGO("Lanzador preciso, Hechizo de Mago"),
	LANZADOR_RITUAL_BARDO("Lanzador ritual, Hechizos de Bardo"),
	LANZADOR_RITUAL_BRUJO("Lanzador ritual, Hechizos de Brujo"),
	LANZADOR_RITUAL_CLERIGO("Lanzador ritual, Hechizos de Clérigo"),
	LANZADOR_RITUAL_DRUIDA("Lanzador ritual, Hechizos de Druida"),
	LANZADOR_RITUAL_HECHICERO("Lanzador ritual, Hechizos de Hechicero"),
	LANZADOR_RITUAL_MAGO("Lanzador ritual, Hechizos de Mago"), LIDER_INSPIRADOR("Lider inspirador"),
	LIGERAMENTE_ACORAZADO_FUERZA("Ligeramente acorazado, + 1 Fuerza"),
	LIGERAMENTE_ACORAZADO_DESTREZA("Ligeramente acorazado, +1 Destreza"), LINGUISTA("Lingüista"),
	MAESTRO_DE_ARMAS_FUERZA("Maestro de armas, +1 Fuerza"), MAESTRO_DE_ARMAS_DESTREZA("Maestro de armas, +1 Destreza"),
	MAESTRO_EN_ARMADURAS_MEDIAS("Maestro en armaduras medias"),
	MAESTRO_EN_ARMADURAS_PESADAS("Maestro en armaduras pesadas"), MAESTRO_EN_ARMAS_DE_ASTA("Maestro en armas de asta"),
	MAESTRO_EN_ARMAS_PESADAS("Maestro en armas pesadas"), MAESTRO_EN_ESCUDOS("Maestro en escudos"),
	MATON_DE_TABERNA_FUERZA("Matón de taberna, +1 Fuerza"),
	MATON_DE_TABERNA_CONSTITUCION("Matón de taberna, +1 Constitucion"), MENTE_AGUDA("Mente aguda"),
	MODERADAMENTE_ACORAZADO_DESTREZA("Moderadamente acorazado, +1 Destreza"),
	MODERADAMENTE_ACORAZADO_FUERZA("Moderadamente acorazado, +1 Fuerza"), MOVIL("Móvil"),
	MUY_ACORAZADO("Muy acorazado"), OBSERVADOR_INTELIGENCIA("Observador,+1 Inteligencia"),
	OBSERVADOR_SABIDURIA("Observador,+1 Sabiduría"), RESILIENTE_FUERZA("Resiliente, Fuerza"),
	RESILIENTE_DESTREZA("Resiliente, Destreza"), RESILIENTE_CONSTITUCION("Resiliente, Constitución"),
	RESILIENTE_INTELIGENCIA("Resiliente, Inteligencia"), RESILIENTE_SABIDURIA("Resiliente, Sabiduría"),
	RESILIENTE_CARISMA("Resiliente, Carisma"), RESISTENTE("Resistente"), SANADOR("Sanador"),
	TIRADOR_DE_PRIMERA("Tirador de primera"), VERSADO_EN_LAS_ARMAS("Versado en las armas"),
	VERSADO_EN_UN_ELEMENTO_ACIDO("Versado en un elemento, Tipo de daño: Ácido"),
	VERSADO_EN_UN_ELEMENTO_FRIO("Versado en un elemento, Tipo de daño: Frío"),
	VERSADO_EN_UN_ELEMENTO_FUEGO("Versado en un elemento, Tipo de daño: Fuego"),
	VERSADO_EN_UN_ELEMENTO_RELAMPAGO("Versado en un elemento, Tipo de daño: Relámpago"),
	VERSADO_EN_UN_ELEMENTO_TRUENO("Versado en un elemento, Tipo de daño: Trueno"),
	// DOTES RACIALES
	VISION_EN_LA_OSCURIDAD("Visión en la Oscuridad"),
	VISION_EN_LA_OSCURIDAD_MEJORADA("Visión en la oscuridad mejorada"), RESISTENCIA_ENANA("Resistencia enana"),
	AGUANTE_ENANO("Aguante Enano"), ENTRENAMIENTO_DE_COMBATE_ENANO("Entrenamiento de combate enano"),
	ENTRENAMIENTO_CON_ARMADURAS_ENANAS("Entrenamiento con Armadura Enana"),
	COMPETENCIA_HERRAMIENTAS("Competencia con Herramientas"), COMPETENCIA_ARMADURAS("Competencia con armaduras"),
	AFINIDAD_PIEDRA("Afinidad con la piedra"), IDIOMAS_ADICIONAL("Idiomas Raciales."),
	IDIOMAS_RACIALES("Idiomas Raciales."), IDIOMAS_SUBRACIALES("Idiomas Subraciales."),
	MEJORA_CARACTERISTICA("Mejora de característica, raza."),
	MEJORA_CARACTERISTICA_SUBRAZA("Mejora de característica, subraza"), SENTIDOS_AGUDOS("Sentidos Agudos"),
	LINAJE_FEERICO("Linaje Feérico"), TRANCE("Trance"), ENTRENAMIENTO_ARMAS_ELFICAS("Entrenamiento con Almas Élficas"),
	ENTRENAMIENTO_ARMAS_DROW("Entrenamiento con Armas Drow"), TRUCO("Truco"),
	MASCARA_DE_LA_NATURALEZA("Máscara de la Naturaleza"), SENSIBILIDAD_A_LA_LUZ_SOLAR("Sensibilidad a la luz solar"),
	MAGIA_DROW("Magia drow"), VALIENTE("Valiente"), AGILIDAD_DE_MEDIANO("Agilidad de mediano"),SIGILOSO_POR_NATURALEZA("Sigiloso por naturaleza"),RESISTENCIA_FORNIDO("'Resistencia de Fornido");

	;

	private String nombreDote;

	private TipoDote(String nombreDote) {
		setNombreDote(nombreDote);
	}

	public String getNombreDote() {
		return nombreDote;
	}

	private void setNombreDote(String nombreDote) {
		this.nombreDote = nombreDote;
	}

}
