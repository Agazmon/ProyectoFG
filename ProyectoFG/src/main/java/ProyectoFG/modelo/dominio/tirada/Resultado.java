package ProyectoFG.modelo.dominio.tirada;

import java.util.List;

public class Resultado {
	private List<Integer> dadosSacados;
	private int bonificadorAnadido;

	public Resultado(List<Integer> dadosSacados, int bonificadorAnadido) {
		setDadosSacados(dadosSacados);
		setBonificadorAnadido(bonificadorAnadido);
	}

	public List<Integer> getDadosSacados() {
		return dadosSacados;
	}

	private void setDadosSacados(List<Integer> dadosSacados) {
		if (dadosSacados == null) {
			throw new IllegalArgumentException("Los dados sacados de una tirada no pueden ser nulos.");
		} else if (dadosSacados.isEmpty()) {
			throw new IllegalArgumentException("No se ha recibido la información de los dados sacados en la tirada.");
		} else if (dadosSacados.size() > 2) {
			throw new IllegalArgumentException("Las tiradas como máximo solo pueden tener 2 resultados");
		} else {
			this.dadosSacados = dadosSacados;
		}
	}

	public int getBonificadorAnadido() {
		return bonificadorAnadido;
	}

	private void setBonificadorAnadido(int bonificadorAnadido) {
		this.bonificadorAnadido = bonificadorAnadido;
	}

	public int getResultado() {
		int resultado = 0;
		for (Integer resultadoIteracion : dadosSacados) {
			resultado += resultadoIteracion;
		}
		return resultado += bonificadorAnadido;
	}

}
