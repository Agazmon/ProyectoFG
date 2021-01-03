package ProyectoFG.modelo.dominio.arma;

import java.util.List;

import ProyectoFG.modelo.dominio.Atributo;
import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.TipoDano;
import ProyectoFG.modelo.dominio.competencia.TipoCompetencia;
import ProyectoFG.modelo.dominio.contador.Contador;
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
	public Tirada atacar(Personaje pj, TipoTirada tipoTirada) {
		if(this.getCantidad()==0) {
			throw new IllegalArgumentException("No quedan unidades con las que atacar");
		} else {
			return new Tirada(super.atacar(pj, tipoTirada));
		}
		
	}

	public Tirada lanzar(Personaje pj, TipoTirada tipoTirada) {
		if (!super.getListaPropiedadesDelArma().contains(PropiedadesArma.ARROJADIZA)) {
			throw new IllegalArgumentException("Esta arma no se puede lanzar no tiene la propiedad de arrojadiza.");
		}
		if(super.getListaPropiedadesDelArma().contains(PropiedadesArma.VERSATIL)) {
			if(pj.getManoPrincipal().equals(this)&&pj.getManoSecundaria().equals(this)) {
				throw new IllegalArgumentException("Para lanzar un arma versatil debe estar equipada en una sola mano.");
			}
		}
		
		if(this.getCantidad()==0) {
			throw new IllegalArgumentException("No quedan unidades que lanzar.");
		} else {
			this.consumirCantidad(1);
			return new Tirada(super.atacar(pj, tipoTirada));
		}
		
	}


}
