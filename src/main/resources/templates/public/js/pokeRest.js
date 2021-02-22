function pokePrint(){
    let myHeaders = new Headers();

    let myInit = { method: 'GET',
        headers: myHeaders,
        mode: 'cors',
        cache: 'default' };

    let myRequest = new Request('http://localhost:8080/new', myInit);

fetch(myRequest)
    .then(response => response.json())
    .then(data => {
        let listElem = "<ul>";
        data.forEach(pokemon => {
            listElem += `<li>${pokemon.name}</li><li>${pokemon.type}</li><li>${pokemon.color}</li>`;
        });
       listElem="</ul>";
        document.getElementById('pokemon').innerHTML = listElem;
    });
}