<?php
        //Clase para las reservas en la app de android
    class ReservaCard implements JsonSerializable{
        //Nombre del restaurante
        private $nombreRestaurante;
        //Id de la reserva
        private $idReserva;
        //Fecha de la reserva
        private $diaReserva;
        //Hora de la reserva
        private $horaReserva;
        //Estado de la reserva
        private $estado;
        //Número de la reserva
        private $numComensales;
        //Logo del restaurante
        private $logoRest;
        
        public function __construct($nombreRestaurante,$idReserva,$diaReserva,$horaReserva,$estado,$numComensales,$logoRest){
            $this->setNombreRestaurante($nombreRestaurante);
            $this->setIdReserva($idReserva);
            $this->setDiaReserva($diaReserva);
            $this->setHoraReserva($horaReserva);
            $this->setEstado($estado);
            $this->setNumComensales($numComensales);
            $this->setLogoRest($logoRest);
        }

        /**
         * Get the value of nombreRestaurante
         */ 
        public function getNombreRestaurante()
        {
                return $this->nombreRestaurante;
        }

        /**
         * Set the value of nombreRestaurante
         *
         * @return  self
         */ 
        public function setNombreRestaurante($nombreRestaurante)
        {
                $this->nombreRestaurante = $nombreRestaurante;

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
         * Get the value of numComensales
         */ 
        public function getNumComensales()
        {
                return $this->numComensales;
        }

        /**
         * Set the value of numComensales
         *
         * @return  self
         */ 
        public function setNumComensales($numComensales)
        {
                $this->numComensales = $numComensales;

                return $this;
        }

        /**
         * Get the value of logoRest
         */ 
        public function getLogoRest()
        {
                return $this->logoRest;
        }

        /**
         * Set the value of logoRest
         *
         * @return  self
         */ 
        public function setLogoRest($logoRest)
        {
            if($logoRest!=null){
                $logoRest = base64_encode($logoRest);
            }
            $this->logoRest = $logoRest;
            return $this;
        }
         /**
         * Get the value of estado
         */ 
        public function getEstado()
        {
                return $this->estado;
        }

        /**
         * Set the value of estado
         *
         * @return  self
         */ 
        public function setEstado($estado)
        {
                $this->estado = $estado;

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
