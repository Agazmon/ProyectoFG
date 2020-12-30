package ProyectoFG.modelo.dominio.competencia;

import java.util.Objects;

public class Competencia {

	private TipoCompetencia tipoCompetencia;
	private boolean competente;

	public Competencia(TipoCompetencia competencia, boolean competente) {
		setTipoCompetencia(competencia);
		setCompetente(competente);
	}

	public Competencia(Competencia competencia) {
		setTipoCompetencia(competencia.getTipoCompetencia());
		setCompetente(competencia.isCompetente());
	}

	public TipoCompetencia getTipoCompetencia() {
		return tipoCompetencia;
	}

	private void setTipoCompetencia(TipoCompetencia tipoCompetencia) {
		if (tipoCompetencia == null) {
			throw new IllegalArgumentException("El tipo de competencia no puede ser nulo.");
		} else {
			this.tipoCompetencia = tipoCompetencia;
		}
	}

	public boolean isCompetente() {
		return competente;
	}

	public void setCompetente(boolean competente) {
		this.competente = competente;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(tipoCompetencia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Competencia other = (Competencia) obj;
		return tipoCompetencia == other.tipoCompetencia;
	}

	@Override
	public String toString() {
		String competente;
		if(isCompetente()) {
			competente = "Competente";
		} else {
			competente = "No competente";
		}
		return "Competencia [Competencia=" + tipoCompetencia + ", competente=" + competente + "]";
	}
	

}
