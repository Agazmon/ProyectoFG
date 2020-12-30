package ProyectoFG.modelo.dominio.hechizo;

import java.util.ArrayList;
import java.util.List;

import ProyectoFG.modelo.dominio.moneda.Moneda;
import ProyectoFG.modelo.dominio.moneda.TipoMoneda;

public class Material {
	boolean usoMaterial;
	Moneda precioMaterial;
	String nombreMaterial;

	public Material(boolean usoMaterial) {
		if (usoMaterial == true) {
			throw new IllegalArgumentException(
					"Es necesario especificar los materiales que usa el conjuro en caso de que los consuma");
		} else {
			setUsoMaterial(usoMaterial);
		}
	}

	public Material(boolean usoMaterial, String nombreMaterial) {
		if (nombreMaterial == null) {
			throw new IllegalArgumentException("La lista con los nombres de los materiales es nula.");
		} else {
			setUsoMaterial(usoMaterial);
			setNombreMaterial(nombreMaterial);
			setPrecioMaterial(new Moneda(TipoMoneda.MONEDA_COBRE, 0));
		}
	}

	public Material(boolean usoMaterial, String nombreMaterial, Moneda precioMaterial) {
		// Comprobar nulos
		if (nombreMaterial == null) {
			throw new IllegalArgumentException("El nombre de los materiales proporcionados es nulo.");
		} else if (precioMaterial == null) {
			throw new IllegalArgumentException("Los precios de los materiales son nulos.");
		} else {

			setUsoMaterial(usoMaterial);
			setNombreMaterial(nombreMaterial);
			setPrecioMaterial(precioMaterial);
		}

	}

	public boolean isUsoMaterial() {
		return usoMaterial;
	}

	private void setUsoMaterial(boolean usoMaterial) {
		this.usoMaterial = usoMaterial;
	}

	public String getNombreMaterial() {
		if (!isUsoMaterial()) {
			throw new IllegalArgumentException("El hechizo no hace uso de componente material.");
		} else {
			return nombreMaterial;
		}

	}

	private void setNombreMaterial(String nombreMaterial) {
		if (nombreMaterial == null) {
			throw new IllegalArgumentException("La lista de los nombres de los materiales del hechizo es nula.");
		} else if (nombreMaterial.isEmpty()) {
			throw new IllegalArgumentException("No se han obtenido el nombre de los materiales para el hechizo.");
		} else {
			this.nombreMaterial = nombreMaterial;
		}
	}

	public Moneda getPrecioMaterial() {
		if (!isUsoMaterial()) {
			throw new IllegalArgumentException("El hechizo no hace uso de componente material.");
		} else {
			return precioMaterial;
		}
	}

	private void setPrecioMaterial(Moneda precioMaterial) {
		if (precioMaterial == null) {
			throw new IllegalArgumentException("La lista de los precios de los materiales es nula.");
		} else {
			this.precioMaterial = precioMaterial;
		}
	}

	@Override
	public String toString() {
		if (!isUsoMaterial()) {
			return "No se hace uso de material";
		} else {
			String materiales = getNombreMaterial();
			Moneda precio = getPrecioMaterial();
			String mensajeFinal = "Materiales [";
			mensajeFinal += "Material:" + materiales.toString();
			if (!precio.equals(new Moneda(TipoMoneda.MONEDA_COBRE, 0))) {
				mensajeFinal += "Precio: " + precio.toString();
			}
			mensajeFinal += ", ";
			mensajeFinal += "]";
			return mensajeFinal;
		}

	}

}
