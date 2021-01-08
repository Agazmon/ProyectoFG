package ProyectoFG;

import java.sql.SQLException;
import java.util.List;

import ProyectoFG.modelo.dao.bibliotecas.BibliotecaArmaduras;
import ProyectoFG.modelo.dao.bibliotecas.BibliotecaArmas;
import ProyectoFG.modelo.dao.bibliotecas.BibliotecaDotes;
import ProyectoFG.modelo.dominio.Atributo;
import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.arma.Arma;
import ProyectoFG.modelo.dominio.dote.Dote;
import ProyectoFG.modelo.dominio.dote.TipoDote;
import ProyectoFG.modelo.dominio.salvacion.TipoSalvacion;
import ProyectoFG.modelo.dominio.tirada.TipoTirada;
import ProyectoFG.modelo.dominio.tirada.Tirada;

public class MainApp {

	public static void main(String[] args) throws SQLException {
		BibliotecaArmaduras armaduras = new BibliotecaArmaduras();
		BibliotecaDotes dotes = new BibliotecaDotes();
		BibliotecaArmas armas = new BibliotecaArmas();
		Personaje pj = new Personaje(BibliotecaArmaduras.buscar("Cota de escamas"),
				BibliotecaArmaduras.buscar("Escudo"));
		BibliotecaDotes.buscar(TipoDote.MAESTRO_EN_ESCUDOS).anadirDote(pj);
		List<Dote> listaDotes = pj.getDotes().getListaDotes();
		for (Dote dote : listaDotes) {
			System.out.println(dote);
		}
		Tirada pruebaDeSalvacion = pj.getSalvaciones().buscar(TipoSalvacion.SALVACION_DESTREZA).pruebaDeSalvacion(pj);
		System.out.println(pruebaDeSalvacion);
	}

}
