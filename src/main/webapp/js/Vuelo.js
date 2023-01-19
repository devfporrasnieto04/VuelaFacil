function loadData(){
    let request = sendRequest ('Vuelo/list', 'GET', '');
    let table = document.getElementById('vuelo-table');
    table.innerHTML = "";
    request.onload = function(){
        let data = request.response;
        data.forEach (element => {
            table.innerHTML + "<tr>";
            table.innerHTML + "<th>${element.idVuelo}</th>";
            table.innerHTML + "<td>${element.lugarOrigen}</td>";
            table.innerHTML + "<td>${element.lugarDestino}</td>";
            table.innerHTML + "</tr>";
            table.innerHTML + "<td>";
            table.innerHTML + '<button type="button" class="btn btn-primary" onclik= window.location='+'"/FormVuelo.html?id=${element.idVuelo}"'+' >Actualizar</button>';
            table.innerHTML + '<button type="button" class="btn btn-danger" onclik= deleteuser=('+'{element.idVuelo})"'+' >Borrar</button>';
            
            table.innerHTML + "</td>";
           
            });
        };
    request.onerror = function (){
        table.innerHTML = '<tr><td colspan="5">Error al traer datos</td></tr>';
    };
}




