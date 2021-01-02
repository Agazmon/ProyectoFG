package ProyectoFG.modelo.dominio.dotes;

public enum TipoDote {
	ACECHADOR("Acechador"), ACTOR("Actor"), AFORTUNADO("Afortunado"), ALERTA("Alerta"), APRESADOR("Apresador"),
	ATACANTE_A_LA_CARGA("Atacante a la carga"), ATACANTE_SALVAJE("Atacante salvaje"), ATLETA("Atleta"),
	AZOTE_DE_MAGOS("Azote de magos"), CENTINELA("Centinela"), COMBATIENTE_CON_DOS_ARMAS("Combatiente con dos armas"),
	COMBATIENTE_MONTADO("Combatiente montado"), DUELISTA_DEFENSIVO("Duelista defensivo"), DURO("Duro"),
	EXPERTO_EN_BALLESTAS("Experto en ballestas"), EXPLORADOR_DE_MAZMORRAS("Explorador de mazmorras"),
	HABILIDOSO("Habilidoso"), INICIADO_EN_LA_MAGIA("Iniciado en la magia"), LANZADOR_EN_COMBATE("Lanzador en combate"),
	LANZADOR_PRECISO("Lanzador prciso"), LANZADOR_RITUAL("Lanzador ritual"), LIDER_INSPIRADOR("Lider inspirador"),
	LIGERAMENTE_ACORAZADO("Ligeramente acorazado"), LINGUISTA("Lingüista"), MAESTRO_DE_ARMAS("Maestro de armas"),
	MAESTRO_EN_ARMADURAS_MEDIAS("Maestro en armaduras medias"),
	MAESTRO_EN_ARMADURAS_PESADAS("Maestro en armaduras pesadas"), MAESTRO_EN_ARMAS_DE_ASTA("Maestro en armas de asta"),
	MAESTRO_EN_ARMAS_PESADAS("Maestro en armas pesadas"), MAESTRO_EN_ESCUDOS("Maestro en escudos"),
	MATON_DE_TABERNA("Matón de taberna"), MENTE_AGUDA("Mente aguda"),
	MODERADAMENTE_ACORAZADO("Moderadamente acorazado"), MOVIL("Móvil"), MUY_ACORAZADO("Muy acorazado"),
	OBSERVADOR("Observador"), RESILIENTE("Resiliente"), RESISTENTE("Resistente"), SANADOR("Sanador"),
	TIRADOR_DE_PRIMERA("Tirador de primera"), VERSADO_EN_LAS_ARMAS("Versado en las armas"),
	VERSADO_EN_UN_ELEMENTO("Versado en un elemento");

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
