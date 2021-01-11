package ProyectoFG.modelo.dominio.hechizo;

import java.util.Objects;
import ProyectoFG.modelo.dominio.Personaje;

public class Hechizo {
	int idHechizo;
	private String nombreHechizo;
	private TipoEscuelaMagia escuela;
	private NivelHechizo nivelBaseHechizo;
	private NivelHechizo puedeRitual;
	String tiempoLanzamiento;
	int alcanceEnPies;
	String duracionHechizo;
	String descripcion;
	boolean componenteVerbal;
	boolean componenteSomatico;
	Material componenteMaterial;
	String aNivelesSuperiores;
	boolean concentracion;

	public Hechizo(int idHechizo, String nombreHechizo, TipoEscuelaMagia escuela, NivelHechizo nivelBaseHechizo,
			NivelHechizo puedeRitual, String tiempoLanzamiento, int alcanceEnPies, String duracionHechizo,
			String descripcion, boolean componenteVerbal, boolean componenteSomatico, Material componenteMaterial) {
		setIdHechizo(idHechizo);
		setNombreHechizo(nombreHechizo);
		setEscuela(escuela);
		setNivelBaseConjuro(nivelBaseHechizo);
		setPuedeRitual(puedeRitual);
		setTiempoLanzamiento(tiempoLanzamiento);
		setAlcanceEnPies(alcanceEnPies);
		setDuracionHechizo(duracionHechizo);
		setDescripcion(descripcion);
		setComponenteVerbal(componenteVerbal);
		setComponenteSomatico(componenteSomatico);

		setComponenteMaterial(componenteMaterial);

		setANivelesSuperiores(null);
		setConcentracion(false);
	}

	public Hechizo(int idHechizo, String nombreHechizo, TipoEscuelaMagia escuela, NivelHechizo nivelBaseHechizo,
			NivelHechizo puedeRitual, String tiempoLanzamiento, int alcanceEnPies, String duracionHechizo,
			String descripcion, boolean componenteVerbal, boolean componenteSomatico, Material componenteMaterial,
			String aNivelesSuperiores) {
		setIdHechizo(idHechizo);
		setNombreHechizo(nombreHechizo);
		setEscuela(escuela);
		setNivelBaseConjuro(nivelBaseHechizo);
		setPuedeRitual(puedeRitual);
		setTiempoLanzamiento(tiempoLanzamiento);
		setAlcanceEnPies(alcanceEnPies);
		setDuracionHechizo(duracionHechizo);
		setDescripcion(descripcion);
		setComponenteVerbal(componenteVerbal);
		setComponenteSomatico(componenteSomatico);
		setComponenteMaterial(componenteMaterial);
		setANivelesSuperiores(aNivelesSuperiores);
		setConcentracion(false);
	}

	public Hechizo(int idHechizo, String nombreHechizo, TipoEscuelaMagia escuela, NivelHechizo nivelBaseHechizo,
			NivelHechizo puedeRitual, String tiempoLanzamiento, int alcanceEnPies, boolean concentracion,
			String duracionHechizo, String descripcion, boolean componenteVerbal, boolean componenteSomatico,
			Material componenteMaterial) {
		setIdHechizo(idHechizo);
		setNombreHechizo(nombreHechizo);
		setEscuela(escuela);
		setNivelBaseConjuro(nivelBaseHechizo);
		setPuedeRitual(puedeRitual);
		setTiempoLanzamiento(tiempoLanzamiento);
		setAlcanceEnPies(alcanceEnPies);
		setDuracionHechizo(duracionHechizo);
		setDescripcion(descripcion);
		setComponenteVerbal(componenteVerbal);
		setComponenteSomatico(componenteSomatico);
		setComponenteMaterial(componenteMaterial);
		setANivelesSuperiores(null);
		setConcentracion(concentracion);
	}

