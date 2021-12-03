package com.example.trying;

import java.io.IOException;

import org.web3j.abi.datatypes.Type;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;

public class MainContract extends SmartContract{
	private String ACCOUNT_PRIVATE_KEY;
	private String ACCOUNT_ADDRESS;
	private String MAIN_CONTRACT_ADDRESS;
	
	
	public static void DeployMainContract(String ACCOUNT_PRIVATE_KEY) {
		System.out.println("Connecting to Ethereum ...");
		Web3j web3 = Web3j.build(new HttpService(BLOCKCHAIN_URL));
	    
	    try {
	      String contract = Main_Smart_Contract.deploy(web3 ,getCredentialsFromPrivateKey(ACCOUNT_PRIVATE_KEY) , GAS_PRICE, GAS_LIMIT).send().getContractAddress();
	      System.out.println("Main Contract deployed at address: "+ contract);
	
	    } catch (IOException ex) {
	      throw new RuntimeException("Error whilst sending json-rpc requests", ex);
	      
	    } catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Main_Smart_Contract connectMainContract(String MAIN_SMART_CONTRACT_ADDRESS, String ACCOUNT_PRIVATE_KEY) {
		Web3j web3 = ConnectToBlockchain(BLOCKCHAIN_URL);
		System.out.println("Successfuly connected to Ethereum");
		try {
			Main_Smart_Contract rootContract = Main_Smart_Contract.load(MAIN_SMART_CONTRACT_ADDRESS, web3,
					getCredentialsFromPrivateKey(ACCOUNT_PRIVATE_KEY), GAS_PRICE, GAS_LIMIT);
			System.out.println("Root contract connected: " + rootContract.getContractAddress());
			System.out.println("------------------------------------------------------------");
			return rootContract;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void createChildContract(String MAIN_SMART_CONTRACT_ADDRESS, String ACCOUNT_PRIVATE_KEY) {
		System.out.println("Error occurred here");
		TransactionReceipt result;
		try {
			result = connectMainContract(MAIN_SMART_CONTRACT_ADDRESS, ACCOUNT_PRIVATE_KEY).createSmartContract().send();
			System.out.println("Branch contract deployed: " + result.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getChildAddress(String MAIN_SMART_CONTRACT_ADDRESS, String ACCOUNT_PRIVATE_KEY, String ACCOUNT_ADDRESS) {
		Type childAddress;
		try {
			childAddress = connectMainContract(MAIN_SMART_CONTRACT_ADDRESS, ACCOUNT_PRIVATE_KEY).getCompanySmartContractAddress(ACCOUNT_ADDRESS).send();
			System.out.println("Child contract's address allocated to the company is: " + childAddress.getValue());
			return (String) childAddress.getValue();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Wrong data";
	}
	
	
}
