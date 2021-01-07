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
						+ "Cuando estas escondido de una criatura y fallas un ataque con arma a distancia contra ella, el haber realizado este atauqe no revela tu ubicaci�n.\n"
						+ "La luz tenue no te provoca desventaja en las pruebas de Sabidur�a(Percepci�n) que dependen de la vista.",
				Atributo.DESTREZA));

		anadir(new DoteRequisitoAtributo(TipoDote.APRESADOR,
				"Has desarrollado las aptitudes necesarias para pelear bien a distancias extremadamente cortas. Obtienes los beneficios siguientes:\n"
						+ "Tienes ventaja en las tiradas de ataque contra una criatura a la que est�s agarrando.\n"
						+ "Puedes usar tu acci�n para intentar someter a un objetivo al que est�s agarrando. Para ello, haz otra prueba de agarrar. Si tienes �xito, tanto t� como la criatura estar�is apresados hasta que el agarre finalice.",
				Atributo.FUERZA));
		anadir(new DoteRequisitoAtributo(TipoDote.DUELISTA_DEFENSIVO,
				"Cuando est�s empu�ando un arma sutil con la que seas competente y otra criatura te impacte con un ataque cuerpo a cuerpo, podr�s utilizar tu reacci�n para sumar tu bonificador por competencia a tu CA a efectos de este ataque. Con suerte conseguiras que falle.",
				Atributo.DESTREZA));
		String descLanzadorRitual = "Has aprendido una serie de conjuros que puedes lanzar como rituales. Estos conjuros est�n escritos en un libro de rituales, que debes tener en las manos para poder lanzar cualquiera de ellos. Cuando escojas esta dote obtendr�s este libro, que contendr� dos conjuros de nivel 1 de tu elecci�n. La clase de la que tendr�s disponibles los hechizos est� definida por el nombre de la dote. Deben est�r marcados como ritual. La clase determinar� tambi�n la aptitud m�gica. Carisma para bardo brujo o hechicero, Sabidur�a para cl�rigo o druida e Inteligencia para Mago. En esta versi�n del programa no puedes a�adir nuevos hechizos al libro.";
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
				"Puedes invertir 10 minutos en inspirar a tus compa�eros, apuntalando su voluntad para luchar. Cuando hagas esto, escoge hasta seis criaturas amistosas (entre las que puedes encontrarte tu mismo) a 30 pies o menos de t� que puedan verte u oirte y sean capaces de entenderte.. Cada uno de estos objetivos recibe tantos puntos de golpe temporales como tu nivel + modificador por Carisma.\n Ninguna de las criaturas puede volver a recibir puntos de golpe temporales gracias a esta dote hasta que termine un descanso corto o largo.",
				Atributo.CARISMA));

		// DOTES CON REQUISITO DE COMPETENCIA.
		anadir(new DoteRequisitoCompetencia(TipoDote.LANZADOR_EN_COMBATE,
				"Has practicado c�mo lanzar conjuros en medio del combate, aprendiendo t�cnicas que te proporcionan los beneficios siguientes:\n"
						+ "Tienes ventaja en las tiradas de salvaci�n de Constituci�n que hagas para mantener la concentracion en un conjuro cuando recibes da�o.\n"
						+ "Puedes ejecutar los componentes som�ticos de tus conjuros incluso cuando empu�as armas o un escudo, en una o ambas manos.\n"
						+ "Cuando el movimiento de una criatura te permite hacer un ataque de oportunidad contra ella, puedes usar tu reacci�n para, en lugar de realizar este ataque, lanzar un conjuro contra la criatura. Dicho conjuro deber� tener un tiempo de lanzamiento de 1 acci�n y tener como objetivo una �nica criatura.",
				TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS));

		String descLanzadorPreciso = "Has aprendido varias t�cnicas que te permiten mejorar tus ataques con ciertos tipos de conjuros, recibiendo los siguientes beneficios: \n"
				+ "Cuando lances un conjuro que precise de una tirada de ataque, su alcance se duplica.\n"
				+ "Tus ataques de conjuros a distancia ignoran las coberturas media y tres cuartos.\n"
				+ "Aprendes un truco que requiera de una tirada de ataque. La clase escogida est� en el nombre de la dote. Tu aptitud m�gica para este truco depender� de la clase a la que pertenezca la lista en la que figuraba: Carisma para bardo, brujo o hechicero Sabidur�a para cl�rigo o druida e Inteligencia para Mago";
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
				"Eres capaz de emplear tu armadura para desviar golpes que mater�an a otros. Obtienes los beneficios siguientes:\n"
						+ "Tu puntuaci�n de Fuerza aumenta en 1, hasta un m�ximo de 20.\n"
						+ "Mientras est�s llevando armadura pesada, el da�o contundente, cortante y perforante de armas, no m�gicas que recibas se reduce en 3.",
				TipoCompetencia.ARMADURA_PESADA));
		anadir(new DoteRequisitoCompetencia(TipoDote.MODERADAMENTE_ACORAZADO_DESTREZA,
				"Te has entrenado hasta dominar el combate en armaduras medias y escudos, obteniendo los beneficios siguientes:\n"
						+ "Tu puntuaci�n de Destreza aumenta en 1, hasta un m�ximo de 20. En el caso de no poder aumentar se aumentar� la fuerza y en caso de no poder aumentar ninguna de las dos, no se aumentar� ninguna.",
				TipoCompetencia.ARMADURA_LIGERA));
		anadir(new DoteRequisitoCompetencia(TipoDote.MODERADAMENTE_ACORAZADO_FUERZA,
				"Te has entrenado hasta dominar el combate en armaduras medias y escudos, obteniendo los beneficios siguientes:\n"
						+ "Tu puntuaci�n de Fuerza aumenta en 1, hasta un m�ximo de 20. En el caso de no poder aumentar se aumentar� la fuerza y en caso de no poder aumentar ninguna de las dos, no se aumentar� ninguna.",
				TipoCompetencia.ARMADURA_LIGERA));
		anadir(new DoteRequisitoCompetencia(TipoDote.MUY_ACORAZADO,
				"Te has entrenado hasta dominar el combate en armaduras pesadas, obteniendo los beneficios siguientes:\n"
						+ "Tu puntuaci�n de Fuerza aumenta en 1, hasta un m�ximo de 20.\n"
						+ "Ganas competencia con armaduras pesadas.",
				TipoCompetencia.ARMADURA_MEDIA));
		anadir(new DoteRequisitoCompetencia(TipoDote.VERSADO_EN_UN_ELEMENTO_ACIDO,
				"Los conjuros que lances ignoran la resistencia al da�o de �cido. Adem�s cuando tires el da�o de uno de tus conjuros que inflinja ese tipo de da�o, puedes considerar cualquier 1 en los dados de da�o como 2. Puedes coger los otros tipo de Versado en un elemento adem�s de este como otra dote.",
				TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS));
		anadir(new DoteRequisitoCompetencia(TipoDote.VERSADO_EN_UN_ELEMENTO_FRIO,
				"Los conjuros que lances ignoran la resistencia al da�o de Fr�o. Adem�s cuando tires el da�o de uno de tus conjuros que inflinja ese tipo de da�o, puedes considerar cualquier 1 en los dados de da�o como 2. Puedes coger los otros tipo de Versado en un elemento adem�s de este como otra dote.",
				TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS));
		anadir(new DoteRequisitoCompetencia(TipoDote.VERSADO_EN_UN_ELEMENTO_FUEGO,
				"Los conjuros que lances ignoran la resistencia al da�o de Fuego. Adem�s cuando tires el da�o de uno de tus conjuros que inflinja ese tipo de da�o, puedes considerar cualquier 1 en los dados de da�o como 2. Puedes coger los otros tipo de Versado en un elemento adem�s de este como otra dote.",
				TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS));
		anadir(new DoteRequisitoCompetencia(TipoDote.VERSADO_EN_UN_ELEMENTO_RELAMPAGO,
				"Los conjuros que lances ignoran la resistencia al da�o de Rel�mpago. Adem�s cuando tires el da�o de uno de tus conjuros que inflinja ese tipo de da�o, puedes considerar cualquier 1 en los dados de da�o como 2. Puedes coger los otros tipo de Versado en un elemento adem�s de este como otra dote.",
				TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS));
		anadir(new DoteRequisitoCompetencia(TipoDote.VERSADO_EN_UN_ELEMENTO_TRUENO,
				"Los conjuros que lances ignoran la resistencia al da�o de Trueno. Adem�s cuando tires el da�o de uno de tus conjuros que inflinja ese tipo de da�o, puedes considerar cualquier 1 en los dados de da�o como 2. Puedes coger los otros tipo de Versado en un elemento adem�s de este como otra dote.",
				TipoCompetencia.CAPACIDAD_LANZAR_HECHIZOS));
		
		// Sin requisito
		anadir(new Dote(TipoDote.ACTOR,"Debido a tu habilidad para la imitaci�n y el arte dram�tico. Recibes los beneficios siguientes:\n"
				+ "Tu puntuaci�n de Carisma aumenta en 1, hasta un m�ximo de 20.\n"
				+ "Tienes ventaja en las pruebas de Carisma (Enga�o) y Carima (Interpretaci�n) que hagas para hacerte pasar por otra persona. Deber�s marcar tu la ventaja.\n"
				+ "Puedes imitar el habla de otra persona o los sonidos que hacen otras criaturas. Debes haber oido hablar a la persona o los sonidos de la criatura durante al menos 1 minuto. Si quien te escucha vence en una prueba de Sabidur�a (Perspicacioa) enfrentada a tu prueba de Carisma (Enga�o), sabr� que se trata de una imitaci�n."));
		anadir(new Dote(TipoDote.AFORTUNADO,"Posees una suerte inexplicable, que te sonr�e siempre en el momento id�neo.\n"
				+ "Tienes 3 puntos de suerte. Cuando hagas una tirada de ataque, prueba de caracter�stica o tirada de salvaci�n, podr�s gastar 1 punto de suerte para tirar 1d20 adicional. Puedes elegir hacer esto despu�s de haber hecho la tirada, pero antes de que se determine el resultado. Podr�s escoger cu�l de los 2d20 vas a usar en la tirada de ataque, prueba de caracter�stica o tirada de salvaci�n. Tambi�n puedes gastar 1 punto de suerte despu�s de que se haga una tirada de ataque contra t�. Tira 1d20 y decide con que resultado quieres que se realzce el ataque, si con el dado del atacante o el tuyo. Si m�s de una criatura invierte puntos de suerte en influir en el resultado de la misma tirada, los puntos se cancelan unos con otros y no se tiran dados adicionales. Recuperas todos tus puntos de suerte tras finalizar un descanso largo."));
		anadir(new Dote(TipoDote.ALERTA,"Siempre est�s atento al peligro. Obtienes los beneficios siguientes:\n"
				+ "Ganas un bonificador de +5 a la iniciativa.\n"
				+ "Mientras est�s consciente no puedes ser sorpendido.\n"
				+ "Las criaturas que te ataquen sin que puedas verlas no reciben ventaja en sus tiradas de ataque por este motivo.\n"));
		anadir(new Dote(TipoDote.ATACANTE_A_LA_CARGA,"Cuando utilizas tu acci�n para Correr, puedes usar una acci�n adicional para hacer un ataque con arma cuerpo a cuerpo o empujar a una criatura.\n"
				+ "Si mueves al menos 10 pies en l�nea recta justo antes de emplear esta acci�n, podr�s elegir entre ganar un bonificador de +5 a la tirada de da�o del ataque (si optas por hacer el ataque cuerpo a cuerpo e impactas) o empujar el objetivo hasta 10 pies en direcci�n contraria a t� (si decides empujar y tienes �xito)"));
		anadir(new Dote(TipoDote.ATACANTE_SALVAJE,"Una vez por turno, cuando tiras el da�o de un ataque con arma cuerpo a cuerpo, puedes repetir los dados de da�o del arma y usar el resultado que prefieras."));
		anadir(new Dote(TipoDote.ATLETA_DESTREZA,"Has seguido un entrenamiento f�sico muy intenso, que te proporciona los beneficios siguientes:\n"
				+ "Tu puntuaci�n de Destreza aumenta en 1, hasta un m�ximo de 20. Si no se puede aumentar la destreza se aumentar� automaticamente la fuerza en 1 hasta un m�ximo de 20, si tampoco se puede, no se aumentar� ninguna caracter�stica.\n"
				+ "Solo te cuesta 5 pies de movimiento levantarte cuando est�s derribado.\n"
				+ "No necesitas invertir movimiento adicional para trepar.\n"
				+ "Puedes hacer un salto con carrerilla, tanto de altura como de longitud, tras haberte movido tan solo 5 pies, en lugar de 10 los 10 pies habituales."));
		anadir(new Dote(TipoDote.ATLETA_FUERZA,"Has seguido un entrenamiento f�sico muy intenso, que te proporciona los beneficios siguientes:\n"
				+ "Tu puntuaci�n de Fuerza aumenta en 1, hasta un m�ximo de 20. Si no se puede aumentar la Fuerza se aumentar� automaticamente la Destreza en 1 hasta un m�ximo de 20, si tampoco se puede, no se aumentar� ninguna caracter�stica.\n"
				+ "Solo te cuesta 5 pies de movimiento levantarte cuando est�s derribado.\n"
				+ "No necesitas invertir movimiento adicional para trepar.\n"
				+ "Puedes hacer un salto con carrerilla, tanto de altura como de longitud, tras haberte movido tan solo 5 pies, en lugar de 10 los 10 pies habituales."));
		anadir(new Dote(TipoDote.AZOTE_DE_MAGOS,"Has ensayado t�cnicas �tiles para luchar en cuerpo a cuerpo contra lanzadores de conjuros, recibiendo los beneficios siguientes:\n"
				+ "Si una criatura que se encuentre a 5 pies o menos de t� lanza un conjuro, puedes utilizar tu reacci�n para hacer un aataque con arma cuerpo a cuerpo contra ella.\n"
				+ "Si inflinges da�o a una criatura que se est� concentrando en un conjuro, esta tendr� desventaja en las tiradas de salvaci�n que haga con el fin de mantener la concentraci�n. La desventaja tendr� que ser seleccionada por la criatura.\n"
				+ "Tienes ventaja en las tiradas de salvaci�n contra los conjuros lanzados por criaturas que se encuentren a 5 pies o menos de t�. La ventaja tendr�s que seleccionarla."));
		anadir(new Dote(TipoDote.CENTINELA,"Has dominado una serire de t�cnicas que te permiten aprovecharte de la m�s m�nima brecha en las defensas de tu enemigo, por lo que recibes los siguientes beneficios:\n"
				+ "Si impactas a una criatura con un ataque de oportunidad, su velocidad desciende a 0 durante el resto del turno.\n"
				+ "Podr�s hacer ataques de oportunidad incluso contra aquellas criaturas que realicen una acci�n de Destrabarse antes de salir de tu alcance.\n"
				+ "Cuando una criatura que se encuentre a 5 pies o menos de t� ataque a un objetivo que no seas t� ( y dicho objetivo no posea tambi�n esta dote), podr�s usar tu reacci�n para realizar un ataque con arma cuerpo a cuerpo contra la criatura atacante."));
		anadir(new Dote(TipoDote.COMBATIENTE_CON_DOS_ARMAS,"Has dominado el combate con dos armas, obteniendo los beneficios siguientes:\n"
				+ "Recibes un +1 a tu CA cuando est�s empu�ando varias armas cuerpo a cuerpo, una en cada mano.\n"
				+ "Puedes combatir con dos armas incluso si las armas que est�s utilizando no son ligeras.\n"
				+ "Puedes envainar y desenvainar dos armas a una mano en aquellas circustancias en las que antes solo pod�as hacerlo con una."));
		anadir(new Dote(TipoDote.COMBATIENTE_MONTADO,"Eres un enemigo muy peligroso cuando te encuentras sobre una montura. Obtendr�s los beneficios siguientes mientras est�s sobre una montura y no estes incapacitado"
				+ "Tienes ventaja en las tiradas de ataque cuerpo a cuerpo contra cualquier criatura que no est� montada y sea de un tama�o inferior al de tu montura.\n"
				+ "Puedes obligar a que un ataque cuyo objetivo original fuera tu montura te tenga como objetivo a ti en su lugar.\n"
				+ "Si tu montura es v�ctima de un efecto que le permita hacer una tirada de salvaci�n de Destreza para recibir solo la mitad del da�o no recibir� da�o alguno si se tiene �xito en la tirada de salvaci�n y solo la mitad si falla."));
		anadir(new Dote(TipoDote.DURO,"Tus puntos de golpe m�ximos aumentan en dos veces tu nivel en el momento en que eliges esta dote. Apartir de ese momento, cada vez que alcances un nuevo nivel tus puntos de golpe m�ximos aumentar�n en 2 m�s."));
		anadir(new Dote(TipoDote.EXPERTO_EN_BALLESTAS,"Debido a una practica intesa con la ballesta, has conseguido los beneficios siguientes:\n"
				+ "Puedes ignorar la propiedad \"Recarga\" de las ballestas con las que eres competente. Ser� ignorada automaticamente."));
		anadir(new Dote(TipoDote.EXPLORADOR_DE_MAZMORRAS,"Est�s alerta a las trampas ocultas y las pueras secretas habituales en muchas mazmorras, lo que te proporciona los beneficios siguientes:\n"
				+ "Tienes ventaja en las pruebas de Sabidur�a (Percepci�n) e Inteligencia (Investigaci�n) para detectar la presencia de puertas secretas. tendr�s que selecionarla en el caso de que la prueba sea de este tipo.\n"
				+ "Posees ventaja en las tiradas de salvaci�n para evitar o resistir trampas. Tendr�s que seleccionarla antes de tirar la salvaci�n.\n"
				+ "Tienes resistencia al da�o causado por trampas.\n"
				+ "Al viajar a un ritmo r�pido no sufres el penaliszador de -5 habitual a tu puntuaci�n de Sabidur�a (Percepci�n) pasiva."));
		//TODO ver como programo la dote espec�fica de habilidoso. Posiblemente esto sea cedido a la interfaz.
		anadir(new Dote(TipoDote.HABILIDOSO,"Ganas competencia en cualquier combinaci�n de tres habilidades o herramientas de tu elecci�n"));
		anadir(new Dote(TipoDote.INICIADO_EN_LA_MAGIA_BARDO,"Aprendes dos trucos y un hechizo de tu elecci�n de la clase de Bardo, el ultimo podr�s usarlo 1 y para poder volver a lanzarlo tendr�s que hacer un descanso largo. La aptitud para lanzarlo es de Carisma."));
		anadir(new Dote(TipoDote.INICIADO_EN_LA_MAGIA_BRUJO,"Aprendes dos trucos y un hechizo de tu elecci�n de la clase de Brujo, el ultimo podr�s usarlo 1 y para poder volver a lanzarlo tendr�s que hacer un descanso largo. La aptitud para lanzarlo es de Carisma."));
		anadir(new Dote(TipoDote.INICIADO_EN_LA_MAGIA_CLERIGO,"Aprendes dos trucos y un hechizo de tu elecci�n de la clase de Cl�rigo, el ultimo podr�s usarlo 1 y para poder volver a lanzarlo tendr�s que hacer un descanso largo. La aptitud para lanzarlo es de Sabidur�a."));
		anadir(new Dote(TipoDote.INICIADO_EN_LA_MAGIA_DRUIDA,"Aprendes dos trucos y un hechizo de tu elecci�n de la clase de Druida, el ultimo podr�s usarlo 1 y para poder volver a lanzarlo tendr�s que hacer un descanso largo. La aptitud para lanzarlo es de Sabidur�a."));
		anadir(new Dote(TipoDote.INICIADO_EN_LA_MAGIA_HECHICERO,"Aprendes dos trucos y un hechizo de tu elecci�n de la clase de Hechicero, el ultimo podr�s usarlo 1 y para poder volver a lanzarlo tendr�s que hacer un descanso largo. La aptitud para lanzarlo es de Carisma."));
		anadir(new Dote(TipoDote.INICIADO_EN_LA_MAGIA_MAGO,"Aprendes dos trucos y un hechizo de tu elecci�n de la clase de Mago, el ultimo podr�s usarlo 1 y para poder volver a lanzarlo tendr�s que hacer un descanso largo. La aptitud para lanzarlo es de Inteligencia."));
		anadir(new Dote(TipoDote.LIGERAMENTE_ACORAZADO_DESTREZA,"Te has entrenado hasta dominar el combate en armaduras ligeras, obteniendo los beneficios siguientes:\n"
				+ "Tu puntuaci�n de Destreza aumenta en 1 si no puede se aumentar� automaticamente la de Fuerza como maximo alcanzando 20 en ambos casos y si tampoco puede no se aumentar� ninguna.\n"
				+ "Ganas competencia en armaduras ligeras."));
		anadir(new Dote(TipoDote.LIGERAMENTE_ACORAZADO_FUERZA,"Te has entrenado hasta dominar el combate en armaduras ligeras, obteniendo los beneficios siguientes:\n"
				+ "Tu puntuaci�n de Fuerza aumenta en 1 si no puede se aumentar� automaticamente la de Destreza como maximo alcanzando 20 en ambos casos y si tampoco puede no se aumentar� ninguna.\n"
				+ "Ganas competencia en armaduras ligeras."));
		anadir(new Dote(TipoDote.LINGUISTA,"Has estudiado idiomas y c�digos, adquiriendo los beneficios siguientes:\n"
				+ "Tu puntuaci�n de Inteligencia aumenta en 1, hasta un m�ximo de 20.\n"
				+ "Eres capaz de inventar c�digos para cifrar mensajes escritos. Si agluien quiere descifrarlos tendr� tres opciones: que le ense�es c�mo hacerlo, tener exito en una prueba de Inteligencia (CD tu puntuaci�n de Inteligencia + tu modificador de competencia) o recurrir a la magia."));
		anadir(new Dote(TipoDote.MAESTRO_DE_ARMAS_FUERZA,"Has practicado intensamente con una gran variedad de armas, por lo que disfrutas de los beneficios siguientes:\n"
				+ "Tu puntuaci�n de Fuerza aumenta en 1, hasta un m�ximo de 20. Si no puede se aumentar� la Destreza en 1, hasta un m�ximo de 20, si tampoco puede, no se subir� ninguna caracter�stica.\n"
				+ "Ganas competencia con cuatro armas de tu elecci�n. Podr�s escoger cualquier arma sencilla o marcial."));
		anadir(new Dote(TipoDote.MAESTRO_DE_ARMAS_DESTREZA,"Has practicado intensamente con una gran variedad de armas, por lo que disfrutas de los beneficios siguientes:\n"
				+ "Tu puntuaci�n de Destreza aumenta en 1, hasta un m�ximo de 20. Si no puede se aumentar� la Fuerza en 1, hasta un m�ximo de 20, si tampoco puede, no se subir� ninguna caracter�stica.\n"
				+ "Ganas competencia con cuatro armas de tu elecci�n. Podr�s escoger cualquier arma sencilla o marcial."));
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
			throw new IllegalArgumentException("No se puede a�adir una dote nula a la biblioteca de dotes.");
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