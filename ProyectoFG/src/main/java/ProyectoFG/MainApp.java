package ProyectoFG;

import java.sql.SQLException;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import ProyectoFG.modelo.dao.bibliotecas.BibliotecaArmaduras;
import ProyectoFG.modelo.dao.bibliotecas.BibliotecaArmas;
import ProyectoFG.modelo.dao.bibliotecas.BibliotecaHechizos;
import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.arma.Arma;
import ProyectoFG.modelo.dominio.arma.ArmaArrojadiza;
import ProyectoFG.modelo.dominio.arma.ArmaDistancia;
import ProyectoFG.modelo.dominio.competencia.TipoCompetencia;
import ProyectoFG.modelo.dominio.hechizo.Hechizo;
import ProyectoFG.modelo.dominio.objeto.ObjetoInventario;
import ProyectoFG.modelo.dominio.tirada.Tirada;

public class MainApp {

	public static void main(String[] args) throws SQLException {
		BibliotecaArmaduras armaduras = new BibliotecaArmaduras();
		Personaje pj = new Personaje(armaduras.buscar("Acolchada"), armaduras.buscar("Escudo"));
		pj.getCompetencias().buscar(TipoCompetencia.ARMADURA_LIGERA).setCompetente(true);
		List<Hechizo> lista = null;
		try {
			lista = new BibliotecaHechizos().getListaHechizos();
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		pj.getCompetencias().buscar(TipoCompetencia.ARMADURA_LIGERA).setCompetente(true);
//		System.out.println(pj.getHechizosDisponibles().get(1).lanzar(pj, NivelHechizo.NIVEL_2));
//		pj.getCompetencias().buscar(TipoCompetencia.ARMADURA_LIGERA).setCompetente(false);
//		System.out.println(pj.getHechizosDisponibles().get(1).lanzar(pj, NivelHechizo.NIVEL_1));
		BibliotecaArmas armas = new BibliotecaArmas();
		List<Arma> armasLista = armas.getListaArmas();
		for (Arma arma : armasLista) {
			armas.comprarArma(arma.getNombre(), pj);
		}


	}

}
