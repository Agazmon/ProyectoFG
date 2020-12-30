package ProyectoFG.modelo.dao;

import java.util.ArrayList;
import java.util.List;

import ProyectoFG.modelo.dominio.hechizo.EspacioConjuro;
import ProyectoFG.modelo.dominio.hechizo.NivelHechizo;

public class EspaciosConjuro {
	List<EspacioConjuro> espaciosConjuro;

	public EspaciosConjuro(List<EspacioConjuro> espacios) {
		setEspaciosConjuro(copiaEspaciosConjuro(espacios));
	}

	public EspaciosConjuro(EspaciosConjuro espacios) {
		setEspaciosConjuro(copiaEspaciosConjuro(espacios.getEspaciosConjuro()));
	}

	public void setEspaciosConjuro(List<EspacioConjuro> espacios) {
		this.espaciosConjuro = copiaEspaciosConjuro(espacios);
	}

	public List<EspacioConjuro> getEspaciosConjuro() {
		return this.espaciosConjuro;
	}

	private List<EspacioConjuro> copiaEspaciosConjuro(List<EspacioConjuro> espacios) {
		if (espacios.isEmpty()) {
			return espacios;
		} else {
			List<EspacioConjuro> listaCopia = new ArrayList<>();
			for (EspacioConjuro espacioConjuro : espacios) {
				listaCopia.add(new EspacioConjuro(espacioConjuro));
			}
			return listaCopia;
		}
	}

	public void insertar(EspacioConjuro espacioInsertar) {
		if (espacioInsertar == null) {
			throw new IllegalArgumentException("No se puede añadir un espacio de hechizo nulo.");
		} else if (espaciosConjuro.contains(espacioInsertar)) {
			throw new IllegalArgumentException("No se puede insertar un espacio de hechizo que ya existe.");
		} else {

		}
	}

	public EspacioConjuro buscar(NivelHechizo nivelBuscar) {
		if (nivelBuscar == null) {
			throw new IllegalArgumentException(
					"No se puede buscar un espacio de conjuro por un nivel de hechizo nulo.");
		} else if (getEspaciosConjuro().contains(new EspacioConjuro(nivelBuscar, 1, 1))) {
			List<EspacioConjuro> espacios = getEspaciosConjuro();
			EspacioConjuro espacioEncontrado = espacios.get(espacios.indexOf(new EspacioConjuro(nivelBuscar, 1, 1)));
			return espacioEncontrado;
		} else {
			throw new IllegalArgumentException("El personaje no tiene espacios de conjuro del nivel pedido.");
		}

	}

}
