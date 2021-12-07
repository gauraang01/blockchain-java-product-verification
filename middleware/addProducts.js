const axios = require('axios');

const production = 'https://minor-backend-springboot.herokuapp.com';
const development = 'http://localhost:8080';

const addProducts = (req,res,next)=>{
    const {walletKey, walletAddress, contractAddress, p1, p2} = req.body;
    try{
        axios.get(development+'/addProduct?USER_WALLET_KEY=' + walletKey + '&USER_WALLET_ADDRESS=' + walletAddress + '&CHILD_CONTRACT_ADDRESS=' + contractAddress + '&p1=' +p1)
            .then(response => {
                console.log(response.data);
                next();
            })
            .catch(error => {
                console.log(error);
                next();
            });
    }catch(err){
        console.log(err);
        next();
    }
}

module.exports = addProducts;