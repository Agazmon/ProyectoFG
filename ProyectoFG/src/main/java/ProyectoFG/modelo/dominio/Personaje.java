package ProyectoFG.modelo.dominio;

import ProyectoFG.modelo.dao.Caracteristicas;

public class Personaje {
	int modificadorCompetencia;
	Caracteristicas caracteristicasPersonaje;

	public Personaje() {
		this.modificadorCompetencia = 4;
		this.caracteristicasPersonaje = new Caracteristicas(18, 8, 16, 8, 14, 10);
	}

	public int getModificadorCompetencia() {
		return this.modificadorCompetencia;
	}

	public Caracteristicas getCaracteristicas() {
		return this.caracteristicasPersonaje;
	}
}
