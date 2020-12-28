package ProyectoFG.modelo.dominio.hechizo;

abstract class Hechizo {
	private String nombre;
	private boolean componenteSomatico;
	private boolean componenteVerbal;
	private boolean componenteMaterial;
	private boolean concentracion;
	private int nivelBasico;
	private int rangoHechizo;
	private String duracionHechizo;
	protected Hechizo(Hechizo hechizo) {
	}

}
