<?php
    // Clase para devolver mensajes
    class UtilidadesJSON{
        private function __construct()
        {
        }
        public static function devolverRespuestaGenerica(){
            $data = array("a" => "Apple", "b" => "Ball", "c" => "Cat");
            echo json_encode($data);
        }
        public static function mensajeExcepcion($mensaje){
            $mensaje = array('tipoMensaje' => 'ERROR', "mensaje" => $mensaje) ;
            echo json_encode($mensaje, JSON_UNESCAPED_UNICODE);
        }
        public static function devolverMensajeExcepcion($mensaje){
            $mensaje = array('tipoMensaje' => 'ERROR', "mensaje" => $mensaje) ;
            return json_encode($mensaje, JSON_UNESCAPED_UNICODE);
        }
        public static function devolverRespuesta($mensaje){
            $cadena = json_encode($mensaje,JSON_UNESCAPED_UNICODE);
            echo $cadena;
        }
        public static function devolverInfo($mensaje){
            echo $mensaje;
        }
    }
?>
