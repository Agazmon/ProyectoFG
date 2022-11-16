<html >
<head>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" defer rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <style>
        body{
            background: url('./resources/fondo.jpg') no-repeat center center fixed;;
            background-size: auto;
        }
    </style>
    <script defer src="/resources/sha256.js"></script>
    <script defer src="index.js"></script>
</head>
<body>
    <div class="container-fluid h-100" style="max-width:35%">
        <div class="align-middle p-4 bg-light rounded" style="margin-top:20%;">
            <img src="/resources/logo.png" class="rounded-circle p-3" style="max-width:25%; background-color:#8ECAE6; display:block; margin:auto;"/>
            <h2 style="display:block;margin:auto;width:fit-content">BookIt!</h2>
            <form id="loginForm">
                <div class="mb-3">
                    <label for="itUsuario" class="form-label">Correo</label>
                    <input type="email" class="form-control" id="itUsuario" aria-describedby="helpUsuario">
                    <div id="helpUsuario" class="form-text">La información es confidencial.</div>
                </div>
                <div class="mb-3">
                    <label for="ipPassword" class="form-label">Contraseña</label>
                    <input type="password" class="form-control" id="ipPassword">
                </div>
                <div class="mb-3 form-check">
                    <input type="checkbox" class="form-check-input" id="condicionesUso">
                    <label class="form-check-label" for="condicionesUso">He leido y acepto las <a href="/resources/condiciones_uso_bookit.pdf">condiciones de uso</a></label>
                </div>
                <p class="p-3 mb-2 bg-danger text-white d-block w-100 rounded d-none" id="mensajeError" ><p>
                <?php
                //Función para comprobar si ha salido con algun error del sistema
                    if(isset($_GET['error']) && $_GET['error']!=''){
                        echo( '<p class="p-3 mb-2 bg-danger text-white d-block w-100 rounded" id="mensajeError">');
                        switch ($_GET['error']) {
                            case '1':
                                echo('Error en el usuario');
                                break;
                            case '2':
                                echo ('No se han encontrado los datos del restaurante');
                            default:
                                # code...
                                break;
                        }
                        echo('</p>');
                    }
                ?>
                <button id="btLogIn" type="submit" class="btn btn-primary">Conectar</button>
            </form>
        </div>
    </div>
</body>



</html>
