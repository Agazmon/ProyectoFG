package ProyectoFG.modelo.dominio.idioma;

public enum TipoIdioma {
	COMUN("Común", "Común"), ELFO("Elfo", "Elfo"), ENANO("Enano", "Enano"), GIGANTE("Gigante", "Enano"),
	GNOMO("Gnomo", "Enano"), GOBLIN("Goblin", "Enano"), MEDIANO("Mediano", "Común"), ORCO("Orco","Enano"), ABISAL("Abisal","Infernal"),
	CELESTIAL("Celestial","Celestial"), DRACONICO("Dracónico", "Dracónico"), HABLA_DE_LAS_PROFUNDIDADES("Habla de las Profundidades", "-"),
	INFERNAL("Infernal","Infernal"), INFRACOMUN("Infracomún","Elfo"), PRIMORDIAL("Primordial","Enano"), SILVANO("Silvano", "Elfo");

	private String nombreIdioma;
	private String alfabetoIdioma;

	private TipoIdioma(String nombreIdioma, String alfabetoIdioma) {
		this.nombreIdioma = nombreIdioma;
	}
}
