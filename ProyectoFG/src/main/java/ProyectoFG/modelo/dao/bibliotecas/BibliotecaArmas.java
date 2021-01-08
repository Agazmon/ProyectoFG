package ProyectoFG.modelo.dao.bibliotecas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;

import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.TipoDano;
import ProyectoFG.modelo.dominio.arma.Arma;
import ProyectoFG.modelo.dominio.arma.ArmaArrojadiza;
import ProyectoFG.modelo.dominio.arma.ArmaDistancia;
import ProyectoFG.modelo.dominio.arma.PropiedadesArma;
import ProyectoFG.modelo.dominio.arma.TipoArma;
import ProyectoFG.modelo.dominio.arma.TipoMunicion;
import ProyectoFG.modelo.dominio.competencia.TipoCompetencia;
import ProyectoFG.modelo.dominio.moneda.Moneda;
import ProyectoFG.modelo.dominio.moneda.TipoMoneda;
import ProyectoFG.modelo.dominio.objeto.ObjetoInventario;
import ProyectoFG.modelo.dominio.tirada.Dado;
import ProyectoFG.modelo.dominio.tirada.Tirada;

public class BibliotecaArmas {
	static List<Arma> listaArmas;

	public BibliotecaArmas() {
		BibliotecaArmas.listaArmas = new ArrayList<>();
		// Cuerpo a cuerpo sencillas
		listaArmas.add(new Arma("Bastón", 4, 1, new Moneda(TipoMoneda.MONEDA_PLATA, 2), TipoCompetencia.BASTONES,
				TipoCompetencia.ARMAS_SENCILLAS, TipoArma.CUERPO_A_CUERPO, TipoDano.CONTUNDENTE,
				new ArrayList<>(Arrays.asList(PropiedadesArma.VERSATIL)), new Tirada(new Dado(6))));
		listaArmas.add(new ArmaArrojadiza("Daga", 1, 1, new Moneda(TipoMoneda.MONEDA_ORO, 2), TipoCompetencia.DAGAS,
				TipoCompetencia.ARMAS_SENCILLAS, TipoArma.CUERPO_A_CUERPO, TipoDano.PERFORANTE,
				new ArrayList<>(
						Arrays.asList(PropiedadesArma.ARROJADIZA, PropiedadesArma.LIGERA, PropiedadesArma.SUTIL)),
				20, 60, new Tirada(new Dado(4))));
		listaArmas.add(new Arma("Garrote", 2, 1, new Moneda(TipoMoneda.MONEDA_PLATA, 1), TipoCompetencia.GARROTES,
				TipoCompetencia.ARMAS_SENCILLAS, TipoArma.CUERPO_A_CUERPO, TipoDano.CONTUNDENTE,
				new ArrayList<>(Arrays.asList(PropiedadesArma.LIGERA)), new Tirada(new Dado(4))));
		listaArmas
				.add(new Arma("Garrote Grande", 10, 1, new Moneda(TipoMoneda.MONEDA_PLATA, 2), TipoCompetencia.GARROTES,
						TipoCompetencia.ARMAS_SENCILLAS, TipoArma.CUERPO_A_CUERPO, TipoDano.CONTUNDENTE,
						new ArrayList<>(Arrays.asList(PropiedadesArma.A_DOS_MANOS)), new Tirada(new Dado(8))));
		listaArmas.add(new ArmaArrojadiza("Hacha de mano", 2, 1, new Moneda(TipoMoneda.MONEDA_ORO, 5),
				TipoCompetencia.HACHAS, TipoCompetencia.ARMAS_SENCILLAS, TipoArma.CUERPO_A_CUERPO, TipoDano.CORTANTE,
				new ArrayList<>(Arrays.asList(PropiedadesArma.ARROJADIZA, PropiedadesArma.ALCANCE)), 20, 60,
				new Tirada(new Dado(6))));
		listaArmas.add(new Arma("Hoz", 2, 1, new Moneda(TipoMoneda.MONEDA_ORO, 1), TipoCompetencia.HOCES,
				TipoCompetencia.ARMAS_SENCILLAS, TipoArma.CUERPO_A_CUERPO, TipoDano.CORTANTE,
				new ArrayList<>(Arrays.asList(PropiedadesArma.LIGERA)), new Tirada(new Dado(4))));
		listaArmas.add(
				new ArmaArrojadiza("Jabalina", 2, 1, new Moneda(TipoMoneda.MONEDA_PLATA, 5), TipoCompetencia.JABALINAS,
						TipoCompetencia.ARMAS_SENCILLAS, TipoArma.CUERPO_A_CUERPO, TipoDano.PERFORANTE,
						new ArrayList<>(Arrays.asList(PropiedadesArma.ARROJADIZA)), 30, 120, new Tirada(new Dado(6))));
		listaArmas.add(new ArmaArrojadiza("Lanza", 3, 1, new Moneda(TipoMoneda.MONEDA_ORO, 1), TipoCompetencia.LANZAS,
				TipoCompetencia.ARMAS_SENCILLAS, TipoArma.CUERPO_A_CUERPO, TipoDano.PERFORANTE,
				new ArrayList<>(Arrays.asList(PropiedadesArma.ARROJADIZA, PropiedadesArma.VERSATIL)), 20, 60,
				new Tirada(new Dado(6))));
		listaArmas.add(new ArmaArrojadiza("Martillo ligero", 2, 1, new Moneda(TipoMoneda.MONEDA_ORO, 2),
				TipoCompetencia.MARTILLOS, TipoCompetencia.ARMAS_SENCILLAS, TipoArma.CUERPO_A_CUERPO,
				TipoDano.CONTUNDENTE,
				new ArrayList<>(Arrays.asList(PropiedadesArma.ARROJADIZA, PropiedadesArma.LIGERA)), 20, 60,
				new Tirada(new Dado(4))));
		listaArmas.add(new Arma("Maza", 4, 1, new Moneda(TipoMoneda.MONEDA_ORO, 5), TipoCompetencia.MAZAS,
				TipoCompetencia.ARMAS_SENCILLAS, TipoArma.CUERPO_A_CUERPO, TipoDano.CONTUNDENTE, null,
				new Tirada(new Dado(6))));
		// Distancia sencillas
		listaArmas.add(new ArmaDistancia("Arco corto", 2, 1, new Moneda(TipoMoneda.MONEDA_ORO, 25),
				TipoCompetencia.ARCOS, TipoCompetencia.ARMAS_SENCILLAS, TipoArma.A_DISTANCIA, TipoDano.PERFORANTE,
				new ArrayList<>(Arrays.asList(PropiedadesArma.A_DOS_MANOS, PropiedadesArma.MUNICION)),
				new Tirada(new Dado(6)), TipoMunicion.FLECHA, 80, 320, false));
		listaArmas.add(new ArmaDistancia("Ballesta ligera", 5, 1, new Moneda(TipoMoneda.MONEDA_ORO, 25),
				TipoCompetencia.BALLESTA_LIGERA, TipoCompetencia.ARMAS_SENCILLAS, TipoArma.A_DISTANCIA,
				TipoDano.PERFORANTE,
				new ArrayList<>(
						Arrays.asList(PropiedadesArma.A_DOS_MANOS, PropiedadesArma.MUNICION, PropiedadesArma.RECARGA)),
				new Tirada(new Dado(8)), TipoMunicion.VIROTE, 80, 320, false));
		listaArmas.add(new ArmaDistancia("Dardo", 1 / 4, 1, new Moneda(TipoMoneda.MONEDA_COBRE, 5),
				TipoCompetencia.DARDOS, TipoCompetencia.ARMAS_SENCILLAS, TipoArma.A_DISTANCIA, TipoDano.PERFORANTE,
				new ArrayList<>(Arrays.asList(PropiedadesArma.ARROJADIZA, PropiedadesArma.SUTIL)),
				new Tirada(new Dado(4)), TipoMunicion.DARDO, 20, 60, true));
		listaArmas.add(new ArmaDistancia("Honda", 0, 1, new Moneda(TipoMoneda.MONEDA_PLATA, 1), TipoCompetencia.HONDAS,
				TipoCompetencia.ARMAS_SENCILLAS, TipoArma.A_DISTANCIA, TipoDano.CONTUNDENTE,
				new ArrayList<>(Arrays.asList(PropiedadesArma.MUNICION)), new Tirada(new Dado(4)), TipoMunicion.PIEDRA,
				30, 120, false));
		// Cuerpo a cuerpo marciales
		listaArmas.add(new Arma("Alabarda", 6, 1, new Moneda(TipoMoneda.MONEDA_ORO, 20), TipoCompetencia.ARMAS_DE_ASTA,
				TipoCompetencia.ARMAS_MARCIALES, TipoArma.CUERPO_A_CUERPO, TipoDano.CORTANTE, new ArrayList<>(Arrays
						.asList(PropiedadesArma.A_DOS_MANOS, PropiedadesArma.GRAN_ALCANCE, PropiedadesArma.PESADA)),
				new Tirada(new Dado(10))));
		listaArmas.add(new Arma("Cimitarra", 3, 1, new Moneda(TipoMoneda.MONEDA_ORO, 25), TipoCompetencia.CIMITARRAS,
				TipoCompetencia.ARMAS_MARCIALES, TipoArma.CUERPO_A_CUERPO, TipoDano.CORTANTE,
				new ArrayList<>(Arrays.asList(PropiedadesArma.LIGERA, PropiedadesArma.SUTIL)),
				new Tirada(new Dado(6))));
		listaArmas.add(new Arma("Espada corta", 2, 1, new Moneda(TipoMoneda.MONEDA_ORO, 10),
				TipoCompetencia.ESPADAS_CORTAS, TipoCompetencia.ARMAS_MARCIALES, TipoArma.CUERPO_A_CUERPO,
				TipoDano.PERFORANTE, new ArrayList<>(Arrays.asList(PropiedadesArma.LIGERA, PropiedadesArma.SUTIL)),
				new Tirada(new Dado(6))));
		listaArmas.add(new Arma("Espada larga", 3, 1, new Moneda(TipoMoneda.MONEDA_ORO, 15),
				TipoCompetencia.ESPADAS_LARGAS, TipoCompetencia.ARMAS_MARCIALES, TipoArma.CUERPO_A_CUERPO,
				TipoDano.CORTANTE, new ArrayList<>(Arrays.asList(PropiedadesArma.VERSATIL)), new Tirada(new Dado(8))));
		listaArmas.add(new Arma("Espadón", 6, 1, new Moneda(TipoMoneda.MONEDA_ORO, 50), TipoCompetencia.ESPADONES,
				TipoCompetencia.ARMAS_MARCIALES, TipoArma.CUERPO_A_CUERPO, TipoDano.CORTANTE,
				new ArrayList<>(Arrays.asList(PropiedadesArma.A_DOS_MANOS, PropiedadesArma.PESADA)),
				new Tirada(new Dado(10), 2)));
		listaArmas.add(new Arma("Estoque", 2, 1, new Moneda(TipoMoneda.MONEDA_ORO, 25), TipoCompetencia.ESTOQUES,
				TipoCompetencia.ARMAS_MARCIALES, TipoArma.CUERPO_A_CUERPO, TipoDano.PERFORANTE,
				new ArrayList<>(Arrays.asList(PropiedadesArma.SUTIL)), new Tirada(new Dado(8))));
		listaArmas.add(new Arma("Flagelo", 2, 1, new Moneda(TipoMoneda.MONEDA_ORO, 10), TipoCompetencia.LATIGOS,
				TipoCompetencia.ARMAS_MARCIALES, TipoArma.CUERPO_A_CUERPO, TipoDano.CONTUNDENTE, null,
				new Tirada(new Dado(8))));
		listaArmas.add(new Arma("Guja", 6, 1, new Moneda(TipoMoneda.MONEDA_ORO, 20), TipoCompetencia.ARMAS_DE_ASTA,
				TipoCompetencia.ARMAS_MARCIALES, TipoArma.CUERPO_A_CUERPO, TipoDano.CORTANTE, new ArrayList<>(Arrays
						.asList(PropiedadesArma.A_DOS_MANOS, PropiedadesArma.GRAN_ALCANCE, PropiedadesArma.PESADA)),
				new Tirada(new Dado(10))));
		listaArmas.add(new Arma("Hacha a dos manos", 7, 1, new Moneda(TipoMoneda.MONEDA_ORO, 30),
				TipoCompetencia.HACHAS, TipoCompetencia.ARMAS_MARCIALES, TipoArma.CUERPO_A_CUERPO, TipoDano.CORTANTE,
				new ArrayList<>(Arrays.asList(PropiedadesArma.A_DOS_MANOS, PropiedadesArma.PESADA)),
				new Tirada(new Dado(12))));
		listaArmas.add(new Arma("Hacha de guerra", 4, 1, new Moneda(TipoMoneda.MONEDA_ORO, 10), TipoCompetencia.HACHAS,
				TipoCompetencia.ARMAS_MARCIALES, TipoArma.CUERPO_A_CUERPO, TipoDano.CORTANTE,
				new ArrayList<>(Arrays.asList(PropiedadesArma.VERSATIL)), new Tirada(new Dado(8))));
		listaArmas.add(new Arma("Lanza de caballeria", 6, 1, new Moneda(TipoMoneda.MONEDA_ORO, 10),
				TipoCompetencia.LANZAS, TipoCompetencia.ARMAS_MARCIALES, TipoArma.CUERPO_A_CUERPO, TipoDano.PERFORANTE,
				new ArrayList<>(Arrays.asList(PropiedadesArma.GRAN_ALCANCE, PropiedadesArma.LANZA_CABALLERIA)),
				new Tirada(new Dado(12))));
		listaArmas.add(new Arma("Látigo", 3, 1, new Moneda(TipoMoneda.MONEDA_ORO, 2), TipoCompetencia.LATIGOS,
				TipoCompetencia.ARMAS_MARCIALES, TipoArma.CUERPO_A_CUERPO, TipoDano.CORTANTE,
				new ArrayList<>(Arrays.asList(PropiedadesArma.GRAN_ALCANCE, PropiedadesArma.SUTIL)),
				new Tirada(new Dado(4))));
		listaArmas.add(new Arma("Lucero del alba", 4, 1, new Moneda(TipoMoneda.MONEDA_ORO, 15), TipoCompetencia.MAZAS,
				TipoCompetencia.ARMAS_MARCIALES, TipoArma.CUERPO_A_CUERPO, TipoDano.PERFORANTE, null,
				new Tirada(new Dado(8))));
		listaArmas.add(
				new Arma("Martillo de guerra", 2, 1, new Moneda(TipoMoneda.MONEDA_ORO, 15), TipoCompetencia.MARTILLOS,
						TipoCompetencia.ARMAS_MARCIALES, TipoArma.CUERPO_A_CUERPO, TipoDano.CONTUNDENTE,
						new ArrayList<>(Arrays.asList(PropiedadesArma.VERSATIL)), new Tirada(new Dado(8))));
		listaArmas.add(new Arma("Maza a dos manos", 10, 1, new Moneda(TipoMoneda.MONEDA_ORO, 10), TipoCompetencia.MAZAS,
				TipoCompetencia.ARMAS_MARCIALES, TipoArma.CUERPO_A_CUERPO, TipoDano.CONTUNDENTE,
				new ArrayList<>(Arrays.asList(PropiedadesArma.A_DOS_MANOS, PropiedadesArma.PESADA)),
				new Tirada(new Dado(6), 2)));
		listaArmas.add(new Arma("Pica", 18, 1, new Moneda(TipoMoneda.MONEDA_ORO, 5), TipoCompetencia.ARMAS_DE_ASTA,
				TipoCompetencia.ARMAS_MARCIALES, TipoArma.CUERPO_A_CUERPO, TipoDano.PERFORANTE, new ArrayList<>(Arrays
						.asList(PropiedadesArma.A_DOS_MANOS, PropiedadesArma.GRAN_ALCANCE, PropiedadesArma.PESADA)),
				new Tirada(new Dado(10))));
		listaArmas.add(new Arma("Pico de guerra", 2, 1, new Moneda(TipoMoneda.MONEDA_ORO, 5), TipoCompetencia.PICOS,
				TipoCompetencia.ARMAS_MARCIALES, TipoArma.CUERPO_A_CUERPO, TipoDano.PERFORANTE, null,
				new Tirada(new Dado(8))));
		listaArmas.add(
				new ArmaArrojadiza("Tridente", 4, 1, new Moneda(TipoMoneda.MONEDA_ORO, 5), TipoCompetencia.TRIDENTES,
						TipoCompetencia.ARMAS_MARCIALES, TipoArma.CUERPO_A_CUERPO, TipoDano.PERFORANTE,
						new ArrayList<>(Arrays.asList(PropiedadesArma.ARROJADIZA, PropiedadesArma.VERSATIL)), 20, 60,
						new Tirada(new Dado(6))));
		// A distancia marciales
		listaArmas.add(new ArmaDistancia("Arco largo", 2, 1, new Moneda(TipoMoneda.MONEDA_ORO, 50),
				TipoCompetencia.ARCOS, TipoCompetencia.ARMAS_MARCIALES, TipoArma.A_DISTANCIA, TipoDano.PERFORANTE,
				new ArrayList<>(Arrays.asList(PropiedadesArma.A_DOS_MANOS, PropiedadesArma.MUNICION,
						PropiedadesArma.ALCANCE, PropiedadesArma.PESADA)),
				new Tirada(new Dado(8)), TipoMunicion.FLECHA, 150, 600, false));
		listaArmas.add(new ArmaDistancia("Ballesta de mano", 3, 1, new Moneda(TipoMoneda.MONEDA_ORO, 75),
				TipoCompetencia.BALLESTAS_DE_MANO, TipoCompetencia.ARMAS_MARCIALES, TipoArma.A_DISTANCIA,
				TipoDano.PERFORANTE,
				new ArrayList<>(Arrays.asList(PropiedadesArma.LIGERA, PropiedadesArma.MUNICION, PropiedadesArma.ALCANCE,
						PropiedadesArma.PESADA, PropiedadesArma.RECARGA)),
				new Tirada(new Dado(6)), TipoMunicion.VIROTE, 150, 600, false));
		listaArmas.add(new ArmaDistancia("Ballesta pesada", 18, 1, new Moneda(TipoMoneda.MONEDA_ORO, 50),
				TipoCompetencia.BALLESTA_PESADA, TipoCompetencia.ARMAS_MARCIALES, TipoArma.A_DISTANCIA,
				TipoDano.PERFORANTE,
				new ArrayList<>(Arrays.asList(PropiedadesArma.A_DOS_MANOS, PropiedadesArma.MUNICION,
						PropiedadesArma.ALCANCE, PropiedadesArma.PESADA, PropiedadesArma.RECARGA)),
				new Tirada(new Dado(10)), TipoMunicion.VIROTE_PESADO, 100, 400, false));
		listaArmas.add(new ArmaDistancia("Cerbatana", 1, 1, new Moneda(TipoMoneda.MONEDA_ORO, 10),
				TipoCompetencia.DARDOS, TipoCompetencia.ARMAS_MARCIALES, TipoArma.A_DISTANCIA, TipoDano.PERFORANTE,
				new ArrayList<>(
						Arrays.asList(PropiedadesArma.MUNICION, PropiedadesArma.ALCANCE, PropiedadesArma.RECARGA)),
				new Tirada(new Dado(1)), TipoMunicion.DARDO, 25, 100, false));
		listaArmas.add(new ArmaArrojadiza("Red", 3, 1, new Moneda(TipoMoneda.MONEDA_ORO, 1), TipoCompetencia.REDES,
				TipoCompetencia.ARMAS_MARCIALES, TipoArma.A_DISTANCIA, TipoDano.NINGUNO,
				new ArrayList<>(Arrays.asList(PropiedadesArma.ARROJADIZA, PropiedadesArma.RED)), 5, 15,
				new Tirada(new Dado(1))));
	}

