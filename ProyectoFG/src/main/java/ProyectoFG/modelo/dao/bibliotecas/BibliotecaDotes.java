package ProyectoFG.modelo.dao.bibliotecas;

import java.util.ArrayList;
import java.util.List;

import ProyectoFG.modelo.dominio.dotes.Dote;
import ProyectoFG.modelo.dominio.dotes.TipoDote;

public class BibliotecaDotes {
	List<Dote> listaDotes;

	public BibliotecaDotes() {
		this.listaDotes = new ArrayList<>();
		//TODO añadir todas las dotes.
	}

	public BibliotecaDotes(List<Dote> listaDotes) {
		setListaDotes(listaDotes);
	}

	public BibliotecaDotes(BibliotecaDotes bibliotecaDotes) {
		setListaDotes(bibliotecaDotes.getListaDotes());
	}

	public List<Dote> getListaDotes() {
		return listaDotes;
	}

	public void setListaDotes(List<Dote> listaDotes) {
		this.listaDotes = listaDotes;
	}
	public Dote buscar(TipoDote doteBuscar) {
		if(doteBuscar == null) {
			throw new IllegalArgumentException("No se puede buscar una dote en la biblioteca que sea nula.");
		} else {
			if(!this.listaDotes.contains(new Dote(doteBuscar, "descripcion"))) {
				return null;
			} else {
				return new Dote(this.listaDotes.get(this.listaDotes.indexOf(new Dote(doteBuscar, "descripcion"))));
			}
		}
	}

}