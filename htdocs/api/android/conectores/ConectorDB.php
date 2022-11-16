<?php

// Clase conectora entre PHP y la BD
class ConectorDB
{
    // Conector mysqli
    public static $conectorDB = null;
    //Constructor privado para no poder instanciarlo
    private function __construct()
    {
    }
    // Función para conectar con la BD
    protected static function conectarDB()
    {
        try {
            if (is_null(ConectorDB::$conectorDB)) {
                ConectorDB::$conectorDB = new mysqli('PMYSQL163.dns-servicio.com', 'alex', '&Pyuo570', '9358941_bookit');
                ConectorDB::$conectorDB->set_charset('utf8');
                if (ConectorDB::$conectorDB->connect_errno) {
                    UtilidadesJSON::mensajeExcepcion("Error al conectar con la Base de Datos");
                }
            }
        } catch (Exception $e) {
            UtilidadesJSON::mensajeExcepcion("Error al conectar con la Base de Datos");
        }
    }
    //Función para comprobar el login del usuario, la contraseña ya está cifrada por sha256, ya que se hace en el cliente
    public static function conectarUsuario($usuario, $pass)
    {
        ConectorDB::conectarDB();
        $usuarioControl = ConectorDB::$conectorDB->real_escape_string($usuario);
        $passControl = ConectorDB::$conectorDB->real_escape_string($pass);
        $query = ConectorDB::$conectorDB->query("SELECT user, pass FROM usuario WHERE user LIKE '$usuarioControl' LIMIT 1");
        if ($query->num_rows != 0) {
            if ($fila = $query->fetch_row()) {
                if ($fila[1] == $passControl) {
                    UtilidadesJSON::devolverRespuesta(new Mensaje(TipoMensaje::$OK, "Usuario encontrado."));
                    $query->free();
                } else {
                    UtilidadesJSON::mensajeExcepcion("Contraseña incorrecta");
                }
            } else {
                UtilidadesJSON::mensajeExcepcion("Usuario no encontrado");
            }
        } else {
            UtilidadesJSON::mensajeExcepcion("Usuario no encontrado");
        }
    }
    //Función para buscar un restaurante por nombre, devuelve un objeto JSON con todos los restaurantes encontrados
    public static function buscarRestaurante($nombreRestaurante)
    {
        ConectorDB::conectarDB();
        $nombreRestauranteControl = ConectorDB::$conectorDB->real_escape_string($nombreRestaurante);
        $query = ConectorDB::$conectorDB->query("SELECT nombre, localizacion, telefono FROM restaurante WHERE nombre LIKE '%$nombreRestauranteControl%' AND cod_estado = 1");
        if ($query->num_rows != 0) {
            $restaurantes = [];
            while ($fila = $query->fetch_row()) {
                array_push($restaurantes, new RestauranteBusqueda($fila[0], $fila[1], $fila[2]));
            }
            $query->free();
            UtilidadesJSON::devolverRespuesta(new Mensaje(TipoMensaje::$INFO, $restaurantes));
        } else {
            UtilidadesJSON::mensajeExcepcion("No se ha encontrado ningún restaurante con el nombre solicitado.");
        }
    }
    //FUnción que dada la información de un restaurante devuelve su horario del ldía de la semana solicitado
    public static function consultarHorario($nombreRestaurante, $telefono, $diaSemana)
    {
        ConectorDB::conectarDB();
        $nombreRestauranteControl = ConectorDB::$conectorDB->real_escape_string($nombreRestaurante);
        $diaSemanaControl = ConectorDB::$conectorDB->real_escape_string($diaSemana);
        $telefonoControl = ConectorDB::$conectorDB->real_escape_string($telefono);
        $query = ConectorDB::$conectorDB->query("SELECT h.apertura, h.cierre FROM restaurante r JOIN horarios_restaurante h ON r.id_restaurante = h.id_restaurante WHERE r.nombre LIKE '$nombreRestauranteControl' AND r.telefono = $telefonoControl AND h.dia_semana = $diaSemanaControl;");
        if ($query->num_rows != 0) {
            $fila = $query->fetch_row();
            $apertura = $fila[0];
            sscanf($apertura, "%d:%d:%d", $horaApertura, $minutos, $segundos);
            $cierre = $fila[1];
            sscanf($cierre, "%d:%d:%d", $horaCierre, $minutosCierre, $segundosCierre);
            $horario = array("apertura" => $horaApertura, "cierre" => $horaCierre);
            $query->free();
            UtilidadesJSON::devolverRespuesta(new Mensaje(TipoMensaje::$INFO, ($horario)));
        } else {
            UtilidadesJSON::mensajeExcepcion("El restaurante no abre el día solicitado.");
        }
    }
    //Función que dados los datos realiza la reserva a nombre del usuario indicado
    public static function realizarReserva($usuarioReserva, $restauranteReserva, $telefonoRestauranteReserva, $diaReserva, $horaReserva, $numComensales)
    {
        ConectorDB::conectarDB();
        //Control
        $usuControl     = ConectorDB::$conectorDB->real_escape_string($usuarioReserva);
        $restControl    = ConectorDB::$conectorDB->real_escape_string($restauranteReserva);
        $telControl     = ConectorDB::$conectorDB->real_escape_string($telefonoRestauranteReserva);
        $diaControl     = ConectorDB::$conectorDB->real_escape_string($diaReserva);
        $horaControl    = ConectorDB::$conectorDB->real_escape_string($horaReserva);
        $numControl     = ConectorDB::$conectorDB->real_escape_string($numComensales);
        $diaHora = date_parse($diaReserva . ' ' . $horaControl);
        $hoy = getdate();


        //Comprobar limitaciones
        //Comprobar que la hora no es anterior a la actual
        if ($diaHora["day"] == $hoy["mday"] && $diaHora["hour"] < $hoy["hours"] + 3) {
            UtilidadesJSON::mensajeExcepcion("Error: No se puede reservar para antes de 3 horas de la hora actual.");
        }
        //Comprobar si el cliente tiene ya una reserva activa para la misma hora

        //Consultar id_usuario
        $query = ConectorDB::$conectorDB->query("SELECT id_cliente FROM usuario WHERE user LIKE '$usuControl' LIMIT 1;");
        if ($query->num_rows == 0) {
            UtilidadesJSON::mensajeExcepcion("Error: No se ha encontrado el usuario para realizar la reserva.");
        } else {
            $fila = $query->fetch_row();
            $idUsuario = $fila[0];
        }
        $query->free_result();
        //Consultar id_restaurante
        $query = ConectorDB::$conectorDB->query("SELECT id_restaurante,capacidad FROM restaurante WHERE nombre LIKE '$restControl' AND telefono LIKE '$telControl';");
        if ($query->num_rows == 0) {
            UtilidadesJSON::mensajeExcepcion("Error: No se ha encontrado el restaurante para realizar la reserva.");
        } else {
            $fila = $query->fetch_row();
            $idRest = $fila[0];
            $capacidad = $fila[1];
        }
        $query->free_result();
        //Comprobar si hay sitio para la hora
        $query = ConectorDB::$conectorDB->query("SELECT  sum(num_personas) FROM reserva WHERE id_restaurante = $idRest AND hora = '$horaControl' AND dia = '$diaControl';");
        if ($query->num_rows > 0) {
            $fila = $query->fetch_row();
            $numComensalesHora = $fila[0];
            if (intval($numComensalesHora) + intval($numControl) > intval($capacidad)) {
                UtilidadesJSON::mensajeExcepcion("Error: La reserva supera la capacidad de reserva del restaurante para esa hora.");
            }
        }
        $query->free_result();
        //Realizar reserva
        $query = ConectorDB::$conectorDB->prepare("INSERT INTO reserva VALUES(null,?,?,DATE(?),?,1,?);");
        $query->bind_param('iissi', $idUsuario, $idRest, $diaControl, $horaControl, $numControl);
        try {
            $query->execute();
        } catch (mysqli_sql_exception $e) {
            if ($e->getCode() == 1062) {
                UtilidadesJSON::devolverRespuesta(new Mensaje(TipoMensaje::$ERROR, "Error: El cliente, ya tiene una reserva hecha para esta configuración"));
            } else {
                UtilidadesJSON::devolverRespuesta(new Mensaje(TipoMensaje::$ERROR, "Error: Desconocido en la BBDD"));
            }
        }
        if (!$query) {
            UtilidadesJSON::devolverRespuesta(new Mensaje(TipoMensaje::$ERROR, "Error: No se ha podido realizar tu reserva"));
        } else {
            UtilidadesJSON::devolverRespuesta(new Mensaje(TipoMensaje::$OK, "¡BookIt!"));
        }
        $query->close();
    }
    //Función que devuelve las reservas de un usuario en caso de tenerlas
    public static function getReservasUsuario($usuario)
    {
        ConectorDB::conectarDB();
        $usuarioControl = ConectorDB::$conectorDB->real_escape_string($usuario);
        $query = ConectorDB::$conectorDB->query("SELECT rest.nombre, r.id_reserva, r.dia, r.hora, r.estado, r.num_personas, rest.logo FROM reserva AS r JOIN restaurante AS rest ON r.id_restaurante = rest.id_restaurante WHERE id_cliente = (SELECT id_cliente FROM usuario WHERE user LIKE '$usuarioControl') ORDER BY dia ASC, hora ASC;");
        if ($query->num_rows != 0) {
            $reservas = [];
            while ($fila = $query->fetch_row()) {
                array_push($reservas, new ReservaCard($fila[0], $fila[1], $fila[2], $fila[3], $fila[4], $fila[5], $fila[5]));
            }
            $query->free();
            UtilidadesJSON::devolverRespuesta(new Mensaje(TipoMensaje::$INFO, ($reservas)));
        } else {
            UtilidadesJSON::mensajeExcepcion("No se ha encontrado ningúna reserva a nombre del usuario.");
        }
    }
}
?>