	public BibliotecaArmas(BibliotecaArmas bibliotecaCopia) {
		setListaArmas(getListaArmas());
	}

	public static Arma buscarArma(String nombre) {
		if (nombre == null) {
			throw new IllegalArgumentException("No se puede buscar una arma por un nombre nulo.");
		} else if (nombre.isBlank()) {
			throw new IllegalArgumentException("No se puede buscar una arma por un nombre vacío.");
		} else {
			int indice = -1;
			for (Arma arma : listaArmas) {
				if(arma.getNombre().equals(nombre)) {
					indice = listaArmas.indexOf(arma);
					break;
				}
			}
			if (indice != -1) {
				if (listaArmas.get(indice) instanceof Arma) {
					return (Arma) listaArmas.get(indice);
				} else {
					return null;
				}
			} else {
				return null;
			}

		}
	}
	public void comprarArma(String nombre, Personaje pj) {
		if (nombre == null) {
			throw new IllegalArgumentException("No se puede buscar una arma por un nombre nulo.");
		} else if (nombre.isBlank()) {
			throw new IllegalArgumentException("No se puede buscar una arma por un nombre vacío.");
		} else {
			if(buscarArma(nombre)!=null){
				Arma armaEncontrada = buscarArma(nombre);
				//TODO cobrar el precio del arma
				 if(armaEncontrada instanceof ArmaArrojadiza) {
						pj.getInventarioPersonaje().anadirObjeto(new ArmaArrojadiza((ArmaArrojadiza) armaEncontrada));
					} else if(armaEncontrada instanceof ArmaDistancia) {
						pj.getInventarioPersonaje().anadirObjeto(new ArmaDistancia((ArmaDistancia) armaEncontrada));
					} else if(armaEncontrada instanceof Arma){
						pj.getInventarioPersonaje().anadirObjeto(new Arma(armaEncontrada));
					}
				
			} else {
				throw new IllegalArgumentException("No se ha encontrado el arma para comprar por lo que no se ha comprado");
			}
			
		}
	}

	public List<Arma> getListaArmas() {
		return listaArmas;
	}

	private void setListaArmas(List<Arma> listaArmas) {
		this.listaArmas = listaArmas;
	}

	@Override
	public String toString() {
		return "BibliotecaArmas [listaArmas=" + listaArmas + ", toString()=" + super.toString() + "]";
	}

}
