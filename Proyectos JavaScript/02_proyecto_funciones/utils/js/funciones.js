let numeros = [1,2,3,4,5,6,7,8,9,10];
let palabras = ["p1","p2","p3","p4"];
let palabrasYNumeros = [1,"p1",false,3.14];
let alumnos = ["Borja","Jose","Marcos","Roberto","David","Victor"];
console.log(alumnos);

for (let index = 0; index < alumnos.length; index++) {
    console.log(alumnos[index]);
}

alumnos.forEach((element,index,array) => {
    console.log(`${index}. ${element}`);
});

//comparar -acceder posiciones 

if (alumnos[1] == "jose"){
    console.log("Alumno encontrado");
}
let existe = false;
function comprobarAlumno(param1) {
    alumnos.forEach(element => {
        if (element.toLowerCase() == param1.toLowerCase()){
            existe = true;
        }
    });   
    
    if (existe){
        alert(`${param1} esta en clase`);
    }else{
        alert(`${param1} no esta en clase`);
    }
}

function encontrarNombre(nombre){

    alumnos.forEach((item,pos) => {
        if (element.toLowerCase()==nombre.toLowerCase()){
            console.log("Alumno Encontrado");
        }
    });

    /*
    for (let index = 0; index < alumnos.length; index++) {
        if (nombre.toLowerCase()== alumnos[index].toLowerCase()){
            console.log("Alumno encontrado");
        }
    }*/
}

comprobarAlumno("Borja");