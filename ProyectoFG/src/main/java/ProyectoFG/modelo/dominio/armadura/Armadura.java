package ProyectoFG.modelo.dominio.armadura;

import java.util.List;
import java.util.Objects;

import ProyectoFG.modelo.dominio.Atributo;
import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.moneda.Moneda;

public class Armadura {

	private TipoArmadura tipoArmadura;
	private String nombre;
	private Moneda precioDeCompra;
	private int claseArmaduraBase;
	private int minFuerza;
	private boolean desventajaSigilo;
	private int pesoEnLb;

	

	public Armadura(TipoArmadura tipo, String nombre, Moneda precioDeCompra, int claseArmaduraBase, int minFuerza,
			boolean desventajaSigilo, int pesoEnLb) {
		setTipoArmadura(tipo);
		setNombre(nombre);
		setPrecioDeCompra(precioDeCompra);
		setClaseArmaduraBase(claseArmaduraBase);;
		setMinFuerza(minFuerza);
		setDesventajaSigilo(desventajaSigilo);;
		setPesoEnLb(pesoEnLb);
	}
	
	public Armadura(Armadura armadura) {
		setTipoArmadura(armadura.getTipoArmadura());
		setNombre(armadura.getNombre());
		setPrecioDeCompra(armadura.getPrecioDeCompra());
		setClaseArmaduraBase(armadura.getClaseArmaduraBase());;
		setMinFuerza(armadura.getMinFuerza());
		setDesventajaSigilo(armadura.isDesventajaSigilo());;
		setPesoEnLb(armadura.getPesoEnLb());
	}

	public TipoArmadura getTipoArmadura() {
		return tipoArmadura;
	}

	private void setTipoArmadura(TipoArmadura tipo) {
		if (tipo == null) {
			throw new IllegalArgumentException("El tipo de armadura no puede ser nulo.");
		} else {
			this.tipoArmadura = tipo;
		}

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null) {
			throw new IllegalArgumentException("El nombre de una armadura no puede ser nulo.");
		} else if (nombre.isBlank()) {
			throw new IllegalArgumentException("El nombre de una armadura no puede estar vacio.");
		} else {
			this.nombre = nombre.trim().replace("\s+", " ");
		}
	}

	public Moneda getPrecioDeCompra() {
		return new Moneda(precioDeCompra);
	}

	public void setPrecioDeCompra(Moneda precio) {
		if (precio == null) {
			throw new IllegalArgumentException("El precio de una pieza de armadura no puede ser nulo.");
		} else {
			this.precioDeCompra = new Moneda(precio);
		}

	}

	public int getClaseArmaduraBase() {
		return claseArmaduraBase;
	}

	public void setClaseArmaduraBase(int claseArmaduraBase) {
		if (claseArmaduraBase < 0) {
			throw new IllegalArgumentException("La clase de armadura no es válida es inferior a 0.");
		} else {

		}
		this.claseArmaduraBase = claseArmaduraBase;
	}

	public int getMinFuerza() {
		return minFuerza;
	}

	public void setMinFuerza(int minFuerza) {
		this.minFuerza = minFuerza;
	}

	public boolean isDesventajaSigilo() {
		return desventajaSigilo;
	}

	public void setDesventajaSigilo(boolean desventajaSigilo) {
		this.desventajaSigilo = desventajaSigilo;
	}

	public int getPesoEnLb() {
		return pesoEnLb;
	}

	public void setPesoEnLb(int pesoEnLb) {
		this.pesoEnLb = pesoEnLb;
	}

	public int getCAFinal(Personaje pj) {
		int modDestrezaPJ = pj.getCaracteristicas().buscar(Atributo.DESTREZA).getModificador();
		if (getTipoArmadura().equals(TipoArmadura.ARMADURA_LIGERA)) {
			return getClaseArmaduraBase() + modDestrezaPJ;
		} else if (getTipoArmadura().equals(TipoArmadura.ARMADURA_MEDIA)) {
			if (modDestrezaPJ > 2)
				return getClaseArmaduraBase() + 2;
			else
				return getClaseArmaduraBase() + modDestrezaPJ;
		} else if (getTipoArmadura().equals(TipoArmadura.ARMADURA_PESADA)) {
			return getClaseArmaduraBase();
		} else {
			return 2;
		}

	}
	

	@Override
	public int hashCode() {
		return Objects.hash(nombre, tipoArmadura);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Armadura other = (Armadura) obj;
		return Objects.equals(nombre, other.nombre) && tipoArmadura == other.tipoArmadura;
	}

	@Override
	public String toString() {
		switch (getTipoArmadura()) {
		case ARMADURA_LIGERA:
			if (isDesventajaSigilo())
				return "Armadura [ Nombre:" + getNombre() + " Coste:" + getPrecioDeCompra() + " Calculo CA ="
					+ getClaseArmaduraBase() + "+Modificador por Des" + " Requisito de fuerza: -" + " Sigilo: Desventaja"  + " Peso: " + getPesoEnLb() + "lb"
					+ "]";
			else 
				return "Armadura [ Nombre:" + getNombre() + " Coste:" + getPrecioDeCompra() + " Calculo CA ="
				+ getClaseArmaduraBase() + "+Modificador por Des" + " Requisito de fuerza: -" +"  Sigilo: -" + " Peso: " + getPesoEnLb() + "lb"
				+ "]";
		case ARMADURA_MEDIA:
			if (isDesventajaSigilo())
				return "Armadura [ Nombre:" + getNombre() + " Coste:" + getPrecioDeCompra() + " Calculo CA ="
					+ getClaseArmaduraBase() + "+Modificador por Des(máx 2)" + " Requisito de fuerza: -" + " Sigilo: Desventaja"  + " Peso: " + getPesoEnLb() + "lb"
					+ "]";
			else 
				return "Armadura [ Nombre:" + getNombre() + " Coste:" + getPrecioDeCompra() + " Calculo CA ="
				+ getClaseArmaduraBase() + "+Modificador por Des (máx 2)" + " Requisito de fuerza: -" +"  Sigilo: -" + " Peso: " + getPesoEnLb() + "lb"
				+ "]";
		case ARMADURA_PESADA:
			return "Armadura [ Nombre:" + getNombre() + " Coste:" + getPrecioDeCompra() + " Calculo CA ="
			+ getClaseArmaduraBase() + "+Modificador por Des(máx 2)" + " Requisito de fuerza:" + getMinFuerza() + " Sigilo: Desventaja"  + " Peso: " + getPesoEnLb() + "lb"
			+ "]";
		case ESCUDOS:
			return "Armadura [ Nombre:" + getNombre() + " Coste:" + getPrecioDeCompra() + " Calculo CA = CA Actual + 2" + "]";
		default:
			throw new IllegalArgumentException("Tipo de armadura no reconocido para mostrar.");
		}

	}

}
