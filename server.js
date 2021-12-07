const express = require("express");
const app = express();
const bodyParser = require('body-parser');

const createBranchContract = require("./middleware/createBranchContract");
const addProducts = require("./middleware/addProducts");
const verification = require("./middleware/verification");


const PORT = process.env.PORT || 5000;

app.set("view engine", "ejs");

app.use(express.static('public'))

app.use(bodyParser.urlencoded({ extended: true })); 

app.get('/', (req,res)=>{
    res.send("Welcome to our minor projrct");
})

app.get('/register', (req, res) => {
    res.render('register');
})

app.post('/deploy',createBranchContract,(req,res)=>{
    
    res.render('info',{text: `Company's smart contract address is: ${req.childAddress}`});
})

app.get('/addProducts',(req,res)=>{
    res.render('addProducts');
})

app.post('/added',addProducts, (req,res)=> {
    res.render('info',{text:"Products added"});
})

app.get('/verifyProducts',(req,res)=>{
    res.render('verifyProducts');
})

app.post('/verified', verification, (req,res)=>{
    res.render('info',{text:`The product is: ${req.result}`});
})

app.listen(PORT, ()=> {
    console.log(`Listining at ${PORT}`);
})