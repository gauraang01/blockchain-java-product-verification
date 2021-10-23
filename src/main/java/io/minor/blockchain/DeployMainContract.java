package io.minor.blockchain;

import java.io.IOException;
import java.math.BigInteger;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.DefaultGasProvider;

public class DeployMainContract {

	private final static String PRIVATE_KEY = "57d72b658e6a36a3409e52b1e4aebeae89680308ce8063edfa6ae320efe580bf"; 
	private final static BigInteger GAS_LIMIT = DefaultGasProvider.GAS_LIMIT;
	public static final BigInteger GAS_PRICE = DefaultGasProvider.GAS_PRICE;
	  
	 
	
	
	private static Credentials getCredentialsFromPrivateKey() {
		  return Credentials.create(PRIVATE_KEY); 	
	  }
	  

	
	public static void main(String[] args) {
		System.out.println("Connecting to Ganache Ethereum ...");
		
		Web3j web3 = Web3j.build(new HttpService());
	    
	    try {
	     
	      String contract = Main_Smart_Contract.deploy(web3 ,getCredentialsFromPrivateKey() , GAS_PRICE, GAS_LIMIT).send().getContractAddress();
	      
	      
	      System.out.println("Contract deployed:"+ contract);
	      
	
	    } catch (IOException ex) {
	      throw new RuntimeException("Error whilst sending json-rpc requests", ex);
	      
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
}
