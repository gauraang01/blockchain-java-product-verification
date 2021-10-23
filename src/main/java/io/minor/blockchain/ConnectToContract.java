package io.minor.blockchain;

import java.io.IOException;
import java.math.BigInteger;

import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;

public class ConnectToContract extends SmartContract{

	private final static String MAIN_SMART_CONTRACT_ADDRESS = "0x851fbab03e3c32b71f53083289d54c13fc250f45";

	private final static String PRIVATE_KEY = GANACHE_KEY;
	
	public static void main(String[] args) {
		Web3j web3 = ConnectToBlockchain(GANACHE_URL);
		
		System.out.println("Successfuly connected to Ganache Ethereum");
		System.out.println("------------------------------------------------------------");

		try {

			System.out.println("Connecting to smart contract");

			Main_Smart_Contract mainContract = Main_Smart_Contract.load(MAIN_SMART_CONTRACT_ADDRESS, web3,
					getCredentialsFromPrivateKey(PRIVATE_KEY), GAS_PRICE, GAS_LIMIT);

			System.out.println("Root contract loaded:" + mainContract.getContractAddress());

			TransactionReceipt result = mainContract.createSmartContract().send();
			System.out.println("Branch contract deployed: " + result.toString());

			System.out.println("------------------------------------------------------------");

			 Type getCompanyContratAddress1 = mainContract.getCompanySmartContractAddress("0x699846e7b68f4C7d55dCFC242A6f4373251dc31b").send();
			 System.out.println("Child contract's address allocated to the company is: " + getCompanyContratAddress1.getValue());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
