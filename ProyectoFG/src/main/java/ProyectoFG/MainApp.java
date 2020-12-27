package ProyectoFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ProyectoFG.modelo.dao.Habilidades;
import ProyectoFG.modelo.dominio.Personaje;
import ProyectoFG.modelo.dominio.Tirada;
import ProyectoFG.modelo.dominio.habilidad.Habilidad;
import ProyectoFG.modelo.dominio.habilidad.TipoHabilidad;
import ProyectoFG.modelo.dominio.moneda.Moneda;
import ProyectoFG.modelo.dominio.moneda.TipoMoneda;

public class MainApp {

	public static void main(String[] args) {
		Personaje pj = new Personaje();
		List<Moneda> iniciales = new ArrayList<Moneda>();
		iniciales.add(new Moneda(TipoMoneda.MONEDA_COBRE,1000));
		pj.getMonedero().anadirMonedas(iniciales);
		System.out.println(pj.getMonedero().toString());
		pj.getMonedero().anadirMonedas(iniciales);
		System.out.println(pj.getMonedero().toString());
		pj.getMonedero().cambiarMonedas(TipoMoneda.MONEDA_COBRE, TipoMoneda.MONEDA_PLATINO, 1100);
		System.out.println(pj.getMonedero().toString());
	}

}
