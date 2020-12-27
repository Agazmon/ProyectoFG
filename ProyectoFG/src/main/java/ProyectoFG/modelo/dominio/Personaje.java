package ProyectoFG.modelo.dominio;

import ProyectoFG.modelo.dao.Caracteristicas;
import ProyectoFG.modelo.dao.Monedas;

public class Personaje {
	int modificadorCompetencia;
	Caracteristicas caracteristicasPersonaje;
	Monedas monedero;

	public Personaje() {
		this.modificadorCompetencia = 4;
		this.caracteristicasPersonaje = new Caracteristicas(18, 8, 16, 8, 14, 10);
		this.monedero = new Monedas();
	}

	public int getModificadorCompetencia() {
		return this.modificadorCompetencia;
	}
	public Caracteristicas getCaracteristicas() {
		return this.caracteristicasPersonaje;
	}
	public Monedas getMonedero() {
		return this.monedero;
	}
	
}
