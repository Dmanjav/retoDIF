// import { genteHora, diasPorSem } from "./valores";

const lsComedores = {
    comedores: [
        ["Cinco de Mayo"],
        ["Mexico 86"],
        ["Monte María"]
    ],
};

const genteHora = {
    cantidad: [
        [2, 5, 3, 7, 1, 2, 3], //the total is 23
        [1, 4, 7, 8, 6, 4, 2], //the total is 32
        [3, 4, 2, 3, 12, 5, 4], //the total is 26
        [1, 2, 2, 3, 4, 5, 6], //the total is 23
        [1, 3, 2, 6, 3, 6, 5], //the total is 16
        [0, 4, 2, 8, 9, 4, 3], //the total is 30
        [1, 0, 2, 6, 3, 6, 5], //the total is 15

        //     [
    //         [2, 5, 3, 7, 1, 2, 3], //the total is 23
    //         [1, 4, 7, 8, 6, 4, 2], //the total is 32
    //         [3, 4, 2, 3, 12, 5, 4], //the total is 26
    //         [1, 2, 2, 3, 4, 5, 6], //the total is 23
    //         [1, 3, 2, 6, 3, 6, 5], //the total is 16
    //         [0, 4, 2, 8, 9, 4, 3], //the total is 30
    //         [1, 0, 2, 6, 3, 6, 5], //the total is 15
    //     ], //Cinco de Mayo
    //     [
    //         [1, 0, 2, 6, 3, 6, 5], //the total is 15
    //         [0, 4, 2, 8, 9, 4, 3], //the total is 30
    //         [1, 3, 2, 6, 3, 6, 5], //the total is 16
    //         [1, 2, 2, 3, 4, 5, 6], //the total is 23
    //         [3, 4, 2, 3, 12, 5, 4], //the total is 26
    //         [1, 4, 7, 8, 6, 4, 2], //the total is 32
    //         [2, 5, 3, 7, 1, 2, 3], //the total is 23
    //     ], //Mexico 86
    //     [
    //         [1, 2, 3, 2, 1, 0, 0], //the total is 10
    //         [2, 4, 6, 4, 2, 1, 1], //the total is 20
    //         [1, 3, 5, 7, 9, 11, 13], //the total is 30
    //         [6, 6, 6, 6, 6, 6, 4], //the total is 40
    //         [7, 7, 7, 7, 7, 7, 8], //the total is 50
    //         [12, 12, 13, 9, 5, 6, 3], //the total is 60
    //         [10, 10, 10, 10, 10, 10, 10], //the total is 70
    //     ]], //Monte María
    ]
    
};

const lsVentas = {
    com1: [
        [23, 32, 26, 23, 16, 30, 15]
        // [[23, 32, 26, 23, 16, 30, 15]], //Cinco de Mayo
        // [[15, 30, 16, 23, 26, 32, 23]], //Mexico 86
        // [[10, 20, 30, 40, 50, 60, 70]], //Monte María
    ],
};

//Información General

//Selector De comedores
var comedores = new Chart(document.getElementById("myChart10"), {
    type: "pie",
    title: "Selector de comedores",
    data: {
        labels: lsComedores.comedores,
        datasets: [
            {
                data: [1, 1, 1],
                backgroundColor: [
                    "rgba(255, 0, 0, 1)",
                    "rgba(255, 255, 0, 1)",
                    "rgba(0, 255, 0, 1)",
                    "rgba(0, 255, 255, 1)",
                    "rgba(0, 0, 255, 1)",
                ],
            },
        ],
    },
    options: {
        plugins: {
            legend: {
                display: false
            }
        },
        tooltips: {
            enabled: true,
            custom: function (tooltipItem) {
                return tooltipItem.yLabel;
            },
        },
    },
});

//Comedores con más Ventas
var top10ventas = new Chart(document.getElementById("myChart3"), {
    type: "bar",
    data: {
        labels: lsComedores.comedores,
        datasets: [
            {
                label: "Top 10 Comedores x Ventas",
                data: [150, 140, 130, 120, 110, 100, 90, 80, 70, 60],
                backgroundColor: [
                    "rgba(255, 0, 0, 1)",
                    "rgba(255, 255, 0, 1)",
                    "rgba(0, 255, 0, 1)",
                    "rgba(0, 255, 255, 1)",
                    "rgba(0, 0, 255, 1)",
                ],
            },
        ],
    },
    options: {
        title: {
            display: true,
            text: "Top 10 ventas",
        },
    },
});

//Más cierres
var cierres = new Chart(document.getElementById("myChart8"), {
    type: "polarArea",
    title: "Cierres por sucursal",
    data: {
        labels: lsComedores.comedores,
        datasets: [
            {
                label: "Cierres",
                data: [5, 3, 4],
                backgroundColor: [
                    "rgba(255, 0, 0, 1)",
                    "rgba(255, 255, 0, 1)",
                    "rgba(0, 255, 0, 1)",
                    "rgba(0, 255, 255, 1)",
                    "rgba(0, 0, 255, 1)",
                ],
            },
        ],
    },
});


//Información Por Comedor

