package ProyectoFG.modelo.dominio.objeto;

import java.util.Objects;

import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.moneda.Moneda;

public class ObjetoInventario {
	String nombre;
	int peso;
	int cantidad;
	Moneda precio;

	public ObjetoInventario(String nombre, int peso, int cantidad, Moneda precio) {
		setNombre(nombre);
		setCantidad(cantidad);
		setPeso(peso);
		setPrecio(precio);
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPeso() {
		return peso;
	}

	private void setPeso(int peso) {
		this.peso = peso;
	}

	public int getCantidad() {
		return cantidad;
	}

	protected void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Moneda getPrecio() {
		return precio;
	}

	private void setPrecio(Moneda precio) {
		this.precio = precio;
	}

	protected void consumirCantidad(int cantidad) {
		setCantidad(getCantidad() - cantidad);
	}

	protected void anadirCantidad(int cantidad) {
		setCantidad(getCantidad() + cantidad);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ObjetoInventario other = (ObjetoInventario) obj;
		return Objects.equals(nombre, other.nombre);
	}

}
