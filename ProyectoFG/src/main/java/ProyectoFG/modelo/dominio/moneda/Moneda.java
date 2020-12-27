package ProyectoFG.modelo.dominio.moneda;

import java.util.Objects;

public class Moneda {
	TipoMoneda tipoMoneda;
	int cantidadMoneda;

	public Moneda(TipoMoneda tipoMoneda, int cantidadMoneda) {
		setTipoMoneda(tipoMoneda);
		setCantidadMoneda(cantidadMoneda);
	}

	public Moneda(Moneda moneda) {
		setTipoMoneda(moneda.getTipoMoneda());
		setCantidadMoneda(moneda.getCantidadMoneda());
	}

	public TipoMoneda getTipoMoneda() {
		return tipoMoneda;
	}

	private void setTipoMoneda(TipoMoneda tipoMoneda) {
		if (tipoMoneda == null)
			throw new IllegalArgumentException("Un tipo de moneda no puede ser nulo.");
		else
			this.tipoMoneda = tipoMoneda;

	}

	public int getCantidadMoneda() {
		return cantidadMoneda;
	}

	private void setCantidadMoneda(int cantidadMoneda) {
		if (cantidadMoneda < 0)
			throw new IllegalArgumentException("La cantidad de monedas no puede ser menor que 0.");
		else
			this.cantidadMoneda = cantidadMoneda;
	}
	public void anadirMoneda(int cantidadAnadir) {
		if(cantidadAnadir<=0) {
			throw new IllegalArgumentException("No se puede añadir monedas negativas a la cantidad de monedas.");
		} else {
			setCantidadMoneda(getCantidadMoneda()+cantidadAnadir);
		}
	}
	public void quitarMoneda(int cantidadQuitar) {
		if(cantidadQuitar<=0) {
			throw new IllegalArgumentException("No se pueden quitar monedas negativas a la cantidad de monedas.");
		} else if((getCantidadMoneda()-cantidadQuitar)<0) {
			throw new IllegalArgumentException("No se pueden retirar tantas monedas, las monedas serían negativas.");
		} else {
			setCantidadMoneda(getCantidadMoneda()-cantidadQuitar);
		}
	}

	public Moneda cambiarMoneda(TipoMoneda tipoMonedaCambio, int cantidadUsar) {
		if (getTipoMoneda().equals(tipoMonedaCambio)) {
			throw new IllegalArgumentException("No se puede cambiar una cantidad de monedas al mismo tipo de moneda.");
		} else {
			if (cantidadUsar <= 0) {
				throw new IllegalArgumentException("No se puede cambiar una cantidad de monedas negativa o igual a 0.");
			} else if ((getCantidadMoneda() - cantidadUsar) < 0) {
				throw new IllegalArgumentException("No se puede cambiar mas monedas de las que se tienen.");
			} else {
				int valorEnCobre = getTipoMoneda().getValorEnCobre();
				int valorEnCobreCambio = tipoMonedaCambio.getValorEnCobre();
				if (valorEnCobreCambio < valorEnCobre) {
					// Cambio hacia abajo
					int nuevasMonedas = (valorEnCobre / valorEnCobreCambio) * cantidadUsar;
					setCantidadMoneda(getCantidadMoneda() - cantidadUsar);
					return new Moneda(tipoMonedaCambio, nuevasMonedas);
				} else if ((valorEnCobre * cantidadUsar) % valorEnCobreCambio == 0) {
					// Cambio hacia arriba perfecto
					int nuevasMonedas = (valorEnCobre * cantidadUsar) / valorEnCobreCambio;
					setCantidadMoneda(getCantidadMoneda() - cantidadUsar);
					return new Moneda(tipoMonedaCambio, nuevasMonedas);
				} else if ((valorEnCobre * cantidadUsar) % valorEnCobreCambio != 0) {
					// Cambio imperfecto
					if ((valorEnCobre * cantidadUsar) < valorEnCobreCambio) {
						throw new IllegalArgumentException(
								"No se han asignado suficientes monedas para cambiar a la moneda pedida.");
					} else {
						for (int i = 1; i < cantidadUsar; i++) {
							if ((valorEnCobre * i) % valorEnCobreCambio == 0) {
								return cambiarMoneda(tipoMonedaCambio, i);
							}
						}
					}
				}
			}
		}
		return null;
	}

	@Override
	public int hashCode() {
		return Objects.hash(tipoMoneda);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Moneda other = (Moneda) obj;
		return tipoMoneda == other.tipoMoneda;
	}

	@Override
	public String toString() {
		return "Moneda [tipoMoneda=" + tipoMoneda + ", cantidadMoneda=" + cantidadMoneda + "]";
	}

}
