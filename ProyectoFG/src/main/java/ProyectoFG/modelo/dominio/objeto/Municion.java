package ProyectoFG.modelo.dominio.objeto;

import java.util.Objects;

import ProyectoFG.modelo.dominio.arma.TipoMunicion;
import ProyectoFG.modelo.dominio.moneda.Moneda;

public class Municion extends ObjetoInventario {
	private TipoMunicion tipoDeMunicion;

	public Municion(String nombre, int peso, int cantidad, Moneda precio, TipoMunicion tipoMunicion) {
		super(nombre, peso, cantidad, precio);
		setTipoDeMunicion(tipoMunicion);
	}

	public TipoMunicion getTipoDeMunicion() {
		return tipoDeMunicion;
	}

	private void setTipoDeMunicion(TipoMunicion tipoDeMunicion) {
		this.tipoDeMunicion = tipoDeMunicion;
	}

	public void consumirUnidad() {
		if (getCantidad() == 0) {
			throw new IllegalArgumentException("No se puede consumir mas munición, no queda munición.");
		} else {
			setCantidad(getCantidad() - 1);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(tipoDeMunicion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Municion other = (Municion) obj;
		return tipoDeMunicion == other.tipoDeMunicion;
	}

}
