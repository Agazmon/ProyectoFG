package ProyectoFG.modelo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.clase.TipoClase;
import ProyectoFG.modelo.dominio.hechizo.Hechizo;

public class Hechizos {
	private List<Hechizo> hechizosPersonaje;
	private HashMap<Integer, List<Hechizo>> hechizoANivelX;

	public Hechizos() {
		setHechizosPersonaje(new ArrayList<>());
		setHechizoANivelX(new HashMap<>());

	}

	public Hechizos(List<Hechizo> listaHechizos, HashMap<Integer, List<Hechizo>> hechizoANivelX) {
		setHechizosPersonaje(listaHechizos);
		setHechizoANivelX(hechizoANivelX);
	}

	public Hechizos(Hechizos hechizos) {
		setHechizosPersonaje(hechizos.getHechizosPersonaje());
		setHechizoANivelX(hechizos.getHechizoANivelX());
	}

	public List<Hechizo> getHechizosPersonaje() {
		return hechizosPersonaje;
	}

	private void setHechizosPersonaje(List<Hechizo> hechizosPersonaje) {
		this.hechizosPersonaje = hechizosPersonaje;
	}

	public void anadir(Hechizo hechizo, boolean consumirMaximoAprender, Personaje personajeConsumir,
			TipoClase claseConsumir) {
		if (consumirMaximoAprender) {
			personajeConsumir.getEspacios().buscar(hechizo.getNivelBaseHechizo())
					.decrementarCapacidadHechizosParaAprender(claseConsumir, 1);
			this.hechizosPersonaje.add(new Hechizo(hechizo));
		} else {
			this.hechizosPersonaje.add(new Hechizo(hechizo));
		}
	}

	public void prepararAnadirHechizoANivelX(Hechizo hechizoAnadir, int nivel) {
		List<Hechizo> lista = this.hechizoANivelX.get(nivel);
		lista.add(new Hechizo(hechizoAnadir));
		this.hechizoANivelX.put(nivel, lista);

	}

	public void anadirHechizosDeNivelX(int nivel) {
		List<Hechizo> hechizosNivel = this.hechizoANivelX.get(nivel);
		for (Hechizo hechizo : hechizosNivel) {
			if (!this.hechizosPersonaje.contains(hechizo)) {
				this.hechizosPersonaje.add(new Hechizo(hechizo));
			}
		}
	}

	public HashMap<Integer, List<Hechizo>> getHechizoANivelX() {
		return hechizoANivelX;
	}

	public void setHechizoANivelX(HashMap<Integer, List<Hechizo>> hechizoANivelX) {
		this.hechizoANivelX = hechizoANivelX;
	}

}
