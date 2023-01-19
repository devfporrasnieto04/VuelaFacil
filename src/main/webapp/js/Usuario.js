function loadData(){
    let request = sendRequest ('usuario/list', 'GET', '');
    let table = document.getElementById('usuario-table');
    table.innerHTML = "";
    request.onload = function(){
        let data = request.response;
        data.forEach (element => {
            table.innerHTML + "<tr>";
            table.innerHTML + "<th>${element.idUsuario}</th>";
            table.innerHTML + "<td>${element.nombre}</td>";
            table.innerHTML + "<td>${element.usuario}</td>";
            table.innerHTML + "<td>${element.password}</td>";
            table.innerHTML + "<td>${element.email}</td>";
            table.innerHTML + "<td>${element.nacionalidad}</td>";
            table.innerHTML + "<td>${element.edad}</td>";
            table.innerHTML + "</tr>";
            table.innerHTML + "<td>";
            table.innerHTML + '<button type="button" class="btn btn-primary" onclik= window.location='+'"/FormUsuario.html?id=${element.idUsuario}"'+' >Actualizar</button>';
            table.innerHTML + '<button type="button" class="btn btn-danger" onclik= deleteuser=('+'{element.idUsuario})"'+' >Borrar</button>';
            
            table.innerHTML + "</td>";
           
            });
        };
    request.onerror = function (){
        table.innerHTML = '<tr><td colspan="5">Error al traer datos</td></tr>';
    };
}

