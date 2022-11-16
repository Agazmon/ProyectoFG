<?php
        // Clase que representa al usuario de la reserva
    class Usuario implements JsonSerializable{
        //Nombre real del usuario
        private $nombre;
        //Apellidos reales del usuario
        private $apellidos;
        //Telefono de contacto del usuario
        private $telefono;
        public function __construct($nombre, $apellidos, $telefono)
        {
            $this->setNombre($nombre);
            $this->setApellidos($apellidos);
            $this->setTelefono($telefono);
        }

        /**
         * Get the value of nombre
         */ 
        public function getNombre()
        {
                return $this->nombre;
        }

        /**
         * Set the value of nombre
         *
         * @return  self
         */ 
        public function setNombre($nombre)
        {
                $this->nombre = $nombre;

                return $this;
        }

        /**
         * Get the value of apellidos
         */ 
        public function getApellidos()
        {
                return $this->apellidos;
        }
        public function getNombreCompleto(){
            return $this->getNombre().' '.$this->getApellidos();
        }

        /**
         * Set the value of apellidos
         *
         * @return  self
         */ 
        public function setApellidos($apellidos)
        {
                $this->apellidos = $apellidos;

                return $this;
        }

        /**
         * Get the value of telefono
         */ 
        public function getTelefono()
        {
                return $this->telefono;
        }

        /**
         * Set the value of telefono
         *
         * @return  self
         */ 
        public function setTelefono($telefono)
        {
                $this->telefono = $telefono;

                return $this;
        }
        //Función para serializar la clase
        public function jsonSerialize(){
            return get_object_vars($this);
        }
    }
?>
