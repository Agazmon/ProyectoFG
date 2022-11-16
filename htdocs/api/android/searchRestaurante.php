<?php
//End-point de la api para buscar restaurantes por nombre
header("Content-type: application/json");
require_once('autoload.php');
autoload(null);
comprobarVariables();
function comprobarVariables()
{
    try {
        if (!isset($_GET['nombre'])) {
            UtilidadesJSON::devolverRespuesta(new Mensaje(TipoMensaje::$ERROR, addslashes('Nombre no recibido')));
        } else {
            ConectorDB::buscarRestaurante($_GET['nombre']);
        }
    } catch (Exception $e) {
        UtilidadesJSON::mensajeExcepcion($e->getMessage());
    }
}
?>
