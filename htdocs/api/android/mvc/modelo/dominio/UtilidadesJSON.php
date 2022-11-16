<?php

    //Clase para devolver mensajes
    class UtilidadesJSON{
        private function __construct()
        {
        }
        public static function devolverRespuestaGenerica(){
            $data = array("a" => "Apple", "b" => "Ball", "c" => "Cat");
            echo json_encode($data);
            exit();
        }
        public static function mensajeExcepcion($mensaje){
            $mensaje = array('tipoMensaje' => 'ERROR', "mensaje" => $mensaje) ;
            echo json_encode($mensaje, JSON_UNESCAPED_UNICODE);
            exit();
        }
        public static function devolverRespuesta($mensaje){
            $devolver = json_encode($mensaje,JSON_UNESCAPED_UNICODE);
            echo $devolver;
            exit();
        }
        public static function devolverInfo($mensaje){
            echo $mensaje;
            exit();
        }
    }
?>
