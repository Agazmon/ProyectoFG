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
import ProyectoFG.modelo.dominio.arma.PropiedadesArma;
import ProyectoFG.modelo.dominio.competencia.TipoCompetencia;
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
		Personaje pj = new Personaje(armaduras.buscar("Acolchada"), armaduras.buscar("Escudo"));
		BibliotecaArmas armas = new BibliotecaArmas();
		List<Arma> armasLista = armas.getListaArmas();
		for (Arma arma : armasLista) {
			armas.comprarArma(arma.getNombre(), pj);
			if (arma.getListaPropiedadesDelArma().contains(PropiedadesArma.ARROJADIZA)
					&& arma.getListaPropiedadesDelArma().contains(PropiedadesArma.LIGERA)) {
				if (pj.getManoPrincipal() == null) {
					pj.setManoPrincipal(arma);
				} else if (pj.getManoSecundaria() == null) {
					pj.setManoSecundaria(arma);
					System.out.println("Mano principal: " + pj.getManoPrincipal().getNombre());
					System.out.println("Mano secundaria: " + pj.getManoSecundaria().getNombre());
				}
			}
		}
		System.out.println("¿Son iguales?");
		System.out.println(pj.getManoPrincipal().equals(pj.getManoSecundaria()));
		ArmaArrojadiza armaLanzar = (ArmaArrojadiza) pj.getManoPrincipal();
		Tirada tiradaManoPrincipal = armaLanzar.lanzar(pj, TipoTirada.NEUTRA);
		tiradaManoPrincipal.tirar();
		System.out.println("Los resultados obtenidos son:");
		List<Resultado> resultadosConseguidos = tiradaManoPrincipal.getResultadosConseguidos();
		for (Resultado resultado : resultadosConseguidos) {
			System.out.println("Resultado: " + resultado.getDadosSacados().toString() + " bono: "
					+ resultado.getBonificadorAnadido() + " Total:" + resultado.getResultado());
		}
		System.out.println("Daño obtenido:");
		Tirada tiradaDanoPrincipal = armaLanzar.danoCausado(pj);
		tiradaDanoPrincipal.tirar();
		List<Resultado> danosPrincipal = tiradaDanoPrincipal.getResultadosConseguidos();
		for (Resultado resultado : danosPrincipal) {
			System.out.println("Resultado: " + resultado.getDadosSacados().toString() + " bono: "
					+ resultado.getBonificadorAnadido() + " Total:" + resultado.getResultado());
		}
		System.out.println("Mano Principal: " + pj.getManoPrincipal().getNombre());
		System.out.println("Mano Secundaria: " + pj.getManoSecundaria().getNombre());
		ArmaArrojadiza armaSecundaria = ((ArmaArrojadiza) pj.getManoSecundaria());
		Tirada tiradaManoSecundaria = armaSecundaria.lanzar(pj, TipoTirada.NEUTRA);
		tiradaManoSecundaria.tirar();
		System.out.println("Los resultados obtenidos con la otra arma son:");
		List<Resultado> resultadosConseguidosS = tiradaManoSecundaria.getResultadosConseguidos();
		for (Resultado resultado : resultadosConseguidosS) {
			System.out.println("Resultado: " + resultado.getDadosSacados().toString() + " bono: "
					+ resultado.getBonificadorAnadido() + " Total:" + resultado.getResultado());
		}
		System.out.println("Daño obtenido:");
		Tirada tiradaDanoS = armaSecundaria.danoCausado(pj);
		tiradaDanoS.tirar();
		List<Resultado> danosS = tiradaDanoS.getResultadosConseguidos();
		for (Resultado resultado : danosS) {
			System.out.println("Resultado: " + resultado.getDadosSacados().toString() + " bono: "
					+ resultado.getBonificadorAnadido() + " Total:" + resultado.getResultado());
		}

	}

}
