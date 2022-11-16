    <?php
    //Cargar autoload
    include('./api/escritorio/autoload.php');
    //Hacerlo funcionar
    autoload(null);
    comprobarVariables();
    //Conectar al usuario comprobando que existe
    function comprobarVariables()
    {

        //Conectar usuario
        $respuestaConexion = ConectorApp::conectarUsuario($_GET['usuario'], $_GET['pass']);
        if ($respuestaConexion != null) {
            if (!($respuestaConexion instanceof Mensaje)) {
                echo ('<script>window.location.href=(location.protocol + "//" + location.host+"index.php?error=1")</script>');
            }
        }
        //Obtener los datos del restaurante
        $datosRestaurante = ConectorApp::obtenerDatosRestaurante($_GET['usuario']);
        if (!is_array($datosRestaurante)) {
            echo ('<script>window.location.href=(location.protocol + "//" + location.host +"index.php?error=2")</script>');
        }
        //Asignacion de variables
        $nombreRestaurante = $datosRestaurante[0];
        $idRestaurante = $datosRestaurante[1];
        $usuarioRestaurante = $_GET['usuario'];;
        // Pintar el head del HTML
        headers($nombreRestaurante);
        // Pintar el resto de la vista
        pintarVista($nombreRestaurante, $usuarioRestaurante, $idRestaurante);
    }
    //Función que añade el head del HTML
    function headers($nombreRestaurante)
    {
        echo '<head> 
            <title>' . $nombreRestaurante . '</title>  
            <!-- CSS only -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" defer rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
            <link defer rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
            <script src="utilidades.js" defer ></script>
        </head>';
    }
    //Función que muestra la vista
    function pintarVista($nombreRestaurante, $usuarioRestaurante, $idRestaurante)
    {
        pintarNavBar($nombreRestaurante);
        $reservas = ConectorApp::getReservasRestaurante($idRestaurante);
        pintarReservas($reservas);
    }
    //Función que muestra la barra superior
    function pintarNavBar($nombreRestaurante)
    {
        echo '<nav class="navbar navbar-expand-lg bg-light">
        <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="/resources/logo.png" alt="" width="30" height="30" class="bg-primary rounded-circle p-1 d-inline-block align-text-top">
            Bookit: ' . $nombreRestaurante . '
        </a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <div class="container-fluid mt-2">
                    <div id="displayMensaje" class="alert w-100 d-none animate__animated animate__slideInDown" id="displayMensaje" role="alert"> Mensaje generico </div>
                </div>
            <div class="d-flex pt-2" role="search">
              <input class="form-control me-2" type="search" placeholder="Buscar" id="inputBuscar" aria-label="Buscar">
            </div>
          </div>
        </div>
      </nav>';
    }
    //Función que muestra todas las reservas de forma dinámica
    function pintarReservas($reservas)
    {
        $stringFinal = '<div class="d-flex align-content-start p-2 w-100 h-100 bg-primary flex-wrap" id="containerCards">';
        foreach ($reservas->getListaReservas() as $reserva) {
            $stringFinal = $stringFinal .
                '<div class="card mb-3 mx-1 my-1 animate__animated animate__fadeIn" style="min-width:22%; max-width: 23%;">
                    <div class="row">
                        <div class="col">
                            <div class="card-body">
                                <h5 class="card-title">Reserva Nº' . $reserva->getIdReserva() . '</h5>
                                    <p class="card-text my-1 text-center">Nombre: <span id="nombreReserva">' . $reserva->getUsuarioReserva()->getNombre() . '</span></p>
                                    <p class="card-text my-1 text-center">Apellidos: <span id="apellidosReserva">' . $reserva->getUsuarioReserva()->getApellidos() . '</span></p>
                                    <p class="card-text my-1 text-center">Nº Comensales: ' . $reserva->getNumComensalesReserva() . '</p>
                                    <p class="card-text my-1 text-center">Fecha: ' . $reserva->getDiaReserva() . '</p>
                                    <p class="card-text my-1 text-center">Hora: ' . $reserva->getHoraReserva() . '</p>
                                    <p class="card-text my-1 text-center">Estado: ' . getEstadoReservaVista($reserva->getEstadoReserva()) . '</p>
                                    <p class="card-text my-1 text-center">' . pintarBotones($reserva->getIdReserva(), $reserva->getEstadoReserva()) . '</p>
                            </div>
                        </div>
                    </div>
                </div>';
        }
        $stringFinal = $stringFinal . '</div>';
        echo $stringFinal;
    }
    //Función que personaliza el estado de las reservas de una forma mas visual
    function getEstadoReservaVista($estado)
    {
        if ($estado == null || $estado == '') {
            return '<span class="badge bg-danger">Error</span>';
        }
        switch ($estado) {
            case '1':
                return '<span class="badge bg-warning">Pendiente</span>';
            case '2':
                return '<span class="badge bg-info">Confirmada</span>';
            case '0':
                return '<span class="badge bg-secondary">Cancelada</span>';
            default:
                return '<span class="badge bg-danger">Error</span>';
        }
    }
    //Función que pinta los botones adecuados dado el estado de la reserva
    function pintarBotones($idReserva, $estadoActual)
    {
        if ($estadoActual == '1') {
            return ('<button class="btn btn-primary w-100 my-1" onclick="confirmarReserva(' . $idReserva . ')">Confirmar</button>');
        } else if ($estadoActual == '2') {
            return ('<button class="btn btn-danger w-100 my-1" onclick="cancelarReserva(' . $idReserva . ')">Cancelar</button>');
        }
    }
?>
