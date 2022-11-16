
    <?php
    //Clase de conector que devuelve las cadenas en lugar de pintarlas en el documento.
    class ConectorApp
    {
        //Conector mysqli
        public static $conectorApp = null;
        //Constructor privado para no poder instanciarlo
        private function __construct()
        {
        }
        //Conexión con la BD
        protected static function conectarDB()
        {
            try {
                if (is_null(ConectorApp::$conectorApp)) {
                    ConectorApp::$conectorApp = new mysqli('PMYSQL163.dns-servicio.com', 'alex', '&Pyuo570', '9358941_bookit');
                    if (ConectorApp::$conectorApp->connect_errno) {
                        return UtilidadesJSON::mensajeExcepcion("Error al conectar con la Base de Datos");
                    }
                }
            } catch (Exception $e) {
                return UtilidadesJSON::mensajeExcepcion("Error al conectar con la Base de Datos");
            }
        }
        //Comprobar el login del usuario solicitado
        public static function conectarUsuario($email, $pass){
            ConectorApp::conectarDB();
            $emailControl = ConectorApp::$conectorApp->real_escape_string($email);
            $passControl = ConectorApp::$conectorApp->real_escape_string($pass);
            $query = ConectorApp::$conectorApp->query("SELECT pass FROM usuario_restaurante WHERE id_restaurante =  (SELECT id_restaurante FROM restaurante WHERE correo LIKE '$emailControl') LIMIT 1;");
            if ($query->num_rows != 0) {
                if ($fila = $query->fetch_row()) {
                    if($fila[0]==$passControl) {
                        $query->free();
                        return new Mensaje(TipoMensaje::$OK,"Usuario encontrado.");
                    } else{
                        return UtilidadesJSON::devolverMensajeExcepcion("Contraseña incorrecta");
                    }
                } else{
                    return UtilidadesJSON::devolverMensajeExcepcion("Usuario no encontrado");
                }
            } else{
                return UtilidadesJSON::devolverMensajeExcepcion("Usuario no encontrado");
            }
        }
        //Obtener los datos del restaurante
        public static function obtenerDatosRestaurante($email){
            ConectorApp::conectarDB();
            $emailControl = ConectorApp::$conectorApp->real_escape_string($email);
            $query = ConectorApp::$conectorApp->query("SELECT nombre,id_restaurante FROM restaurante WHERE correo LIKE '$emailControl' LIMIT 1;");
            if ($query->num_rows != 0) {
                if ($fila = $query->fetch_row()) {
                    $query->free();
                    return $fila;    
                } else{
                    return UtilidadesJSON::devolverMensajeExcepcion("Datos no encontrados");
                }
            } else{
                return UtilidadesJSON::devolverMensajeExcepcion("Datos no encontrados");
            }
        }
        //Obtiene las reservas del restaurante
        public static function getReservasRestaurante($idRest){
            $respuesta = ConectorApp::conectarDB()!=null;
            if($respuesta != null) return $respuesta;
            $idRestControl = ConectorApp::$conectorApp->real_escape_string($idRest);
            $query = ConectorApp::$conectorApp->query("SELECT c.nombre, c.apellidos, c.telefono, r.id_reserva, r.dia, r.hora, r.estado, r.num_personas FROM reserva AS r JOIN cliente as c ON c.id_cliente=r.id_cliente WHERE r.dia >= DATE(NOW()) AND r.id_restaurante = $idRestControl ORDER BY r.dia ASC, r.hora ASC;");
            if ($query->num_rows != 0) {
                $reservas = [];
                while ($fila = $query->fetch_row()) {
                    array_push($reservas, new Reserva(new Usuario($fila[0], $fila[1], $fila[2]), $fila[3], $fila[4], $fila[5], $fila[6], $fila[7]));
                }
                $query->free();
                return new Reservas($reservas);
            } else {
                return UtilidadesJSON::mensajeExcepcion("No se ha encontrado ningúna reserva a nombre del usuario.");
            }
        }
        

    }
    ?>
