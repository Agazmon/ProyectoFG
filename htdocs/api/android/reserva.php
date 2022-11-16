<?php
//End-point de la api para realizar una reserva
header("Content-type: application/json");
require_once('autoload.php');
autoload(null);
comprobarVariables();
function comprobarVariables()
{
    try {
        if (!isset($_GET['usuario']) or !isset($_GET['restaurante']) or !isset($_GET['telefono']) or !isset($_GET['dia']) or !isset($_GET['hora']) or !isset($_GET['numComensales'])) {
            UtilidadesJSON::devolverRespuesta(new Mensaje(TipoMensaje::$ERROR, addslashes('Falta información para formalizar la reserva.')));
        } else {
            ConectorDB::realizarReserva($_GET['usuario'], $_GET['restaurante'], $_GET['telefono'], $_GET['dia'], $_GET['hora'], $_GET['numComensales']);
        }
    } catch (Exception $e) {
        UtilidadesJSON::mensajeExcepcion($e->getMessage());
    }
}
?>