	public Hechizo(int idHechizo, String nombreHechizo, TipoEscuelaMagia escuela, NivelHechizo nivelBaseHechizo,
			NivelHechizo puedeRitual, String tiempoLanzamiento, int alcanceEnPies, boolean concentracion,
			String duracionHechizo, String descripcion, boolean componenteVerbal, boolean componenteSomatico,
			Material componenteMaterial, String aNivelesSuperiores) {
		setIdHechizo(idHechizo);
		setNombreHechizo(nombreHechizo);
		setEscuela(escuela);
		setNivelBaseConjuro(nivelBaseHechizo);
		setPuedeRitual(puedeRitual);
		setTiempoLanzamiento(tiempoLanzamiento);
		setAlcanceEnPies(alcanceEnPies);
		setDuracionHechizo(duracionHechizo);
		setDescripcion(descripcion);
		setComponenteVerbal(componenteVerbal);
		setComponenteSomatico(componenteSomatico);
		setComponenteMaterial(componenteMaterial);
		setANivelesSuperiores(aNivelesSuperiores);
		setConcentracion(concentracion);
	}

	public Hechizo(Hechizo hechizo) {
		setIdHechizo(hechizo.getIdHechizo());
		setNombreHechizo(hechizo.getNombreHechizo());
		setEscuela(hechizo.getEscuela());
		setNivelBaseConjuro(hechizo.getNivelBaseHechizo());
		setPuedeRitual(hechizo.getPuedeRitual());
		setTiempoLanzamiento(hechizo.getTiempoLanzamiento());
		setAlcanceEnPies(hechizo.getAlcanceEnPies());
		setDuracionHechizo(hechizo.getDuracionHechizo());
		setDescripcion(hechizo.getDescripcion());
		setComponenteVerbal(hechizo.isComponenteVerbal());
		setComponenteSomatico(hechizo.isComponenteSomatico());
		setComponenteMaterial(hechizo.getComponenteMaterial());
		setANivelesSuperiores(hechizo.getANivelesSuperiores());
		setConcentracion(hechizo.isConcentracion());

	}

	public int getIdHechizo() {
		return this.idHechizo;
	}

	private void setIdHechizo(int idHechizo) {
		if (idHechizo <= 0) {
			throw new IllegalArgumentException("La id de un hechizo no puede ser menor o igual a 0, como mínimo 1");
		} else {
			this.idHechizo = idHechizo;
		}
	}

	public String getNombreHechizo() {
		return nombreHechizo;
	}

	public void setNombreHechizo(String nombreHechizo) {
		if (nombreHechizo == null) {
			throw new IllegalArgumentException("El nombre de un hechizo no puede ser nulo.");
		} else if (nombreHechizo.isBlank()) {
			throw new IllegalArgumentException("El nombre de un hechizo no puede estar vacío.");
		} else {
			this.nombreHechizo = nombreHechizo;
		}

	}

	public TipoEscuelaMagia getEscuela() {
		return escuela;
	}

	public void setEscuela(TipoEscuelaMagia escuela) {
		if (escuela == null) {
			throw new IllegalArgumentException("La escuela de magia de un hechizo no puede ser nula.");
		} else {
			this.escuela = escuela;
		}
	}

	public NivelHechizo getNivelBaseHechizo() {
		return nivelBaseHechizo;
	}

	public void setNivelBaseConjuro(NivelHechizo nivelBaseHechizo) {
		if (nivelBaseHechizo.equals(NivelHechizo.RITUAL) || nivelBaseHechizo.equals(NivelHechizo.NO_RITUAL)) {
			throw new IllegalArgumentException(
					"Un hechizo no puede ser de base un ritual, debe tener un nivel de hechizo mínimo.");
		} else {
			this.nivelBaseHechizo = nivelBaseHechizo;
		}
	}

	public NivelHechizo getPuedeRitual() {
		return puedeRitual;
	}

	public void setPuedeRitual(NivelHechizo puedeRitual) {
		if (puedeRitual == null) {
			throw new IllegalArgumentException(
					"Un hechizo no puede tener un nulo como opción de lanzamiento como ritual.");
		} else {
			if (puedeRitual.equals(NivelHechizo.RITUAL) || puedeRitual.equals(NivelHechizo.NO_RITUAL)) {
				this.puedeRitual = puedeRitual;
			} else {
				throw new IllegalArgumentException(
						"El ritual puede o no puede ser, no puede ser un nivel de hechizo común.");
			}

		}

	}

	public String getTiempoLanzamiento() {
		return tiempoLanzamiento;
	}

