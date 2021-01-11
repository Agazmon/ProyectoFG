package ProyectoFG.modelo.dao;

import java.util.ArrayList;
import java.util.List;

import ProyectoFG.modelo.dominio.idioma.TipoIdioma;

public class Idiomas {
	private List<TipoIdioma> listaIdiomas;
	private int numeroMaximosIdiomas;

	public Idiomas() {
		setListaIdiomas(new ArrayList<>());
		setNumeroMaximosIdiomas(0);
	}

	public Idiomas(Idiomas idiomas) {
		setListaIdiomas(idiomas.getListaIdiomas());
		setNumeroMaximosIdiomas(idiomas.getNumeroMaximosIdiomas());
	}

	public Idiomas(List<TipoIdioma> listaIdiomas) {
		setListaIdiomas(listaIdiomas);
		setNumeroMaximosIdiomas(listaIdiomas.size());
	}

	public List<TipoIdioma> getListaIdiomas() {
		return listaIdiomas;
	}

	private void setListaIdiomas(List<TipoIdioma> listaIdiomas) {
		this.listaIdiomas = listaIdiomas;
	}

	public int getNumeroMaximosIdiomas() {
		return numeroMaximosIdiomas;
	}

	public void setNumeroMaximosIdiomas(int numeroMaximosIdiomas) {
		this.numeroMaximosIdiomas = numeroMaximosIdiomas;
	}

	public void anadir(TipoIdioma idioma) {
		if (idioma == null) {
			throw new IllegalArgumentException("No se puede añadir un idioma nulo a la lista de idiomas.");
		} else {
			if (listaIdiomas.contains(idioma)) {
				throw new IllegalArgumentException("El personaje ya conoce el idioma a añadir.");
			} else if (listaIdiomas.size() >= numeroMaximosIdiomas) {
				throw new IllegalArgumentException(
						"El personaje ya conoce el número máximo de idiomas que puede aprender.");
			} else {
				this.listaIdiomas.add(idioma);
			}
		}
	}
	public TipoIdioma buscar(TipoIdioma idioma) {
		if(idioma == null) {
			throw new IllegalArgumentException("No se puede buscar un idioma nulo.");
		} else {
			if(!listaIdiomas.contains(idioma)) {
				return null;
			} else {
				return listaIdiomas.get(listaIdiomas.indexOf(idioma));
			}
		}
	}

	public void aumentarNumeroMaximoIdiomas(int aumento) {
		if (aumento <= 0) {
			throw new IllegalArgumentException("El aumento mínimo de idiomas es de 1.");
		} else {
			setNumeroMaximosIdiomas(getNumeroMaximosIdiomas() + aumento);
		}

	}

	@Override
	public String toString() {
		return "Idiomas [listaIdiomas=" + listaIdiomas + ", numeroMaximosIdiomas=" + numeroMaximosIdiomas + "]";
	}
	
}
