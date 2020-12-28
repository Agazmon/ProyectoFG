package ProyectoFG.modelo.dominio.clase;

import java.util.List;

import ProyectoFG.modelo.dominio.Atributo;
import ProyectoFG.modelo.dominio.Dado;
import ProyectoFG.modelo.dominio.arma.TipoArma;
import ProyectoFG.modelo.dominio.armadura.TipoArmadura;

import ProyectoFG.modelo.dominio.salvacion.Salvacion;

public enum TipoClase {
	BARBARO("Barbaro", null, Atributo.FUERZA),
	BARDO("Bardo",null,Atributo.CARISMA),
	BRUJO("Brujo",null,Atributo.CARISMA);
	
	String nombreClase;
	TipoClase clasePadre;
	Atributo atributoPrincipal;
	List<Salvacion> competenciasSalvacion;
	List<TipoArmadura> competenciasDeArmadura;
	List<TipoArma> competenciasDeArmas;
	Dado dadoGolpe;
	private TipoClase(String nombreClase, TipoClase clasePadre, Atributo atributoPrincipal) {
		
	}
}
