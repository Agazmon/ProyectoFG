package ProyectoFG.modelo.dominio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import ProyectoFG.modelo.dao.BibliotecaHechizos;
import ProyectoFG.modelo.dao.Caracteristicas;
import ProyectoFG.modelo.dao.EspaciosConjuro;
import ProyectoFG.modelo.dao.Monedas;
import ProyectoFG.modelo.dominio.armadura.Armadura;
import ProyectoFG.modelo.dominio.armadura.TipoArmadura;
import ProyectoFG.modelo.dominio.hechizo.EspacioConjuro;
import ProyectoFG.modelo.dominio.hechizo.Hechizo;
import ProyectoFG.modelo.dominio.hechizo.NivelHechizo;

public class Personaje {
	int modificadorCompetencia;
	Caracteristicas caracteristicasPersonaje;
	Monedas monedero;
	Armadura armadura;
	Armadura escudo;
	EspaciosConjuro espaciosPersonaje;
	List<Hechizo> hechizosDisponibles;
	Competencias competencias;
	

	int velocidad;

	public Personaje(Armadura armadura, Armadura escudo) {
		this.modificadorCompetencia = 4;
		this.caracteristicasPersonaje = new Caracteristicas(18, 12, 16, 8, 14, 10);
		this.monedero = new Monedas();
		this.competencias = new Competencias();
		try {
			this.hechizosDisponibles = new BibliotecaHechizos().getListaHechizos();
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.espaciosPersonaje = new EspaciosConjuro(new ArrayList<EspacioConjuro>(Arrays.asList(new EspacioConjuro(NivelHechizo.NIVEL_1,1,1), new EspacioConjuro(NivelHechizo.NIVEL_2,1,1))));
		
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
	
	public EspaciosConjuro getEspaciosPersonaje() {
		return espaciosPersonaje;
	}

	public void setEspaciosPersonaje(EspaciosConjuro espaciosPersonaje) {
		this.espaciosPersonaje = espaciosPersonaje;
	}
	

	public List<Hechizo> getHechizosDisponibles() {
		return hechizosDisponibles;
	}

	public void setHechizosDisponibles(List<Hechizo> hechizosDisponibles) {
		this.hechizosDisponibles = hechizosDisponibles;
	}

	public int getModificadorCompetencia() {
		return this.modificadorCompetencia;
	}
	

	public Competencias getCompetencias() {
		return competencias;
	}

	public void setCompetencias(Competencias competencias) {
		this.competencias = competencias;
	}

	public Caracteristicas getCaracteristicas() {
		return this.caracteristicasPersonaje;
	}

	public Monedas getMonedero() {
		return this.monedero;
	}

}
