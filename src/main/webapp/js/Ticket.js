function loadData(){
    let request = sendRequest ('ticket/list', 'GET', '');
    let table = document.getElementById('Ticket-table');
    table.innerHTML = "";
    request.onload = function(){
        let data = request.response;
        data.forEach (element => {
            table.innerHTML + "<tr>";
            table.innerHTML + "<th>${element.idTicket}</th>";
            table.innerHTML + "<td>${element.precio}</td>";
            table.innerHTML + "<td>${element.fechaVueloIda}</td>";
            table.innerHTML + "<td>${element.fechaVueloRegreso}</td>";
            table.innerHTML + "<td>${element.numAsiento}</td>";
            table.innerHTML + "<td>${element.clase}</td>";
            table.innerHTML + "<td>${element.equipaje}</td>";
            table.innerHTML + "<td>${element.usuario_idUsuario}</td>";
            table.innerHTML + "<td>${element.usuario_idVuelo}</td>";
            table.innerHTML + "<td>${element.usuario_idAeropuerto}</td>";
            table.innerHTML + "</tr>";
            table.innerHTML + "<td>";
            table.innerHTML + '<button type="button" class="btn btn-primary" onclik= window.location='+'"/FormTicket.html?id=${element.idTicket}"'+' >Actualizar</button>';
            table.innerHTML + '<button type="button" class="btn btn-danger" onclik= deleteuser=('+'{element.idTicket})"'+' >Borrar</button>';
            
            table.innerHTML + "</td>";
           
            });
        };
    request.onerror = function (){
        table.innerHTML = '<tr><td colspan="5">Error al traer datos</td></tr>';
    };
}

