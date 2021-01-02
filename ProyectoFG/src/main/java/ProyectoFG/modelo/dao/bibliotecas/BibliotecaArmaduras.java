package ProyectoFG.modelo.dao.bibliotecas;

import java.util.ArrayList;
import java.util.List;

import ProyectoFG.modelo.dominio.armadura.Armadura;
import ProyectoFG.modelo.dominio.armadura.TipoArmadura;
import ProyectoFG.modelo.dominio.moneda.Moneda;
import ProyectoFG.modelo.dominio.moneda.TipoMoneda;

public class BibliotecaArmaduras {
	List<Armadura> armadurasDisponibles;
	public BibliotecaArmaduras() {
		List<Armadura> listaArmadurasDisponibles = new ArrayList<Armadura>();
		listaArmadurasDisponibles.add(new Armadura(TipoArmadura.ARMADURA_LIGERA, "Acolchada",new Moneda(TipoMoneda.MONEDA_ORO,5),11,0,true,8));
		listaArmadurasDisponibles.add(new Armadura(TipoArmadura.ARMADURA_LIGERA, "Cuero",new Moneda(TipoMoneda.MONEDA_ORO,10),11,0,false,10));
		listaArmadurasDisponibles.add(new Armadura(TipoArmadura.ARMADURA_LIGERA, "Cuero Tachonado",new Moneda(TipoMoneda.MONEDA_ORO,45),12,0,false,13));
		listaArmadurasDisponibles.add(new Armadura(TipoArmadura.ARMADURA_MEDIA, "Camisa de malla",new Moneda(TipoMoneda.MONEDA_ORO,50),13,0,false,20));
		listaArmadurasDisponibles.add(new Armadura(TipoArmadura.ARMADURA_MEDIA,"Cota de escamas", new Moneda(TipoMoneda.MONEDA_ORO,50),14,0,true,45));
		listaArmadurasDisponibles.add(new Armadura(TipoArmadura.ARMADURA_MEDIA,"Coraza", new Moneda(TipoMoneda.MONEDA_ORO,400),14,0,false,20));
		listaArmadurasDisponibles.add(new Armadura(TipoArmadura.ARMADURA_MEDIA,"Media Armadura", new Moneda(TipoMoneda.MONEDA_ORO,750),15,0,true,40));
		listaArmadurasDisponibles.add(new Armadura(TipoArmadura.ARMADURA_MEDIA,"Pieles", new Moneda(TipoMoneda.MONEDA_ORO,10),12,0,false,12));
		listaArmadurasDisponibles.add(new Armadura(TipoArmadura.ARMADURA_PESADA,"Armadura de bandas", new Moneda(TipoMoneda.MONEDA_ORO,200),17,15,true,60));
		listaArmadurasDisponibles.add(new Armadura(TipoArmadura.ARMADURA_PESADA,"Armadura de placas", new Moneda(TipoMoneda.MONEDA_ORO,1500),18,15,true,65));
		listaArmadurasDisponibles.add(new Armadura(TipoArmadura.ARMADURA_PESADA,"Cota Guarnecida", new Moneda(TipoMoneda.MONEDA_ORO,30),14,0,true,40));
		listaArmadurasDisponibles.add(new Armadura(TipoArmadura.ARMADURA_PESADA,"Cota de malla", new Moneda(TipoMoneda.MONEDA_ORO,75),16,13,true,55));
		listaArmadurasDisponibles.add(new Armadura(TipoArmadura.ESCUDOS,"Escudo", new Moneda(TipoMoneda.MONEDA_ORO,10),0,0,false,6));
		setArmadurasDisponibles(listaArmadurasDisponibles);
	}
	public BibliotecaArmaduras(BibliotecaArmaduras armaduras) {
		setArmadurasDisponibles(armaduras.getArmadurasDisponibles());
	}
	public BibliotecaArmaduras(List<Armadura> listaArmaduras) {
		setArmadurasDisponibles(listaArmaduras);
	
	}
	public List<Armadura> getArmadurasDisponibles(){
		return this.armadurasDisponibles;
	}
	private void setArmadurasDisponibles(List<Armadura> listaArmaduras){
		this.armadurasDisponibles = new ArrayList<>();
		this.armadurasDisponibles = listaArmaduras;
	}
	
	public Armadura buscar(String nombre) {
		if(nombre == null) {
			throw new IllegalArgumentException("No se puede buscar una armadura por un nombre nulo.");
		} else if(nombre.isBlank()) {
			throw new IllegalArgumentException("No se puede buscar una armadura por un nombre vacío.");
		} else {
			for (Armadura armadura : getArmadurasDisponibles()) {
				if(armadura.getNombre().equals(nombre)) {
					return new Armadura(armadura);
				}
			}
			return null;
		}
		
	}
	@Override
	public String toString() {
		return "Armaduras [armadurasDisponibles=" + armadurasDisponibles + "]";
	}
	
}
