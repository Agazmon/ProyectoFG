<?php
//Clase de conector que si que pinta las respuestas como JSON
class ConectorDB
{
    //Conector mysqli
    public static $conectorDB = null;
    //Constructor privado para evitar la instanciación
    private function __construct()
    {
    }
    //Conexión con la BD
    protected static function conectarDB()
    {
        try {
            if (is_null(ConectorDB::$conectorDB)) {
                ConectorDB::$conectorDB = new mysqli('PMYSQL163.dns-servicio.com', 'alex', '&Pyuo570', '9358941_bookit');
                if (ConectorDB::$conectorDB->connect_errno) {
                    UtilidadesJSON::mensajeExcepcion("Error al conectar con la Base de Datos");
                }
            }
        } catch (Exception $e) {
            UtilidadesJSON::mensajeExcepcion("Error al conectar con la Base de Datos");
        }
    }
    //Comprobar el login del usuario
    public static function conectarUsuario($email, $pass)
    {
        ConectorDB::conectarDB();
        $emailControl = ConectorDB::$conectorDB->real_escape_string($email);
        $passControl = ConectorDB::$conectorDB->real_escape_string($pass);
        $query = ConectorDB::$conectorDB->query("SELECT pass FROM usuario_restaurante WHERE id_restaurante =  (SELECT id_restaurante FROM restaurante WHERE correo LIKE '$email') LIMIT 1;");
        if ($query->num_rows != 0) {
            if ($fila = $query->fetch_row()) {
                if ($fila[0] == $passControl) {
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

    //Cancelación de la reserva, para ser consumido vía API
    public static function cancelarReserva($correoRestauranteReserva, $idReserva)
    {
        ConectorDB::conectarDB();
        $correoControl = ConectorDB::$conectorDB->real_escape_string($correoRestauranteReserva);
        $idControl = ConectorDB::$conectorDB->real_escape_string($idReserva);
        $resultado = ConectorDB::perteneceReservaRestaurante($correoControl, $idControl);
        if ($resultado) {
            $query = ConectorDB::$conectorDB->prepare("UPDATE reserva SET estado = 0 WHERE id_reserva = ?;");
            $query->bind_param('i', $idControl);
            try {
                $query->execute();
                UtilidadesJSON::devolverRespuesta(new Mensaje(TipoMensaje::$OK, "Reserva cancelada con exito"));
            } catch (mysqli_sql_exception $e) {
                UtilidadesJSON::devolverRespuesta(new Mensaje(TipoMensaje::$ERROR, "Error: Desconocido en la BBDD: " . $e->getCode()));
            }
        } else {
            UtilidadesJSON::devolverMensajeExcepcion("La reserva no pertenece al restaurante conectado");
        }
    }
    //Confirmación de la reserva, para ser consumido vía API
    public static function confirmarReserva($correoRestauranteReserva, $idReserva)
    {
        ConectorDB::conectarDB();
        $correoControl = ConectorDB::$conectorDB->real_escape_string($correoRestauranteReserva);
        $idControl = ConectorDB::$conectorDB->real_escape_string($idReserva);
        $resultado = ConectorDB::perteneceReservaRestaurante($correoControl, $idControl);
        if ($resultado) {
            $query = ConectorDB::$conectorDB->prepare("UPDATE reserva SET estado = 2 WHERE id_reserva = ?;");
            $query->bind_param('i', $idControl);
            try {
                $query->execute();
                UtilidadesJSON::devolverRespuesta(new Mensaje(TipoMensaje::$OK, "Reserva confirmada con exito"));
            } catch (mysqli_sql_exception $e) {
                UtilidadesJSON::devolverRespuesta(new Mensaje(TipoMensaje::$ERROR, "Error: Desconocido en la BBDD: " . $e->getCode()));
            }
        } else {
            UtilidadesJSON::devolverMensajeExcepcion("La reserva no pertenece al restaurante conectado");
        }
    }
    //Comprobación de que la reserva pertenece al restaurante solicitado, para que no puedan hacer peticiones a la API y realizar cualquier operación
    private static function perteneceReservaRestaurante($correoControl, $idControl)
    {
        $query = ConectorDB::$conectorDB->query("SELECT id_restaurante FROM restaurante WHERE correo LIKE '$correoControl' LIMIT 1;");
        $idRestauranteCorreo = '';
        $idRestauranteReserva = '';
        if ($query->num_rows != 0) {
            if ($fila = $query->fetch_row()) {
                $idRestauranteCorreo = $fila[0];
                $query->free();
            } else {
                UtilidadesJSON::devolverMensajeExcepcion("Usuario no encontrado");
            }
        } else {
            UtilidadesJSON::devolverMensajeExcepcion("Usuario no encontrado");
        }
        $query = ConectorDB::$conectorDB->query("SELECT id_restaurante FROM reserva WHERE id_reserva = $idControl LIMIT 1;");
        if ($query->num_rows != 0) {
            if ($fila = $query->fetch_row()) {
                $idRestauranteReserva = $fila[0];
                $query->free();
            } else {
                UtilidadesJSON::devolverMensajeExcepcion("Usuario no encontrado");
            }
        } else {
            UtilidadesJSON::devolverMensajeExcepcion("Usuario no encontrado");
        }
        if ($idRestauranteCorreo == $idRestauranteReserva) {
            return true;
        } else {
            UtilidadesJSON::devolverMensajeExcepcion("La reserva no pertenece al restaurante conectado");
        }
    }
}
?>
