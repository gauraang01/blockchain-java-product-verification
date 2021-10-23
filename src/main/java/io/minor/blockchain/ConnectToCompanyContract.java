package io.minor.blockchain;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.web3j.abi.datatypes.Array;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;

public class ConnectToCompanyContract extends SmartContract{
	
	private final static String CHILD_SMART_CONTRACT_ADDRESS = "0x9a278ebccf42c6fc1620f8da8df26e677b8911fd";
	
	private final static String PRIVATE_KEY = GANACHE_KEY; 

		public static void main(String[] args) {
			
			System.out.println("Connecting to Ganache Ethereum ...");
			Web3j web3 = ConnectToBlockchain(GANACHE_URL);

			try {
				System.out.println("Connecting to smart contract");
				
				Company_Smart_Contract childContract = Company_Smart_Contract.load(CHILD_SMART_CONTRACT_ADDRESS, web3,
						getCredentialsFromPrivateKey(PRIVATE_KEY), GAS_PRICE, GAS_LIMIT);
				
				
				System.out.println("Child contract loaded:" + childContract.getContractAddress());
				
				String OWNER_ADDRESS = "0x699846e7b68f4C7d55dCFC242A6f4373251dc31b";
				
				List<BigInteger> list = new ArrayList<BigInteger>() {{
					  add(new BigInteger("12345"));
					  add(new BigInteger("23456"));
					}};
				
					TransactionReceipt result = childContract.addProducts(OWNER_ADDRESS,list).send();
					System.out.println("Products added: " + result.toString());

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		
}