	public void setTiempoLanzamiento(String tiempoLanzamiento) {
		if (tiempoLanzamiento == null) {
			throw new IllegalArgumentException("El tiempo de lanzamiento de un conjuro no puede ser nulo.");
		} else if (tiempoLanzamiento.isBlank()) {
			throw new IllegalArgumentException("El tiempo de lanzamiento de un conjuro no puede estar vacío.");
		} else {
			this.tiempoLanzamiento = tiempoLanzamiento;
		}
	}

	public int getAlcanceEnPies() {
		return alcanceEnPies;
	}

	public void setAlcanceEnPies(int alcanceEnPies) {
		if (alcanceEnPies < 0) {
			throw new IllegalArgumentException("El alcance de un hechizo no puede ser negativo.");
		} else {
			this.alcanceEnPies = alcanceEnPies;
		}

	}

	public String getDuracionHechizo() {
		return duracionHechizo;
	}

	public void setDuracionHechizo(String duracionHechizo) {
		if (duracionHechizo == null) {
			throw new IllegalArgumentException("La duración de un hechizo no puede ser nula.");
		} else if (duracionHechizo.isBlank()) {
			throw new IllegalArgumentException("La duración de un hechizo no puede estar en blanco.");
		} else {
			this.duracionHechizo = duracionHechizo;
		}

	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		if (descripcion == null) {
			throw new IllegalArgumentException("La descripción de un hechizo no puede ser nula.");
		} else if (descripcion.isBlank()) {
			throw new IllegalArgumentException("La descripción de un hechizo no puede estar vacía.");
		} else {
			this.descripcion = descripcion;
		}

	}

	public boolean isComponenteVerbal() {
		return componenteVerbal;
	}

	public void setComponenteVerbal(boolean componenteVebal) {
		this.componenteVerbal = componenteVebal;
	}

	public boolean isComponenteSomatico() {
		return componenteSomatico;
	}

	public void setComponenteSomatico(boolean componenteSomatico) {
		this.componenteSomatico = componenteSomatico;
	}

	public Material getComponenteMaterial() {
		return componenteMaterial;
	}

	public void setComponenteMaterial(Material componenteMaterial) {
		if (componenteMaterial == null) {
			throw new IllegalArgumentException("El material de un hechizo no puede ser nulo.");
		} else {
			this.componenteMaterial = componenteMaterial;
		}

	}

	public String getANivelesSuperiores() {
		return aNivelesSuperiores;
	}

	public void setANivelesSuperiores(String aNivelesSuperiores) {
		this.aNivelesSuperiores = aNivelesSuperiores;
	}

	private void setConcentracion(boolean concentracion) {
		this.concentracion = concentracion;
	}

	public boolean isConcentracion() {
		return this.concentracion;
	}

