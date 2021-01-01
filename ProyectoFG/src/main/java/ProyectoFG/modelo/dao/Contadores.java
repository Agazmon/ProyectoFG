package ProyectoFG.modelo.dao;

import java.util.ArrayList;
import java.util.List;

import ProyectoFG.modelo.dominio.contador.Contador;

public class Contadores {

	List<Contador> listaContadores;

	public Contadores() {
		this.listaContadores = new ArrayList<>();
	}

	public Contadores(List<Contador> listaContadores) {
		this.listaContadores = new ArrayList<>();
		setListaContadores(listaContadores);
	}

	public Contadores(Contadores contadores) {
		setListaContadores(contadores.getListaContadores());
	}

	public List<Contador> getListaContadores() {
		return listaContadores;
	}

	private void setListaContadores(List<Contador> listaContadores) {
		this.listaContadores = listaContadores;
	}
	
	public Contador buscar(String nombreContadorBuscar) {
		if(nombreContadorBuscar==null) {
			throw new IllegalArgumentException("No se puede buscar un contador por el nombre nulo.");
		} else if(nombreContadorBuscar.isBlank()){
			throw new IllegalArgumentException("El nombre de un contador no puede estar en blanco para buscarlo.");
		} else {
			if(!getListaContadores().contains(new Contador(nombreContadorBuscar,1,1))) {
				return null;
			} else {
				return new Contador(getListaContadores().get(getListaContadores().indexOf(new Contador(nombreContadorBuscar,1,1))));
			}
		}
	}

}
