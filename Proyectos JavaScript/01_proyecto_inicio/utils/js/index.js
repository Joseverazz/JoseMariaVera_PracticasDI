console.log("Ejecucion de codigo JS por carpeta")

//let numero = 5;
//let numeroDecimal = 5.7;
//const IVA = 18;

/*
let numero = 5; // Number
let numeroDecimal = 5.7; // Number
let acierto = true; // Boolean
let palabra = "Jose"; // String
let letra = 'c'; // char
let nulo = null; // null
let sinDefinir = undefined; // Sin definicion
/*
console.log(typeof numero);
console.log(typeof numeroDecimal);
console.log(typeof acierto);
console.log(typeof palabra);
console.log(typeof letra);
console.log(typeof nulo);
console.log(typeof sinDefinir);

console.log("La variable "+" es de tipo"+typeof numero);
console.log(`la variable ${numero} es de tipo ${typeof numero}`);
console.log(`la variable ${numeroDecimal} es de tipo ${typeof numeroDecimal}`);
console.log(`la variable ${acierto} es de tipo ${typeof acierto}`);
console.log(`la variable ${palabra} es de tipo ${typeof palabra}`);
console.log(`la variable ${letra} es de tipo ${typeof letra}`);
console.log(`la variable ${nulo} es de tipo ${typeof nulo}`);
console.log(`la variable ${sinDefinir} es de tipo ${typeof sinDefinir}`);

let numeroUno = 5;
let numeroDos = 10;


console.log(isNaN(palabra));

//alert("Esto es un ejemplo de alert");

let contestacion = confirm("Estas conforme con la accion");

if (contestacion) {
    console.log("Opcion aceptada");
} else {
    console.log("Opcion cancelada");
}

let nombre = prompt("Introduce tu nombre");
console.log(nombre);*/

/* Porfavor introduce tu nombre

    Bienvenido ... a la web de operaciones, que operaciones quieres 

    suma, resta, multiplicacion, division

    perfecto, vamos a sumar, dime el primer operando

    dime el segundo operando

    la suma de 4 y 6 es 10
*/

let nombre = prompt("Porfavor introduce tu nombre");
let operacion = prompt("Bienvenido "+nombre+", que operaciones quieres(suma, resta, multiplicacion, division)");
let operando1 = prompt("Perfecto, vamos a hacer una "+operacion+", dime el primer operando")*1;
let operando2 = prompt("Dime el segundo operando")*1;
switch (operacion) {
    case "suma":
            console.log("La suma de "+operando1+" y "+operando2+" es "+(operando1+operando2));
        break;
    case "resta":
            console.log("La suma de "+operando1+" y "+operando2+" es "+(operando1+operando2));
        break;
    case "multiplicacion":
            console.log("La suma de "+operando1+" y "+operando2+" es "+(operando1+operando2));
        break;
    case "division":
            console.log("La suma de "+operando1+" y "+operando2+" es "+(operando1+operando2));
        break;
}