	public boolean lanzar(Personaje pj, NivelHechizo espacioConsumir) {
		if (espacioConsumir.equals(NivelHechizo.NO_RITUAL)) {
			throw new IllegalArgumentException(
					"Para lanzar un hechizo como no ritual se debe proporcionar un espacio de conjuro para consumir.");
		} else if (espacioConsumir.equals(NivelHechizo.RITUAL)) {
			if (getPuedeRitual().equals(NivelHechizo.RITUAL)) {
				try {
					EspacioConjuro espacioConjuro = pj.getEspacios().buscar(getNivelBaseHechizo());
					if (pj.getCompetencias().buscar(pj.getArmadura().getTipoArmadura().getCompetenciaRequerida())
							.isCompetente()) {
						return true;
					} else {
						throw new IllegalArgumentException(
								"El personaje no puede lanzar el hechizo, no es competente con la armadura que lleva equipada.");
					}
					// TODO comprobar lanzar no consumir
				} catch (IllegalArgumentException e) {
					throw new IllegalArgumentException("El personaje no puede lanzar este hechizo.");
				}
			} else {
				throw new IllegalArgumentException("El hechizo no puede ser lanzado como ritual.");
			}
		} else {
			if (getNivelBaseHechizo().equals(NivelHechizo.TRUCO)) {
				if (!espacioConsumir.equals(NivelHechizo.TRUCO)) {
					throw new IllegalArgumentException("El hechizo solo puede ser lanzado como truco");
				} else {
					if (pj.getCompetencias().buscar(pj.getArmadura().getTipoArmadura().getCompetenciaRequerida())
							.isCompetente()) {
						return true;
					} else {
						throw new IllegalArgumentException(
								"El personaje no puede lanzar el hechizo, no es competente con la armadura que lleva equipada.");
					}
				}
			} else if (espacioConsumir == NivelHechizo.TRUCO) {
				if (getNivelBaseHechizo() == NivelHechizo.TRUCO) {
					if (pj.getCompetencias().buscar(pj.getArmadura().getTipoArmadura().getCompetenciaRequerida())
							.isCompetente()) {
						return true;
					} else {
						throw new IllegalArgumentException(
								"El personaje no puede lanzar el hechizo, no es competente con la armadura que lleva equipada.");
					}
				} else {
					throw new IllegalArgumentException("El hechizo no se puede lanzar como truco.");
				}
			} else {
				if (espacioConsumir.getValorNivelHechizo() >= getNivelBaseHechizo().getValorNivelHechizo()) {
					EspacioConjuro espacioPersonaje = pj.getEspacios().buscar(espacioConsumir);
					if (espacioPersonaje.comprobarEspacios()) {
						if (pj.getCompetencias().buscar(pj.getArmadura().getTipoArmadura().getCompetenciaRequerida())
								.isCompetente()) {
							espacioPersonaje.consumirEspacio();
							return true;
						} else {
							throw new IllegalArgumentException(
									"El personaje no puede lanzar el hechizo, no es competente con la armadura que lleva equipada.");
						}
					} else {
						throw new IllegalArgumentException(
								"El personaje no tiene espacios de conjuro para lanzar el hechizo.");
					}
				} else {
					throw new IllegalArgumentException(
							"El espacio de conjuro asignado es menor que el mínimo que se pide para lanzarlo.");
				}
			}
		}

	}

	@Override
	public int hashCode() {
		return Objects.hash(idHechizo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hechizo other = (Hechizo) obj;
		return idHechizo == other.idHechizo;
	}

	@Override
	public String toString() {
		String mensajeFinal = "";
		mensajeFinal += "Hechizo: " + getNombreHechizo() + ".\n";
		mensajeFinal += "Escuela: " + getEscuela().getNombreEscuelaMagia() + ".\n";
		mensajeFinal += "Nivel: " + getNivelBaseHechizo().getNivelHechizo();
		if (getPuedeRitual().equals(NivelHechizo.RITUAL))
			mensajeFinal += " (Ritual)";
		mensajeFinal += ".\n";
		mensajeFinal += "Tiempo de Lanzamiento: " + getTiempoLanzamiento() + ".\n";
		if (getAlcanceEnPies() == 0) {
			mensajeFinal += "Alcance: Lanzador";
		} else {
			mensajeFinal += "Alcance: ";
			switch (getAlcanceEnPies()) {
			case 0:
				mensajeFinal += "Toque";
				break;
			case 1:
				mensajeFinal += "Visión";
				break;
			case 2:
				mensajeFinal += "Ilimitado";
				break;
			default:
				break;
			}
		}
		mensajeFinal += "Componentes:";
		if (isComponenteVerbal()) {
			mensajeFinal += " V";
		}
		if (isComponenteSomatico()) {
			mensajeFinal += " S";
		}
		if (getComponenteMaterial().isUsoMaterial()) {
			mensajeFinal += " M (";
			mensajeFinal += getComponenteMaterial().toString();
			mensajeFinal += ")";
		}
		mensajeFinal += ".\n";
		mensajeFinal += "Duración: ";
		if (isConcentracion())
			mensajeFinal += "Concentración, ";
		mensajeFinal += getDuracionHechizo();
		mensajeFinal += ".\n";
		mensajeFinal += "Descripción:" + getDescripcion() + ".\n";
		if (getANivelesSuperiores() != null && getANivelesSuperiores().trim().replace("/s+", "") != "") {
			mensajeFinal += "A niveles superiores: " + getANivelesSuperiores();
		}
		return mensajeFinal;
	}

}
