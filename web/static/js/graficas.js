async function getComedores() {
    await fetch("http://localhost:5000/queries/get-comedores", {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("HTTP error " + response.status);
            }
            return response.json();
        })
        .then(data => {
            for (key in data) {
                llaves.push(key)
                ids.push(data[key])
            }
            return data;
        })
        .catch(error => {
            console.log('Hubo un error: ', error);
        });
}

async function getTopVentas() {
    await fetch("http://localhost:5000/queries/get-top-ventas", {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("HTTP error " + response.status);
            }
            return response.json();
        })
        .then(data => {
            for (elem in data) {
                top10labels.push(elem)
                top10data.push(data[elem])
            }
        })
        .catch(error => {
            console.log('Hubo un error: ', error);
        });
}

async function getCierres() {
    await fetch("http://localhost:5000/queries/get-cierres", {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("HTTP error " + response.status);
            }
            return response.json();
        })
        .then(data => {
            for (elem in data) {
                cierreslabels.push(elem)
                cierresdata.push(data[elem])
            }
        })
        .catch(error => {
            console.log('Hubo un error: ', error);
        });
}

async function getDependencias() {
    await fetch("http://localhost:5000/queries/get-num-dependencias", {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("HTTP error " + response.status);
            }
            return response.json();
        })
        .then(data => {
            for (elem in data) {
                dependata.push(data[elem])
            }
        })
        .catch(error => {
            console.log('Hubo un error: ', error);
        });
}

async function getSexos() {
    await fetch("http://localhost:5000/queries/get-cant-sexos", {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("HTTP error " + response.status);
            }
            return response.json();
        })
        .then(data => {
            for (elem in data) {
                sexodata.push(data[elem])
            }
        })
        .catch(error => {
            console.log('Hubo un error: ', error);
        });
}

async function getEdades() {
    await fetch("http://localhost:5000/queries/get-edades", {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("HTTP error " + response.status);
            }
            return response.json();
        })
        .then(data => {
            for (elem in data) {
                edadlabels.push(elem)
                edaddata.push(data[elem])
            }
        })
        .catch(error => {
            console.log('Hubo un error: ', error);
        });
}

async function getVentasDia(id) {
    await fetch("http://localhost:5000/queries/get-ventas-dia?idComedor=" + [id], {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("HTTP error " + response.status);
            }
            return response.json();
        })
        .then(data => {
            for (elem in data){
                ventaslabels.push(elem)
                ventasdata.push(data[elem])
            }
        })
        .catch(error => {
            console.log('Hubo un error: ', error);
        });
}

async function getVentasHora(id) {
    await fetch("http://localhost:5000/queries/get-ventas-hora?idComedor=" + [id], {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("HTTP error " + response.status);
            }
            return response.json();
        })
        .then(data => {
            for (elem in data){
                ventaHoralabels.push(elem)
                ventaHoradata.push(data[elem])
            }
        })
        .catch(error => {
            console.log('Hubo un error: ', error);
        });
}

async function getDonaciones(id) {
    await fetch("http://localhost:5000/queries/get-donaciones?idComedor=" + [id], {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("HTTP error " + response.status);
            }
            return response.json();
        })
        .then(data => {
            for (elem in data){
                donacioneslabels.push(elem)
                donacionesdata.push(data[elem])
            }
        })
        .catch(error => {
            console.log('Hubo un error: ', error);
        });
}

async function getMetas(id) {
    await fetch("http://localhost:5000/queries/get-metas?idComedor=" + [id], {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
    })
        .then(response => {
            if (!response.ok) {
                throw new Error("HTTP error " + response.status);
            }
            return response.json();
        })
        .then(data => {
            for (elem in data){
                metaslabels.push(elem)
                metasdata.push(data[elem])
            }
        })
        .catch(error => {
            console.log('Hubo un error: ', error);
        });
}

generar_datos()

const ids = []
const llaves = []
const datos = []
const top10data = []
const top10labels = []
const cierresdata = []
const cierreslabels = []
const dependata = []
const sexodata = []
const edaddata = []
const edadlabels = []

var ventasdata = []
var ventaslabels = []
var ventaHoradata = []
var ventaHoralabels = []
var donacionesdata = []
var donacioneslabels = []
var metasdata = []
var metaslabels = []
var objetivos = []


