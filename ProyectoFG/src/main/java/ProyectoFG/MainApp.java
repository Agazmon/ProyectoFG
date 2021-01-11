package ProyectoFG;

import java.sql.SQLException;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import ProyectoFG.modelo.dao.Dotes;
import ProyectoFG.modelo.dao.bibliotecas.BibliotecaArmaduras;
import ProyectoFG.modelo.dao.bibliotecas.BibliotecaArmas;
import ProyectoFG.modelo.dao.bibliotecas.BibliotecaDotes;
import ProyectoFG.modelo.dao.bibliotecas.BibliotecaHechizos;
import ProyectoFG.modelo.dominio.Atributo;
import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.arma.Arma;
import ProyectoFG.modelo.dominio.dote.Dote;
import ProyectoFG.modelo.dominio.dote.TipoDote;
import ProyectoFG.modelo.dominio.hechizo.Hechizo;
import ProyectoFG.modelo.dominio.salvacion.TipoSalvacion;
import ProyectoFG.modelo.dominio.tirada.TipoTirada;
import ProyectoFG.modelo.dominio.tirada.Tirada;

public class MainApp {

	public static void main(String[] args) throws SQLException {

		BibliotecaArmaduras armaduras = new BibliotecaArmaduras();
		BibliotecaDotes dotes = new BibliotecaDotes();
		BibliotecaArmas armas = new BibliotecaArmas();
		BibliotecaHechizos hechizos = null;
		try {
			hechizos = new BibliotecaHechizos();
		} catch (OperationNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		Personaje personaje = new Personaje(BibliotecaArmaduras.getArmadurasDisponibles().get(1), BibliotecaArmaduras.buscar("Escudo"));
		System.out.println(personaje.toString());
	}

}