//Ventas por día
var daysPerWeek = new Chart(document.getElementById("myChart"), {
    // Define el tipo de gráfico
    type: "bar",
    // Define los datos
    data: {
        labels: [
            "Lunes",
            "Martes",
            "Miércoles",
            "Jueves",
            "Viernes",
            "Sábado",
            "Domingo",
        ],
        datasets: [
            {
                label: "Cantidad de Clientes",
                data: lsVentas.com1[0],
                backgroundColor: [
                    "rgba(255, 99, 132, 0.5)",
                    "rgba(255, 255, 64, 0.5)",
                    "rgba(54, 162, 235, 0.5)",
                    "rgba(100, 255, 255, 0.5)",
                    "rgba(200, 140, 255, 0.5)",
                    "rgba(180, 47, 202, 0.5)",
                    "rgba(20, 150, 102, 0.5)",
                ],
            },
        ],
    },
    options: {
        title: {
            display: true,
            text: "Ventas por día",
        },
    },
});

//Cantidad de clientes por horario
var horarios = new Chart(document.getElementById("myChart2"), {
    // Define el tipo de gráfico
    type: "line",
    // Define los datos
    data: {
        labels: ["12:00", "1:00", "2:00", "3:00", "4:00", "5:00", "6:00"],
        datasets: [
            {
                label: "# Clientes",
                data: genteHora.cantidad[0],
            },
        ],
    },
    options: {
        title: {
            display: true,
            text: "Clientes por Horario",
        },
    },
});

function clickHandler(click) {
    const points = daysPerWeek.getElementsAtEventForMode(click, 'nearest', { intersect: true }, true);
    if (points.length) {
        //console.log(points[0].index); Esta cosa saca a que lugar está apuntando de la gráfica
        horarios.data.datasets[0].data = genteHora.com1[points[0].index];
        horarios.update();
    }
}

daysPerWeek.canvas.onclick = clickHandler;

// function clickHandler(click) {
//     const points = comedores.getElementsAtEventForMode(click, 'nearest', { intersect: true }, true);
//     if (points.length) {
//         // Obtén el comedor en el que se hizo clic
//         const comedor = points[0].index;
//         console.log(comedor);

//         // Actualiza los datos del gráfico de `daysPerWeek` con los datos de ventas del comedor seleccionado
//         daysPerWeek.data.datasets[0].data = lsVentas[comedor][0][0]; //EL ERROR ESTÁ AQUÍ
//         daysPerWeek.update();

//         // Actualiza los datos del gráfico de `horarios` con los datos de clientes por hora del comedor seleccionado
//         horarios.data.datasets[0].data = genteHora[comedor][0][points[0].index];
//         horarios.update();
//     }
// }

// comedores.canvas.onclick = clickHandler;


//Sexo de los clientes
var poblacion = new Chart(document.getElementById("myChart4"), {
    type: "doughnut",
    data: {
        labels: ["Hombres", "Mujeres"],
        datasets: [
            {
                label: "Población",
                data: [47, 53],
                backgroundColor: ["rgba(255, 99, 132, 1)", "rgba(255, 255, 64, 1)"],
            },
        ],
    },
    options: {
        title: {
            display: true,
            text: "% Población",
        },
    },
});

//Edades de los CLientes
var edades = new Chart(document.getElementById("myChart5"), {
    type: "polarArea",
    title: "Distribución de edades",
    data: {
        labels: ["10+", "20+", "30+", "40+", "50+", "60+", "70+", "80+", "90+"],
        datasets: [
            {
                label: "Población",
                data: [3, 5, 7, 8, 6, 4, 2, 1, 0],
            },
        ],
    },
});

//Cantida de donaciones
var donacions = new Chart(document.getElementById("myChart6"), {
    type: "doughnut",
    title: "Donaciones",
    data: {
        labels: ["Si", "No"],
        datasets: [
            {
                label: "Donaciones",
                data: [30, 150],
                backgroundColor: ["rgba(255, 0, 255, 1)", "rgba(150, 225, 64, 1)"],
            },
        ],
    },
});

//Estado de los clientes
var dependencias = new Chart(document.getElementById("myChart7"), {
    type: "bar",
    title: "Dependencias",
    data: {
        labels: ["Dependientes", "Independientes"],
        datasets: [
            {
                label: "Dependencias",
                data: [23, 41],
                backgroundColor: ["rgba(0, 255, 10, 1)", "rgba(0, 255, 200, 1)"],
            },
        ],
    },
});

//Cumplimiento de metas
var metas = new Chart(document.getElementById("myChart9"), {
    data: {
        datasets: [
            {
                type: "line",
                label: "Objetivo de la Meta",
                data: [50, 50, 50, 50, 50, 50],
                backgroundColor: "rgba(130, 250, 80, 1)",
            },
            {
                type: "bar",
                label: "Venta",
                data: [43, 51, 50, 49, 48, 47],
                backgroundColor: "rgba(100, 95, 182, 1)",
            },
        ],
        labels: ["Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"],
    },
    options: {
        title: {
            display: true,
            text: "Metas",
        },
    },
});

//asdasd

