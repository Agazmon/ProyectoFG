
//Elementos con los que se interactua
var cards, inputBuscar, displayMensaje;
inicializarListeners()
//Función para obtener los elementos y añadir listeners
function inicializarListeners(){
    inputBuscar = document.getElementById("inputBuscar");
    cards = document.getElementById("containerCards");
    displayMensaje = document.getElementById("displayMensaje");
    let funcion = debounce(buscar,250)
    inputBuscar.addEventListener("input",funcion);
    inputBuscar.addEventListener("emptied",funcion);
}
//Función para mostrar desde el cliente solo la reserva del cliente que se ponga en el buscador
function buscar(){
    let arrayCartas = cards.children;
    let busqueda = inputBuscar.value.toLowerCase();
    var nombreReserva, apellidosReserva, carteraActual;
    if(busqueda!=""){
        for(cartaItera of arrayCartas){ 
            nombreReserva = cartaItera.querySelector("#nombreReserva").innerText;
            apellidosReserva = cartaItera.querySelector("#apellidosReserva").innerText;
            if(nombreReserva.toLowerCase().includes(busqueda) || apellidosReserva.toLowerCase().includes(busqueda)){
                cartaItera.classList.add("animate__animated")
                cartaItera.classList.add("animate__fadeIn");
                cartaItera.classList.remove("d-none");
                cartaItera.classList.remove("animate__fadeOut");
            } else{
                cartaItera.classList.add("animate__animated");
                cartaItera.classList.remove("animate__fadeIn");
                cartaItera.classList.add("animate__fadeOut");
                cartaItera.classList.add("d-none");
            }
        }
    } else{
             for(cartaItera of arrayCartas){ 
                cartaItera.classList.remove("d-none");
                cartaItera.classList.remove("animate__fadeOut");
                cartaItera.classList.add("animate__fadeIn");
            }
        
    }
}
//Función para llamar al endpoint de cancelar la reserva
function cancelarReserva(idReserva){
    let urlParams = new URLSearchParams(window.location.search);
    fetch('https://40289522.servicio-online.net/api/escritorio/cancelarReserva.php?user='+urlParams.get('usuario')+'&idReserva='+idReserva).then(response=>response.json()).then(data=>mostrarMensaje(data));
}
//Función para llamar al endpoint de confirmacion
function confirmarReserva(idReserva){
    let urlParams = new URLSearchParams(window.location.search);
    fetch('https://40289522.servicio-online.net/api/escritorio/confirmarReserva.php?user='+urlParams.get('usuario')+'&idReserva='+idReserva).then(response=>response.json()).then(data=>mostrarMensaje(data));
}
//Funcion para mostrar mensaje de error devuelto de los fetch
function mostrarMensaje(mensaje,mostrar=true){
    if(mostrar){
        displayMensaje.classList.remove("d-none");
        displayMensaje.innerText=mensaje.mensaje;
        if(mensaje.tipoMensaje=="ERROR"){
            displayMensaje.classList.remove("alert-primary");
            displayMensaje.classList.add("alert-danger");
        } else{
            displayMensaje.classList.add("alert-primary");
            displayMensaje.classList.remove("alert-danger");
        }
    } else{
        displayMensaje.classList.add("d-none");
    }
}

//Función de debounce, esto lo tiene angular y es muy util
function debounce(func, wait, immediate) {
    var timeout;
  
    return function executedFunction() {
      var context = this;
      var args = arguments;
          
      var later = function() {
        timeout = null;
        if (!immediate) func.apply(context, args);
      };
  
      var callNow = immediate && !timeout;
      
      clearTimeout(timeout);
  
      timeout = setTimeout(later, wait);
      
      if (callNow) func.apply(context, args);
    };
};
