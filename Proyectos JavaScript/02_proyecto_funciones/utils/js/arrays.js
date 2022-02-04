let alumnos = ["Borja","Jose","Marcos","Roberto","David","Victor"];
console.log(alumnos.length);
alumnos[1] = "luis nuevo";
alumnos[4] = "otro";
console.log(alumnos);


//Añadir elementos
alumnos.push("Alumno nuevo",1,2,3,4,5,6,7,8,9,10);
alumnos.unshift("inicial1","inicial2","inicial3");
console.log();
//Borrar elementos
console.log("Elemento eliminado "+alumnos.pop())
for (let index = 0; index < 3; index++) {
    console.log("Elemento eliminado "+alumnos.pop())     
}

console.log("Elemento eliminado "+alumnos.shift())


//Ejercicio 1- baraja de poker
function shuffleArray(array) {
    for (let i = array.length - 1; i > 0; i--) {
        const j = Math.floor(Math.random() * (i + 1));
        [array[i], array[j]] = [array[j], array[i]];
    }
    return array;
}

let palos = ["C","P","T","D"];
let numeros = [1,2,3,4,5,6,7,8,9,10,"J","Q","K"];
let barajaPoker = [];
numeros.forEach(item => {
    palos.forEach(element => {
        barajaPoker.push(item+element);
    });
});


barajaPoker = _.shuffle(barajaPoker);

console.log(barajaPoker);

let carta = barajaPoker.pop();
console.log(carta.substring(0,carta.length-1));