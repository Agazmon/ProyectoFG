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
		// Comprobar si está equipada
		if (!(pj.getManoPrincipal().equals(this)) && !(pj.getManoSecundaria().equals(this))) {
			throw new IllegalArgumentException(
					"El arma no está equipada en la mano del personaje. Equípala primero para poder usarla.");
		} else {
			int bonificadorAtributo = pj.getCaracteristicas().buscar(Atributo.FUERZA).getModificador();
			int bonificadorCompetencia = pj.getModificadorCompetencia();
			Tirada dadoDano = getDadoDano();
			boolean ligeraOffHand = false;
			// Comprobar si es sutil
			if (getListaPropiedadesDelArma().contains(PropiedadesArma.SUTIL)) {
				if (bonificadorAtributo < pj.getCaracteristicas().buscar(Atributo.DESTREZA).getModificador()) {
					bonificadorAtributo = pj.getCaracteristicas().buscar(Atributo.DESTREZA).getModificador();
				}
				// Si es a dos manos comprobar que la lleva a dos manos
			}
			if (getListaPropiedadesDelArma().contains(PropiedadesArma.A_DOS_MANOS)) {
				if (pj.getManoPrincipal() == null || pj.getManoSecundaria() == null) {
					throw new IllegalArgumentException(
							"Se requiere que el personaje tenga equipada el arma a dos manos.");
				}
				if (!pj.getManoSecundaria().equals(pj.getManoPrincipal())) {
					throw new IllegalArgumentException(
							"Se requiere que el personaje tenga equipada el arma a dos manos.");
				}
				// Si es pesada comprobar que no es pequeño
			}
			if (getListaPropiedadesDelArma().contains(PropiedadesArma.PESADA)) {
				if (pj.getRazaPersonaje().getTamanoRaza().equals(TamanoRaza.PEQUENA)
						|| pj.getRazaPersonaje().getTamanoRaza().equals(TamanoRaza.DIMINUTA)) {
					if(tirada.equals(TipoTirada.VENTAJA)) tirada = TipoTirada.NEUTRA;
					else tirada = TipoTirada.DESVENTAJA;
				}
			}
			// Si es una lanza de caballería comprobar la distancia con el objetivo
			if (getListaPropiedadesDelArma().contains(PropiedadesArma.LANZA_CABALLERIA)) {
				// No hay forma actualmente de comprobar el objetivo de un ataque es posible que
				// se implemente en el futuro.
				// Comprobar que el personaje no esté en montura y si no lo está necesita usar
				// las dos manos para usarla.
				// Como no hay sistema de montura por ahora, se necesitan las dos manos siempre
				// para empuñarla
				// TODO sistema de montura y comprobar si esta en montura.
				if (!pj.getManoSecundaria().equals(pj.getManoPrincipal())) {
					throw new IllegalArgumentException(
							"Se requiere que el personaje tenga equipada el arma a dos manos.");
				}
			}
			if (getListaPropiedadesDelArma().contains(PropiedadesArma.GRAN_ALCANCE)) {
				// Comprobar si el objetivo esta a mas de 5 pies del límite por defecto de
				// cuerpo a cuerpo
				// Como no hay sistema de apuntado, por ahora no se hace nada.

			}
			if (getListaPropiedadesDelArma().contains(PropiedadesArma.LIGERA)) {
				//
				if (pj.getManoSecundaria().getListaPropiedadesDelArma().contains(PropiedadesArma.LIGERA)
						&& pj.getManoPrincipal().getListaPropiedadesDelArma().contains(PropiedadesArma.LIGERA)) {
					if (!pj.getManoSecundaria().equals(pj.getManoPrincipal())) {
						// comprobar si es el ataque offhandd
						if (this.equals(pj.getManoPrincipal())) {
							// El ataque es con la mano principal
							// TODO si se crea economía de acciones consumir acción normal.

						} else if (this.equals(pj.getManoSecundaria())) {
							// El ataque es con la mano secundaria
							// TODO si se crea economía de acciones consumir la acción adicional.
							ligeraOffHand = true;

						}
					} else {
						throw new IllegalArgumentException("Un arma ligera no se puede coger a dos manos");
					}
				}
			}

			// Ataque normal
			if ((pj.getCompetencias().buscar(competenciaEspecifica) == null)
					&& (pj.getCompetencias().buscar(competenciaGeneral) == null)) {
				// no competente
				return new Tirada(new Dado(20), 1, bonificadorAtributo, tirada);
			} else {
				// Competente
				return new Tirada(new Dado(20), 1, bonificadorAtributo + bonificadorCompetencia, tirada);
			}

		}

	}

	public Tirada danoCausado(Personaje pj) {
		int bonificadorAtributo = pj.getCaracteristicas().buscar(Atributo.FUERZA).getModificador();
		Tirada tiradaDano = getDadoDano();
		boolean ligeraOffHand = false;
		int bonificadorCompetencia = pj.getModificadorCompetencia();
		// Comprobar si es sutil
		if (getListaPropiedadesDelArma().contains(PropiedadesArma.SUTIL)) {
			if (bonificadorAtributo < pj.getCaracteristicas().buscar(Atributo.DESTREZA).getModificador()) {
				bonificadorAtributo = pj.getCaracteristicas().buscar(Atributo.DESTREZA).getModificador();
			}
			// Comprobar si es versatil
		} else if (getListaPropiedadesDelArma().contains(PropiedadesArma.VERSATIL)) {
			if (pj.getManoSecundaria().equals(pj.getManoPrincipal())) {
				tiradaDano = new Tirada(new Dado(getDadoDano().getDado().getCaras() + 2),
						getDadoDano().getNumeroVeces());
			}
		}
		if (getListaPropiedadesDelArma().contains(PropiedadesArma.LIGERA)) {
			//
			if (pj.getManoSecundaria().getListaPropiedadesDelArma().contains(PropiedadesArma.LIGERA)
					&& pj.getManoPrincipal().getListaPropiedadesDelArma().contains(PropiedadesArma.LIGERA)) {
				if (!pj.getManoSecundaria().equals(pj.getManoPrincipal())) {
					// comprobar si es el ataque offhandd
					if (this.equals(pj.getManoPrincipal())) {
						// El ataque es con la mano principal
						// TODO si se crea economía de acciones consumir acción normal.

					}
					if (pj.getManoSecundaria().equals(this)) {
						// El ataque es con la mano secundaria
						// TODO si se crea economía de acciones consumir la acción adicional.
						ligeraOffHand = true;
					}
				} else {
					throw new IllegalArgumentException("Un arma ligera no se puede coger a dos manos");
				}
			}
		}
		if (ligeraOffHand) {
			// Ataque offhand
			// tirada con el modificador de atributo solo si es negativo
			if (bonificadorAtributo < 0) {
				return new Tirada(new Dado(tiradaDano.getDado()), tiradaDano.getNumeroVeces(), bonificadorAtributo);
			} else {
				return new Tirada(new Dado(tiradaDano.getDado()), tiradaDano.getNumeroVeces());
			}
		} else {
			return new Tirada(new Dado(getDadoDano().getDado()), getDadoDano().getNumeroVeces(), bonificadorAtributo);

		}
	}

}
