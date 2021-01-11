package ProyectoFG.modelo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import ProyectoFG.modelo.dominio.accion.TiempoRecuperacion;
import ProyectoFG.modelo.dominio.clase.TipoClase;
import ProyectoFG.modelo.dominio.hechizo.EspacioConjuro;
import ProyectoFG.modelo.dominio.hechizo.NivelHechizo;

public class EspaciosConjuro {
	private List<EspacioConjuro> espaciosConjuro;

	public EspaciosConjuro() {
		setEspaciosConjuro(new ArrayList<>());
	}

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
			int index = espaciosConjuro.indexOf(espacioInsertar);
			EspacioConjuro encontrado = espaciosConjuro.get(index);
			for (Entry<TipoClase, Integer> iteracion : espacioInsertar.getCantidadHechizosParaAprender().entrySet()) {
				encontrado.aumentarCapacidadHechizosParaAprender(iteracion.getKey(), iteracion.getValue());
			}
		} else {
			this.espaciosConjuro.add(espacioInsertar);
		}
	}

	public EspacioConjuro buscar(NivelHechizo nivelBuscar) {
		if (nivelBuscar == null) {
			throw new IllegalArgumentException(
					"No se puede buscar un espacio de conjuro por un nivel de hechizo nulo.");
		} else if (getEspaciosConjuro().contains(
				new EspacioConjuro(nivelBuscar, 1, 1, TipoClase.BARBARO, 1, TiempoRecuperacion.DESCANSO_CORTO))) {
			List<EspacioConjuro> espacios = getEspaciosConjuro();
			EspacioConjuro espacioEncontrado = espacios.get(espacios.indexOf(
					new EspacioConjuro(nivelBuscar, 1, 1, TipoClase.BARBARO, 1, TiempoRecuperacion.DESCANSO_CORTO)));
			return espacioEncontrado;
		} else {
			throw new IllegalArgumentException("El personaje no tiene espacios de conjuro del nivel pedido.");
		}

	}

	@Override
	public String toString() {
		return "EspaciosConjuro [espaciosConjuro=" + espaciosConjuro + "]";
	}
	

}
