//Objeto que debe recibir del API los datos para horas del día
//Var: horarios
const genteHora = {
    cantidad: [
        [2, 5, 3, 7, 1, 2, 3], //the total is 23
        [1, 4, 7, 8, 6, 4, 2], //the total is 32
        [3, 4, 2, 3, 12, 5, 4], //the total is 26
        [1, 2, 2, 3, 4, 5, 6], //the total is 23
        [1, 3, 2, 6, 3, 6, 5], //the total is 16
        [0, 4, 2, 8, 9, 4, 3], //the total is 30
        [1, 0, 2, 6, 3, 6, 5], //the total is 15
    ]
}

//Objeto para conocer la gente por hora del día
//Var: horarios
const horasPorDia = {
    horario: [
        ["12:00"],
        ["1:00"],
        ["2:00"],
        ["3:00"],
        ["4:00"],
        ["5:00"],
        ["6:00"]
    ]
}

//Objeto para conocer los días de la semana
//Var: daysPerWeek
const diasPorSem = {
    nombredia: [
        ["Lunes"],
        ["Martes"],
        ["Miercoles"],
        ["Jueves"],
        ["Viernes"],
        ["Sabado"],
        ["Domingo"]
    ]
}

//Objeto para conocer la gente por día de la semana
//Var: daysPerWeek
const genteDia = {
    cantidad: [
        [23],
        [32],
        [26],
        [23],
        [16],
        [30],
        [15]
    ]
}

//Objeto para conocer los comedores con más ventas
//Var: top10ventas
const comedor = {
    nombre: [
        ["Comedor 1"],
        ["Comedor 2"],
        ["Comedor 3"],
        ["Comedor 4"],
        ["Comedor 5"],
        ["Comedor 6"],
        ["Comedor 7"]
    ],
    cantidad: [
        [23],
        [32],
        [26],
        [23],
        [16],
        [30],
        [15]
    ]
}

//Objeto para conocer el porcentaje de hombres y mujeres
//Var: poblacion
const distSex = {
    sexo: [
        ["Hombre"],
        ["Mujer"]
    ],
    cantidad: [
        [23],
        [32]
    ]
}

//Objeto para conocer la distribución de edades
//Var: edades
const rangoEdades = {
    rango: [
        ["18-25"],
        ["26-35"],
        ["36-45"],
        ["46-55"],
        ["56-65"],
        ["66-75"],
        ["76-85"],
        ["86-95"]
    ],
    cantidad: [
        [23],
        [32],
        [26],
        [23],
        [16],
        [30],
        [15],
        [10]
    ]
}

//Objeto para conocer la distribución de donaciones
//Var: donacions
const donaciones = {
    valor : [
        ["Sí"],
        ["No"]
    ],
    cantidad : [
        [23],
        [32]
    ]
}

//Objeto para conocer la distribución de las dependencias
//Var: dependencias
const dependientes = {
    valor : [
        ["Dependiente"],
        ["Independiente"]
    ],
    cantidad : [
        [28],
        [32]
    ]
}

//Objeto para conocer la distribución de los cierres por sucursal
//Var: cierres
const cierresSuc = {
    nombre : [
        ["Comedor 1"],
        ["Comedor 2"],
        ["Comedor 3"],
        ["Comedor 4"],
        ["Comedor 5"],
        ["Comedor 6"],
        ["Comedor 7"]
    ],
    cantidad : [
        [1],
        [2],
        [3],
        [4],
        [5],
        [6],
        [7]
    ]
}

//Objeto para conocer la complitud? de las metas
//Var: metas
const metasCum = {
    objetivo: [
        [50],
        [50],
        [50],
        [50],
        [50],
        [50],
        [50]
    ],
    cantReal: [
        [62],
        [48],
        [52],
        [46],
        [50],
        [48],
        [50]
    ]
}