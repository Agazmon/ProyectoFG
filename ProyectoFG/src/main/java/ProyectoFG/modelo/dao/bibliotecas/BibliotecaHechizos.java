package ProyectoFG.modelo.dao.bibliotecas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.OperationNotSupportedException;

import ProyectoFG.modelo.dominio.clase.TipoClase;
import ProyectoFG.modelo.dominio.hechizo.Hechizo;
import ProyectoFG.modelo.dominio.hechizo.Material;
import ProyectoFG.modelo.dominio.hechizo.NivelHechizo;
import ProyectoFG.modelo.dominio.hechizo.TipoEscuelaMagia;
import ProyectoFG.modelo.dominio.moneda.Moneda;
import ProyectoFG.modelo.dominio.moneda.TipoMoneda;

public class BibliotecaHechizos {
	private static List<Hechizo> bibliotecaHechizos;
	private static final String patronMonedas = "(\\d+,)*\\d+\\s\\w[gp]";

	public BibliotecaHechizos() throws OperationNotSupportedException {
		this.bibliotecaHechizos = new ArrayList<>();
		obtenerHechizos(establecerConexion());
	}

	public static List<Hechizo> getListaHechizos() {
		return bibliotecaHechizos;
	}

	private void obtenerHechizos(Connection conexion) throws OperationNotSupportedException {
		try {
			PreparedStatement consulta = establecerConexion().prepareStatement(
					"SELECT spell_id,spell_name,spell_level,spell_type,casting_time,spell_range,components,duration,description,higher_levels FROM dnd5_spells");
			ResultSet resultados = consulta.executeQuery();
			if (resultados.next() == false) {
				throw new OperationNotSupportedException("No se han podido obtener resultados de la BD");
			} else {
				do {
					int idHechizo = Integer.parseInt(resultados.getString("spell_id"));
					String nombreHechizo = resultados.getString("spell_name");
					NivelHechizo nivelHechizo = obtenerNivelHechizo(resultados.getString("spell_level"));
					String tipoHechizo = resultados.getString("spell_type");
					TipoEscuelaMagia escuelaHechizo = obtenerEscuelaHechizo(tipoHechizo);
					NivelHechizo ritual = obtenerRitualHechizo(tipoHechizo);
					String tiempoLanzar = resultados.getString("casting_time");
					int rangoHechizo = obtenerRangoHechizo(resultados.getString("spell_range"));
					String componentes = resultados.getString("components");
					boolean componenteVerbal = getComponente(componentes, "V");
					boolean componenteSomatico = getComponente(componentes, "S");
					boolean componenteMaterial = getComponente(componentes, "M");
					Material material;
					if (componenteMaterial) {
						material = getComponenteMaterial(componentes);
					} else {
						material = new Material(false);
					}
					String duracionBD = resultados.getString("duration");
					String duracion = obtenerDuracion(duracionBD);
					boolean concentracion = obtenerConcentracion(duracionBD);
					String descripcion = resultados.getString("description");
					String nivelesSup = resultados.getString("higher_levels");
					Hechizo hechizoIteracion;
					if (nivelesSup == "") {
						hechizoIteracion = new Hechizo(idHechizo, nombreHechizo, escuelaHechizo, nivelHechizo, ritual,
								tiempoLanzar, rangoHechizo, concentracion, duracion, descripcion, componenteVerbal,
								componenteSomatico, material);
					} else {
						hechizoIteracion = new Hechizo(idHechizo, nombreHechizo, escuelaHechizo, nivelHechizo, ritual,
								tiempoLanzar, rangoHechizo, concentracion, duracion, descripcion, componenteVerbal,
								componenteSomatico, material, nivelesSup);
					}

					anadirHechizo(hechizoIteracion);

				} while (resultados.next());
				conexion.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new OperationNotSupportedException(
					"Ha ocurrido un error preparando la consulta de los hechizos en la BD. Error específico: "
							+ e.getMessage());
		}
	}

	public static List<Hechizo> obtenerHechizosClase(TipoClase claseBuscar) {
		if (claseBuscar == null) {
			throw new IllegalArgumentException("No se puede buscar los hechizos de una clase nula.");
		} else if (getListaHechizos().isEmpty()) {
			throw new IllegalArgumentException("No hay hechizos en la lista de hechizos.");
		} else {
			try {
				Connection conexion = establecerConexion();
				PreparedStatement consulta = conexion
						.prepareStatement("SELECT class_id, spell_id FROM dnd5_class_spells WHERE class_id = ?");
				consulta.setInt(1, obtenerNumeroClase(claseBuscar));
				ResultSet resultado = consulta.executeQuery();
				if (resultado.next() == false) {
					return new ArrayList<Hechizo>();
				} else {
					List<Hechizo> hechizosClase = new ArrayList<>();
					do {
						Hechizo hechizo = getListaHechizos().get(resultado.getInt("spell_id") - 1);
						hechizosClase.add(hechizo);
					} while (resultado.next());
					return hechizosClase;
				}
			} catch (OperationNotSupportedException e) {
				throw new IllegalArgumentException(
						"Ha habido un problema estableciendo la conexión para obtener los hechizos de la clase requerida.");
			} catch (SQLException e) {
				throw new IllegalArgumentException(
						"Ha habido un error SQL a la hora de consultar la relación de hechizos con la clase. Error específico: "
								+ e.getMessage());
			}

		}
	}

	private static int obtenerNumeroClase(TipoClase claseConvertir) {
		switch (claseConvertir) {
		case BARBARO:
			return 1;
		case BARDO:
			return 2;
		case BRUJO:
			return 11;
		case CLERIGO:
			return 3;
		case DRUIDA:
			return 4;
		case EXPLORADOR:
			return 8;
		case GUERRERO:
			return 5;
		case HECHICERO:
			return 10;
		case MAGO:
			return 12;
		case MONJE:
			return 6;
		case PALADIN:
			return 7;
		case PICARO:
			return 9;
		default:
			throw new IllegalArgumentException(
					"La clase pasada para buscar hechizos de la clase no es una opción contemplada.");
		}
	}

	private boolean getComponente(String componentes, String componenteComprobar) {
		if (componentes.contains(componenteComprobar)) {
			return true;
		} else {
			return false;
		}
	}

	private void anadirHechizo(Hechizo hechizo) {
		if (hechizo == null) {
			throw new IllegalArgumentException("No se puede añadir un hechizo nulo a la biblioteca de hechizos.");
		} else if (getListaHechizos().contains(hechizo)) {
			throw new IllegalArgumentException(
					"No se puede añadir un hechizo que ya existe a la biblioteca de hechizos.");
		} else {
			this.bibliotecaHechizos.add(hechizo);
		}
	}

	private boolean obtenerConcentracion(String duracionBD) {
		if (duracionBD.contains("Concentration")) {
			return true;
		} else {
			return false;
		}

	}

	private String obtenerDuracion(String duracionBD) {
		if (obtenerConcentracion(duracionBD)) {
			return duracionBD.substring(duracionBD.lastIndexOf("Concentration"), duracionBD.length());
		} else {
			return duracionBD;
		}
	}

	private Material getComponenteMaterial(String componentes) {
		String componentesCadena = (String) componentes.substring(componentes.indexOf("M"), componentes.length());
		// TODO sacar el nombre de los componentes para el precio del material
		Pattern patron = Pattern.compile(patronMonedas);
		Matcher matcher = patron.matcher(componentesCadena);
		String encontrado = "";
		Moneda precio = null;
		TipoMoneda tipoMoneda = null;
		while (matcher.find()) {
			encontrado = matcher.group();
			String moneda = encontrado.substring(encontrado.length() - 2, encontrado.length());
			if (moneda.equals("gp")) {
				tipoMoneda = TipoMoneda.MONEDA_ORO;
			}
			String cantidad = encontrado.substring(0, encontrado.indexOf(moneda.charAt(0)));
			if (cantidad.contains(","))
				cantidad = cantidad.replace(",", "");
			if (cantidad.contains("."))
				cantidad = cantidad.replace(".", "");
			int cantidadInt = Integer.parseInt(cantidad.trim());
			if (precio == null) {
				precio = new Moneda(tipoMoneda, cantidadInt);
			} else {
				precio.anadirMoneda(cantidadInt);
			}
		}
		String componentesSolos;
		if (componentes.indexOf(")") == -1) {
			componentes = componentes.concat(")");
		}
		componentesSolos = (String) componentes.substring(componentes.indexOf("("), componentes.length());
		if (encontrado != "") {
			return new Material(true, componentesSolos, precio);
		} else {
			return new Material(true, componentesSolos);
		}

	}

	private TipoEscuelaMagia obtenerEscuelaHechizo(String tipoHechizo) {
		if (tipoHechizo.contains("abjuration") || tipoHechizo.contains("Abjuration")) {
			return TipoEscuelaMagia.ABJURACION;
		} else if (tipoHechizo.contains("divination") || tipoHechizo.contains("Divination")) {
			return TipoEscuelaMagia.EVOCACION;
		} else if (tipoHechizo.contains("conjuration") || tipoHechizo.contains("Conjuration")) {
			return TipoEscuelaMagia.CONJURACION;
		} else if (tipoHechizo.contains("enchantment") || tipoHechizo.contains("Enchantment")) {
			return TipoEscuelaMagia.ENCANTAMIENTO;
		} else if (tipoHechizo.contains("evocation") || tipoHechizo.contains("Evocation")) {
			return TipoEscuelaMagia.EVOCACION;
		} else if (tipoHechizo.contains("illusion") || tipoHechizo.contains("Illusion")) {
			return TipoEscuelaMagia.ILUSIONISMO;
		} else if (tipoHechizo.contains("necromancy") || tipoHechizo.contains("Necromancy")) {
			return TipoEscuelaMagia.NIGROMANCIA;
		} else if (tipoHechizo.contains("transmutation") || tipoHechizo.contains("Transmutation")) {
			return TipoEscuelaMagia.TRANSMUTACION;
		} else {
			throw new IllegalArgumentException("Tipo de escuela no válido, el recibido es: " + tipoHechizo);
		}
	}

	private NivelHechizo obtenerRitualHechizo(String tipoHechizo) {
		if (tipoHechizo.contains("(ritual)")) {
			return NivelHechizo.RITUAL;
		} else {
			return NivelHechizo.NO_RITUAL;
		}
	}

	private int obtenerRangoHechizo(String rango) {
		if (rango.contains("Self") || rango.contains("Touch")) {
			return 0;
		} else if (rango.contains("Sight")) {
			return 1;
		} else if (rango.contains("Unlimited")) {
			return 2;
		} else if (rango.contains("mile") || rango.contains("miles")) {
			return (obtenerNumero(rango) * 1000);
		} else if (rango.contains("feet")) {
			return obtenerNumero(rango);
		} else {
			throw new IllegalArgumentException(
					"No se ha podido obtener el rango del hechizo, no está entre las opciones válidas: " + rango);
		}
	}

	private int obtenerNumero(String cadena) {
		String[] cadenaSeparada = cadena.split("\s");
		if (cadenaSeparada[0].matches("\\d+")) {
			return Integer.parseInt(cadenaSeparada[0]);
		} else {
			throw new IllegalArgumentException("No se ha podido obtener el rango del hechizo de la cadena: " + cadena);
		}

	}

	private NivelHechizo obtenerNivelHechizo(String nivelHechizo) {
		switch (nivelHechizo) {
		case "0":
			return NivelHechizo.TRUCO;
		case "1":
			return NivelHechizo.NIVEL_1;
		case "2":
			return NivelHechizo.NIVEL_2;
		case "3":
			return NivelHechizo.NIVEL_3;
		case "4":
			return NivelHechizo.NIVEL_4;
		case "5":
			return NivelHechizo.NIVEL_5;
		case "6":
			return NivelHechizo.NIVEL_6;
		case "7":
			return NivelHechizo.NIVEL_7;
		case "8":
			return NivelHechizo.NIVEL_8;
		case "9":
			return NivelHechizo.NIVEL_9;
		default:
			throw new IllegalArgumentException(
					"No se ha podido poner el nivel de hechizo adecuado al hechizo. Nivel recibido: " + nivelHechizo);
		}
	}

	private static Connection establecerConexion() throws OperationNotSupportedException {
		try {
			Connection conn = DriverManager
					.getConnection("jdbc:mariadb://localhost:3306/proyecto?user=alex&password=accesodatos");
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new OperationNotSupportedException(
					"No se ha podido conectar con la BD de los hechizos. Error específico: " + e.getMessage());
		}
	}
}
