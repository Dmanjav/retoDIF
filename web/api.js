// Configuración (puerto)
const PORT = 3000;

const express = require("express")
const app = express()

app.get('/', (req, res) => {
    res.statusCode = 200
    res.send("login.html")
});

app.get("/login", (req,res))

// start server
app.listen(PORT, () => {
    console.log(`Example app listening at http://localhost:${PORT}`);
});

