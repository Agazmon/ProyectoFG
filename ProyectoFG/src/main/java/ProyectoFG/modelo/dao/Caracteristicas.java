package ProyectoFG.modelo.dao;

import java.util.ArrayList;
import java.util.List;

import ProyectoFG.modelo.dominio.Atributo;
import ProyectoFG.modelo.dominio.Caracteristica;

public class Caracteristicas {
	private List<Caracteristica> listaCaracteristicas;

	public Caracteristicas() {
		this.listaCaracteristicas = new ArrayList<>();
		listaCaracteristicas.add(new Caracteristica(Atributo.FUERZA, 18));
		listaCaracteristicas.add(new Caracteristica(Atributo.DESTREZA, 8));
		listaCaracteristicas.add(new Caracteristica(Atributo.CONSTITUCION, 16));
		listaCaracteristicas.add(new Caracteristica(Atributo.INTELIGENCIA, 8));
		listaCaracteristicas.add(new Caracteristica(Atributo.SABIDURIA, 14));
		listaCaracteristicas.add(new Caracteristica(Atributo.CARISMA, 10));
	}

	public Caracteristicas(int fuerza, int destreza, int constitucion, int inteligencia, int sabiduria, int carisma) {
		this.listaCaracteristicas = new ArrayList<>();
		listaCaracteristicas.add(new Caracteristica(Atributo.FUERZA, fuerza));
		listaCaracteristicas.add(new Caracteristica(Atributo.DESTREZA, destreza));
		listaCaracteristicas.add(new Caracteristica(Atributo.CONSTITUCION, constitucion));
		listaCaracteristicas.add(new Caracteristica(Atributo.INTELIGENCIA, inteligencia));
		listaCaracteristicas.add(new Caracteristica(Atributo.SABIDURIA, sabiduria));
		listaCaracteristicas.add(new Caracteristica(Atributo.CARISMA, carisma));
	}

	public Caracteristicas(List<Caracteristica> listaCaracteristicas) {
		this.listaCaracteristicas = copiarArrayList(listaCaracteristicas);
	}

	// Búsqueda de la característica
	public Caracteristica buscar(Caracteristica caracteristicaBuscar) {
		if (caracteristicaBuscar == null) {
			throw new IllegalArgumentException("No se puede buscar una característica nula.");
		} else if (!this.listaCaracteristicas.contains(caracteristicaBuscar)) {
			return null;
		} else {
			int index = this.listaCaracteristicas.indexOf(caracteristicaBuscar);
			return listaCaracteristicas.get(index);
		}

	}

	public Caracteristica buscar(Atributo atributoBuscar) {
		if (atributoBuscar == null) {
			throw new IllegalArgumentException("No se puede buscar por un Atributo nulo.");
		} else if (!this.listaCaracteristicas.contains(new Caracteristica(atributoBuscar, 1))) {
			return null;
		} else {
			int index = this.listaCaracteristicas.indexOf(new Caracteristica(atributoBuscar, 1));
			return listaCaracteristicas.get(index);
		}

	}

	// Modificación de la característica de personaje
	public void aumentarCaracteristica(Caracteristica caracteristicaModificar, int valorAumento) {
		if (caracteristicaModificar == null) {
			throw new IllegalArgumentException("No se puede modificar una característica nula.");
		} else {
			Caracteristica caracteristicaEncontrada = buscar(caracteristicaModificar);
			if (caracteristicaEncontrada == null) {
				throw new IllegalArgumentException("No se puede modificar una característica que no existe");
			} else {
				caracteristicaEncontrada.modificarCaracteristica(valorAumento);
			}

		}
	}

	public void aumentarCaracteristica(Atributo atributoMejora, int valorAumento) {
		if (atributoMejora == null) {
			throw new IllegalArgumentException("No se puede modificar una característica nula.");
		} else {
			Caracteristica caracteristicaEncontrada = buscar(atributoMejora);
			if (caracteristicaEncontrada == null) {
				throw new IllegalArgumentException("No se puede modificar una característica que no existe");
			} else {
				caracteristicaEncontrada.modificarCaracteristica(valorAumento);
			}

		}
	}
	// Métodos de apoyo

	private List<Caracteristica> copiarArrayList(List<Caracteristica> arrayPrincipal) {
		if (arrayPrincipal.isEmpty()) {
			return new ArrayList<Caracteristica>();
		}
		List<Caracteristica> arrayCopia = new ArrayList<>();
		for (Caracteristica caracteristica : arrayPrincipal) {
			arrayCopia.add(new Caracteristica(caracteristica));
		}
		return arrayCopia;
	}

	// Métodos generados
	@Override
	public String toString() {
		return "Caracteristicas [listaCaracteristicas=" + listaCaracteristicas + "]";
	}

}
