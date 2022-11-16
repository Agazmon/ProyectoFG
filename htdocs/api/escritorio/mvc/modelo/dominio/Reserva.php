<?php
        //Clase para la reserva
    class Reserva implements JsonSerializable{
        // Usuario de la reserva
        private $usuarioReserva;
        // Id único de la reserva
        private $idReserva;
        // Día de la reserva
        private $diaReserva;
        //Hora de la reserva
        private $horaReserva;
        //Estado de la reserva
        private $estadoReserva;
        //Número de comensales que asistiran a la reserva
        private $numComensalesReserva;
        //Constructor parametrizado
        function __construct( $usuarioReserva,$idReserva, $diaReserva, $horaReserva, $estadoReserva,$numComensalesReserva){
            $this->setUsuarioReserva($usuarioReserva);
            $this->setIdReserva($idReserva);
            $this->setDiaReserva($diaReserva);
            $this->setHoraReserva($horaReserva);
            $this->setEstadoReserva($estadoReserva);
            $this->setNumComensalesReserva($numComensalesReserva);
        }
        
        /**
         * Get the value of usuarioReserva
         */ 
        public function getUsuarioReserva()
        {
                return $this->usuarioReserva;
        }

        /**
         * Set the value of usuarioReserva
         *
         * @return  self
         */ 
        public function setUsuarioReserva($usuarioReserva)
        {
                $this->usuarioReserva = $usuarioReserva;

                return $this;
        }

        /**
         * Get the value of diaReserva
         */ 
        public function getDiaReserva()
        {
                return $this->diaReserva;
        }

        /**
         * Set the value of diaReserva
         *
         * @return  self
         */ 
        public function setDiaReserva($diaReserva)
        {
                $this->diaReserva = $diaReserva;

                return $this;
        }

        /**
         * Get the value of horaReserva
         */ 
        public function getHoraReserva()
        {
                return $this->horaReserva;
        }

        /**
         * Set the value of horaReserva
         *
         * @return  self
         */ 
        public function setHoraReserva($horaReserva)
        {
                $this->horaReserva = $horaReserva;

                return $this;
        }

        /**
         * Get the value of estadoReserva
         */ 
        public function getEstadoReserva()
        {
                return $this->estadoReserva;
        }

        /**
         * Set the value of estadoReserva
         *
         * @return  self
         */ 
        public function setEstadoReserva($estadoReserva)
        {
                $this->estadoReserva = $estadoReserva;

                return $this;
        }

        /**
         * Get the value of numComensalesReserva
         */ 
        public function getNumComensalesReserva()
        {
                return $this->numComensalesReserva;
        }

        /**
         * Set the value of numComensalesReserva
         *
         * @return  self
         */ 
        public function setNumComensalesReserva($numComensalesReserva)
        {
                $this->numComensalesReserva = $numComensalesReserva;

                return $this;
        }

        /**
         * Get the value of idReserva
         */ 
        public function getIdReserva()
        {
                return $this->idReserva;
        }

        /**
         * Set the value of idReserva
         *
         * @return  self
         */ 
        public function setIdReserva($idReserva)
        {
                $this->idReserva = $idReserva;

                return $this;
        }
        //Función para serializar la clase
        public function jsonSerialize(){
                return get_object_vars($this);
        }
    }
?>
