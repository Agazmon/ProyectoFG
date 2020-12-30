package ProyectoFG;

import java.sql.SQLException;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import ProyectoFG.modelo.dao.Armaduras;
import ProyectoFG.modelo.dao.BibliotecaHechizos;
import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.competencia.TipoCompetencia;
import ProyectoFG.modelo.dominio.hechizo.Hechizo;
import ProyectoFG.modelo.dominio.hechizo.NivelHechizo;

public class MainApp {

	public static void main(String[] args) throws SQLException {
		Armaduras armaduras = new Armaduras();
		Personaje pj = new Personaje(armaduras.buscar("Acolchada"), armaduras.buscar("Escudo"));
		pj.getCompetencias().buscar(TipoCompetencia.ARMADURA_LIGERA).setCompetente(true);
		List<Hechizo> lista = null;
		try {
			lista = new BibliotecaHechizos().getListaHechizos();
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pj.getCompetencias().buscar(TipoCompetencia.ARMADURA_LIGERA).setCompetente(true);
		System.out.println(pj.getHechizosDisponibles().get(1).lanzar(pj, NivelHechizo.NIVEL_2));
		pj.getCompetencias().buscar(TipoCompetencia.ARMADURA_LIGERA).setCompetente(false);
		System.out.println(pj.getHechizosDisponibles().get(1).lanzar(pj, NivelHechizo.NIVEL_1));

	}

}
