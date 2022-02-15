//Ejecucion larga
    //cuando termine ¿? se ejecuta
    //si lo ha hecho bien --> ejecuto una cosa
    //si lo ha hecho mal --> ejecuto otra cosa
/*
setInterval(() => {
    console.log("Ejecucion");
}, 500);
*/
//Promise
let promesa = new Promise((res,rej)=>{
    //logica de la promesa
    // la accion que tarda mucho
    setTimeout(() => {
        let numero = 6;

        if (numero>5) {
            res("bien resuelto");
        } else{
            rej("mal resuelto");
        }
    }, 3000);
    
});

promesa.then(
    //la respuesta ha entrado por el res
    (data) => {
        console.log(data);
    },
    //la respuesta ha entrado por el rej
    (data) => {
        console.log("No se ha podido hacer");
        console.log(data);
    }
);

let url = "https://randomuser.me/api/?results=10";
let lista_masc = document.querySelector('#lista-masc');
let lista_fem = document.querySelector('#lista-fem');
let div_personas = document.querySelector('#div-personas');
let usuarios = [];

fetch(url).then(
    (data) => {
        //console.log(data);
        let json = data.json();
        return json;
    },
    (err) => {}
).then(
    (data) => {
        this.usuarios = data.results;
        data.results.forEach(element => {
            div_personas.innerHTML += `<div class="col">
                <div class="card" style="width: 20rem;">
                    <img class="card-img-top" src="${element.picture.large}" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title"> ${element.name.title} ${element.name.first} ${element.name.last}</h5>
                        <p class="card-text"> Telefono: ${element.phone} <br>
                        C/ ${element.location.street.name} ${element.location.street.number} ${element.location.state},
                        <br>${element.location.postcode} ${element.location.country}</p>
                        <a id="${element.login.username}" class="btn btn-primary">Go somewhere</a>
                    </div>
                </div>
            </div>`;
            if ("female" == element.gender) {
                lista_fem.innerHTML += `<li class='list-group-item'> ${element.name.title} ${element.name.first} ${element.name.last}</li>`;
            }
            else{
                lista_masc.innerHTML += `<li class='list-group-item'> ${element.name.title} ${element.name.first} ${element.name.last}</li>`;
            }
            /* let boton = document.querySelector(`#${element.login.username}`);
            boton.addEventListener('click',()=>{
                console.log('pulsado');
                alert(`${element.name.first} ${element.name.last}`);
                console.log('pulsado');
            }); */
        });       
    },
    (err) => {}
).then(
    (data) =>{
        let botones = document.querySelectorAll('#div-personas a');
        botones.forEach(element => {
            element.addEventListener('click',()=>{
                //alert(element.id);
                let encontrados = this.usuarios.filter((e) =>{return e.login.username == element.id});
                alert(encontrados[0].name.first);
            });
        });
        console.log(botones.length); 
    },
    (err) =>{}
);