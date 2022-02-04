// funciones 
function metodoParametros(param1, param2, param3)
{
    console.log(param1);
    console.log(param2);
    console.log(param3);
    console.log(arguments)
}

let variableMetodo = function (param1, param2){
    console.log(param1);
    console.log(param2);
}

function metodoPorDefecto (param1, param2){
    //param2 = param2 || "Por Defecto"
    if (typeof param2 == undefined){
        param2 = "Por Defecto"
    }
    console.log(param1);
    console.log(param2);
}

function metodoRetorno(param1,param2){
    let suma = param1+param2;
    return suma;
}

let funcionFlecha = (param1)=>{
    console.log(param1);
};

function funcionCallback(param1,param2, param3){
    param3(param1,param2)
}

metodoParametros("borja", 4, false, 7);
variableMetodo(1, "hola");
metodoPorDefecto("Borja")
console.log(metodoRetorno(5,9));
funcionFlecha(4);
funcionCallback(1,2,(p1,p2)=>{
    console.log(p1+p2);
});
funcionCallback(1,2,(p1,p2)=>{
    console.log("*Otra definicion*");
    console.log(p1*p2);
});

array.forEach(element => {
    
});