package com.example.trying;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiHandler {
	
	private String MAIN_CONTRACT_ADDRESS= "0xad1f0aba0ca566d8f3ce15850d57351dc3efd423";
	
	@GetMapping("/hello")
	public String hello() {
		return "Hi";
	}
	

	@RequestMapping(
			value = "/deployChild",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	
	public String deployChild(@RequestParam String USER_WALLET_KEY,@RequestParam String USER_WALLET_ADDRESS) {
		System.out.println("===============================deployChild===============================");
		System.out.println(USER_WALLET_KEY  + " " +USER_WALLET_ADDRESS);
		MainContract.createChildContract(MAIN_CONTRACT_ADDRESS, USER_WALLET_KEY);
		
		return MainContract.getChildAddress(MAIN_CONTRACT_ADDRESS, USER_WALLET_KEY, USER_WALLET_ADDRESS);
	}
	
	@GetMapping("/addProduct")
	public String addProduct(@RequestParam String USER_WALLET_KEY,@RequestParam String USER_WALLET_ADDRESS, @RequestParam String CHILD_CONTRACT_ADDRESS, @RequestParam String p1) {
		System.out.println("===============================addProduct===============================");
		System.out.println("Data: " + p1);
		System.out.println("Converting to  Hashcode......");
		int hashedvalue=p1.hashCode();
		System.out.println("Hashcode: "+hashedvalue);
		List<BigInteger> list = Arrays.asList(new BigInteger(String.valueOf(hashedvalue)));
		ChildContract.addProducts(CHILD_CONTRACT_ADDRESS, USER_WALLET_KEY, USER_WALLET_ADDRESS, list);
		return "Products Added";
	}
	
	@GetMapping("/verifyProduct")
	public String verifyProduct(@RequestParam String USER_WALLET_KEY, @RequestParam String CHILD_CONTRACT_ADDRESS, @RequestParam String data) {
		System.out.println("===============================verifyProduct===============================");		System.out.println("data" + data);
		System.out.println("Converting to  Hashcode......");
		int hashedvalue=data.hashCode();
		System.out.println("Hashcode: "+hashedvalue);
		return ChildContract.verifyProduct(CHILD_CONTRACT_ADDRESS, USER_WALLET_KEY, new BigInteger(String.valueOf(hashedvalue)));
	}
}
