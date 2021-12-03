package com.example.trying;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.web3j.abi.datatypes.Type;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

public class ChildContract extends MainContract {
	
	private static Company_Smart_Contract connectChildContract(String Child_SMART_CONTRACT_ADDRESS, String OWNER_WALLET_KEY) {
			
		System.out.println("Connecting to Ganache Ethereum ...");
		Web3j web3 = ConnectToBlockchain(BLOCKCHAIN_URL);
		
		try {
			System.out.println("Connecting to smart contract.....");
			
			Company_Smart_Contract ChildContract = Company_Smart_Contract.load(Child_SMART_CONTRACT_ADDRESS, web3,
					getCredentialsFromPrivateKey(OWNER_WALLET_KEY), GAS_PRICE, GAS_LIMIT);
			
			System.out.println("Child contract loaded:" + ChildContract.getContractAddress());
			
			return ChildContract;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public static void addProducts(String Child_SMART_CONTRACT_ADDRESS, String OWNER_WALLET_KEY, String OWNER_WALLET_ADDRESS, List<BigInteger> products ) {
		TransactionReceipt result;
		try {
			result = connectChildContract(Child_SMART_CONTRACT_ADDRESS, OWNER_WALLET_KEY).addProducts(OWNER_WALLET_ADDRESS, products).send();
			System.out.println("Products added: " + result.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String verifyProduct(String Child_SMART_CONTRACT_ADDRESS, String OWNER_WALLET_KEY, BigInteger HASHCODE) {
		try {
			Type result = connectChildContract(Child_SMART_CONTRACT_ADDRESS, OWNER_WALLET_KEY).verifyProduct(HASHCODE).send();
			System.out.println("The product is: " + result.getValue().toString());
			return result.getValue().toString();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}
}
