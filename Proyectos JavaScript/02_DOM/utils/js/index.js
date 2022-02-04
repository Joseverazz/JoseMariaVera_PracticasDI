//modificaciones y acceso a nodos por parte de código
let botonAgregar = document.getElementById('boton-agregar');
botonAgregar.innerText = "Agregar ahora"; //cambias el texto del boton
//si hay varios botones saca un html collection 
let botones = document.getElementsByClassName('btn');
let inputs = document.getElementsByClassName('input');

//por $nombreID por clase .nombreclase por tag nombretag(sin nada)
//el primer elemento que tiene la clase btn
let botonQuery = document.querySelector('.btn');//solo da el primer elemento
botonQuery.innerText = "Pulsar nuevo"

let botonesQuery = document.querySelectorAll('.btn');
//botonQuery.innerText = "Pulsado";
botonesQuery.forEach((element,index) => {
    element .innerText = `pulsado ${index+1}`});

let lista = document.querySelector('#lista-contenido');
//lista.innerHTML += "<li>Elemento nuevo</li>";

let nodoLI = document.createElement("li");
nodoLI.innerText = "elemento nuevo";
nodoLI.classList.add("list-group-item");
lista.append(nodoLI);

let btnAgregar = document.querySelector("#boton-agregar");
let inputAgregar = document.querySelector('input');
let check = document.querySelector('#check-activar');
let contador = document.querySelector('#span-contador');

inputAgregar.addEventListener('keyup', ()=>{
    console.log(inputAgregar.value.length);
    contador.innerText = inputAgregar.value.length;
})

btnAgregar.addEventListener('click', ()=>{
    if (check.checked && inputAgregar.value.length == 0) {
        let valor = inputAgregar.value
    let nodo = document.createElement('li')
        nodo.innerText = valor;
        nodo.classList.add("list-group-item")
        lista.append(nodo)
    }
    else{
        alert("No se puede agregar");
    }
})

check.addEventListener('click', ()=>{
    if (check.checked) {
        inputAgregar.removeAttribute("disabled");
    }
    else{
        inputAgregar.setAttribute('disabled',"");
    }
})
