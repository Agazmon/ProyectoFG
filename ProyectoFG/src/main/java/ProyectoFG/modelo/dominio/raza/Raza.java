package ProyectoFG.modelo.dominio.raza;

import ProyectoFG.modelo.dominio.Personaje;

public abstract class Raza {

	protected String nombreRaza;
	protected String nombreSubraza;
	protected TamanoRaza tamanoRaza;
	private Personaje personaje;
	private boolean racialesAplicadas = false;
	private boolean subracialesAplicadas = false;

	protected Raza(Personaje personaje, String nombreRaza, String nombreSubraza, TamanoRaza tamanoRaza) {
		setPersonaje(personaje);
		setNombreRaza(nombreRaza);
		setNombreSubraza(nombreSubraza);
		setTamanoRaza(tamanoRaza);
	}

	public String getNombreRaza() {
		return this.nombreRaza;
	}

	private void setNombreRaza(String nombreRaza) {
		if (nombreRaza == null) {
			throw new IllegalArgumentException("El nombre de una raza no puede ser nulo.");
		} else if (nombreRaza.isBlank()) {
			throw new IllegalArgumentException("El nombre de una raza no puede estar vacío.");
		} else {
			this.nombreRaza = nombreRaza.trim();
		}
	}

	public String getNombreSubraza() {
		return nombreSubraza;
	}

	private void setNombreSubraza(String nombreSubraza) {
		if (nombreSubraza == null) {
			throw new IllegalArgumentException("El nombre de una subraza no puede ser nulo.");
		} else if (nombreSubraza.isBlank()) {
			throw new IllegalArgumentException("El nombre de una subraza no puede estar vacío.");
		} else {
			this.nombreSubraza = nombreSubraza.trim();
		}
	}

	public TamanoRaza getTamanoRaza() {
		return this.tamanoRaza;
	}

	private void setTamanoRaza(TamanoRaza tamanoRaza) {
		if (tamanoRaza == null) {
			System.out.println("El tamaño de una Raza no puede ser nulo.");
		} else {
			this.tamanoRaza = tamanoRaza;
		}
	}

	public Personaje getPersonaje() {
		return this.personaje;
	}

	public void setPersonaje(Personaje personaje) {
		if (personaje == null) {
			throw new IllegalArgumentException(
					"La raza necesita saber a qué personaje debe aplicar las características raciales.");
		} else {
			this.personaje = personaje;
		}
	}

	public boolean isRacialesAplicadas() {
		return racialesAplicadas;
	}

	protected void setRacialesAplicadas(boolean racialesAplicadas) {
		this.racialesAplicadas = racialesAplicadas;
	}

	public boolean isSubracialesAplicadas() {
		return subracialesAplicadas;
	}

	protected void setSubracialesAplicadas(boolean subracialesAplicadas) {
		this.subracialesAplicadas = subracialesAplicadas;
	}

	protected abstract void aplicarRaciales();

	@Override
	public abstract String toString();

}
