<?php
//End-point de la api para confirmar una reserva
header('Access-Control-Allow-Origin: *');
header("Content-type: application/json");
require_once('autoload.php');
autoload(null);
comprobarVariables();
function comprobarVariables()
{
    try {
        if (!isset($_GET['user']) or !isset($_GET['idReserva'])) {
            UtilidadesJSON::devolverRespuesta(new Mensaje(TipoMensaje::$ERROR, addslashes('No se ha recibido información suficiente para confirmar la reserva')));
        } else {
            ConectorDB::confirmarReserva($_GET['user'],$_GET['idReserva']);
        }
    } catch (Exception $e) {
        UtilidadesJSON::mensajeExcepcion($e->getMessage);
    }
}
?>
