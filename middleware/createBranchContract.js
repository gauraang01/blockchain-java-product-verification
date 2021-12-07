const axios = require('axios');

const production = 'https://minor-backend-springboot.herokuapp.com';
const development = 'http://localhost:8080';

var createBranchContract = async(req,res,next)=>{
    const {walletKey, walletAddress} = req.body;

    try{
        axios.get(development +'/deployChild?USER_WALLET_KEY=' + walletKey + '&USER_WALLET_ADDRESS=' + walletAddress)
            .then(response => {
                req.childAddress = response.data;
                console.log(response.data);
                next()
            })
            .catch(error => {
                console.log(error);
        });
    }catch(err){
        console.log(err);
        next();
    }
    
};

module.exports = createBranchContract;