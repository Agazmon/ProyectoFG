package ProyectoFG.modelo.dao;

import java.util.ArrayList;
import java.util.List;

import ProyectoFG.modelo.dominio.dote.Dote;
import ProyectoFG.modelo.dominio.dote.DoteRacial;
import ProyectoFG.modelo.dominio.dote.DoteRequisitoAtributo;
import ProyectoFG.modelo.dominio.dote.DoteRequisitoCompetencia;
import ProyectoFG.modelo.dominio.dote.TipoDote;

public class Dotes {
	private List<Dote> listaDotes;

	public Dotes() {
		this.listaDotes = new ArrayList<>();
	}

	public Dotes(List<Dote> listaDotes) {
		setListaDotes(listaDotes);
	}

	public Dotes(Dotes dotes) {
		setListaDotes(dotes.getListaDotes());
	}

	public List<Dote> getListaDotes() {
		return listaDotes;
	}

	public void setListaDotes(List<Dote> listaDotes) {
		this.listaDotes = listaDotes;
	}

	public Dote buscar(TipoDote tipoBuscar) {
		if (tipoBuscar == null) {
			throw new IllegalArgumentException("No se puede buscar una dote por un nombre nulo.");
		} else {
			if (!this.listaDotes.contains(new Dote(tipoBuscar, "descripcion"))) {
				return null;
			} else {
				return new Dote(this.listaDotes.get(this.listaDotes.indexOf(new Dote(tipoBuscar, "descripcion"))));
			}

		}
	}

	public Dote buscar(Dote doteBuscar) {
		if (doteBuscar == null) {
			throw new IllegalArgumentException("No se puede buscar una dote nula.");
		} else {
			if (!this.listaDotes.contains(new Dote(doteBuscar))) {
				return null;
			} else {
				int index = -1;
				for (Dote dote : listaDotes) {
					if (dote.getTipoDote() == doteBuscar.getTipoDote()) {
						index = listaDotes.indexOf(dote);
					}
				}
				if (index != -1) {
					return new Dote(this.listaDotes.get(index));
				} else {
					return null;
				}
			}

		}
	}

	public void anadir(Dote doteAnadir) {
		if (doteAnadir == null) {
			throw new IllegalArgumentException("No se puede añadir una dote nula a la lista de dotes del personaje.");
		} else if (buscar(doteAnadir) != null) {
			throw new IllegalArgumentException("El personaje ya tiene la dote añadida.");
		} else {
			if (doteAnadir instanceof DoteRacial) {
				this.listaDotes.add(new DoteRacial((DoteRacial) doteAnadir));
			} else if (doteAnadir instanceof DoteRequisitoAtributo) {
				this.listaDotes.add(new DoteRequisitoAtributo((DoteRequisitoAtributo) doteAnadir));
			} else if (doteAnadir instanceof DoteRequisitoCompetencia) {
				this.listaDotes.add(new DoteRequisitoCompetencia((DoteRequisitoCompetencia) doteAnadir));
			} else if (doteAnadir instanceof Dote) {
				this.listaDotes.add(new Dote((Dote) doteAnadir));
			}
		}
	}

	@Override
	public String toString() {
		return "Dotes [listaDotes=" + listaDotes + "]";
	}
	

}
