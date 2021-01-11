package ProyectoFG.modelo.dao;

import java.util.ArrayList;
import java.util.List;

import ProyectoFG.modelo.dominio.habilidad.Habilidad;
import ProyectoFG.modelo.dominio.habilidad.TipoHabilidad;

public class Habilidades {

	private List<Habilidad> listaHabilidades;
	private int competenciasPorGanar;

	// Constructores
	public Habilidades() {
		listaHabilidades = new ArrayList<>();
		setCompetenciasPorGanar(0);
		insertarFaltantes();
	}

	public Habilidades(Habilidades habilidades) {
		setHabilidades(habilidades.getHabilidades());
		setCompetenciasPorGanar(habilidades.getCompetenciasPorGanar());
	}

	public Habilidades(Boolean[] competencias) {
		if (competencias.length < 18) {
			throw new IllegalArgumentException("Faltan competencias para asignar a las habilidades. Hay menos de 18.");
		} else if (competencias.length > 18) {
			throw new IllegalArgumentException("Sobran competencias para asignar a las habilidades. Hay mas de 18.");
		} else {
			this.listaHabilidades = new ArrayList<>();
			int maximo = 0;
			for (int i = 0; i < competencias.length; i++) {
				if (competencias[i])
					maximo += 1;
			}
			setCompetenciasPorGanar(maximo);
			insertar((new Habilidad(TipoHabilidad.ATLETISMO, competencias[0])));
			insertar((new Habilidad(TipoHabilidad.ACROBACIAS, competencias[1])));
			insertar((new Habilidad(TipoHabilidad.JUEGO_DE_MANOS, competencias[2])));
			insertar((new Habilidad(TipoHabilidad.SIGILO, competencias[3])));
			insertar((new Habilidad(TipoHabilidad.CONOCIMIENTO_ARCANO, competencias[4])));
			insertar((new Habilidad(TipoHabilidad.HISTORIA, competencias[5])));
			insertar((new Habilidad(TipoHabilidad.INVESTIGACION, competencias[6])));
			insertar((new Habilidad(TipoHabilidad.NATURALEZA, competencias[7])));
			insertar((new Habilidad(TipoHabilidad.RELIGION, competencias[8])));
			insertar((new Habilidad(TipoHabilidad.TRATO_CON_ANIMALES, competencias[9])));
			insertar((new Habilidad(TipoHabilidad.PERSPICACIA, competencias[10])));
			insertar((new Habilidad(TipoHabilidad.MEDICINA, competencias[11])));
			insertar((new Habilidad(TipoHabilidad.PERCEPCION, competencias[12])));
			insertar((new Habilidad(TipoHabilidad.SUPERVIVENCIA, competencias[13])));
			insertar((new Habilidad(TipoHabilidad.ENGANO, competencias[14])));
			insertar((new Habilidad(TipoHabilidad.INTIMIDACION, competencias[15])));
			insertar((new Habilidad(TipoHabilidad.INTERPRETACION, competencias[16])));
			insertar((new Habilidad(TipoHabilidad.PERSUASION, competencias[17])));
		}
	}

	public Habilidades(List<Habilidad> listaHabilidades) {
		if (listaHabilidades == null) {
			throw new IllegalArgumentException("La lista de habilidades proporcionada es nula.");
		} else {
			if (listaHabilidades.isEmpty()) {
				this.listaHabilidades = new ArrayList<>();
				setCompetenciasPorGanar(0);
				insertarFaltantes();
			} else {
				this.listaHabilidades = new ArrayList<>();
				int maximo = 0;
				for (Habilidad habilidad : listaHabilidades) {
					if (habilidad.isCompetencia())
						maximo += 1;
				}
				setCompetenciasPorGanar(maximo);
				for (Habilidad habilidad : listaHabilidades) {
					insertar(habilidad);
				}
				insertarFaltantes();
			}
		}
	}

	// Getter y setter
	public List<Habilidad> getHabilidades() {
		return copiaArray(this.listaHabilidades);
	}

	private void setHabilidades(List<Habilidad> lista) {
		this.listaHabilidades = lista;
	}

	public int getCompetenciasPorGanar() {
		return competenciasPorGanar;
	}

	private void setCompetenciasPorGanar(int competenciasPorGanar) {
		this.competenciasPorGanar = competenciasPorGanar;
	}

	// Metodos de utilidad
	private void insertar(Habilidad habilidadInsertar) {
		if (habilidadInsertar == null) {
			throw new IllegalArgumentException("No se puede insertar una habilidad nula");
		} else if (listaHabilidades.contains(habilidadInsertar)) {
			throw new IllegalArgumentException("No se puede insertar una habilidad que ya existe");
		} else {
			if (this.listaHabilidades.size() <= 18) {
				this.listaHabilidades.add(new Habilidad(habilidadInsertar));
			} else {
				throw new IllegalArgumentException("No se pueden a�adir mas habilidades a las habilidades.");
			}
		}
	}

	private void insertar(Habilidad habilidadInsertar, int index) {
		if (habilidadInsertar == null) {
			throw new IllegalArgumentException("No se puede insertar una habilidad nula");
		} else if (listaHabilidades.contains(habilidadInsertar)) {
			throw new IllegalArgumentException("No se puede insertar una habilidad que ya existe");
		} else {
			if (index < 0 || index > 17) {
				throw new IllegalArgumentException("No se puede insertar la habilidad:" + habilidadInsertar.toString()
						+ " en el indice indicado " + index);
			}
			listaHabilidades.add(index, new Habilidad(habilidadInsertar));
		}
	}

