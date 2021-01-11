package ProyectoFG.modelo.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ProyectoFG.modelo.dominio.competencia.Competencia;
import ProyectoFG.modelo.dominio.competencia.TipoCompetencia;

public class Competencias {

	private List<Competencia> listaCompetencias;
	private int competenciasPorGanar;

	public Competencias() {
		List<Competencia> lista = new ArrayList<>();
		setListaCompetencias(lista);
		setCompetenciasPorGanar(0);
	}

	public Competencias(List<Competencia> listaCompetencias) {
		setListaCompetencias(copiarLista(listaCompetencias));
		setCompetenciasPorGanar(0);
	}

	public Competencias(Competencias competencias) {
		setListaCompetencias(copiarLista(competencias.getListaCompetencias()));
		setCompetenciasPorGanar(competencias.getCompetenciasPorGanar());
	}

	public List<Competencia> getListaCompetencias() {
		return listaCompetencias;
	}

	private void setListaCompetencias(List<Competencia> listaCompetencias) {
		List<TipoCompetencia> competencias = Arrays.asList(TipoCompetencia.values());
		for (TipoCompetencia tipoCompetencia : competencias) {
			Competencia competenciaIteracion = new Competencia(tipoCompetencia, false);
			if (!listaCompetencias.contains(competenciaIteracion)) {
				listaCompetencias.add(competenciaIteracion);
			}
		}
		this.listaCompetencias = listaCompetencias;
	}

	public Competencia buscar(TipoCompetencia competenciaBusqueda) {
		if (competenciaBusqueda == null) {
			throw new IllegalArgumentException("No se puede buscar una competencia nula.");
		} else if (!(getListaCompetencias().contains(new Competencia(competenciaBusqueda, false)))) {
			return null;
		} else {
			return this.listaCompetencias
					.get(this.listaCompetencias.indexOf(new Competencia(competenciaBusqueda, false)));
		}
	}

	public void anadir(TipoCompetencia competencia, boolean competente) {
		if (competencia == null) {
			throw new IllegalArgumentException(
					"No se puede añadir una competencia nula a la lista de competencias de un personaje.");
		} else if (this.listaCompetencias.contains(new Competencia(competencia, competente))) {
			throw new IllegalArgumentException("La competencia ya es parte de la lista de competencias del personaje.");
		} else {
			this.listaCompetencias.add(new Competencia(competencia, competente));
		}
	}

	private List<Competencia> copiarLista(List<Competencia> listaCompetenciasCopiar) {
		if (listaCompetenciasCopiar == null) {
			return new ArrayList<Competencia>();
		} else if (listaCompetenciasCopiar.isEmpty()) {
			return new ArrayList<Competencia>();
		} else {
			ArrayList<Competencia> copiaLista = new ArrayList<Competencia>();
			for (Competencia competencia : listaCompetenciasCopiar) {
				copiaLista.add(new Competencia(competencia));
			}
			return copiaLista;
		}
	}

	public int getCompetenciasPorGanar() {
		return competenciasPorGanar;
	}

	public void setCompetenciasPorGanar(int competenciasPorGanar) {
		this.competenciasPorGanar = competenciasPorGanar;
	}

	public void aumentarMaximoCompetencias(int incremento) {
		if (incremento <= 0) {
			throw new IllegalArgumentException("El incremento minimo para el máximo de competencias es de 1.");
		} else {
			setCompetenciasPorGanar(getCompetenciasPorGanar() + incremento);
		}

	}

	public void ganarCompetencia(TipoCompetencia competencia) {
		if(getCompetenciasPorGanar()==0) {
			throw new IllegalArgumentException("Se ha alcanzado el máximo de competencias que este personaje puede ganar.");
		} else {
			buscar(competencia).setCompetente(true);
			setCompetenciasPorGanar(getCompetenciasPorGanar()-1);
		}

	}

	@Override
	public String toString() {
		return "Competencias [listaCompetencias=" + listaCompetencias + ", competenciasPorGanar=" + competenciasPorGanar
				+ "]";
	}
	

}