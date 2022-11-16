<?php

//Clase DAO para almacenar las reservas y pintarlas en la vista mas sencillo
class Reservas implements JsonSerializable
{
    //Lista de reservas
    private $listaReservas;
    //Constructor de la clase
    function __construct($listaReservas)
    {
        $this->setListaReservas($listaReservas);
    }

    /**
     * Getter de una copia de la lista
     */
    public function getListaReservas()
    {
        $copia = $this->listaReservas;
        return $copia;
    }

    /**
     * Setter de la lista de reservas, no puedo hacerla privada porque si no no funciona el serialize para JSON
     *
     * @return  self
     */
    public function setListaReservas($listaReservas)
    {
        if ($listaReservas == null) {
            throw new Error("No se ha encontrado la lista de reservas");
        } else if (!is_array($listaReservas)) {
            throw new Error("La lista de reservas no es válida");
        } else {
            $this->listaReservas = $listaReservas;
            return $this;
        }
    }
    //Función para buscar una reserva por nombre de cliente, aunque al final lo realicé desde Javascript
    public function buscarPorNombreCliente($nombreCliente)
    {
        $listaEncontradas = [];
        foreach ($this->getListaReservas() as $reserva) {
            if (str_contains(strtolower($reserva->getUsuarioReserva()->getNombreCompleto()), strtolower($nombreCliente))) {
                array_push($listaEncontradas, $reserva);
            }
        }
        if (empty($listaEncontradas)) {
            throw new Exception("No se han encontrado reservas para el cliente");
        } else {
            return $listaEncontradas;
        }
    }
    //Función para serializar la clase
    public function jsonSerialize()
    {
        return get_object_vars($this);
    }
}
?>
