class personas {
    nombre;
    apellido;
    edad;
    conocimiento;
    constructor(nombre,apellido,edad,conocimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.conocimiento = conocimiento;
    }

    mostrarDatos(){
        console.log(`Nombre: ${this.nombre}\nApellido: ${this.apellido}\nEdad: ${this.edad}`);
    }

    get getEdad(){
        return this.edad;
    }

    set setEdad(edad){
        this.edad = edad;
    }
}