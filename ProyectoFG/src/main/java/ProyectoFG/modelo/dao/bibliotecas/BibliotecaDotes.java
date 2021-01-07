package ProyectoFG.modelo.dao.bibliotecas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ProyectoFG.modelo.dominio.Atributo;
import ProyectoFG.modelo.dominio.competencia.TipoCompetencia;
import ProyectoFG.modelo.dominio.dote.Dote;
import ProyectoFG.modelo.dominio.dote.DoteRequisitoAtributo;
import ProyectoFG.modelo.dominio.dote.DoteRequisitoCompetencia;
import ProyectoFG.modelo.dominio.dote.TipoDote;

public class BibliotecaDotes {
	private static List<Dote> listaDotes;

	public BibliotecaDotes() {
		BibliotecaDotes.listaDotes = new ArrayList<>();
		// DOTES CON REQUISITO DE ATRIBUTO.
		anadir(new DoteRequisitoAtributo(TipoDote.ACECHADOR,
				"Eres experto en escabullirte entre las sombras. Obtienes los beneficios siguientes: \n"
						+ "Puedes intentar esconderte simplemente con estar en una zona ligeramente oscura desde el punto de vista de la criatura de la que deseas ocultarte.\n"
						+ "Cuando estas escondido de una criatura y fallas un ataque con arma a distancia contra ella, el haber realizado este atauqe no revela tu ubicación.\n"
						+ "La luz tenue no te provoca desventaja en las pruebas de Sabiduría(Percepción) que dependen de la vista.",
				Atributo.DESTREZA));

		anadir(new DoteRequisitoAtributo(TipoDote.APRESADOR,
				"Has desarrollado las aptitudes necesarias para pelear bien a distancias extremadamente cortas. Obtienes los beneficios siguientes:\n"
						+ "Tienes ventaja en las tiradas de ataque contra una criatura a la que estés agarrando.\n"
						+ "Puedes usar tu acción para intentar someter a un objetivo al que estés agarrando. Para ello, haz otra prueba de agarrar. Si tienes éxito, tanto tú como la criatura estaréis apresados hasta que el agarre finalice.",
				Atributo.FUERZA));
		anadir(new DoteRequisitoAtributo(TipoDote.DUELISTA_DEFENSIVO,
				"Cuando estás empuñando un arma sutil con la que seas competente y otra criatura te impacte con un ataque cuerpo a cuerpo, podrás utilizar tu reacción para sumar tu bonificador por competencia a tu CA a efectos de este ataque. Con suerte conseguiras que falle.",
				Atributo.DESTREZA));
		String descLanzadorRitual = "Has aprendido una serie de conjuros que puedes lanzar como rituales. Estos conjuros están escritos en un libro de rituales, que debes tener en las manos para poder lanzar cualquiera de ellos. Cuando escojas esta dote obtendrás este libro, que contendrá dos conjuros de nivel 1 de tu elección. La clase de la que tendrás disponibles los hechizos está definida por el nombre de la dote. Deben estár marcados como ritual. La clase determinará también la aptitud mágica. Carisma para bardo brujo o hechicero, Sabiduría para clérigo o druida e Inteligencia para Mago. En esta versión del programa no puedes añadir nuevos hechizos al libro.";
		anadir(new DoteRequisitoAtributo(TipoDote.LANZADOR_RITUAL_BARDO, descLanzadorRitual,
				Arrays.asList(Atributo.INTELIGENCIA, Atributo.SABIDURIA)));
		anadir(new DoteRequisitoAtributo(TipoDote.LANZADOR_RITUAL_BRUJO, descLanzadorRitual,
				Arrays.asList(Atributo.INTELIGENCIA, Atributo.SABIDURIA)));
		anadir(new DoteRequisitoAtributo(TipoDote.LANZADOR_RITUAL_CLERIGO, descLanzadorRitual,
				Arrays.asList(Atributo.INTELIGENCIA, Atributo.SABIDURIA)));
		anadir(new DoteRequisitoAtributo(TipoDote.LANZADOR_RITUAL_DRUIDA, descLanzadorRitual,
				Arrays.asList(Atributo.INTELIGENCIA, Atributo.SABIDURIA)));
		anadir(new DoteRequisitoAtributo(TipoDote.LANZADOR_RITUAL_HECHICERO, descLanzadorRitual,
				Arrays.asList(Atributo.INTELIGENCIA, Atributo.SABIDURIA)));
		anadir(new DoteRequisitoAtributo(TipoDote.LANZADOR_RITUAL_MAGO, descLanzadorRitual,
				Arrays.asList(Atributo.INTELIGENCIA, Atributo.SABIDURIA)));
		anadir(new DoteRequisitoAtributo(TipoDote.LIDER_INSPIRADOR,
				"Puedes invertir 10 minutos en inspirar a tus compañeros, apuntalando su voluntad para luchar. Cuando hagas esto, escoge hasta seis criaturas amistosas (entre las que puedes encontrarte tu mismo) a 30 pies o menos de tí que puedan verte u oirte y sean capaces de entenderte.. Cada uno de estos objetivos recibe tantos puntos de golpe temporales como tu nivel + modificador por Carisma.\n Ninguna de las criaturas puede volver a recibir puntos de golpe temporales gracias a esta dote hasta que termine un descanso corto o largo.",
				Atributo.CARISMA));

		// DOTES CON REQUISITO DE COMPETENCIA.
		anadir(new DoteRequisitoCompetencia(TipoDote.LANZADOR_EN_COMBATE,
				"Has practicado cómo lanzar conjuros en medio del combate, aprendiendo técnicas que te proporcionan los beneficios siguientes:\n"
						+ "Tienes ventaja en las tiradas de salvación de Constitución que hagas para mantener la concentracion en un conjuro cuando recibes daño.\n"
						+ "Puedes ejecutar los componentes somáticos de tus conjuros incluso cuando empuñas armas o un escudo, en una o ambas manos.\n"
						+ "Cuando el movimiento de una criatura te permite hacer un ataque de oportunidad contra ella, puedes usar tu reacción para, en lugar de realizar este ataque, lanzar un conjuro contra la criatura. Dicho conjuro deberá tener un tiempo de lanzamiento de 1 acción y tener como objetivo una única criatura.",
				TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS));

		String descLanzadorPreciso = "Has aprendido varias técnicas que te permiten mejorar tus ataques con ciertos tipos de conjuros, recibiendo los siguientes beneficios: \n"
				+ "Cuando lances un conjuro que precise de una tirada de ataque, su alcance se duplica.\n"
				+ "Tus ataques de conjuros a distancia ignoran las coberturas media y tres cuartos.\n"
				+ "Aprendes un truco que requiera de una tirada de ataque. La clase escogida está en el nombre de la dote. Tu aptitud mágica para este truco dependerá de la clase a la que pertenezca la lista en la que figuraba: Carisma para bardo, brujo o hechicero Sabiduría para clérigo o druida e Inteligencia para Mago";
		anadir(new DoteRequisitoCompetencia(TipoDote.LANZADOR_PRECISO_BARDO, descLanzadorPreciso,
				TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS));
		anadir(new DoteRequisitoCompetencia(TipoDote.LANZADOR_PRECISO_BRUJO, descLanzadorPreciso,
				TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS));
		anadir(new DoteRequisitoCompetencia(TipoDote.LANZADOR_PRECISO_CLERIGO, descLanzadorPreciso,
				TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS));
		anadir(new DoteRequisitoCompetencia(TipoDote.LANZADOR_PRECISO_DRUIDA, descLanzadorPreciso,
				TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS));
		anadir(new DoteRequisitoCompetencia(TipoDote.LANZADOR_PRECISO_HECHICERO, descLanzadorPreciso,
				TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS));
		anadir(new DoteRequisitoCompetencia(TipoDote.LANZADOR_PRECISO_MAGO, descLanzadorPreciso,
				TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS));

		anadir(new DoteRequisitoCompetencia(TipoDote.MAESTRO_EN_ARMADURAS_MEDIAS,
				"Te has acostumbrado a moverte con armaduras medias, obtienes los beneficios siguientes:\n"
						+ "Llevar armadura media no te das desventaja en las pruebas de Destreza(Sigilo).\n"
						+ "Cuando portas armadura media puedes sumar 3, en lugar de 2 a tu CA si tienes 16 de Destreza o mas.",
				TipoCompetencia.ARMADURA_MEDIA));
		anadir(new DoteRequisitoCompetencia(TipoDote.MAESTRO_EN_ARMADURAS_PESADAS,
				"Eres capaz de emplear tu armadura para desviar golpes que materían a otros. Obtienes los beneficios siguientes:\n"
						+ "Tu puntuación de Fuerza aumenta en 1, hasta un máximo de 20.\n"
						+ "Mientras estás llevando armadura pesada, el daño contundente, cortante y perforante de armas, no mágicas que recibas se reduce en 3.",
				TipoCompetencia.ARMADURA_PESADA));
		anadir(new DoteRequisitoCompetencia(TipoDote.MODERADAMENTE_ACORAZADO_DESTREZA,
				"Te has entrenado hasta dominar el combate en armaduras medias y escudos, obteniendo los beneficios siguientes:\n"
						+ "Tu puntuación de Destreza aumenta en 1, hasta un máximo de 20. En el caso de no poder aumentar se aumentará la fuerza y en caso de no poder aumentar ninguna de las dos, no se aumentará ninguna.",
				TipoCompetencia.ARMADURA_LIGERA));
		anadir(new DoteRequisitoCompetencia(TipoDote.MODERADAMENTE_ACORAZADO_FUERZA,
				"Te has entrenado hasta dominar el combate en armaduras medias y escudos, obteniendo los beneficios siguientes:\n"
						+ "Tu puntuación de Fuerza aumenta en 1, hasta un máximo de 20. En el caso de no poder aumentar se aumentará la fuerza y en caso de no poder aumentar ninguna de las dos, no se aumentará ninguna.",
				TipoCompetencia.ARMADURA_LIGERA));
		anadir(new DoteRequisitoCompetencia(TipoDote.MUY_ACORAZADO,
				"Te has entrenado hasta dominar el combate en armaduras pesadas, obteniendo los beneficios siguientes:\n"
						+ "Tu puntuación de Fuerza aumenta en 1, hasta un máximo de 20.\n"
						+ "Ganas competencia con armaduras pesadas.",
				TipoCompetencia.ARMADURA_MEDIA));
		anadir(new DoteRequisitoCompetencia(TipoDote.VERSADO_EN_UN_ELEMENTO_ACIDO,
				"Los conjuros que lances ignoran la resistencia al daño de Ácido. Además cuando tires el daño de uno de tus conjuros que inflinja ese tipo de daño, puedes considerar cualquier 1 en los dados de daño como 2. Puedes coger los otros tipo de Versado en un elemento además de este como otra dote.",
				TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS));
		anadir(new DoteRequisitoCompetencia(TipoDote.VERSADO_EN_UN_ELEMENTO_FRIO,
				"Los conjuros que lances ignoran la resistencia al daño de Frío. Además cuando tires el daño de uno de tus conjuros que inflinja ese tipo de daño, puedes considerar cualquier 1 en los dados de daño como 2. Puedes coger los otros tipo de Versado en un elemento además de este como otra dote.",
				TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS));
		anadir(new DoteRequisitoCompetencia(TipoDote.VERSADO_EN_UN_ELEMENTO_FUEGO,
				"Los conjuros que lances ignoran la resistencia al daño de Fuego. Además cuando tires el daño de uno de tus conjuros que inflinja ese tipo de daño, puedes considerar cualquier 1 en los dados de daño como 2. Puedes coger los otros tipo de Versado en un elemento además de este como otra dote.",
				TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS));
		anadir(new DoteRequisitoCompetencia(TipoDote.VERSADO_EN_UN_ELEMENTO_RELAMPAGO,
				"Los conjuros que lances ignoran la resistencia al daño de Relámpago. Además cuando tires el daño de uno de tus conjuros que inflinja ese tipo de daño, puedes considerar cualquier 1 en los dados de daño como 2. Puedes coger los otros tipo de Versado en un elemento además de este como otra dote.",
				TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS));
		anadir(new DoteRequisitoCompetencia(TipoDote.VERSADO_EN_UN_ELEMENTO_TRUENO,
				"Los conjuros que lances ignoran la resistencia al daño de Trueno. Además cuando tires el daño de uno de tus conjuros que inflinja ese tipo de daño, puedes considerar cualquier 1 en los dados de daño como 2. Puedes coger los otros tipo de Versado en un elemento además de este como otra dote.",
				TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS));
		
		// Sin requisito
		anadir(new Dote(TipoDote.ACTOR,"Debido a tu habilidad para la imitación y el arte dramático. Recibes los beneficios siguientes:\n"
				+ "Tu puntuación de Carisma aumenta en 1, hasta un máximo de 20.\n"
				+ "Tienes ventaja en las pruebas de Carisma (Engaño) y Carima (Interpretación) que hagas para hacerte pasar por otra persona. Deberás marcar tu la ventaja.\n"
				+ "Puedes imitar el habla de otra persona o los sonidos que hacen otras criaturas. Debes haber oido hablar a la persona o los sonidos de la criatura durante al menos 1 minuto. Si quien te escucha vence en una prueba de Sabiduría (Perspicacioa) enfrentada a tu prueba de Carisma (Engaño), sabrá que se trata de una imitación."));
		anadir(new Dote(TipoDote.AFORTUNADO,"Posees una suerte inexplicable, que te sonríe siempre en el momento idóneo.\n"
				+ "Tienes 3 puntos de suerte. Cuando hagas una tirada de ataque, prueba de característica o tirada de salvación, podrás gastar 1 punto de suerte para tirar 1d20 adicional. Puedes elegir hacer esto después de haber hecho la tirada, pero antes de que se determine el resultado. Podrás escoger cuál de los 2d20 vas a usar en la tirada de ataque, prueba de característica o tirada de salvación. También puedes gastar 1 punto de suerte después de que se haga una tirada de ataque contra tí. Tira 1d20 y decide con que resultado quieres que se realzce el ataque, si con el dado del atacante o el tuyo. Si más de una criatura invierte puntos de suerte en influir en el resultado de la misma tirada, los puntos se cancelan unos con otros y no se tiran dados adicionales. Recuperas todos tus puntos de suerte tras finalizar un descanso largo."));
		anadir(new Dote(TipoDote.ALERTA,"Siempre estás atento al peligro. Obtienes los beneficios siguientes:\n"
				+ "Ganas un bonificador de +5 a la iniciativa.\n"
				+ "Mientras estés consciente no puedes ser sorpendido.\n"
				+ "Las criaturas que te ataquen sin que puedas verlas no reciben ventaja en sus tiradas de ataque por este motivo.\n"));
		anadir(new Dote(TipoDote.ATACANTE_A_LA_CARGA,"Cuando utilizas tu acción para Correr, puedes usar una acción adicional para hacer un ataque con arma cuerpo a cuerpo o empujar a una criatura.\n"
				+ "Si mueves al menos 10 pies en línea recta justo antes de emplear esta acción, podrás elegir entre ganar un bonificador de +5 a la tirada de daño del ataque (si optas por hacer el ataque cuerpo a cuerpo e impactas) o empujar el objetivo hasta 10 pies en dirección contraria a tí (si decides empujar y tienes éxito)"));
		anadir(new Dote(TipoDote.ATACANTE_SALVAJE,"Una vez por turno, cuando tiras el daño de un ataque con arma cuerpo a cuerpo, puedes repetir los dados de daño del arma y usar el resultado que prefieras."));
		anadir(new Dote(TipoDote.ATLETA_DESTREZA,"Has seguido un entrenamiento físico muy intenso, que te proporciona los beneficios siguientes:\n"
				+ "Tu puntuación de Destreza aumenta en 1, hasta un máximo de 20. Si no se puede aumentar la destreza se aumentará automaticamente la fuerza en 1 hasta un máximo de 20, si tampoco se puede, no se aumentará ninguna característica.\n"
				+ "Solo te cuesta 5 pies de movimiento levantarte cuando estás derribado.\n"
				+ "No necesitas invertir movimiento adicional para trepar.\n"
				+ "Puedes hacer un salto con carrerilla, tanto de altura como de longitud, tras haberte movido tan solo 5 pies, en lugar de 10 los 10 pies habituales."));
		anadir(new Dote(TipoDote.ATLETA_FUERZA,"Has seguido un entrenamiento físico muy intenso, que te proporciona los beneficios siguientes:\n"
				+ "Tu puntuación de Fuerza aumenta en 1, hasta un máximo de 20. Si no se puede aumentar la Fuerza se aumentará automaticamente la Destreza en 1 hasta un máximo de 20, si tampoco se puede, no se aumentará ninguna característica.\n"
				+ "Solo te cuesta 5 pies de movimiento levantarte cuando estás derribado.\n"
				+ "No necesitas invertir movimiento adicional para trepar.\n"
				+ "Puedes hacer un salto con carrerilla, tanto de altura como de longitud, tras haberte movido tan solo 5 pies, en lugar de 10 los 10 pies habituales."));
		anadir(new Dote(TipoDote.AZOTE_DE_MAGOS,"Has ensayado técnicas útiles para luchar en cuerpo a cuerpo contra lanzadores de conjuros, recibiendo los beneficios siguientes:\n"
				+ "Si una criatura que se encuentre a 5 pies o menos de tí lanza un conjuro, puedes utilizar tu reacción para hacer un aataque con arma cuerpo a cuerpo contra ella.\n"
				+ "Si inflinges daño a una criatura que se está concentrando en un conjuro, esta tendrá desventaja en las tiradas de salvación que haga con el fin de mantener la concentración. La desventaja tendrá que ser seleccionada por la criatura.\n"
				+ "Tienes ventaja en las tiradas de salvación contra los conjuros lanzados por criaturas que se encuentren a 5 pies o menos de tí. La ventaja tendrás que seleccionarla."));
		anadir(new Dote(TipoDote.CENTINELA,"Has dominado una serire de técnicas que te permiten aprovecharte de la más mínima brecha en las defensas de tu enemigo, por lo que recibes los siguientes beneficios:\n"
				+ "Si impactas a una criatura con un ataque de oportunidad, su velocidad desciende a 0 durante el resto del turno.\n"
				+ "Podrás hacer ataques de oportunidad incluso contra aquellas criaturas que realicen una acción de Destrabarse antes de salir de tu alcance.\n"
				+ "Cuando una criatura que se encuentre a 5 pies o menos de tí ataque a un objetivo que no seas tú ( y dicho objetivo no posea también esta dote), podrás usar tu reacción para realizar un ataque con arma cuerpo a cuerpo contra la criatura atacante."));
		anadir(new Dote(TipoDote.COMBATIENTE_CON_DOS_ARMAS,"Has dominado el combate con dos armas, obteniendo los beneficios siguientes:\n"
				+ "Recibes un +1 a tu CA cuando estás empuñando varias armas cuerpo a cuerpo, una en cada mano.\n"
				+ "Puedes combatir con dos armas incluso si las armas que estás utilizando no son ligeras.\n"
				+ "Puedes envainar y desenvainar dos armas a una mano en aquellas circustancias en las que antes solo podías hacerlo con una."));
		anadir(new Dote(TipoDote.COMBATIENTE_MONTADO,"Eres un enemigo muy peligroso cuando te encuentras sobre una montura. Obtendrás los beneficios siguientes mientras estés sobre una montura y no estes incapacitado"
				+ "Tienes ventaja en las tiradas de ataque cuerpo a cuerpo contra cualquier criatura que no esté montada y sea de un tamaño inferior al de tu montura.\n"
				+ "Puedes obligar a que un ataque cuyo objetivo original fuera tu montura te tenga como objetivo a ti en su lugar.\n"
				+ "Si tu montura es víctima de un efecto que le permita hacer una tirada de salvación de Destreza para recibir solo la mitad del daño no recibirá daño alguno si se tiene éxito en la tirada de salvación y solo la mitad si falla."));
		anadir(new Dote(TipoDote.DURO,"Tus puntos de golpe máximos aumentan en dos veces tu nivel en el momento en que eliges esta dote. Apartir de ese momento, cada vez que alcances un nuevo nivel tus puntos de golpe máximos aumentarán en 2 más."));
		anadir(new Dote(TipoDote.EXPERTO_EN_BALLESTAS,"Debido a una practica intesa con la ballesta, has conseguido los beneficios siguientes:\n"
				+ "Puedes ignorar la propiedad \"Recarga\" de las ballestas con las que eres competente. Será ignorada automaticamente."));
		anadir(new Dote(TipoDote.EXPLORADOR_DE_MAZMORRAS,"Estás alerta a las trampas ocultas y las pueras secretas habituales en muchas mazmorras, lo que te proporciona los beneficios siguientes:\n"
				+ "Tienes ventaja en las pruebas de Sabiduría (Percepción) e Inteligencia (Investigación) para detectar la presencia de puertas secretas. tendrás que selecionarla en el caso de que la prueba sea de este tipo.\n"
				+ "Posees ventaja en las tiradas de salvación para evitar o resistir trampas. Tendrás que seleccionarla antes de tirar la salvación.\n"
				+ "Tienes resistencia al daño causado por trampas.\n"
				+ "Al viajar a un ritmo rápido no sufres el penaliszador de -5 habitual a tu puntuación de Sabiduría (Percepción) pasiva."));
		//TODO ver como programo la dote específica de habilidoso. Posiblemente esto sea cedido a la interfaz.
		anadir(new Dote(TipoDote.HABILIDOSO,"Ganas competencia en cualquier combinación de tres habilidades o herramientas de tu elección"));
		anadir(new Dote(TipoDote.INICIADO_EN_LA_MAGIA_BARDO,"Aprendes dos trucos y un hechizo de tu elección de la clase de Bardo, el ultimo podrás usarlo 1 y para poder volver a lanzarlo tendrás que hacer un descanso largo. La aptitud para lanzarlo es de Carisma."));
		anadir(new Dote(TipoDote.INICIADO_EN_LA_MAGIA_BRUJO,"Aprendes dos trucos y un hechizo de tu elección de la clase de Brujo, el ultimo podrás usarlo 1 y para poder volver a lanzarlo tendrás que hacer un descanso largo. La aptitud para lanzarlo es de Carisma."));
		anadir(new Dote(TipoDote.INICIADO_EN_LA_MAGIA_CLERIGO,"Aprendes dos trucos y un hechizo de tu elección de la clase de Clérigo, el ultimo podrás usarlo 1 y para poder volver a lanzarlo tendrás que hacer un descanso largo. La aptitud para lanzarlo es de Sabiduría."));
		anadir(new Dote(TipoDote.INICIADO_EN_LA_MAGIA_DRUIDA,"Aprendes dos trucos y un hechizo de tu elección de la clase de Druida, el ultimo podrás usarlo 1 y para poder volver a lanzarlo tendrás que hacer un descanso largo. La aptitud para lanzarlo es de Sabiduría."));
		anadir(new Dote(TipoDote.INICIADO_EN_LA_MAGIA_HECHICERO,"Aprendes dos trucos y un hechizo de tu elección de la clase de Hechicero, el ultimo podrás usarlo 1 y para poder volver a lanzarlo tendrás que hacer un descanso largo. La aptitud para lanzarlo es de Carisma."));
		anadir(new Dote(TipoDote.INICIADO_EN_LA_MAGIA_MAGO,"Aprendes dos trucos y un hechizo de tu elección de la clase de Mago, el ultimo podrás usarlo 1 y para poder volver a lanzarlo tendrás que hacer un descanso largo. La aptitud para lanzarlo es de Inteligencia."));
		anadir(new Dote(TipoDote.LIGERAMENTE_ACORAZADO_DESTREZA,"Te has entrenado hasta dominar el combate en armaduras ligeras, obteniendo los beneficios siguientes:\n"
				+ "Tu puntuación de Destreza aumenta en 1 si no puede se aumentará automaticamente la de Fuerza como maximo alcanzando 20 en ambos casos y si tampoco puede no se aumentará ninguna.\n"
				+ "Ganas competencia en armaduras ligeras."));
		anadir(new Dote(TipoDote.LIGERAMENTE_ACORAZADO_FUERZA,"Te has entrenado hasta dominar el combate en armaduras ligeras, obteniendo los beneficios siguientes:\n"
				+ "Tu puntuación de Fuerza aumenta en 1 si no puede se aumentará automaticamente la de Destreza como maximo alcanzando 20 en ambos casos y si tampoco puede no se aumentará ninguna.\n"
				+ "Ganas competencia en armaduras ligeras."));
		anadir(new Dote(TipoDote.LINGUISTA,"Has estudiado idiomas y códigos, adquiriendo los beneficios siguientes:\n"
				+ "Tu puntuación de Inteligencia aumenta en 1, hasta un máximo de 20.\n"
				+ "Eres capaz de inventar códigos para cifrar mensajes escritos. Si agluien quiere descifrarlos tendrá tres opciones: que le enseñes cómo hacerlo, tener exito en una prueba de Inteligencia (CD tu puntuación de Inteligencia + tu modificador de competencia) o recurrir a la magia."));
		anadir(new Dote(TipoDote.MAESTRO_DE_ARMAS_FUERZA,"Has practicado intensamente con una gran variedad de armas, por lo que disfrutas de los beneficios siguientes:\n"
				+ "Tu puntuación de Fuerza aumenta en 1, hasta un máximo de 20. Si no puede se aumentará la Destreza en 1, hasta un máximo de 20, si tampoco puede, no se subirá ninguna característica.\n"
				+ "Ganas competencia con cuatro armas de tu elección. Podrás escoger cualquier arma sencilla o marcial."));
		anadir(new Dote(TipoDote.MAESTRO_DE_ARMAS_DESTREZA,"Has practicado intensamente con una gran variedad de armas, por lo que disfrutas de los beneficios siguientes:\n"
				+ "Tu puntuación de Destreza aumenta en 1, hasta un máximo de 20. Si no puede se aumentará la Fuerza en 1, hasta un máximo de 20, si tampoco puede, no se subirá ninguna característica.\n"
				+ "Ganas competencia con cuatro armas de tu elección. Podrás escoger cualquier arma sencilla o marcial."));
	}

