package ProyectoFG.modelo.dominio.clase;

import java.util.List;

import ProyectoFG.modelo.dominio.Atributo;
import ProyectoFG.modelo.dominio.arma.TipoArma;
import ProyectoFG.modelo.dominio.armadura.TipoArmadura;

import ProyectoFG.modelo.dominio.salvacion.Salvacion;
import ProyectoFG.modelo.dominio.tirada.Dado;

public enum TipoClase {
	BARBARO("Barbaro", null, Atributo.FUERZA),
	BARDO("Bardo",null,Atributo.CARISMA),
	BRUJO("Brujo",null,Atributo.CARISMA),
	CLERIGO("Clérigo",null,Atributo.SABIDURIA),
	DRUIDA("Druida",null,Atributo.SABIDURIA),
	EXPLORADOR("Explorador",null,Atributo.DESTREZA),
	GUERRERO("Guerrero",null,Atributo.FUERZA),
	HECHICERO("Hechicero",null,Atributo.CARISMA),
	MAGO("Mago",null,Atributo.INTELIGENCIA),
	MONJE("Monje",null,Atributo.DESTREZA),
	PALADIN("Paladón",null,Atributo.FUERZA),
	PICARO("Pícaro",null,Atributo.DESTREZA);
	
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
