package ProyectoFG.modelo.dominio.arma;

import java.util.List;

import ProyectoFG.modelo.dominio.Atributo;
import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.TipoDano;
import ProyectoFG.modelo.dominio.competencia.TipoCompetencia;
import ProyectoFG.modelo.dominio.moneda.Moneda;
import ProyectoFG.modelo.dominio.tirada.Dado;
import ProyectoFG.modelo.dominio.tirada.TipoTirada;
import ProyectoFG.modelo.dominio.tirada.Tirada;

public class ArmaArrojadiza extends Arma {

	private int alcanceNormal;
	private int alcanceMaximo;

	public ArmaArrojadiza(String nombreArma, int pesoArma, int cantidadArma, Moneda precio,
			TipoCompetencia competenciaEspecifica, TipoCompetencia competenciaGeneral, TipoArma tipoDeArma,
			TipoDano tipoDeDano, List<PropiedadesArma> listaPropiedadesDelArma, int alcanceNormal, int alcanceMaximo,
			Tirada dadoDano) {
		super(nombreArma, pesoArma, cantidadArma, precio, competenciaEspecifica, competenciaGeneral, tipoDeArma,
				tipoDeDano, listaPropiedadesDelArma, dadoDano);
		setAlcanceNormal(alcanceNormal);
		setAlcanceMaximo(alcanceMaximo);
	}

	public ArmaArrojadiza(ArmaArrojadiza armaArrojadiza) {
		super(armaArrojadiza.getNombre(), armaArrojadiza.getPeso(), armaArrojadiza.getCantidad(),
				armaArrojadiza.getPrecio(), armaArrojadiza.getCompetenciaEspecifica(),
				armaArrojadiza.getCompetenciaGeneral(), armaArrojadiza.getTipoDeArma(), armaArrojadiza.getTipoDeDano(),
				armaArrojadiza.getListaPropiedadesDelArma(), armaArrojadiza.getDadoDano());
		setAlcanceNormal(armaArrojadiza.getAlcanceNormal());
		setAlcanceMaximo(armaArrojadiza.getAlcanceMaximo());
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

	@Override
	public Tirada atacar(Personaje pj, TipoTirada tipo) {
		if (super.getListaPropiedadesDelArma().contains(PropiedadesArma.RED)) {
			throw new IllegalArgumentException("No se puede atacar con una red, solo se puede lanzar.");
		} else {
			if (pj.getCompetencias().buscar(getCompetenciaEspecifica()) == null
					&& pj.getCompetencias().buscar(getCompetenciaGeneral()) == null) {
				return new Tirada(new Dado(20), 1, pj.getCaracteristicas().buscar(Atributo.FUERZA).getModificador());
			} else {
				return new Tirada(new Dado(20), 1, pj.getModificadorCompetencia()
						+ pj.getCaracteristicas().buscar(Atributo.FUERZA).getModificador());
			}
		}

	}

	public Tirada lanzar(Personaje pj) {
		this.consumirCantidad(1);
		if (pj.getCompetencias().buscar(getCompetenciaEspecifica()) == null
				&& pj.getCompetencias().buscar(getCompetenciaGeneral()) == null) {
			return new Tirada(new Dado(20), 1, pj.getCaracteristicas().buscar(Atributo.FUERZA).getModificador());
		} else {
			return new Tirada(new Dado(20), 1,
					pj.getModificadorCompetencia() + pj.getCaracteristicas().buscar(Atributo.FUERZA).getModificador());
		}

	}

	@Override
	public Tirada danoCausado(Personaje pj) {
		if (super.getListaPropiedadesDelArma().contains(PropiedadesArma.RED)) {
			throw new IllegalArgumentException("Una red no causa daño");
		} else {
			if (pj.getCompetencias().buscar(getCompetenciaEspecifica()) == null
					&& pj.getCompetencias().buscar(getCompetenciaGeneral()) == null) {
				return new Tirada(getDadoDano().getDado(), getDadoDano().getNumeroVeces(),
						pj.getCaracteristicas().buscar(Atributo.FUERZA).getModificador());
			} else {
				return new Tirada(getDadoDano().getDado(), getDadoDano().getNumeroVeces(),
						pj.getModificadorCompetencia()
								+ pj.getCaracteristicas().buscar(Atributo.FUERZA).getModificador());
			}
		}

	}
}
