let usuarios = [
    {
        nombre:"Jose Maria",
        apellidos: "Vera Verdezoto",
        genero: "Masculino",
        edad:20,
        conocimientos: [
            { area: "Informatica", tema: "Programacion"},
            { area: "Informatica", tema: "Sistemas"},
            { area: "Diseño", tema: "videojuegos"},
            { area: "Analisis", tema: "BigData"}
        ]
    },
    {
        nombre:"Celia",
        apellidos: "Rodriguez",
        genero: "Femenino",
        edad:15,
        conocimientos: [
            { area: "Medicina", tema: "Odontologia"},
            { area: "Cocina", tema: "Tailandesa"},
            { area: "Informatica", tema: "interiores"}
        ]
    },
    {
        nombre:"Francisco",
        apellidos: "Morgan",
        genero: "Masculino",
        edad:35,
        conocimientos: [
            { area: "Ingenieria", tema: "Aeronautica"},
            { area: "Cocina", tema: "Italiana"}
        ]
    },
    {
        nombre:"Lina",
        apellidos: "Gonzalez",
        genero: "Femenino",
        edad:42,
        conocimientos: [
            { area: "Medicina", tema: "Odontologia"},
            { area: "Medicina", tema: "Fisioterapeuta"},
            { area: "Psicologia", tema: "Terapia ocupacional"}
        ]
    }
];

//console.log(usuarios[0].nombre);
/*
usuarios.forEach(item => {
    comprobante = false;
    item.conocimientos.forEach(element => {
        if(element.area.toLowerCase() == "informatica"){
            comprobante = true;
        }
    });
    if (comprobante) {
        console.log(item.nombre);
    }
});

let arrayFemenino = [];

usuarios.forEach(element => {
    if (element.genero.toLowerCase() == "femenino") {
        arrayFemenino.push(element);
    }
});

console.log(arrayFemenino);
*/
//console.log(usuarios.filter(element=>element.genero.toLowerCase()=="femenino"));

let persona = new personas("Jose","Vera",19,[]);

console.log(persona.getEdad);
persona.setEdad = 12;

persona.mostrarDatos()
