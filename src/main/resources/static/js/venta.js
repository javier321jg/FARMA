
// generamos el evento para el boton
document.getElementsByTagName("button")[0].addEventListener("click",calcular);
 
/**
 * funcion que realiza los calculos
 */
function calcular() {
    // obtenemos todas las filas del tbody
    var filas=document.querySelectorAll("#tablita tbody tr");
 
    var total=0;
 
    // recorremos cada una de las filas
    filas.forEach(function(e) {
 
        // obtenemos las columnas de cada fila
        var columnas=e.querySelectorAll("td");
 
        // obtenemos los valores de la cantidad y importe
        var cantidad=parseFloat(columnas[2].textContent);
        var precio=parseFloat(columnas[3].textContent);
 
        // mostramos el total por fila
        columnas[4].textContent=(cantidad*precio).toFixed(2);
 
        total+=cantidad*precio;
    });
 
    // mostramos la suma total
    var filas=document.querySelectorAll("#tablita tfoot tr td");
    filas[1].textContent=total.toFixed(2);
}
