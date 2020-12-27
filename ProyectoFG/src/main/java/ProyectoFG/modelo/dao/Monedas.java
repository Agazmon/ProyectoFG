package ProyectoFG.modelo.dao;

import java.util.ArrayList;
import java.util.List;

import ProyectoFG.modelo.dominio.moneda.Moneda;
import ProyectoFG.modelo.dominio.moneda.TipoMoneda;

public class Monedas {
	private List<Moneda> listaMonedas;

	public Monedas() {
		List<Moneda> listaMonedasAsignar = new ArrayList<>();
		listaMonedasAsignar.add(new Moneda(TipoMoneda.MONEDA_COBRE, 0));
		listaMonedasAsignar.add(new Moneda(TipoMoneda.MONEDA_PLATA, 0));
		listaMonedasAsignar.add(new Moneda(TipoMoneda.MONEDA_ELECTRUM, 0));
		listaMonedasAsignar.add(new Moneda(TipoMoneda.MONEDA_ORO, 0));
		listaMonedasAsignar.add(new Moneda(TipoMoneda.MONEDA_PLATINO, 0));
		setListaMonedas(listaMonedasAsignar);
	}

	public Monedas(List<Moneda> monedas) {
		setListaMonedas(listaMonedas);
	}

	public Monedas(Monedas monedas) {
		setListaMonedas(monedas.getListaMonedas());
	}

	public List<Moneda> getListaMonedas() {
		return listaMonedas;
	}

	private void setListaMonedas(List<Moneda> listaMonedas) {
		if (listaMonedas == null)
			throw new IllegalArgumentException("No se puede establecer una lista nula como monedas.");
		else if (listaMonedas.isEmpty())
			throw new IllegalArgumentException("No se puede establecer una lista vacía como monedas.");
		else
			this.listaMonedas = listaMonedas;
	}

	public void anadirMonedas(List<Moneda> cantidadAnadir) {
		if (cantidadAnadir == null) {
			throw new IllegalArgumentException("No se puede añadir monedas nulas.");
		} else if (cantidadAnadir.isEmpty()) {
			throw new IllegalArgumentException("No se han recibido datos de las monedas a añadir.");
		} else {
			List<Moneda> listaActual = getListaMonedas();
			for (Moneda monedaIteracion : cantidadAnadir) {
				Moneda monedaEncontrada = buscarMoneda(monedaIteracion);
				if (monedaEncontrada == null) {
					throw new IllegalArgumentException("Uno de los tipos de moneda a añádir no ha sido encontrado");
				} else {
					monedaEncontrada.anadirMoneda(monedaIteracion.getCantidadMoneda());
				}
			}
		}
	}
	public void anadirMonedas(Moneda monedaAnadir) {
		if (monedaAnadir == null) {
			throw new IllegalArgumentException("No se puede añadir monedas nulas.");
		} else {
			Moneda monedaEncontrada = buscarMoneda(monedaAnadir);
			if(monedaEncontrada==null) {
				throw new IllegalArgumentException("La moneda a añadir no se encuentra.");
			} else {
				monedaEncontrada.anadirMoneda(monedaAnadir.getCantidadMoneda());
			}
		}
	}

	public void quitarMonedas(List<Moneda> cantidadQuitar) {
		if (cantidadQuitar == null) {
			throw new IllegalArgumentException("No se puede quitar monedas nulas.");
		} else if (cantidadQuitar.isEmpty()) {
			throw new IllegalArgumentException("No se han recibido datos de las monedas a retirar.");
		} else {
			List<Moneda> listaActual = getListaMonedas();
			for (Moneda monedaIteracion : cantidadQuitar) {
				Moneda monedaEncontrada = buscarMoneda(monedaIteracion);
				if (monedaEncontrada == null) {
					throw new IllegalArgumentException("Uno de los tipos de moneda a retirar no ha sido encontrado");
				} else {
					monedaEncontrada.quitarMoneda(monedaIteracion.getCantidadMoneda());
				}
			}
		}
	}

	public Moneda buscarMoneda(TipoMoneda tipoMonedaBuscar) {
		if (tipoMonedaBuscar == null) {
			throw new IllegalArgumentException("No se puede buscar un tipo de moneda nulo.");
		} else if (getListaMonedas().isEmpty()) {
			throw new IllegalArgumentException("No se puede encontrar la moneda porque no hay monedas.");
		} else if (!getListaMonedas().contains(new Moneda(tipoMonedaBuscar, 1))) {
			// No existe la moneda en el conjunto.
			return null;
		} else {
			for (Moneda moneda : listaMonedas) {
				if (moneda.equals(new Moneda(tipoMonedaBuscar, 1)))
					;
				return moneda;
			}
		}
		return null;
	}

	public Moneda buscarMoneda(Moneda monedaBuscar) {
		if (monedaBuscar == null) {
			throw new IllegalArgumentException("No se puede buscar una de moneda nula.");
		} else if (getListaMonedas().isEmpty()) {
			throw new IllegalArgumentException("No se puede encontrar la moneda porque no hay monedas.");
		} else if (!getListaMonedas().contains(monedaBuscar)) {
			// No existe la moneda en el conjunto.
			return null;
		} else {
			for (Moneda moneda : listaMonedas) {
				if (moneda.equals(monedaBuscar))
					return moneda;
			}
		}
		return null;

	}
	public void cambiarMonedas(TipoMoneda tipoCambiar, TipoMoneda tipoBuscado, int cantidad) {
		if(tipoCambiar==null) {
			throw new IllegalArgumentException("El tipo de monedas a cambiar no es válido.");
		} else if(tipoBuscado==null) {
			throw new IllegalArgumentException("El tipo de monedas al que se quiere cambiar no es válido.");
		} else if(cantidad<=0) {
			throw new IllegalArgumentException("La cantidad de monedas que se quiere cambiar son insuficientes.");
		} else {
			Moneda monedaCambio = buscarMoneda(tipoCambiar);
			if(monedaCambio==null) {
				throw new IllegalArgumentException("La moneda que se quiere cambiar no existe en el conjunto de monedas.");
			} else {
				anadirMonedas(buscarMoneda(tipoCambiar).cambiarMoneda(tipoBuscado, cantidad));
			}
		}
	}

	@Override
	public String toString() {
		return "Monedas [listaMonedas=" + listaMonedas + "]";
	}
	
}
