package ProyectoFG.modelo.dao;

import java.util.ArrayList;
import java.util.List;

import ProyectoFG.modelo.dominio.arma.Arma;
import ProyectoFG.modelo.dominio.arma.ArmaArrojadiza;
import ProyectoFG.modelo.dominio.arma.ArmaDistancia;
import ProyectoFG.modelo.dominio.arma.TipoMunicion;
import ProyectoFG.modelo.dominio.moneda.Moneda;
import ProyectoFG.modelo.dominio.moneda.TipoMoneda;
import ProyectoFG.modelo.dominio.objeto.Municion;
import ProyectoFG.modelo.dominio.objeto.ObjetoInventario;

public class ObjetosInventario {
	private List<ObjetoInventario> listaObjetosInventario;

	public ObjetosInventario() {
		this.listaObjetosInventario = new ArrayList<>();
		this.listaObjetosInventario
				.add(new Municion("Dardo", 1, 20, new Moneda(TipoMoneda.MONEDA_COBRE, 5), TipoMunicion.DARDO));
		this.listaObjetosInventario
				.add(new Municion("Flecha", 1, 20, new Moneda(TipoMoneda.MONEDA_COBRE, 5), TipoMunicion.FLECHA));
		this.listaObjetosInventario
				.add(new Municion("Piedra", 1, 20, new Moneda(TipoMoneda.MONEDA_COBRE, 5), TipoMunicion.PIEDRA));
		this.listaObjetosInventario
				.add(new Municion("Virote", 1, 20, new Moneda(TipoMoneda.MONEDA_COBRE, 5), TipoMunicion.VIROTE));
		this.listaObjetosInventario.add(new Municion("Virote Pesado", 1, 20, new Moneda(TipoMoneda.MONEDA_COBRE, 5),
				TipoMunicion.VIROTE_PESADO));
	}

	public Municion getTipoMunicion(TipoMunicion municionPedida) {
		if (municionPedida == null) {
			throw new IllegalArgumentException("No se puede utilizar una munición nula.");
		} else if (listaObjetosInventario.isEmpty()) {
			throw new IllegalArgumentException("No hay nada en el inventario. Por lo que no habrá munición.");
		} else {
			if (!listaObjetosInventario.contains(
					new Municion("MunicionPedida", 1, 1, new Moneda(TipoMoneda.MONEDA_COBRE, 1), municionPedida))) {
				return null;
			} else {
				return (Municion) listaObjetosInventario.get(listaObjetosInventario.indexOf(
						new Municion("MunicionPedida", 1, 1, new Moneda(TipoMoneda.MONEDA_COBRE, 1), municionPedida)));
			}
		}
	}

	public ObjetoInventario buscarObjeto(String nombreObjeto) {
		if (nombreObjeto == null) {
			throw new IllegalArgumentException("El nombre de objeto a buscar no puede ser nulo.");
		} else if (nombreObjeto.isBlank()) {
			throw new IllegalArgumentException("El nombre de objeto a buscar no puede estar vacio.");
		} else {
			int indice = -1;
			for (ObjetoInventario objetoInventario : listaObjetosInventario) {
				if (objetoInventario.getNombre().equals(nombreObjeto)) {
					indice = listaObjetosInventario.indexOf(objetoInventario);
					break;
				}
			}
			if (indice != -1) {
				ObjetoInventario objetoEncontrado = this.listaObjetosInventario.get(indice);
				if (objetoEncontrado instanceof ArmaArrojadiza) {
					return new ArmaArrojadiza((ArmaArrojadiza) objetoEncontrado);
				} else if (objetoEncontrado instanceof ArmaDistancia) {
					return new ArmaDistancia((ArmaDistancia) objetoEncontrado);
				} else if (objetoEncontrado instanceof Arma) {
					return new Arma((Arma) objetoEncontrado);
				} else {
					return null;
				}
			}
		}
		return null;

	}

	public void anadirObjeto(ObjetoInventario objeto) {
		this.listaObjetosInventario.add(objeto);
	}

	public List<ObjetoInventario> getListaObjetos() {
		return this.listaObjetosInventario;
	}

	public int getPesoTotalInventario() {
		return 1;
	}

	@Override
	public String toString() {
		return "ObjetosInventario [listaObjetosInventario=" + listaObjetosInventario + "]";
	}
	
}
