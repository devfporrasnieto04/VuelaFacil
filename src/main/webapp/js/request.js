const url="http://localhost:8080/cuelafacil/list";
function sendRequest (endpoint, method, data){
    let request = new XMLHttpRequest();
    request.open(method, url+endpoint);
    request.responseType = 'json';
    request.setRequestHeader('Content-type', 'aplication/json');
    request.send(data ? JSON.stringify(data): data);
    return request;
}