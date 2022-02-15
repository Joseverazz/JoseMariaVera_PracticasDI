let rojo = document.querySelector("#range-r");
let verde = document.querySelector("#range-g");
let azul = document.querySelector("#range-b");
let paleta = document.querySelector('#paleta');

let colores = [rojo,verde,azul];

colores.forEach(element => {
    element.addEventListener('click', ()=>{
        let valorRojo = Number(rojo.value).toString(16);
        let valorVerde = Number(verde.value).toString(16);
        let valorAzul = Number(azul.value).toString(16);
        if (valorRojo < 10){
            valorRojo = "0"+valorRojo;
        }
        if (valorVerde < 10){
            valorVerde = "0"+valorVerde;
        }
        if (valorAzul < 10){
            valorAzul = "0"+valorAzul;
        }
        paleta.setAttribute("style",`width: 400px; height: 400px; background-color: #${valorRojo}${valorVerde}${valorAzul};`);
        paleta.innerHTML = `RGB: ${rojo.value}/${verde.value}/${azul.value}`;
     })
});