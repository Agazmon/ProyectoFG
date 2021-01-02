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
	public Contador buscar(Contador contadorBuscar) {
		if(contadorBuscar==null) {
			throw new IllegalArgumentException("No se puede buscar un contador nulo.");
		} else {
			if(!getListaContadores().contains(new Contador(contadorBuscar))) {
				return null;
			} else {
				return new Contador(getListaContadores().get(getListaContadores().indexOf(contadorBuscar)));
			}
		}
	}
	public void anadir(Contador contadorInsertar) {
		if(contadorInsertar==null) {
			throw new IllegalArgumentException("No se puede a�adir un contador nulo.");
		} else if(buscar(contadorInsertar)!=null) {
			throw new IllegalArgumentException("El contador ya existe por lo que no se puede a�adir otro igual.");
		} else {
			this.listaContadores.add(new Contador(contadorInsertar));
		}
	}

}
