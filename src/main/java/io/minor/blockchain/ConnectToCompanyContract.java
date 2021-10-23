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

public class ConnectToCompanyContract {
	
	private final static String RINKEBY_KEY = "0727368c7ae05fdaa0557f129388102a52a5a8643409c16e7a745c91ac791e98";
	private final static String GANACHE_KEY = "57d72b658e6a36a3409e52b1e4aebeae89680308ce8063edfa6ae320efe580bf";
	
	
	private final static String CHILD_SMART_CONTRACT_ADDRESS = "0xfaad251ff00a505fecf981099c975ad1e25836d6";

	
	private final static String PRIVATE_KEY = RINKEBY_KEY;
	private final static BigInteger GAS_LIMIT = DefaultGasProvider.GAS_LIMIT;
	public static final BigInteger GAS_PRICE = DefaultGasProvider.GAS_PRICE;

	
		public static void main(String[] args) {

			System.out.println("Connecting to Ganache Ethereum ...");

			//Web3j web3 = Web3j.build(new HttpService());
			Web3j web3 = Web3j.build(new
			HttpService("https://rinkeby.infura.io/v3/35689e739123405ba066ed5674070d27"));

			try {
				System.out.println("Connecting to smart contract");

				Company_Smart_Contract childContract = Company_Smart_Contract.load(CHILD_SMART_CONTRACT_ADDRESS, web3,
						getCredentialsFromPrivateKey(), GAS_PRICE, GAS_LIMIT);

				// String deployedAddress = deployContract(web3,
				// getCredentialsFromPrivateKey());
				
				
				System.out.println("Contract loaded:" + childContract.getContractAddress());
				
				String OWNER_ADDRESS = "0x00473E1000a089190Ed582f3B1643EAefB4af6d2";
				List<BigInteger> list = new ArrayList<BigInteger>() {{
					  add(new BigInteger("12345"));
					  add(new BigInteger("23456"));
					}};
				TransactionReceipt result = childContract.addProducts(OWNER_ADDRESS,list).send();
				System.out.println("transaction result: " + result.toString());

				/*
				 * System.out.println("Storing value"); TransactionReceipt storeValue =
				 * mainContract.storeValue(new BigInteger("100")).send();
				 * System.out.println("Value stored");
				 */

				/*
				 * Type getData =
				 * mainContract.retrieve("0xee4c76c1a1e16d2de517963e908d0856efb0e9d3").send();
				 * System.out.println("Data fetched: " + getData.getValue());
				 * 
				 * 
				 * Type getCompanyContratAddress1 = mainContract.getCompanySmartContractAddress(
				 * "0x00873E1000a089190Ed582f3B1643EAefB4af6d2").send();
				 * System.out.println("Finally: " + getCompanyContratAddress1.getValue());
				 */
				

			} catch (IOException ex) {
				throw new RuntimeException("Error whilst sending json-rpc requests", ex);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		private static Credentials getCredentialsFromPrivateKey() {
			return Credentials.create(PRIVATE_KEY);

		}
}


