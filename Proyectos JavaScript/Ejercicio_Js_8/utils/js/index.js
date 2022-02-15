let boton = document.querySelector('#boton-agregar');
let span = document.querySelector('#texto-chistes');
let select = document.querySelector('#seleccionar');

let urlCategorias = "https://api.chucknorris.io/jokes/categories"

boton.addEventListener('click',() => {
    //alert('funciona');
    let categoria = select.value;
    //console.log(categoria);
    urlChistes = `https://api.chucknorris.io/jokes/random?category=${categoria}`;
    console.log(urlChistes);
    fetch(urlChistes).then(
        (data) => {
            let json1 = data.json();
            return json1;
        },
        (err) => {}
    ).then(
        (data) => {
            span.innerHTML = data.value;
        }
    )
});

fetch(urlCategorias).then(
    (data) => {
        let json = data.json();
        return json;
    },
    (err) => {}
).then(
    (data) => {
        console.log(data);
        data.forEach(element => {
            select.innerHTML += `<option value="${element}">${element}</option>`;
        });
    },
    (err) => {}
)


