package ProyectoFG.modelo.dao;

import java.util.ArrayList;
import java.util.List;

import ProyectoFG.modelo.dominio.salvacion.Salvacion;
import ProyectoFG.modelo.dominio.salvacion.TipoSalvacion;

public class Salvaciones {
	private List<Salvacion> listaSalvaciones;

	// Constructores
	public Salvaciones() {
		listaSalvaciones = new ArrayList<>();
		insertar(new Salvacion(TipoSalvacion.SALVACION_FUERZA));
		insertar(new Salvacion(TipoSalvacion.SALVACION_DESTREZA));
		insertar(new Salvacion(TipoSalvacion.SALVACION_CONSTITUCION));
		insertar(new Salvacion(TipoSalvacion.SALVACION_INTELIGENCIA));
		insertar(new Salvacion(TipoSalvacion.SALVACION_SABIDURIA));
		insertar(new Salvacion(TipoSalvacion.SALVACION_CARISMA));
	}

	public Salvaciones(Boolean[] competencias) {
		if (competencias.length < 6) {
			throw new IllegalArgumentException("Faltan competencias para asignar a las salvaciones. Hay menos de 6.");
		} else if (competencias.length > 6) {
			throw new IllegalArgumentException("Sobran competencias para asignar a las salvaciones. Hay mas de 6.");
		} else {
			listaSalvaciones = new ArrayList<>();
			insertar(new Salvacion(TipoSalvacion.SALVACION_FUERZA, competencias[0]));
			insertar(new Salvacion(TipoSalvacion.SALVACION_DESTREZA, competencias[1]));
			insertar(new Salvacion(TipoSalvacion.SALVACION_CONSTITUCION, competencias[2]));
			insertar(new Salvacion(TipoSalvacion.SALVACION_INTELIGENCIA, competencias[3]));
			insertar(new Salvacion(TipoSalvacion.SALVACION_SABIDURIA, competencias[4]));
			insertar(new Salvacion(TipoSalvacion.SALVACION_CARISMA, competencias[5]));
		}
	}

	public Salvaciones(List<Salvacion> listaSalvaciones) {
		if (listaSalvaciones == null) {
			throw new IllegalArgumentException("La lista de Salvaciones proporcionada es nula");
		} else {
			if (listaSalvaciones.isEmpty()) {
				this.listaSalvaciones = new ArrayList<>();
				insertarFaltantes();
			} else {
				this.listaSalvaciones = new ArrayList<>();
				for (Salvacion salvacion : listaSalvaciones) {
					insertar(salvacion);
				}
				insertarFaltantes();
			}
		}
	}

	private void insertar(Salvacion salvacionInsertar) {
		if (salvacionInsertar == null) {
			throw new IllegalArgumentException("No se puede insertar una salvación nula en las salvaciones");
		} else if (this.listaSalvaciones.contains(salvacionInsertar)) {
			throw new IllegalArgumentException("No se puede insertar una salvación nula.");
		} else {
			listaSalvaciones.add(new Salvacion(salvacionInsertar));
		}
	}

	private void insertar(Salvacion salvacionInsertar, int index) {
		if (salvacionInsertar == null) {
			throw new IllegalArgumentException("No se puede insertar una salvación nula en las salvaciones");
		} else if (this.listaSalvaciones.contains(salvacionInsertar)) {
			throw new IllegalArgumentException("No se puede insertar una salvación nula.");
		} else {
			if (index < 0 || index > 5) {
				throw new IllegalArgumentException("No se puede insertar la habilidad:" + salvacionInsertar.toString()
						+ " en el indice indicado " + index);
			}
			listaSalvaciones.add(index, new Salvacion(salvacionInsertar));
		}
	}

	private void insertarFaltantes() {
		if (buscar(TipoSalvacion.SALVACION_FUERZA) == null)
			insertar(new Salvacion(TipoSalvacion.SALVACION_FUERZA), 0);
		if (buscar(TipoSalvacion.SALVACION_DESTREZA) == null)
			insertar(new Salvacion(TipoSalvacion.SALVACION_DESTREZA), 1);
		if (buscar(TipoSalvacion.SALVACION_CONSTITUCION) == null)
			insertar(new Salvacion(TipoSalvacion.SALVACION_CONSTITUCION), 2);
		if (buscar(TipoSalvacion.SALVACION_INTELIGENCIA) == null)
			insertar(new Salvacion(TipoSalvacion.SALVACION_INTELIGENCIA), 3);
		if (buscar(TipoSalvacion.SALVACION_FUERZA) == null)
			insertar(new Salvacion(TipoSalvacion.SALVACION_FUERZA), 4);
		if (buscar(TipoSalvacion.SALVACION_FUERZA) == null)
			insertar(new Salvacion(TipoSalvacion.SALVACION_FUERZA), 5);

	}

	public Salvacion buscar(Salvacion salvacionBusqueda) {
		if (salvacionBusqueda == null) {
			throw new IllegalArgumentException("No se puede buscar una salvación nula");
		} else if (!listaSalvaciones.contains(salvacionBusqueda)) {
			return null;
		} else {
			int index = listaSalvaciones.indexOf(salvacionBusqueda);
			if (index == -1) {
				return null;
			} else {
				return listaSalvaciones.get(index);
			}
		}
	}

	public Salvacion buscar(TipoSalvacion salvacionBusqueda) {
		if (salvacionBusqueda == null) {
			throw new IllegalArgumentException("No se puede buscar una salvación nula");
		} else if (!listaSalvaciones.contains(new Salvacion(salvacionBusqueda))) {
			return null;
		} else {
			int index = listaSalvaciones.indexOf(new Salvacion(salvacionBusqueda));
			if (index == -1) {
				return null;
			} else {
				return listaSalvaciones.get(index);
			}
		}
	}

	public void cambiarCompetencia(Salvacion salvacionCambio, boolean cambio) {
		Salvacion salvacionEncontrada = buscar(salvacionCambio);
		if (salvacionEncontrada == null) {
			throw new IllegalArgumentException("No se puede cambiar la competencia de una salvacion inexistente");
		} else {
			salvacionEncontrada.setCompetencia(cambio);
		}
	}

	public void cambiarCompetencia(TipoSalvacion salvacionCambio, boolean cambio) {
		Salvacion salvacionEncontrada = buscar(salvacionCambio);
		if (salvacionEncontrada == null) {
			throw new IllegalArgumentException("No se puede cambiar la competencia de una salvacion inexistente");
		} else {
			salvacionEncontrada.setCompetencia(cambio);
		}
	}

	public void cambiarCompetencia(Salvacion salvacionCambio) {
		Salvacion salvacionEncontrada = buscar(salvacionCambio);
		if (salvacionEncontrada == null) {
			throw new IllegalArgumentException("No se puede cambiar la competencia de una Salvacion inexistente");
		} else {
			salvacionEncontrada.setCompetencia(!salvacionEncontrada.isCompetencia());
		}
	}

	public void cambiarCompetencia(TipoSalvacion salvacionCambio) {
		Salvacion salvacionEncontrada = buscar(salvacionCambio);
		if (salvacionEncontrada == null) {
			throw new IllegalArgumentException("No se puede cambiar la competencia de una Salvacion inexistente");
		} else {
			salvacionEncontrada.setCompetencia(!salvacionEncontrada.isCompetencia());
		}
	}

	@Override
	public String toString() {
		return "Salvaciones [listaSalvaciones=" + listaSalvaciones + "]";
	}
	

}
