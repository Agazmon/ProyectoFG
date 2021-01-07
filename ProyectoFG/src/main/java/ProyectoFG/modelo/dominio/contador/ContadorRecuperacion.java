package ProyectoFG.modelo.dominio.contador;

import ProyectoFG.modelo.dominio.accion.TiempoRecuperacion;

public class ContadorRecuperacion extends Contador {
	private TiempoRecuperacion tiempoRecuperacion;

	public ContadorRecuperacion(String origenContador, TipoContador tipoContador,
			TiempoRecuperacion tiempoRecuperacion) {
		super(origenContador, tipoContador.getCargasPorDefecto(), tipoContador.getCargasPorDefecto(), tipoContador);
		setTiempoRecuperacion(tiempoRecuperacion);
	}

	public ContadorRecuperacion(String origenContador, int valorActual, TipoContador tipoContador,
			TiempoRecuperacion tiempoRecuperacion) {
		super(origenContador, tipoContador.getCargasPorDefecto(), valorActual, tipoContador);
		setTiempoRecuperacion(tiempoRecuperacion);
	}

	public ContadorRecuperacion(String origenContador, int valorMaximo, int valorActual, TipoContador tipoContador,
			TiempoRecuperacion tiempoRecuperacion) {
		super(origenContador, valorMaximo, valorActual, tipoContador);
		setTiempoRecuperacion(tiempoRecuperacion);
	}

	public ContadorRecuperacion(ContadorRecuperacion contadorRecuperacion) {
		super(contadorRecuperacion.getNombreContador(), contadorRecuperacion.getValorMaximo(),
				contadorRecuperacion.getValorActual(), contadorRecuperacion.getTipoContador());
		setTiempoRecuperacion(contadorRecuperacion.getTiempoRecuperacion());
	}

	public TiempoRecuperacion getTiempoRecuperacion() {
		return tiempoRecuperacion;
	}

	private void setTiempoRecuperacion(TiempoRecuperacion tiempoRecuperacion) {
		if (tiempoRecuperacion == null) {
			throw new IllegalArgumentException(
					"El tiempo de recuperación no puede ser nulo. Para ello el tipo de contador será del tipo Contador normal.");
		} else {
			this.tiempoRecuperacion = tiempoRecuperacion;
		}
	}

	public void recuperar() {
		setValorActual(getValorMaximo());
	}

}
