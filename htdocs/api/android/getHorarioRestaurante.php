<?php
//End-point de la api para obtener el horario de un restaurante
header("Content-type: application/json");
require_once('autoload.php');
autoload(null);
comprobarVariables();
function comprobarVariables()
{
    try {
        if (!isset($_GET['nombre']) or !isset($_GET['telefono']) or !isset($_GET['diaSemana'])) {
            UtilidadesJSON::devolverRespuesta(new Mensaje(TipoMensaje::$ERROR, addslashes('Falta información para consultar el horario.')));
        } else {
            ConectorDB::consultarHorario($_GET['nombre'], $_GET['telefono'], $_GET['diaSemana']);
        }
    } catch (Exception $e) {
        UtilidadesJSON::mensajeExcepcion($e->getMessage);
    }
}
?>
