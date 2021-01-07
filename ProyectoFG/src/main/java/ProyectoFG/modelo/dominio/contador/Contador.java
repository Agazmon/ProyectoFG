package ProyectoFG.modelo.dominio.contador;

import java.util.Objects;

public class Contador {
	private String nombreContador;
	private TipoContador tipoContador;
	private int valorMaximo;
	private int valorActual;

	public Contador(String nombreContador, int valorMaximo, int valorActual) {
		setNombreContador(nombreContador);
		setValorMaximo(valorMaximo);
		setValorActual(valorActual);
		setTipoContador(TipoContador.PERSONALIZADO);
	}
	public Contador(String nombreContador, int valorMaximo, int valorActual, TipoContador tipoContador) {
		setNombreContador(nombreContador);
		setValorMaximo(valorMaximo);
		setValorActual(valorActual);
		setTipoContador(tipoContador);
		
	}

	public Contador(Contador contador) {
		setNombreContador(contador.getNombreContador());
		setValorMaximo(contador.getValorMaximo());
		setValorActual(contador.getValorActual());
		setTipoContador(contador.getTipoContador());
	}
	public String getNombreContador() {
		return nombreContador;
	}
	public void setNombreContador(String nombreContador) {
		if(nombreContador==null) {
			throw new IllegalArgumentException("El nombre de un contador no puede ser nulo.");
		} else if(nombreContador.isBlank()) {
			throw new IllegalArgumentException("El nombre de un contador no puede estar vacío.");
		} else {
			this.nombreContador = nombreContador.trim();
		}
	}

	public TipoContador getTipoContador() {
		return tipoContador;
	}

	private void setTipoContador(TipoContador tipoContador) {
		if (tipoContador == null) {
			throw new IllegalArgumentException("El tipo de un contador no puede ser nulo.");
		} else {
			this.tipoContador = tipoContador;
		}

	}

	public int getValorMaximo() {
		return valorMaximo;
	}

	private void setValorMaximo(int valorMaximo) {
		this.valorMaximo = valorMaximo;
	}

	public int getValorActual() {
		return valorActual;
	}

	protected void setValorActual(int valorActual) {
		if (valorActual < 0) {
			throw new IllegalArgumentException("Un contador necesita tener como mínimo 0 cargas.");
		} else if (valorActual > getValorMaximo()) {
			throw new IllegalArgumentException("Un contador no puede tener mas cargas que el valor máximo.");
		}
		this.valorActual = valorActual;
	}

	public void decrementarContador() {
		if (getValorActual() == 0) {
			throw new IllegalArgumentException("No se puede decrementar mas el valor del contador.");
		} else {
			setValorActual(getValorActual() - 1);
		}
	}

	public void aumentarContador() {
		if (getValorActual() == getValorMaximo()) {
			throw new IllegalArgumentException("No se puede aumentar mas el contador, se ha alcanzado el límite");
		} else {
			setValorActual(getValorActual() + 1);
		}
	}
	@Override
	public int hashCode() {
		return Objects.hash(nombreContador);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Contador))
			return false;
		Contador other = (Contador) obj;
		return Objects.equals(nombreContador, other.nombreContador);
	}
	
	
	

}
