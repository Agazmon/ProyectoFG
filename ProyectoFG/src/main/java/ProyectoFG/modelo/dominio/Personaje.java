package ProyectoFG.modelo.dominio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import ProyectoFG.modelo.dao.Caracteristicas;
import ProyectoFG.modelo.dao.Competencias;
import ProyectoFG.modelo.dao.Contadores;
import ProyectoFG.modelo.dao.Dotes;
import ProyectoFG.modelo.dao.EspaciosConjuro;
import ProyectoFG.modelo.dao.Habilidades;
import ProyectoFG.modelo.dao.Idiomas;
import ProyectoFG.modelo.dao.Monedas;
import ProyectoFG.modelo.dao.ObjetosInventario;
import ProyectoFG.modelo.dao.bibliotecas.BibliotecaHechizos;
import ProyectoFG.modelo.dominio.accion.TiempoRecuperacion;
import ProyectoFG.modelo.dominio.arma.Arma;
import ProyectoFG.modelo.dominio.arma.TipoArma;
import ProyectoFG.modelo.dominio.armadura.Armadura;
import ProyectoFG.modelo.dominio.armadura.TipoArmadura;
import ProyectoFG.modelo.dominio.clase.TipoClase;
import ProyectoFG.modelo.dominio.competencia.Competencia;
import ProyectoFG.modelo.dominio.competencia.TipoCompetencia;
import ProyectoFG.modelo.dominio.dote.DoteRequisitoCompetencia;
import ProyectoFG.modelo.dominio.dote.TipoDote;
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
	Arma manoSecundaria;
	Arma manoPrincipal;
	ObjetosInventario inventarioPersonaje;
	Raza razaPersonaje;
	Habilidades habilidades;
	private Idiomas idiomas;
	int velocidad;
	private int nivelPersonaje;
	private int puntosDeGolpeActuales;
	private int puntosDeGolpeMaximos;
	
	public Personaje(Armadura armadura, Armadura escudo) {
		this.modificadorCompetencia = 1;
		this.caracteristicasPersonaje = new Caracteristicas(13, 20, 10, 13, 13, 10);
//		new Caracteristicas(fuerza, destreza, constitucion, inteligencia, sabiduria, carisma);
//		this.caracteristicasPersonaje = new Caracteristicas(18, 12, 16, 8, 14, 10);
		this.habilidades = new Habilidades();
		this.monedero = new Monedas();
		this.competencias = new Competencias(Arrays.asList(new Competencia(TipoCompetencia.ARMAS_MARCIALES, true)));
		this.hechizosDisponibles = BibliotecaHechizos.getListaHechizos();
		this.espaciosPersonaje = new EspaciosConjuro(new ArrayList<EspacioConjuro>(
				Arrays.asList(new EspacioConjuro(NivelHechizo.NIVEL_1, 1, 1, TipoClase.BARBARO, 1, TiempoRecuperacion.DESCANSO_CORTO),
						new EspacioConjuro(NivelHechizo.NIVEL_2, 1, 1, TipoClase.BARDO, 1, TiempoRecuperacion.DESCANSO_LARGO))));
		setArmadura(armadura);
		setEscudo(escudo);
		this.inventarioPersonaje = new ObjetosInventario();
		this.razaPersonaje = new Raza("Humano", TamanoRaza.PEQUENA);
		this.setIdiomas(new Idiomas());
		this.dotes = new Dotes();
		setNivelPersonaje(1);
		setPuntosDeGolpeActuales(10);
		setPuntosDeGolpeMaximos(10);
		// new
		// DoteRequisitoCompetencia(TipoDote.MAESTRO_EN_ARMADURAS_MEDIAS,"descripcion"
		// ,TipoCompetencia.ARMADURA_MEDIA).anadirDote(this);

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
		int bono = 0;
		if (getDotes().buscar(TipoDote.COMBATIENTE_CON_DOS_ARMAS) != null) {
			if (getManoPrincipal() != null && getManoSecundaria() != null) {
				if (getManoPrincipal() instanceof Arma && getManoSecundaria() instanceof Arma) {
					if (getManoPrincipal().getTipoDeArma() == TipoArma.CUERPO_A_CUERPO
							&& getManoSecundaria().getTipoDeArma() == TipoArma.CUERPO_A_CUERPO) {
						bono += 1;
					}
				}
			}

		}
		if (armadura == null && escudo == null) {
			return 10 + getCaracteristicas().buscar(Atributo.DESTREZA).getModificador() + bono;
		} else if (armadura != null && escudo == null) {
			return getArmadura().getCAFinal(this);
		} else if (armadura == null && escudo != null) {
			return 10 + getCaracteristicas().buscar(Atributo.DESTREZA).getModificador() + getEscudo().getCAFinal(this)
					+ bono;
		} else {
			return getArmadura().getCAFinal(this) + getEscudo().getCAFinal(this) + bono;
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
		if (this.getDotes().buscar(TipoDote.ALERTA) != null) {
			return this.getCaracteristicas().buscar(Atributo.DESTREZA).getModificador() + 5;
		} else {
			return this.getCaracteristicas().buscar(Atributo.DESTREZA).getModificador();
		}
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

	public Arma getManoSecundaria() {
		return manoSecundaria;
	}

	public void setManoSecundaria(Arma manoSecundaria) {
		this.manoSecundaria = manoSecundaria;
	}

	public Arma getManoPrincipal() {
		return manoPrincipal;
	}

	public void setManoPrincipal(Arma manoPrincipal) {
		this.manoPrincipal = manoPrincipal;
	}

	public Habilidades getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(Habilidades habilidades) {
		this.habilidades = habilidades;
	}

	public int getNivelPersonaje() {
		return nivelPersonaje;
	}

	public void setNivelPersonaje(int nivelPersonaje) {
		this.nivelPersonaje = nivelPersonaje;
	}

	public int getPuntosDeGolpeActuales() {
		return puntosDeGolpeActuales;
	}

	public void setPuntosDeGolpeActuales(int puntosDeGolpeActuales) {
		this.puntosDeGolpeActuales = puntosDeGolpeActuales;
	}

	public int getPuntosDeGolpeMaximos() {
		return puntosDeGolpeMaximos;
	}

	public void setPuntosDeGolpeMaximos(int puntosDeGolpeMaximos) {
		this.puntosDeGolpeMaximos = puntosDeGolpeMaximos;
	}

	public Idiomas getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(Idiomas idiomas) {
		this.idiomas = idiomas;
	}

}
