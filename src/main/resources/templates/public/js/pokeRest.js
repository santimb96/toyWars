function pokePrint(){
  /*  //let url = new Request('http://localhost:8080/new');
    let request = new Request('http://localhost:8080/new');
    fetch(request).then(function(response) {
        // Convert to JSON
        return response.json();
    }).then(function(myJson) {
        // Yay, `j` is a JavaScript object
        console.log(JSON.stringify(myJson));
        let listElem = "<ul>";
        myJson.forEach(pokemon => {
            listElem += `<li>${pokemon.name}</li><li>${pokemon.type}</li><li>${pokemon.color}</li>`;
        });
        listElem = "</ul>";
        document.getElementById('pokemon').innerHTML = listElem;
    }).catch(function(error) {
        console.log('Request failed', error)
    });
}*/
    fetch('/new',{
                method: 'GET',
                headers: new Headers({ 'Content-type': 'application/json'}),
                mode: 'same-origin',
                proxy: "http://localhost:8080",
        })
        .then(function(response) {
            return response.json()
        })
                .then(data => {
                    let listElem = "<ul>";
                    data.forEach(pokemon => {
                        listElem += `<li>${pokemon.name}</li><li>${pokemon.type}</li><li>${pokemon.color}</li>`;
                    });
                    listElem = "</ul>";
                    document.getElementById('pokemon').innerHTML = listElem;
                })};
  /*  fetch('./new')
        .then(
        function(response) {
            if (response.status !== 200) {
                console.log('Hay un problema. Status code: ' +
                    response.status);
                return;
            }
            // Examine the text in the response
            response.json().then(function(data) {
                console.log(data);
                let listElem = "<ul>";
                data.forEach(pokemon => {
                    listElem += `<li>${pokemon.name}</li><li>${pokemon.type}</li><li>${pokemon.color}</li>`;
                });
                listElem = "</ul>";
                document.getElementById('pokemon').innerHTML = listElem;
            });
        }
    )
    .catch(function(err) {
        console.log('Fetch Error :-S', err);
    })};

   */
/*
    let allowCrossDomain = function(req, res, next) {
        res.header('Access-Control-Allow-Origin', "*");
        res.header('Access-Control-Allow-Headers', "*");
        next();
    }
    app.use(allowCrossDomain);
const url = 'http://localhost:8080/new';
const initDetails = {
    method: 'get',
    headers: {
        "Content-Type": "Access-Control-Allow-Origin: http://localhost:8080 "
    },
    mode: "cors",
    origin: 'http://localhost:8080'
}

    fetch( url, initDetails )
        .then( response =>
            {
                if ( response.status !== 200 )
                {
                    console.log( 'Looks like there was a problem. Status Code: ' +
                        response.status );
                    return;
                }

                console.log( response.headers.get( "Content-Type" ) );
                return response.json();
            }
        )
        .then( myJson =>
        {
            console.log( JSON.stringify( myJson ) ); let listElem = "<ul>";
            myJson.forEach(pokemon => {
                listElem += `<li>${pokemon.name}</li><li>${pokemon.type}</li><li>${pokemon.color}</li>`;
            });
            listElem = "</ul>";
        } )
        .catch( err =>
        {
            console.log( 'Fetch Error :-S', err );
        } );
}*/
