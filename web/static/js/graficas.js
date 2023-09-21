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