package ProyectoFG.modelo.dominio.arma;

import java.util.ArrayList;
import java.util.List;

import ProyectoFG.modelo.dominio.Atributo;
import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.TipoDano;
import ProyectoFG.modelo.dominio.competencia.TipoCompetencia;
import ProyectoFG.modelo.dominio.moneda.Moneda;
import ProyectoFG.modelo.dominio.objeto.ObjetoInventario;
import ProyectoFG.modelo.dominio.raza.TamanoRaza;
import ProyectoFG.modelo.dominio.tirada.Dado;
import ProyectoFG.modelo.dominio.tirada.TipoTirada;
import ProyectoFG.modelo.dominio.tirada.Tirada;

public class Arma extends ObjetoInventario {
	private TipoCompetencia competenciaEspecifica;
	private TipoCompetencia competenciaGeneral;
	private TipoArma tipoDeArma;
	private TipoDano tipoDeDano;
	private List<PropiedadesArma> listaPropiedadesDelArma;
	private Tirada dadoDano;

	public Arma(String nombreArma, int pesoArma, int cantidadArma, Moneda precio, TipoCompetencia competenciaEspecifica,
			TipoCompetencia competenciaGeneral, TipoArma tipoDeArma, TipoDano tipoDeDano,
			List<PropiedadesArma> listaPropiedadesDelArma, Tirada dadoDano) {
		super(nombreArma, pesoArma, cantidadArma, precio);
		setCompetenciaEspecifica(competenciaEspecifica);
		setCompetenciaGeneral(competenciaGeneral);
		setTipoDeArma(tipoDeArma);
		setTipoDeDano(tipoDeDano);
		setListaPropiedadesDelArma(listaPropiedadesDelArma);
		setDadoDano(dadoDano);
	}

	public Arma(Arma arma) {
		super(arma.getNombre(), arma.getPeso(), arma.getCantidad(), arma.getPrecio());
		setCompetenciaEspecifica(arma.getCompetenciaEspecifica());
		setCompetenciaGeneral(arma.getCompetenciaGeneral());
		setTipoDeArma(arma.getTipoDeArma());
		setTipoDeDano(arma.getTipoDeDano());
		setListaPropiedadesDelArma(arma.getListaPropiedadesDelArma());
		setTipoDeDano(arma.getTipoDeDano());
		setDadoDano(arma.getDadoDano());
	}

	public TipoCompetencia getCompetenciaEspecifica() {
		return competenciaEspecifica;
	}

	public void setCompetenciaEspecifica(TipoCompetencia competenciaEspecifica) {
		if (competenciaEspecifica == null) {
			throw new IllegalArgumentException(
					"La competencia específica del arma no puede ser nula. Sin embargo puede ser uno de los tipos generales.");
		} else {
			this.competenciaEspecifica = competenciaEspecifica;
		}

	}

	public TipoCompetencia getCompetenciaGeneral() {
		return competenciaGeneral;
	}

	private void setCompetenciaGeneral(TipoCompetencia competenciaGeneral) {
		if (competenciaGeneral == null) {
			throw new IllegalArgumentException(
					"La competencia general pasada es nula. El arma necesita una competencia para ser usada.");
		} else {
			this.competenciaGeneral = competenciaGeneral;
		}
	}

	public TipoArma getTipoDeArma() {
		return tipoDeArma;
	}

	private void setTipoDeArma(TipoArma tipoDeArma) {
		if (tipoDeArma == null) {
			throw new IllegalArgumentException(
					"El tipo de arma pasada no es válida. El arma necesita un tipo para ser usada.");
		} else {
			this.tipoDeArma = tipoDeArma;
		}
	}

	public TipoDano getTipoDeDano() {
		return tipoDeDano;
	}

	public void setTipoDeDano(TipoDano tipoDeDano) {
		this.tipoDeDano = tipoDeDano;
	}

	public List<PropiedadesArma> getListaPropiedadesDelArma() {
		return listaPropiedadesDelArma;
	}

	private void setListaPropiedadesDelArma(List<PropiedadesArma> listaPropiedadesDelArma) {
		if (listaPropiedadesDelArma == null) {
			this.listaPropiedadesDelArma = new ArrayList<>();
		} else if (listaPropiedadesDelArma.isEmpty()) {
			this.listaPropiedadesDelArma = new ArrayList<>();
		} else {
			this.listaPropiedadesDelArma = listaPropiedadesDelArma;
		}
	}

	public Tirada getDadoDano() {
		return dadoDano;
	}

	public void setDadoDano(Tirada dadoDano) {
		this.dadoDano = dadoDano;
	}

	public void equipar(Personaje pj) {
		// TODO equipar al personaje el arma si la tiene en el inventario
	}

	public Tirada atacar(Personaje pj, TipoTirada tirada) {
		// TODO hacer el ataque

		int bonificadorAtributo = pj.getCaracteristicas().buscar(Atributo.FUERZA).getModificador();
		// Comprobar si es sutil
		if (getListaPropiedadesDelArma().contains(PropiedadesArma.SUTIL)) {
			if (bonificadorAtributo < pj.getCaracteristicas().buscar(Atributo.DESTREZA).getModificador()) {
				bonificadorAtributo = pj.getCaracteristicas().buscar(Atributo.DESTREZA).getModificador();
			}
		//Si es a dos manos comprobar que la lleva a dos manos
		} else if(getListaPropiedadesDelArma().contains(PropiedadesArma.A_DOS_MANOS)) {
			if(!pj.getArmaIzquierda().equals(pj.getArmaDerecha())){
				throw new IllegalArgumentException("Se requiere que el personaje tenga equipada el arma a dos manos.");
			}
		//Si es pesada comprobar que no es pequeño
		} else if(getListaPropiedadesDelArma().contains(PropiedadesArma.PESADA)) {
			if(pj.getRazaPersonaje().getTamanoRaza().equals(TamanoRaza.PEQUENA)||pj.getRazaPersonaje().getTamanoRaza().equals(TamanoRaza.DIMINUTA)) {
				tirada = TipoTirada.DESVENTAJA;
			}
		}

		if ((pj.getCompetencias().buscar(competenciaEspecifica) == null)
				&& (pj.getCompetencias().buscar(competenciaGeneral) == null))

		{
			// Tirada sin ninguna competencia
		} else {
			// Tirada con competencia
			return new Tirada(new Dado(20), 1, bonificadorAtributo);
		}

	}

	public Tirada danoCausado(Personaje pj) {
		int bonificadorAtributo = pj.getCaracteristicas().buscar(Atributo.FUERZA).getModificador();
		Tirada tiradaDano = getDadoDano();
		// Comprobar si es sutil
		if (getListaPropiedadesDelArma().contains(PropiedadesArma.SUTIL)) {
			if (bonificadorAtributo < pj.getCaracteristicas().buscar(Atributo.DESTREZA).getModificador()) {
				bonificadorAtributo = pj.getCaracteristicas().buscar(Atributo.DESTREZA).getModificador();
			}
			// Comprobar si es versatil
		} else if (getListaPropiedadesDelArma().contains(PropiedadesArma.VERSATIL)) {
			if (pj.getArmaIzquierda().equals(pj.getArmaDerecha())) {
				tiradaDano = new Tirada(new Dado(getDadoDano().getDado().getCaras() + 2), getDadoDano().getNumeroVeces());
			} 
		}
		// TODO Todo atacar y poner que si es versatil en las hijas y en esta que coja
					// el mayor.
					return new Tirada(getDadoDano().getDado());
	}

}
