<?php
    //Clase que representa a los mensajes devueltos
    class Mensaje implements JsonSerializable{
        //Tipo de mensaje
        private $tipoMensaje;
        // Contenido del mensaje
        private $mensaje;

        public function __construct($tipoMensaje, $mensaje)
        {
            $this->setTipoMensaje($tipoMensaje);
            $this->setMensaje($mensaje);
        }   
        /**
         * Get the value of mensaje
         */ 
        public function getMensaje()
        {
                return $this->mensaje;
        }
        /**
         * Get the value of tipoMensaje
         */ 
        public function getTipoMensaje()
        {
                return $this->tipoMensaje;
        }
        /**
         * Set the value of mensaje
         *
         * @return  self
         */ 
        public function setMensaje($mensaje)
        {
            if(is_null($mensaje) OR $mensaje == ''){
                throw new Exception('Error en la creación del mensaje');
            } else{
                $this->mensaje = $mensaje;
                return $this;
            }
            
        }
        /**
         * Set the value of tipoMensaje
         *
         * @return  self
         */ 
        public function setTipoMensaje($tipoMensaje){
            if(is_null($tipoMensaje))
            {
                throw new Exception("No se ha podido crear el mensaje, tipo nulo");
            }
            else
            {
                $this->tipoMensaje = $tipoMensaje;
                return $this;
            }
        }
        //Para serializar la clase
        public function jsonSerialize(){
            return get_object_vars($this);
        }
    }
?>