async function contar_llaves() {
    await getComedores()
    tamaño = llaves.length
    for (let i = 0; i < tamaño; i++) {
        datos.push(1);
    }
}


async function generar_datos() {
    await contar_llaves();
    await getTopVentas();
    await getCierres();
    await getDependencias();
    await getSexos();
    await getEdades();
    generar_graficas()
}

//Información General
function generar_graficas() {
    //Selector De comedores
    var comedores = new Chart(document.getElementById("myChart10"), {
        type: "pie",
        title: "Selector de comedores",
        data: {
            labels: llaves,
            datasets: [
                {
                    data: datos,
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

    //FUNCIÓN QUE VA A SACAR LOS DATOS DEL API
    async function clickHandler(click) {
        const points = comedores.getElementsAtEventForMode(click, 'nearest', { intersect: true }, true);
        if (points.length) {
            const name = comedores.data.labels[points[0].index];
            const idSeleccionado = ids[points[0].index];
            console.log(name)
            console.log(idSeleccionado)

            activeSelection = { name, id: idSeleccionado };
            console.log(activeSelection)

            // Gráfica 1
            while(ventasdata.length > 0) {
                ventasdata.pop();
            }
            while(ventaslabels.length > 0) {
                ventaslabels.pop();
            }
            await getVentasDia(idSeleccionado)
            daysPerWeek.update();
            // Gráfica 2
            while(ventaHoradata.length > 0) {
                ventaHoradata.pop();
            }
            while(ventaHoralabels.length > 0) {
                ventaHoralabels.pop();
            }
            await getVentasHora(idSeleccionado);
            horarios.update();
            // Gráfica 3
            while(donacionesdata.length > 0) {
                donacionesdata.pop();
            }
            while(donacioneslabels.length > 0) {
                donacioneslabels.pop();
            }
            await getDonaciones(idSeleccionado);
            donaciones.update();
            // Gráfica 4
            while(metasdata.length > 0) {
                metasdata.pop();
            }
            while(metaslabels.length > 0) {
                metaslabels.pop();
            }
            await getMetas(idSeleccionado);
            metas.update();
            dias = metaslabels.length
            for (let i = 0; i < dias; i++) {
                objetivos.push(50);
            }
        }
    }
    comedores.canvas.onclick = clickHandler;

    //Comedores con más Ventas
    var top10ventas = new Chart(document.getElementById("myChart3"), {
        type: "bar",
        data: {
            labels: top10labels,
            datasets: [
                {
                    label: "Top 10 Comedores x Ventas",
                    data: top10data,
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
            labels: cierreslabels,
            datasets: [
                {
                    label: "Cierres",
                    data: cierresdata,
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
            // labels: [
            //     "Lunes",
            //     "Martes",
            //     "Miércoles",
            //     "Jueves",
            //     "Viernes",
            //     "Sábado",
            //     "Domingo",
            // ],
            labels: ventaslabels,
            datasets: [
                {
                    label: "Cantidad de Clientes",
                    // data: lsVentas.com1[0],
                    data: ventasdata,
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
            // labels: ["12:00", "1:00", "2:00", "3:00", "4:00", "5:00", "6:00"],
            labels: ventaHoralabels,
            datasets: [
                {
                    label: "# Clientes",
                    data: ventaHoradata,
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

    //Sexo de los clientes
    var poblacion = new Chart(document.getElementById("myChart4"), {
        type: "doughnut",
        data: {
            labels: ["Mujeres", "Hombres"],
            datasets: [
                {
                    label: "Población",
                    data: sexodata,
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
            labels: edadlabels,
            datasets: [
                {
                    label: "Población",
                    data: edaddata,
                },
            ],
        },
    });

    //Cantida de donaciones
    var donaciones = new Chart(document.getElementById("myChart6"), {
        type: "doughnut",
        title: "Donaciones",
        data: {
            labels: donacioneslabels,
            datasets: [
                {
                    label: "Ventas",
                    data: donacionesdata,
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
                    data: dependata,
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
                    data: objetivos,
                    backgroundColor: "rgba(130, 250, 80, 1)",
                },
                {
                    type: "bar",
                    label: "Venta",
                    data: metasdata,
                    backgroundColor: "rgba(100, 95, 182, 1)",
                },
            ],
            labels: metaslabels,
        },
        options: {
            title: {
                display: true,
                text: "Metas",
            },
        },
    });
}