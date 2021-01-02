package ProyectoFG.modelo.dominio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import ProyectoFG.modelo.dao.Caracteristicas;
import ProyectoFG.modelo.dao.Contadores;
import ProyectoFG.modelo.dao.Dotes;
import ProyectoFG.modelo.dao.EspaciosConjuro;
import ProyectoFG.modelo.dao.Monedas;
import ProyectoFG.modelo.dao.ObjetosInventario;
import ProyectoFG.modelo.dao.bibliotecas.BibliotecaHechizos;
import ProyectoFG.modelo.dominio.arma.Arma;
import ProyectoFG.modelo.dominio.armadura.Armadura;
import ProyectoFG.modelo.dominio.armadura.TipoArmadura;
import ProyectoFG.modelo.dominio.hechizo.EspacioConjuro;
import ProyectoFG.modelo.dominio.hechizo.Hechizo;
import ProyectoFG.modelo.dominio.hechizo.NivelHechizo;
import ProyectoFG.modelo.dominio.raza.Raza;
import ProyectoFG.modelo.dominio.raza.TamanoRaza;

public class Personaje {
	int modificadorCompetencia;
	Caracteristicas caracteristicasPersonaje;
	Monedas monedero;
	Armadura armadura;
	Armadura escudo;
	EspaciosConjuro espaciosPersonaje;
	List<Hechizo> hechizosDisponibles;
	Contadores contadores;
	Competencias competencias;
	Dotes dotes;
	Arma armaIzquierda;
	Arma armaDerecha;
	ObjetosInventario inventarioPersonaje;
	Raza razaPersonaje;
	

	int velocidad;
	int iniciativa;

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
		setIniciativa(getCaracteristicas().buscar(Atributo.DESTREZA).getModificador());
		setArmadura(armadura);
		setEscudo(escudo);
		this.inventarioPersonaje = new ObjetosInventario();
		this.razaPersonaje = new Raza("Humano", TamanoRaza.PEQUENA);

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
	

	public Caracteristicas getCaracteristicasPersonaje() {
		return caracteristicasPersonaje;
	}

	public void setCaracteristicasPersonaje(Caracteristicas caracteristicasPersonaje) {
		this.caracteristicasPersonaje = caracteristicasPersonaje;
	}

	public Contadores getContadores() {
		return contadores;
	}

	public void setContadores(Contadores contadores) {
		this.contadores = contadores;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public void setModificadorCompetencia(int modificadorCompetencia) {
		this.modificadorCompetencia = modificadorCompetencia;
	}

	public void setMonedero(Monedas monedero) {
		this.monedero = monedero;
	}

	public Caracteristicas getCaracteristicas() {
		return this.caracteristicasPersonaje;
	}

	public Monedas getMonedero() {
		return this.monedero;
	}

	public Dotes getDotes() {
		return dotes;
	}

	public void setDotes(Dotes dotes) {
		this.dotes = dotes;
	}

	public int getIniciativa() {
		return iniciativa;
	}

	public void setIniciativa(int iniciativa) {
		this.iniciativa = iniciativa;
	}

	public ObjetosInventario getInventarioPersonaje() {
		return inventarioPersonaje;
	}

	public void setInventarioPersonaje(ObjetosInventario inventarioPersonaje) {
		this.inventarioPersonaje = inventarioPersonaje;
	}

	public Raza getRazaPersonaje() {
		return razaPersonaje;
	}

	public void setRazaPersonaje(Raza razaPersonaje) {
		this.razaPersonaje = razaPersonaje;
	}

	public Arma getArmaIzquierda() {
		return armaIzquierda;
	}

	public void setArmaIzquierda(Arma armaIzquierda) {
		this.armaIzquierda = armaIzquierda;
	}

	public Arma getArmaDerecha() {
		return armaDerecha;
	}

	public void setArmaDerecha(Arma armaDerecha) {
		this.armaDerecha = armaDerecha;
	}
	
	
	
	
	

}
