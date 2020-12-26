package ProyectoFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ProyectoFG.modelo.dao.Habilidades;
import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.Tirada;
import ProyectoFG.modelo.dominio.habilidad.Habilidad;
import ProyectoFG.modelo.dominio.habilidad.TipoHabilidad;

public class MainApp {

	public static void main(String[] args) {
		Personaje pj = new Personaje();
		Tirada tirada = new Tirada("4d20-1+1");
		Tirada tirada2 = new Tirada("4d20+1-1");
		Tirada tirada3 = new Tirada("4d20-1-1");
		tirada.tirar();
		tirada2.tirar();
		tirada3.tirar();
		System.out.println(tirada.toString());
		System.out.println(tirada2.toString());
		System.out.println(tirada3.toString());
	
//		List<Habilidad> listaCompetencias = new ArrayList<>();
//		
//		listaCompetencias.add(new Habilidad(TipoHabilidad.JUEGO_DE_MANOS, true));
//		listaCompetencias.add(new Habilidad(TipoHabilidad.INTIMIDACION, true));
//		listaCompetencias.add(0, new Habilidad(TipoHabilidad.PERCEPCION, true));
//		
//		
//		Habilidades habilidades = new Habilidades(listaCompetencias);
//		Habilidades habilidades2 = new Habilidades(listaCompetencias);
//		habilidades2.cambiarCompetencia(TipoHabilidad.ATLETISMO,true);
//		System.out.println(habilidades.toString());
//		for (Habilidad habilidad : habilidades.getHabilidades()) {
//			System.out.println("Habilidad: "+ habilidades2.buscar(new Habilidad(habilidad)).toString() +"indice: " +habilidades2.getHabilidades().indexOf(habilidad));
//			Tirada tirada = habilidades2.buscar(habilidad).pruebaDeHabilidad(pj);
//			tirada.tirar();
//			System.out.println(tirada.toString());
//			System.out.println("Habilidad: " + habilidad.toString() + "indice: " + habilidades.getHabilidades().indexOf(habilidad) );
//			Tirada tirada2 = habilidades.buscar(habilidad).pruebaDeHabilidad(pj);
//			tirada2.tirar();
//			System.out.println(tirada2.toString());
//		}
		
		
		
		
	}

}
