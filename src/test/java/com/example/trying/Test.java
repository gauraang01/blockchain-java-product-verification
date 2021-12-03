package com.example.trying;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test {
	
	public String USER_WALLET_ADDRESS="";
	public String USER_WALLET_KEY ="";
	public String MAIN_CONTRACT_ADDRESS = "";
	public String CHILD_CONTRACT_ADDRESS = "";
	
	Test (String USER_WALLET_KEY, String USER_WALLET_ADDRESS, String USER_MAIN_CONTRACT_ADDRESS){
		this.USER_WALLET_KEY = USER_WALLET_KEY;
		this.USER_WALLET_ADDRESS = USER_WALLET_ADDRESS;
		this.MAIN_CONTRACT_ADDRESS = USER_MAIN_CONTRACT_ADDRESS;
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("---Smart Contract Interaction----");
		
		String main_contract_address ="0x3f41f0c797704d20687fc1e17ac7cd8f09d3baf6";
		String user_wallet_key = "0727368c7ae05fdaa0557f129388102a52a5a8643409c16e7a745c91ac791e98";
		System.out.println("Input your wallet address: ");
		
		String user_wallet_address = sc.nextLine();
		Test t1 = new Test(user_wallet_key, user_wallet_address, main_contract_address);
		System.out.println("---------------------------------------------------------------------------");	
		
		int CHECK = 0;
		while(CHECK == 0) {
			
			System.out.println("\n\n");
			System.out.println("Input (1) to create a child contract \n"
					+ "Input (2) To add products to the smart contract \n"
					+ "Input (3) To verify whether the product exists in Company's child contract \n"
					+ "Input (4) To Restart \n"
					+ "Input (5) To exit");
			
			int choice = sc.nextInt();
			switch(choice){
				case 1:
					MainContract.createChildContract(t1.MAIN_CONTRACT_ADDRESS, t1.USER_WALLET_KEY);
					t1.CHILD_CONTRACT_ADDRESS = MainContract.getChildAddress(t1.MAIN_CONTRACT_ADDRESS, t1.USER_WALLET_KEY, t1.USER_WALLET_ADDRESS);
				break;
				
				case 2:
					System.out.println("Enter code for first product: ");
					BigInteger p1 = sc.nextBigInteger();
					System.out.println("Enter code for second product: ");
					BigInteger p2 = sc.nextBigInteger();
					
					List<BigInteger> list = Arrays.asList(p1, p2);
					
					if(t1.CHILD_CONTRACT_ADDRESS == "") {
						System.out.println("Press 1 first");
					}else {
						ChildContract.addProducts(t1.CHILD_CONTRACT_ADDRESS, t1.USER_WALLET_KEY, t1.USER_WALLET_ADDRESS, list);
					}
				break;
				
				case 3:
					System.out.println("Enter code for the product you want to verify");
					BigInteger hashcode = sc.nextBigInteger();
					ChildContract.verifyProduct(t1.CHILD_CONTRACT_ADDRESS, t1.USER_WALLET_KEY, hashcode);
				break;
				
				case 4:
				break;
				
				case 5:
					CHECK = 1;
				break;
				
				default:
					System.out.println("Restarting.....");
			}
		}
	}

}
