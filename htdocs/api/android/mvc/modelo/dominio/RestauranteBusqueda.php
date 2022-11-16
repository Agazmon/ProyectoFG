<?php
//Clase que representa al restaurante a la hora de buscarlo en la Aplicacion de Movil
class RestauranteBusqueda implements JsonSerializable
{
    //Nombre del restaurante
    private $nombre;
    //Direccion del restaurante
    private $direccion;
    //Telefono del restaurante
    private $telefono;
    // Constructor parametrizado
    public function __construct($nombre, $direccion, $telefono)
    {
        $this->setNombre($nombre);
        $this->setDireccion($direccion);
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
     * Get the value of direccion
     */
    public function getDireccion()
    {
        return $this->direccion;
    }

    /**
     * Set the value of direccion
     *
     * @return  self
     */
    public function setDireccion($direccion)
    {
        $this->direccion = $direccion;

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
