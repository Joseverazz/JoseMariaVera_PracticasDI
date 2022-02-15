let boton = document.querySelector('#boton-comprobar');
let texto = document.querySelector('#texto-aprobar');
let check = document.querySelector('#check-aprobar');
let nombre = document.querySelector('#nombre');
let apellido = document.querySelector('#apellido');
let noticia = document.querySelector('#noticia');
let boton_noticia = document.querySelector('#boton-noticia');
let categoria = document.querySelector('#categoria');
let boton_categoria = document.querySelector('#boton-categoria');
let noticias = document.querySelector('#noticias');


boton.addEventListener("click", ()=>{
    if (apellido.value == "" || nombre.value == "") {
        alert("Faltan datos para completar");
    }
    else {
        if (check.checked) {
            texto.innerHTML = `<label style="width: 400px; height: 200px; background-color: #3b83bd;">Perfecto, estás preparado para comenzar</label>`;
            noticia.removeAttribute("disabled");
            boton_noticia.removeAttribute("disabled");
            boton_categoria.removeAttribute("disabled");
            categoria.removeAttribute("disabled");

        }
        else{
            texto.innerHTML = `<label style="width: 400px; height: 200px; background-color: #ffff00;">Asi no vamos bien</label>`;
            noticia.setAttribute("disabled","");
            boton_noticia.setAttribute("disabled","");
            boton_categoria.setAttribute("disabled","");
            categoria.setAttribute("disabled","");
        }

    }
})


boton_noticia.addEventListener('click', () => {
    if (noticia.value == "") {
        alert("No debe estar el campo vacio");
    } else {
        url = `https://newsdata.io/api/1/news?apikey=pub_45004cab77badd6381033af892db07d2fbd2&q=${noticia.value}`;
        noticias.innerHTML = "";
        fetch(url).then(
            (data) => {
                let json = data.json();
                return json;
            },
            (err) => {}
        ).then(
            (data) => {
                data.results.forEach(element => {
                    noticias.innerHTML += `<div class="col">
                        <div class="card" style="width: 20rem;">
                            <div class="card-body">
                                <h5 class="card-title"> ${element.title}</h5>
                                <a href="${element.link}" class="btn btn-primary">Ir a la noticia</a>
                            </div>
                        </div>
                    </div>`;
                });
                
            }
        )
    }
})

boton_categoria.addEventListener('click', () => {
    if (categoria.value == "sports"||categoria.value == "environment"||categoria.value == "science") {
        url = `https://newsdata.io/api/1/news?apikey=pub_45004cab77badd6381033af892db07d2fbd2&category=${categoria.value}`;
        noticias.innerHTML = "";
        fetch(url).then(
            (data) => {
                let json = data.json();
                return json;
            }
        ).then(
            (data) => {
                data.results.forEach(element => {
                    noticias.innerHTML += `<div class="col">
                        <div class="card" style="width: 20rem;">
                            <div class="card-body">
                                <h5 class="card-title"> ${element.title}</h5>
                                <a href="${element.link}" class="btn btn-primary">Ir a la noticia</a>
                            </div>
                        </div>
                    </div>`;
                });
            }
        )
    } else {
        alert("Categoria incorrecta");
    }
    
    
})