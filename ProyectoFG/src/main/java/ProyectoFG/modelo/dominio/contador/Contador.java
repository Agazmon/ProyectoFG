package ProyectoFG.modelo.dominio.contador;

public class Contador {
	String origenContador;
	int valorMaximo;
	int valorActual;
	public Contador(String origenContador, int valorMaximo, int valorActual) {
		setOrigenContador(origenContador);
		setValorMaximo(valorMaximo);
		setValorActual(valorActual);
	}
	public Contador(Contador contador) {
		setOrigenContador(contador.getOrigenContador());
		setValorMaximo(contador.getValorMaximo());
		setValorActual(contador.getValorActual());
	}
	public String getOrigenContador() {
		return origenContador;
	}
	private void setOrigenContador(String origenContador) {
		this.origenContador = origenContador;
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
	private void setValorActual(int valorActual) {
		if(valorActual<0) {
			throw new IllegalArgumentException("Un contador necesita tener como mínimo 0 cargas.");
		} else if(valorActual>getValorMaximo()) {
			throw new IllegalArgumentException("Un contador no puede tener mas cargas que el valor máximo.");
		}
		this.valorActual = valorActual;
	}
	public void decrementarContador() {
		if(getValorActual()==0) {
			throw new IllegalArgumentException("No se puede decrementar mas el valor del contador.");
		} else {
			setValorActual(getValorActual()-1);
		}
	}
	public void aumentarContador() {
		if(getValorActual()==getValorMaximo()) {
			throw new IllegalArgumentException("No se puede aumentar mas el contador, se ha alcanzado el límite");
		} else {
			setValorActual(getValorActual()+1);
		}
	}
	
	
}
