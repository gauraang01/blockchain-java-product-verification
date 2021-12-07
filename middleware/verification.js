const axios = require('axios');

const production = 'https://minor-backend-springboot.herokuapp.com';
const development = 'http://localhost:8080';

const verification = (req,res,next)=>{
    const {walletKey, contractAddress, result} = req.body;
    try{
        axios.get(development + '/verifyProduct?USER_WALLET_KEY='+ walletKey + '&CHILD_CONTRACT_ADDRESS=' + contractAddress + '&data='+result)
            .then(response => {
                console.log(response.data);
                req.result = response.data;
                next();
            })
            .catch(error => {
                console.log(error);
                next();
            });
    }catch(error){
        console.log(error);
    }
}

module.exports = verification;