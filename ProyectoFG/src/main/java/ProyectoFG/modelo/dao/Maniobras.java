package ProyectoFG.modelo.dao;

import java.util.ArrayList;
import java.util.List;

import ProyectoFG.modelo.dominio.maniobra.Maniobra;
import ProyectoFG.modelo.dominio.tirada.Dado;

public class Maniobras {
	private List<Maniobra> listaManiobras;
	private int cantidadRestante;
	private Dado dadoSupremacia;
	private int cantidadRestanteDados;
	private int cantidadMaximaDados;

	public Maniobras() {
		setListaManiobras(new ArrayList<>());
		setCantidadRestanteManiobrasPorAprender(0);
		setDadoSupremacia(new Dado(1));
		setCantidadRestanteDados(0);
		setCantidadMaximaDados(0);
	}

	public Maniobras(List<Maniobra> listaManiobras, int cantidadRestante, Dado dadoSupremacia,
			int cantidadRestanteDados, int cantidadMaximaDados) {
		setListaManiobras(listaManiobras);
		setCantidadRestanteManiobrasPorAprender(cantidadRestante);
		setDadoSupremacia(dadoSupremacia);
		setCantidadRestanteDados(cantidadRestanteDados);
		setCantidadMaximaDados(cantidadMaximaDados);
	}

	public Maniobras(Maniobras maniobras) {
		setListaManiobras(maniobras.getListaManiobras());
		setCantidadRestanteManiobrasPorAprender(maniobras.getCantidadRestanteManiobrasPorAprender());
		setDadoSupremacia(maniobras.getDadoSupremacia());
		setCantidadRestanteDados(maniobras.getCantidadRestanteDados());
		setCantidadMaximaDados(maniobras.getCantidadMaximaDados());
	}

	public List<Maniobra> getListaManiobras() {
		return listaManiobras;
	}

	private void setListaManiobras(List<Maniobra> listaManiobras) {
		if (listaManiobras == null) {
			this.listaManiobras = new ArrayList<Maniobra>();
		} else if (listaManiobras.isEmpty()) {
			this.listaManiobras = new ArrayList<Maniobra>();
		} else {
			this.listaManiobras = listaManiobras;
		}
	}

	public int getCantidadRestanteManiobrasPorAprender() {
		return cantidadRestante;
	}

	private void setCantidadRestanteManiobrasPorAprender(int cantidadRestante) {
		this.cantidadRestante = cantidadRestante;
	}

	public void aumentarCantidadRestanteManiobrasPorAprender(int aumento) {
		if (aumento <= 0) {
			throw new IllegalArgumentException(
					"El aumento mínimo para aumentar la cantidad de maniobras que puede aprender el personaje es de 1.");
		} else {
			setCantidadRestanteManiobrasPorAprender(getCantidadRestanteManiobrasPorAprender() + aumento);
		}
	}

	public void anadirManiobra(Maniobra maniobraAnadir) {
		if (maniobraAnadir == null) {
			throw new IllegalArgumentException(
					"No se puede añadir una maniobra nula a la lista de maniobras del personaje.");
		} else {
			if (getCantidadRestanteManiobrasPorAprender() == 0) {
				throw new IllegalArgumentException(
						"No se pueden añadir mas maniobras el personaje no tiene capacidad para ello.");
			} else {
				this.listaManiobras.add(new Maniobra(maniobraAnadir));
			}
		}
	}

	public void anadirCantidadDadoSupremacia(int aumento) {
		if (aumento <= 0) {
			throw new IllegalArgumentException("La cantidad mínima de dados a añadir es de 1.");
		} else {
			setCantidadMaximaDados(getCantidadMaximaDados() + aumento);
		}
	}

	public void anadirDadoSupremacia(Dado dado) {
		if (dado == null) {
			throw new IllegalArgumentException("El dado de supremacía no puede ser nulo.");
		} else {
			setDadoSupremacia(new Dado(dado));
		}
	}

	public Dado getDadoSupremacia() {
		return dadoSupremacia;
	}

	private void setDadoSupremacia(Dado dadoSupremacia) {
		if (dadoSupremacia == null) {
			throw new IllegalArgumentException("El dado de supremacía de las maniobras no puede ser nulo.");
		} else {
			this.dadoSupremacia = dadoSupremacia;
		}
	}

	public int getCantidadRestanteDados() {
		return cantidadRestanteDados;
	}

	private void setCantidadRestanteDados(int cantidadRestanteDados) {
		if (cantidadRestanteDados < 0) {
			throw new IllegalArgumentException("La cantidad de dados restantes no puede ser menor de 0.");
		} else {
			this.cantidadRestanteDados = cantidadRestanteDados;
		}
	}

	public int getCantidadMaximaDados() {
		return cantidadMaximaDados;
	}

	private void setCantidadMaximaDados(int cantidadMaximaDados) {
		if (cantidadMaximaDados < 0) {
			throw new IllegalArgumentException("La cantidad de dados máxima no puede ser menor de 0.");
		} else {
			this.cantidadMaximaDados = cantidadMaximaDados;
		}
	}

	public void recuperarDados() {
		setCantidadRestanteDados(getCantidadMaximaDados());
	}

}
