<?php
//End-point de la api para obtener el horario de un restaurante
header("Content-type: application/json");
require_once('autoload.php');
autoload(null);
comprobarVariables();
function comprobarVariables()
{
    try {
        if (!isset($_GET['usuario'])) {
            UtilidadesJSON::devolverRespuesta(new Mensaje(TipoMensaje::$ERROR, addslashes('Falta información para consultar la reservas del usuario.')));
        } else {
            ConectorDB::getReservasUsuario($_GET['usuario']);
        }
    } catch (Exception $e) {
        UtilidadesJSON::mensajeExcepcion($e->getMessage);
    }
}
?>
