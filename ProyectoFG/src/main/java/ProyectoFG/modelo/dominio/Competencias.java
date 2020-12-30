package ProyectoFG.modelo.dominio;

import java.util.ArrayList;
import java.util.List;

import ProyectoFG.modelo.dominio.competencia.Competencia;
import ProyectoFG.modelo.dominio.competencia.TipoCompetencia;

public class Competencias {

	List<Competencia> listaCompetencias;

	public Competencias() {
		List<Competencia> lista = new ArrayList<>();
		lista.add(new Competencia(TipoCompetencia.ARMADURA_SENCILLA, false));
		lista.add(new Competencia(TipoCompetencia.ARMADURA_LIGERA, false));
		lista.add(new Competencia(TipoCompetencia.ARMADURA_MEDIA, false));
		lista.add(new Competencia(TipoCompetencia.ARMADURA_PESADA, false));
		lista.add(new Competencia(TipoCompetencia.ESCUDOS, false));
		lista.add(new Competencia(TipoCompetencia.ARMAS_SENCILLAS, false));
		lista.add(new Competencia(TipoCompetencia.ARMAS_MARCIALES, false));
		lista.add(new Competencia(TipoCompetencia.ESPADAS_CORTAS, false));
		lista.add(new Competencia(TipoCompetencia.ESPADAS_LARGAS, false));
		lista.add(new Competencia(TipoCompetencia.ESTOQUES, false));
		lista.add(new Competencia(TipoCompetencia.BASTONES, false));
		lista.add(new Competencia(TipoCompetencia.CIMITARRAS, false));
		lista.add(new Competencia(TipoCompetencia.DAGAS, false));
		lista.add(new Competencia(TipoCompetencia.DARDOS, false));
		lista.add(new Competencia(TipoCompetencia.GARROTES, false));
		lista.add(new Competencia(TipoCompetencia.HOCES, false));
		lista.add(new Competencia(TipoCompetencia.HONDAS, false));
		lista.add(new Competencia(TipoCompetencia.JABALINAS, false));
		lista.add(new Competencia(TipoCompetencia.LANZAS, false));
		lista.add(new Competencia(TipoCompetencia.MAZAS, false));
		lista.add(new Competencia(TipoCompetencia.BALLESTA_LIGERA, false));
		lista.add(new Competencia(TipoCompetencia.BALLESTAS_DE_MANO, false));
		setListaCompetencias(lista);
	}

	public Competencias(List<Competencia> listaCompetencias) {
		setListaCompetencias(copiarLista(listaCompetencias));
	}

	public List<Competencia> getListaCompetencias() {
		return listaCompetencias;
	}

	private void setListaCompetencias(List<Competencia> listaCompetencias) {
		this.listaCompetencias = listaCompetencias;
	}

	public Competencia buscar(TipoCompetencia competenciaBusqueda) {
		if(competenciaBusqueda==null) {
			throw new IllegalArgumentException("No se puede buscar una competencia nula.");
		} else if(!(getListaCompetencias().contains(new Competencia(competenciaBusqueda,false)))){
			throw new IllegalArgumentException("No se ha encontrado la competencia.");
		} else {
			return this.listaCompetencias.get(this.listaCompetencias.indexOf(new Competencia(competenciaBusqueda,false)));
		}
	}

	private List<Competencia> copiarLista(List<Competencia> listaCompetenciasCopiar) {
		if (listaCompetenciasCopiar == null) {
			return new ArrayList<Competencia>();
		} else if (listaCompetenciasCopiar.isEmpty()) {
			return new ArrayList<Competencia>();
		} else {
			ArrayList<Competencia> copiaLista = new ArrayList<Competencia>();
			for (Competencia competencia : listaCompetenciasCopiar) {
				copiaLista.add(new Competencia(competencia));
			}
			return copiaLista;
		}
	}
}
