package ProyectoFG.modelo.dominio.hechizo;

public class HechizoRitual extends Hechizo {
	
	public HechizoRitual(Hechizo hechizo) {
		super(hechizo);
		// TODO Auto-generated constructor stub
	}
	
	public boolean lanzar(NivelHechizo espacioConsumo) {
		if (espacioConsumo == null) {
			throw new IllegalArgumentException("El espacio a consumir por el hechizo no puede ser nulo.");
		} else if (espacioConsumo != NivelHechizo.RITUAL) {
			throw new IllegalArgumentException("Este hechizo solo puede ser lanzado como Ritual.");
		} else {
			if (this.getPuedeRitual() != NivelHechizo.RITUAL) {
				throw new IllegalArgumentException("Este hechizo no puede ser lanzado como Ritual.");
			} else {
				return true;
			}
		}
	}

}
