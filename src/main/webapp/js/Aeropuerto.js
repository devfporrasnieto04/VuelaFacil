function loadData(){
    let request = sendRequest ('Aeropuerto/list', 'GET', '');
    let table = document.getElementById('Aeropuerto-table');
    table.innerHTML = "";
    request.onload = function(){
        let data = request.response;
        data.forEach (element => {
            table.innerHTML + "<tr>";
            table.innerHTML + "<th>${element.idAeropuerto}</th>";
            table.innerHTML + "<td>${element.ciudad}</td>";
            table.innerHTML + "</tr>";
            table.innerHTML + "<td>";
            table.innerHTML + '<button type="button" class="btn btn-primary" onclik= window.location='+'"/FormAeropuertos.html?id=${element.idAeropuerto}"'+' >Actualizar</button>';
            table.innerHTML + '<button type="button" class="btn btn-danger" onclik= deleteuser=('+'{element.idAeropuerto})"'+' >Borrar</button>';
            table.innerHTML + "</td>";
            });
        };
    request.onerror = function (){
        table.innerHTML = '<tr><td colspan="5">Error al traer datos</td></tr>';
    };
}