	private void insertarFaltantes() {
		if (buscar(TipoHabilidad.ATLETISMO) == null)
			insertar(new Habilidad(TipoHabilidad.ATLETISMO), 0);
		if (buscar(TipoHabilidad.ACROBACIAS) == null)
			insertar(new Habilidad(TipoHabilidad.ACROBACIAS), 1);
		if (buscar(TipoHabilidad.JUEGO_DE_MANOS) == null)
			insertar(new Habilidad(TipoHabilidad.JUEGO_DE_MANOS), 2);
		if (buscar(TipoHabilidad.SIGILO) == null)
			insertar(new Habilidad(TipoHabilidad.SIGILO), 3);
		if (buscar(TipoHabilidad.CONOCIMIENTO_ARCANO) == null)
			insertar(new Habilidad(TipoHabilidad.CONOCIMIENTO_ARCANO), 4);
		if (buscar(TipoHabilidad.HISTORIA) == null)
			insertar(new Habilidad(TipoHabilidad.HISTORIA), 5);
		if (buscar(TipoHabilidad.INVESTIGACION) == null)
			insertar(new Habilidad(TipoHabilidad.INVESTIGACION), 6);
		if (buscar(TipoHabilidad.NATURALEZA) == null)
			insertar(new Habilidad(TipoHabilidad.NATURALEZA), 7);
		if (buscar(TipoHabilidad.RELIGION) == null)
			insertar(new Habilidad(TipoHabilidad.RELIGION), 8);
		if (buscar(TipoHabilidad.MEDICINA) == null)
			insertar(new Habilidad(TipoHabilidad.MEDICINA), 9);
		if (buscar(TipoHabilidad.PERCEPCION) == null)
			insertar(new Habilidad(TipoHabilidad.PERCEPCION), 10);
		if (buscar(TipoHabilidad.PERSPICACIA) == null)
			insertar(new Habilidad(TipoHabilidad.PERSPICACIA), 11);
		if (buscar(TipoHabilidad.SUPERVIVENCIA) == null)
			insertar(new Habilidad(TipoHabilidad.SUPERVIVENCIA), 12);
		if (buscar(TipoHabilidad.TRATO_CON_ANIMALES) == null)
			insertar(new Habilidad(TipoHabilidad.TRATO_CON_ANIMALES), 13);
		if (buscar(TipoHabilidad.ENGANO) == null)
			insertar(new Habilidad(TipoHabilidad.ENGANO), 14);
		if (buscar(TipoHabilidad.INTERPRETACION) == null)
			insertar(new Habilidad(TipoHabilidad.INTERPRETACION), 15);
		if (buscar(TipoHabilidad.INTIMIDACION) == null)
			insertar(new Habilidad(TipoHabilidad.INTIMIDACION), 16);
		if (buscar(TipoHabilidad.PERSUASION) == null)
			insertar(new Habilidad(TipoHabilidad.PERSUASION), 17);
	}

	public Habilidad buscar(Habilidad habilidadBusqueda) {
		if (habilidadBusqueda == null) {
			throw new IllegalArgumentException("No se puede buscar una habilidad nula");
		} else if (!(listaHabilidades.contains(habilidadBusqueda))) {
			return null;
		} else {
			int index = listaHabilidades.indexOf(habilidadBusqueda);
			if (index == -1) {
				return null;
			} else {
				return listaHabilidades.get(index);
			}
		}
	}

	public Habilidad buscar(TipoHabilidad tipoHabilidadBusqueda) {
		if (tipoHabilidadBusqueda == null) {
			throw new IllegalArgumentException("No se puede buscar una habilidad por atributo nulo");
		} else if (!(listaHabilidades.contains(new Habilidad(tipoHabilidadBusqueda)))) {
			return null;
		} else {
			int index = listaHabilidades.indexOf(new Habilidad(tipoHabilidadBusqueda));
			if (index == -1) {
				return null;
			} else {
				return listaHabilidades.get(index);
			}
		}
	}

	public void ganarCompetencia(TipoHabilidad habilidad) {
		if (habilidad == null) {
			throw new IllegalArgumentException("El personaje no puede ganar la competencia en una habilidad nula.");
		} else if (buscar(habilidad) == null) {
			throw new IllegalArgumentException("El personaje no tiene la habilidad por lo tanto no puede ganarla.");
		} else {
			if (getCompetenciasPorGanar() > 0) {
				setCompetenciasPorGanar(getCompetenciasPorGanar() - 1);
				buscar(habilidad).setCompetencia(true);
			} else {
				throw new IllegalArgumentException("El personaje no puede ganar competencia en mas habilidades.");
			}
		}
	}
	
	public void aumentarMaximoCompetencias(int incremento) {
		if(incremento<=0) {
			throw new IllegalArgumentException("El incremento minimo para el m�ximo de competencias es de 1.");
		} else {
			setCompetenciasPorGanar(incremento);
		}
	}
	
	// M�todos de soporte
	private List<Habilidad> copiaArray(List<Habilidad> listaPrincipal) {
		List<Habilidad> listaCopia = new ArrayList<>();
		for (Habilidad habilidad : listaPrincipal) {
			listaCopia.add(new Habilidad(habilidad));
		}
		return listaCopia;
	}

	// M�todos autogenerados
	@Override
	public String toString() {
		return "Habilidades [listaHabilidades=" + listaHabilidades + "]";
	}

}
