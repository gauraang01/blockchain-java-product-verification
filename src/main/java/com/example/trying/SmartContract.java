package com.example.trying;

import java.math.BigInteger;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;

public class SmartContract {
	protected final static String RINKEBY_KEY = "0727368c7ae05fdaa0557f129388102a52a5a8643409c16e7a745c91ac791e98";
	protected final static String GANACHE_KEY = "d62918d83f076839a573e9a60f48e7729c36496b9bce7db96a9a5bf9ad808583";
	
	protected final static String RINKEBY_URL ="https://rinkeby.infura.io/v3/35689e739123405ba066ed5674070d27";
	protected final static String GANACHE_URL = "HTTP://127.0.0.1:8545";
	
	protected final static String BLOCKCHAIN_URL = RINKEBY_URL;
	
	protected static String MAIN_SMART_CONTRACT_ADDRESS = "";
	
	protected final static BigInteger GAS_LIMIT = DefaultGasProvider.GAS_LIMIT;
	protected static final BigInteger GAS_PRICE = DefaultGasProvider.GAS_PRICE;
	
	protected static Web3j ConnectToBlockchain(String url) {
		Web3j web3 = Web3j.build(new HttpService(url));
		return web3;
	}
	
	protected static Web3j ConnectToBlockchain() {
		Web3j web3 = Web3j.build(new HttpService());
		return web3;
	}
	
	protected static Credentials getCredentialsFromPrivateKey(String PRIVATE_KEY) {
		return Credentials.create(PRIVATE_KEY);

	}
}
