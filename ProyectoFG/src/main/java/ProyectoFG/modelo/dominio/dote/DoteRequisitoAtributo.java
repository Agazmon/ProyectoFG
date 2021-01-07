package ProyectoFG.modelo.dominio.dote;

import java.util.Arrays;
import java.util.List;

import ProyectoFG.modelo.dominio.Atributo;
import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.clase.TipoClase;
import ProyectoFG.modelo.dominio.competencia.TipoCompetencia;
import ProyectoFG.modelo.dominio.hechizo.NivelHechizo;
import ProyectoFG.modelo.dominio.moneda.Moneda;
import ProyectoFG.modelo.dominio.moneda.TipoMoneda;
import ProyectoFG.modelo.dominio.objeto.LibroHechizos;
import ProyectoFG.modelo.dominio.objeto.ObjetoInventario;
import ProyectoFG.modelo.dominio.objeto.TipoLibro;

public class DoteRequisitoAtributo extends Dote {

	private List<Atributo> atributoRequisito;

	public DoteRequisitoAtributo(TipoDote tipoDote, String descripcion, List<Atributo> atributosRequisito) {
		super(tipoDote, descripcion);
		setAtributoRequisito(atributosRequisito);
	}

	public DoteRequisitoAtributo(TipoDote tipoDote, String descripcion, Atributo atributoRequisito) {
		super(tipoDote, descripcion);
		setAtributoRequisito(Arrays.asList(atributoRequisito));
	}

	public DoteRequisitoAtributo(DoteRequisitoAtributo dote) {
		super(dote.getTipoDote(), dote.getDescripcion());
		setAtributoRequisito(dote.getAtributoRequisito());
	}

	public List<Atributo> getAtributoRequisito() {
		return atributoRequisito;
	}

	private void setAtributoRequisito(List<Atributo> atributoRequisito) {
		if (atributoRequisito == null) {
			throw new IllegalArgumentException(
					"El atributo de una dote no puede ser nulo. Para ello existen las dotes sin requisito.");
		} else {
			this.atributoRequisito = atributoRequisito;
		}

	}

	@Override
	public void anadirDote(Personaje pj) {
		if (comprobarRequisito(pj)) {
			aplicarDote(pj);
		}
	}

	@Override
	protected void aplicarDote(Personaje pj) {
		switch (getTipoDote()) {
		case LANZADOR_RITUAL_BARDO:
			pj.getCompetencias().buscar(TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS).setCompetente(true);
			pj.getInventarioPersonaje().anadirObjeto(new LibroHechizos("Libro de hechizos", 3, 1,
					new Moneda(TipoMoneda.MONEDA_COBRE, 0), TipoLibro.LANZADOR_RITUAL, TipoClase.BARDO));
			break;
		case LANZADOR_RITUAL_BRUJO:
			pj.getCompetencias().buscar(TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS).setCompetente(true);
			pj.getInventarioPersonaje().anadirObjeto(new LibroHechizos("Libro de hechizos", 3, 1,
					new Moneda(TipoMoneda.MONEDA_COBRE, 0), TipoLibro.LANZADOR_RITUAL, TipoClase.BRUJO));
			break;
		case LANZADOR_RITUAL_CLERIGO:
			pj.getCompetencias().buscar(TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS).setCompetente(true);
			pj.getInventarioPersonaje().anadirObjeto(new LibroHechizos("Libro de hechizos", 3, 1,
					new Moneda(TipoMoneda.MONEDA_COBRE, 0), TipoLibro.LANZADOR_RITUAL, TipoClase.CLERIGO));
			break;
		case LANZADOR_RITUAL_DRUIDA:
			pj.getCompetencias().buscar(TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS).setCompetente(true);
			pj.getInventarioPersonaje().anadirObjeto(new LibroHechizos("Libro de hechizos", 3, 1,
					new Moneda(TipoMoneda.MONEDA_COBRE, 0), TipoLibro.LANZADOR_RITUAL, TipoClase.DRUIDA));
			break;
		case LANZADOR_RITUAL_HECHICERO:
			pj.getCompetencias().buscar(TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS).setCompetente(true);
			pj.getInventarioPersonaje().anadirObjeto(new LibroHechizos("Libro de hechizos", 3, 1,
					new Moneda(TipoMoneda.MONEDA_COBRE, 0), TipoLibro.LANZADOR_RITUAL, TipoClase.HECHICERO));
			break;
		case LANZADOR_RITUAL_MAGO:
			pj.getCompetencias().buscar(TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS).setCompetente(true);
			LibroHechizos libro = new LibroHechizos("Libro de hechizos", 3, 1, new Moneda(TipoMoneda.MONEDA_COBRE, 0),
					TipoLibro.LANZADOR_RITUAL, TipoClase.MAGO);
			libro.aumentarMaximoHechizos(NivelHechizo.NIVEL_1, 2);
			pj.getInventarioPersonaje().anadirObjeto(libro);
			break;
		// Dotes con requisito de atributo con solo texto
		case ACECHADOR:
		case APRESADOR:
		case DUELISTA_DEFENSIVO:
		case LIDER_INSPIRADOR:
		default:
			pj.getDotes().anadir(new DoteRequisitoAtributo(this));
			break;
		}
	}

	public boolean comprobarRequisito(Personaje pj) {
		boolean atributoCumple = false;
		for (Atributo atributo : getAtributoRequisito()) {
			if (pj.getCaracteristicas().buscar(atributo).getPuntuacion() >= 13) {
				atributoCumple = true;
			}
		}
		if (!atributoCumple) {
			throw new IllegalArgumentException(
					"El personaje no cumple el requisito de atributo mínimo, debe tener 13 como mínimo en uno de los siguientes atributos: "
							+ getAtributoRequisito().toString());
		} else {

			if (pj.getDotes().buscar(this) != null) {
				throw new IllegalArgumentException(
						"El personaje ya tiene esta dote en su lista de dotes, no puede volver a ser cogida.");
			} else {
				if (getTipoDote() == TipoDote.LANZADOR_RITUAL_BARDO || getTipoDote() == TipoDote.LANZADOR_RITUAL_BRUJO
						|| getTipoDote() == TipoDote.LANZADOR_RITUAL_CLERIGO
						|| getTipoDote() == TipoDote.LANZADOR_RITUAL_DRUIDA
						|| getTipoDote() == TipoDote.LANZADOR_RITUAL_HECHICERO
						|| getTipoDote() == TipoDote.LANZADOR_RITUAL_MAGO) {
					if (pj.getDotes().buscar(TipoDote.LANZADOR_RITUAL_BARDO) != null
							|| pj.getDotes().buscar(TipoDote.LANZADOR_RITUAL_BRUJO) != null
							|| pj.getDotes().buscar(TipoDote.LANZADOR_RITUAL_CLERIGO) != null
							|| pj.getDotes().buscar(TipoDote.LANZADOR_RITUAL_DRUIDA) != null
							|| pj.getDotes().buscar(TipoDote.LANZADOR_RITUAL_HECHICERO) != null
							|| pj.getDotes().buscar(TipoDote.LANZADOR_RITUAL_MAGO) != null) {
						throw new IllegalArgumentException(
								"El personaje ya tiene en sus dotes una de Lanzador Ritual, no se puede escoger otra vez");
					} else {
						return true;
					}
				} else {
					return true;
				}
			}
		}
	}

}
