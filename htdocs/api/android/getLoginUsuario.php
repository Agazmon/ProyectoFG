<?php
//End-point de la api para comprobar el login del usuario
header("Content-type: application/json");
require_once('autoload.php');
autoload(null);
comprobarVariables();
function comprobarVariables()
{
    try {
        if (!isset($_GET['user']) or !isset($_GET['pass'])) {
            UtilidadesJSON::devolverRespuesta(new Mensaje(TipoMensaje::$ERROR, addslashes('Usuario o contraseña no recibido')));
        } else {
            //Conectar usuario
            ConectorDB::conectarUsuario($_GET['user'], $_GET['pass']);
        }
    } catch (Exception $e) {
        UtilidadesJSON::mensajeExcepcion($e->getMessage);
    }
}
?>
