package ProyectoFG.modelo.dominio.idioma;

public enum TipoIdioma {
	COMUN("Com�n", "Com�n"), ELFO("Elfo", "Elfo"), ENANO("Enano", "Enano"), GIGANTE("Gigante", "Enano"),
	GNOMO("Gnomo", "Enano"), GOBLIN("Goblin", "Enano"), MEDIANO("Mediano", "Com�n"), ORCO("Orco","Enano"), ABISAL("Abisal","Infernal"),
	CELESTIAL("Celestial","Celestial"), DRACONICO("Drac�nico", "Drac�nico"), HABLA_DE_LAS_PROFUNDIDADES("Habla de las Profundidades", "-"),
	INFERNAL("Infernal","Infernal"), INFRACOMUN("Infracom�n","Elfo"), PRIMORDIAL("Primordial","Enano"), SILVANO("Silvano", "Elfo");

	private String nombreIdioma;
	private String alfabetoIdioma;

	private TipoIdioma(String nombreIdioma, String alfabetoIdioma) {
		this.nombreIdioma = nombreIdioma;
	}
}
