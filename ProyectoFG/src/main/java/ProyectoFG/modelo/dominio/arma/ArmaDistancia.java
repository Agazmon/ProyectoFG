package ProyectoFG.modelo.dominio.arma;

import java.util.List;

import ProyectoFG.modelo.dominio.Atributo;
import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.TipoDano;
import ProyectoFG.modelo.dominio.competencia.TipoCompetencia;
import ProyectoFG.modelo.dominio.dote.TipoDote;
import ProyectoFG.modelo.dominio.moneda.Moneda;
import ProyectoFG.modelo.dominio.tirada.Dado;
import ProyectoFG.modelo.dominio.tirada.TipoTirada;
import ProyectoFG.modelo.dominio.tirada.Tirada;

public class ArmaDistancia extends Arma {

	private TipoMunicion municionUsada;
	private int alcanceNormal;
	private int alcanceMaximo;
	private boolean cargada;

	public ArmaDistancia(String nombreArma, int peso, int cantidad, Moneda precio,
			TipoCompetencia competenciaEspecifica, TipoCompetencia competenciaGeneral, TipoArma tipoDeArma,
			TipoDano tipoDeDano, List<PropiedadesArma> listaPropiedadesDelArma, Tirada dadoDano,
			TipoMunicion municionUsada, int alcanceNormal, int alcanceMaximo, boolean cargada) {
		super(nombreArma, peso, cantidad, precio, competenciaEspecifica, competenciaGeneral, tipoDeArma, tipoDeDano,
				listaPropiedadesDelArma, dadoDano);
		setMunicionUsada(municionUsada);
		setAlcanceNormal(alcanceNormal);
		setAlcanceMaximo(alcanceMaximo);
		setCargada(cargada);
	}

	public ArmaDistancia(ArmaDistancia armaDistancia) {
		super(armaDistancia.getNombre(), armaDistancia.getPeso(), armaDistancia.getCantidad(),
				armaDistancia.getPrecio(), armaDistancia.getCompetenciaEspecifica(),
				armaDistancia.getCompetenciaGeneral(), armaDistancia.getTipoDeArma(), armaDistancia.getTipoDeDano(),
				armaDistancia.getListaPropiedadesDelArma(), armaDistancia.getDadoDano());
		setMunicionUsada(armaDistancia.getMunicionUsada());
		setAlcanceNormal(armaDistancia.getAlcanceNormal());
		setAlcanceMaximo(armaDistancia.getAlcanceMaximo());
		setCargada(armaDistancia.isCargada());
	}

	public TipoMunicion getMunicionUsada() {
		return municionUsada;
	}

	private void setMunicionUsada(TipoMunicion municionUsada) {
		if (municionUsada == null) {
			throw new IllegalArgumentException(
					"El tipo de munición usada no puede ser nula. Una arma a distancia necesita un tipo de munición.");
		}
		this.municionUsada = municionUsada;
	}

	public int getAlcanceNormal() {
		return alcanceNormal;
	}

	private void setAlcanceNormal(int alcanceNormal) {
		this.alcanceNormal = alcanceNormal;
	}

	public int getAlcanceMaximo() {
		return alcanceMaximo;
	}

	private void setAlcanceMaximo(int alcanceMaximo) {
		this.alcanceMaximo = alcanceMaximo;
	}

	public boolean isCargada() {
		return cargada;
	}

	public void setCargada(boolean cargada) {
		this.cargada = cargada;
	}

	@Override
	public Tirada atacar(Personaje pj, TipoTirada tirada) {
		if (getListaPropiedadesDelArma().contains(PropiedadesArma.MUNICION)) {
			pj.getInventarioPersonaje().getTipoMunicion(this.getMunicionUsada()).consumirUnidad();
		}
		if (getListaPropiedadesDelArma().contains(PropiedadesArma.RECARGA)) {
			if (pj.getCompetencias().buscar(getCompetenciaEspecifica()).isCompetente()
					|| pj.getCompetencias().buscar(getCompetenciaGeneral()).isCompetente()) {
				if (pj.getDotes().buscar(TipoDote.EXPERTO_EN_BALLESTAS) == null) {
					if (!isCargada()) {
						throw new IllegalArgumentException("Primero es necesario recargar el arma.");
					}
				} else {
					return new Tirada(super.atacar(pj, tirada));
				}
			} else {
				if (!isCargada()) {
					throw new IllegalArgumentException("Primero es necesario recargar el arma.");
				}
			}
		}

		setCargada(false);
		return new Tirada(super.atacar(pj, tirada));
	}

	public void recargar() {
		if (!isCargada()) {
			setCargada(true);
		} else {
			throw new IllegalArgumentException("El arma ya está cargada, no es necesario cargarla");
		}
	}

}
