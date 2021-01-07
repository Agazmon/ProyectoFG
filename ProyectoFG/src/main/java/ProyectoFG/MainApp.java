package ProyectoFG;

import java.sql.SQLException;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import ProyectoFG.modelo.dao.Competencias;
import ProyectoFG.modelo.dao.bibliotecas.BibliotecaArmaduras;
import ProyectoFG.modelo.dao.bibliotecas.BibliotecaArmas;
import ProyectoFG.modelo.dao.bibliotecas.BibliotecaDotes;
import ProyectoFG.modelo.dao.bibliotecas.BibliotecaHechizos;
import ProyectoFG.modelo.dominio.Atributo;
import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.arma.Arma;
import ProyectoFG.modelo.dominio.arma.ArmaArrojadiza;
import ProyectoFG.modelo.dominio.arma.ArmaDistancia;
import ProyectoFG.modelo.dominio.arma.PropiedadesArma;
import ProyectoFG.modelo.dominio.competencia.Competencia;
import ProyectoFG.modelo.dominio.competencia.TipoCompetencia;
import ProyectoFG.modelo.dominio.dote.Dote;
import ProyectoFG.modelo.dominio.dote.DoteRequisitoAtributo;
import ProyectoFG.modelo.dominio.dote.DoteRequisitoCompetencia;
import ProyectoFG.modelo.dominio.dote.TipoDote;
import ProyectoFG.modelo.dominio.habilidad.TipoHabilidad;
import ProyectoFG.modelo.dominio.hechizo.Hechizo;
import ProyectoFG.modelo.dominio.objeto.ObjetoInventario;
import ProyectoFG.modelo.dominio.raza.Raza;
import ProyectoFG.modelo.dominio.raza.TamanoRaza;
import ProyectoFG.modelo.dominio.tirada.Dado;
import ProyectoFG.modelo.dominio.tirada.Resultado;
import ProyectoFG.modelo.dominio.tirada.TipoTirada;
import ProyectoFG.modelo.dominio.tirada.Tirada;

public class MainApp {

	public static void main(String[] args) throws SQLException {
		BibliotecaArmaduras armaduras = new BibliotecaArmaduras();
		BibliotecaDotes dotes = new BibliotecaDotes();
		BibliotecaArmas armas = new BibliotecaArmas();
		Personaje pj = new Personaje(BibliotecaArmaduras.buscar("Cota de escamas"),
				BibliotecaArmaduras.buscar("Escudo"));
		Personaje pj2 = new Personaje(BibliotecaArmaduras.buscar("Cota de escamas"),
				BibliotecaArmaduras.buscar("Escudo"));
		pj.setManoPrincipal(armas.buscarArma("Ballesta de mano"));
		pj.setManoSecundaria(armas.buscarArma("Garrote"));
		System.out.println(pj.getCaracteristicas().buscar(Atributo.FUERZA).toString());
		Dote dote = BibliotecaDotes.buscar(TipoDote.EXPERTO_EN_BALLESTAS);
		System.out.println("Maximos"+pj.getPuntosDeGolpeMaximos());
		System.out.println("Actuales"+pj.getPuntosDeGolpeMaximos());
		dote.anadirDote(pj);
		System.out.println("Maximos"+pj.getPuntosDeGolpeMaximos());
		System.out.println("Actuales"+pj.getPuntosDeGolpeMaximos());
		List<Dote> listaDotes2 = pj.getDotes().getListaDotes();
		for (Dote dote2 : listaDotes2) {
			System.out.println(dote2.toString());
		}
	
	}

}
