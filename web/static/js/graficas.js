//import { genteHora } from './valores.js';

// Crea un objeto gráfico
var daysPerWeek = new Chart(document.getElementById("myChart"), {
    // Define el tipo de gráfico
    type: "bar",
    // Define los datos
    data: {
        labels: ["Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"],
        datasets: [{
            label: "Días de la semana",
            data: [23, 32, 26, 23, 16, 30, 15],
            backgroundColor: [
                'rgba(255, 99, 132, 0.5)',
                'rgba(255, 255, 64, 0.5)',
                'rgba(54, 162, 235, 0.5)',
                'rgba(100, 255, 255, 0.5)',
                'rgba(200, 140, 255, 0.5)',
                'rgba(180, 47, 202, 0.5)',
                'rgba(20, 150, 102, 0.5)']
        }],
    },
    options: {
        title: {
            display: true,
            text: "Ventas por día"
        }
    }
});

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

var horarios = new Chart(document.getElementById("myChart2"), {
    // Define el tipo de gráfico
    type: "line",
    // Define los datos
    data: {
        labels: ["12:00","1:00", "2:00", "3:00", "4:00", "5:00", "6:00"],
        datasets: [{
            label: "# Clientes",
            data: genteHora.cantidad[0],
        }],
    },
    options: {
        title: {
            display: true,
            text: "Clientes por Horario"
        }
    }
});

function clickHandler(click) {
    console.log('click');
    const points = daysPerWeek.getElementsAtEventForMode(click, 'nearest', { intersect: true }, true);
    console.log(points);
    if (points.length) {
        //console.log(points[0].index); Esta cosa saca a que lugar está apuntando de la gráfica
        horarios.data.datasets[0].data = genteHora.cantidad[points[0].index];
        horarios.update();
    }
}

daysPerWeek.canvas.onclick = clickHandler;


var top10ventas = new Chart(document.getElementById("myChart3"), {

    type: "bar",
    data: {
        labels: [],
        datasets: [{
            label: "Top 10 Comedores x Ventas",
            data: [],
        }]
    },
    options: {
        title: {
            display: true,
            text: "Top 10 ventas"
        }
    }
});

var poblacion = new Chart(document.getElementById("myChart4"), {
    type: "doughnut",
    data: {
        labels: ["Hombres", "Mujeres"],
        datasets: [{
            label: "Población",
            data: [47, 53],
            backgroundColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(255, 255, 64, 1)',
            ]
        }]
    },
    options: {
        title: {
            display: true,
            text: "% Población"
        }
    }
});

var poblacion = new Chart(document.getElementById("myChart5"), {
    type: "polarArea",
    title: "Distribución de edades",
    data: {
        labels: ["10+", "20+", "30+", "40+", "50+", "60+", "70+", "80+", "90+"],
        datasets: [{
            label: "Población",
            data: [3, 5, 7, 8, 6, 4, 2, 1, 0],
        }]
    },
});

var donacions = new Chart(document.getElementById("myChart6"), {
    type: "doughnut",
    title: "Donaciones",
    data: {
        labels: ["Si", "No"],
        datasets: [{
            label: "Donaciones",
            data: [30, 150],
            backgroundColor: [
                'rgba(255, 0, 255, 1)',
                'rgba(150, 225, 64, 1)',
            ]
        }]
    },
});

var dependencias = new Chart(document.getElementById("myChart7"), {
    type: "bar",
    title: "Dependencias",
    data: {
        labels: ["Dependientes", "Independientes"],
        datasets: [{
            label: "Dependencias", 
            data: [23, 41],
            backgroundColor: [
                'rgba(0, 255, 10, 1)',
                'rgba(0, 255, 200, 1)',
            ]
        }]
    },
});

var cierres = new Chart(document.getElementById("myChart8"), {
    type: "polarArea",
    title: "Cierres por sucursal",
    data: {
        labels: ["Comedor 1", "Comedor 2", "Comedor 3", "Comedor 4", "Comedor 5"],
        datasets: [{
            label: "Cierres",
            data: [5, 3, 4, 2, 7],
            backgroundColor: [
                'rgba(255, 0, 0, 1)',
                'rgba(255, 255, 0, 1)',
                'rgba(0, 255, 0, 1)',
                'rgba(0, 255, 255, 1)',
                'rgba(0, 0, 255, 1)',
            ],
        }]
    },
});

var metas = new Chart(document.getElementById("myChart9"), {
    data: {
        datasets: [{
            type: 'line',
            label: "Objetivo de la Meta",
            data: [50, 50, 50, 50, 50, 50],
            backgroundColor: 'rgba(130, 250, 80, 1)',
        }, 
        {
            type: 'bar',
            label: "Venta",
            data: [43, 51, 50, 49, 48, 47],
            backgroundColor: 'rgba(100, 95, 182, 1)',
        }],
        labels: ["Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"],
    },
    options: {
        title: {
            display: true,
            text: "Metas"
        }
    }
});