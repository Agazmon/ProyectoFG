package ProyectoFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ProyectoFG.modelo.dao.Armaduras;
import ProyectoFG.modelo.dao.Habilidades;
import ProyectoFG.modelo.dominio.Atributo;
import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.Tirada;
import ProyectoFG.modelo.dominio.armadura.Armadura;
import ProyectoFG.modelo.dominio.habilidad.Habilidad;
import ProyectoFG.modelo.dominio.habilidad.TipoHabilidad;
import ProyectoFG.modelo.dominio.moneda.Moneda;
import ProyectoFG.modelo.dominio.moneda.TipoMoneda;

public class MainApp {

	public static void main(String[] args) {
		Armaduras armaduras = new Armaduras();
		Personaje pj = new Personaje(armaduras.buscar("Acolchada"), armaduras.buscar("Escudo"));
		System.out.println(pj.getCaracteristicas().buscar(Atributo.DESTREZA));
		System.out.println(pj.getArmadura());
		System.out.println(pj.getEscudo());
		System.out.println(pj.getCAFinal());
	}

}
