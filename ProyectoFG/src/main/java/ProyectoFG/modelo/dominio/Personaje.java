package ProyectoFG.modelo.dominio;

import ProyectoFG.modelo.dao.Caracteristicas;
import ProyectoFG.modelo.dao.Monedas;
import ProyectoFG.modelo.dominio.armadura.Armadura;
import ProyectoFG.modelo.dominio.armadura.TipoArmadura;

public class Personaje {
	int modificadorCompetencia;
	Caracteristicas caracteristicasPersonaje;
	Monedas monedero;
	Armadura armadura;
	Armadura escudo;
	int velocidad;

	public Personaje(Armadura armadura, Armadura escudo) {
		this.modificadorCompetencia = 4;
		this.caracteristicasPersonaje = new Caracteristicas(18, 12, 16, 8, 14, 10);
		this.monedero = new Monedas();
		setArmadura(armadura);
		setEscudo(escudo);

	}

	public void setArmadura(Armadura armadura) {
		if (armadura.getTipoArmadura().equals(TipoArmadura.ESCUDOS)) {
			throw new IllegalArgumentException(
					"No se puede equipar un escudo como armadura, tiene que ser equipado como escudo.");
		} else {
			this.armadura = new Armadura(armadura);
		}
	}

	public Armadura getArmadura() {
		return new Armadura(this.armadura);
	}

	public void setEscudo(Armadura escudo) {
		if (!escudo.getTipoArmadura().equals(TipoArmadura.ESCUDOS)) {
			throw new IllegalArgumentException(
					"No se puede equipar una pieza de armadura como escudo, tiene que ser equipado como pieza de armadura.");
		} else {
			this.escudo = new Armadura(escudo);
		}
	}

	public Armadura getEscudo() {
		return this.escudo;
	}

	public int getCAFinal() {
		Armadura armadura = getArmadura();
		Armadura escudo = getEscudo();
		if (armadura == null && escudo == null) {
			return 10 + getCaracteristicas().buscar(Atributo.DESTREZA).getModificador();
		} else if (armadura != null && escudo == null) {
			return getArmadura().getCAFinal(this);
		} else if (armadura == null && escudo != null) {
			return 10 + getCaracteristicas().buscar(Atributo.DESTREZA).getModificador() + getEscudo().getCAFinal(this);
		} else {
			return getArmadura().getCAFinal(this) + getEscudo().getCAFinal(this);
		}
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
