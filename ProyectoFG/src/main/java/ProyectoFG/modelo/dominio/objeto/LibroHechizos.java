package ProyectoFG.modelo.dominio.objeto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ProyectoFG.modelo.dao.bibliotecas.BibliotecaHechizos;
import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.clase.TipoClase;
import ProyectoFG.modelo.dominio.hechizo.Hechizo;
import ProyectoFG.modelo.dominio.hechizo.HechizoRitual;
import ProyectoFG.modelo.dominio.hechizo.NivelHechizo;
import ProyectoFG.modelo.dominio.moneda.Moneda;

public class LibroHechizos extends ObjetoInventario {
	private HashMap<NivelHechizo, Integer> maximoHechizosLevelPorNivel;
	private List<Hechizo> hechizosLibro;
	private TipoClase claseHechizos;
	private TipoLibro tipoLibro;

	public LibroHechizos(String nombre, int peso, int cantidad, Moneda precio, TipoLibro tipoLibro,
			TipoClase claseHechizos) {
		super(nombre, peso, cantidad, precio);
		setMaximoHechizosLevelPorNivel(new HashMap<>());
		setHechizosLibro(new ArrayList<>());
		setClaseHechizos(claseHechizos);
		setTipoLibro(tipoLibro);
	}

	public LibroHechizos(String nombre, int peso, int cantidad, Moneda precio, TipoLibro tipoLibro,
			TipoClase claseHechizos, List<Hechizo> hechizosLibro) {
		super(nombre, peso, cantidad, precio);
		setMaximoHechizosLevelPorNivel(new HashMap<>());
		setHechizosLibro(hechizosLibro);
		setClaseHechizos(claseHechizos);
		setTipoLibro(tipoLibro);
	}

	public HashMap<NivelHechizo, Integer> getMaximoHechizosLevelPorNivel() {
		return maximoHechizosLevelPorNivel;
	}

	private void setMaximoHechizosLevelPorNivel(HashMap<NivelHechizo, Integer> maximoHechizosLevelPorNivel) {
		this.maximoHechizosLevelPorNivel = maximoHechizosLevelPorNivel;
	}

	public List<Hechizo> getHechizosLibro() {
		return hechizosLibro;
	}

	private void setHechizosLibro(List<Hechizo> hechizosLibro) {
		this.hechizosLibro = hechizosLibro;
	}

	public TipoClase getClaseHechizos() {
		return claseHechizos;
	}

	private void setClaseHechizos(TipoClase claseHechizos) {
		this.claseHechizos = claseHechizos;
	}

	public TipoLibro getTipoLibro() {
		return tipoLibro;
	}

	private void setTipoLibro(TipoLibro tipoLibro) {
		this.tipoLibro = tipoLibro;
	}

	public boolean lanzarHechizoLibro(Hechizo hechizoLanzamiento) {
		if (hechizoLanzamiento == null) {
			throw new IllegalArgumentException("No se puede lanzar un hechizo nulo. Desde el libro de hechizos");
		} else if (hechizosLibro.isEmpty()) {
			throw new IllegalArgumentException(
					"No se puede lanzar hechizos del libro de hechizos, no tiene ninguno escrito.");
		} else {
			if (!getHechizosLibro().contains(hechizoLanzamiento)) {
				throw new IllegalArgumentException("El libro no tiene el hechizo buscado");
			} else {
				if (tipoLibro == TipoLibro.LANZADOR_RITUAL) {
					if (hechizoLanzamiento.getPuedeRitual() == (NivelHechizo.RITUAL)) {
						return new HechizoRitual(hechizoLanzamiento).lanzar(NivelHechizo.RITUAL);
					} else {
						throw new IllegalArgumentException(
								"El hechizo no puede ser lanzado como ritual. Y este libro solo admite rituales.");
					}
				} else {
					// TODO esto es si el libro es de un tipo no controlado.
					return true;
				}
			}
		}
	}

	public void aumentarMaximoHechizos(NivelHechizo nivelAumento, int cantidad) {
		int cantidadActual = maximoHechizosLevelPorNivel.get(nivelAumento);
		maximoHechizosLevelPorNivel.put(nivelAumento, cantidadActual + cantidad);
	}

	public void anadirHechizo(Personaje pj, Hechizo hechizoAnadir) {
		if (hechizoAnadir == null) {
			throw new IllegalArgumentException("No se puede añadir un hechizo nulo al libro de hechizos");
		} else {
			if (pj.getHechizosDisponibles().contains(hechizoAnadir)) {
				throw new IllegalArgumentException("El personaje ya puede lanzar este hechizo.");
			} else {
				if (getHechizosLibro().contains(hechizoAnadir)) {
					throw new IllegalArgumentException("El libro ya contiene este hechizo.");
				} else {
					if (!BibliotecaHechizos.obtenerHechizosClase(getClaseHechizos()).contains(hechizoAnadir)) {
						throw new IllegalArgumentException(
								"El hechizo no es de la clase que admite el libro, el libro admite:"
										+ getClaseHechizos().toString());
					} else {
						this.hechizosLibro.add(new HechizoRitual(hechizoAnadir));
					}
				}
			}
		}
	}

}