	public BibliotecaDotes(List<Dote> listaDotes) {
		setListaDotes(listaDotes);
	}

	public BibliotecaDotes(BibliotecaDotes bibliotecaDotes) {
		setListaDotes(BibliotecaDotes.getListaDotes());
	}

	public static List<Dote> getListaDotes() {
		return listaDotes;
	}

	public void setListaDotes(List<Dote> listaDotes) {
		BibliotecaDotes.listaDotes = listaDotes;
	}

	public static Dote buscar(TipoDote doteBuscar) {
		if (doteBuscar == null) {
			throw new IllegalArgumentException("No se puede buscar una dote en la biblioteca que sea nula.");
		} else {
			if (!listaDotes.contains(new Dote(doteBuscar, "descripcion"))) {
				return null;
			} else {
				int index = -1;
				for (Dote dote : listaDotes) {
					if (dote.getTipoDote() == doteBuscar) {
						System.out.println("Encontrada");
						index = listaDotes.indexOf(dote);
					}
				}
				if (index != -1) {
					if (listaDotes.get(index) instanceof DoteRequisitoAtributo) {
						return new DoteRequisitoAtributo((DoteRequisitoAtributo) listaDotes.get(index));
					} else if (listaDotes.get(index) instanceof DoteRequisitoCompetencia) {
						return new DoteRequisitoCompetencia((DoteRequisitoCompetencia) listaDotes.get(index));
					} else if (listaDotes.get(index) instanceof Dote) {
						return new Dote(listaDotes.get(index));
					} else {
						return null;
					}
				} else {
					return null;
				}
			}
		}
	}

	private void anadir(Dote dote) {
		if (dote == null) {
			throw new IllegalArgumentException("No se puede añadir una dote nula a la biblioteca de dotes.");
		} else {
			if (getListaDotes().contains(dote)) {
				throw new IllegalArgumentException("La biblioteca de dotes ya contiene la dote.");
			} else {
				if (dote instanceof DoteRequisitoAtributo) {
					BibliotecaDotes.listaDotes.add(new DoteRequisitoAtributo((DoteRequisitoAtributo) dote));
				} else if (dote instanceof DoteRequisitoCompetencia) {
					BibliotecaDotes.listaDotes.add(new DoteRequisitoCompetencia((DoteRequisitoCompetencia) dote));
				} else if (dote instanceof Dote) {
					BibliotecaDotes.listaDotes.add(new Dote(dote));
				} else {
					throw new IllegalArgumentException("Tipo de dote no contemplada.");
				}
			}
		}
	}

}