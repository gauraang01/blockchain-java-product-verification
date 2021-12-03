package com.example.trying;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Uint;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.6.0.
 */
public class Company_Smart_Contract extends Contract {
    private static final String BINARY = "0x608060405234801561001057600080fd5b506040516107a93803806107a9833981810160405281019061003291906100dc565b80600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050610109565b600080fd5b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b60006100a98261007e565b9050919050565b6100b98161009e565b81146100c457600080fd5b50565b6000815190506100d6816100b0565b92915050565b6000602082840312156100f2576100f1610079565b5b6000610100848285016100c7565b91505092915050565b610691806101186000396000f3fe608060405234801561001057600080fd5b50600436106100365760003560e01c806320bf63ac1461003b578063524e84621461006b575b600080fd5b61005560048036038101906100509190610481565b61009b565b6040516100629190610565565b60405180910390f35b61008560048036038101906100809190610587565b6101dd565b6040516100929190610565565b60405180910390f35b6060600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff16146100f757600080fd5b60005b825181101561019e576000838281518110610118576101176105b4565b5b60200260200101519080600181540180825580915050600190039060005260206000200160009091909190915055600180600085848151811061015e5761015d6105b4565b5b6020026020010151815260200190815260200160002060006101000a81548160ff021916908315150217905550808061019690610612565b9150506100fa565b6040518060400160405280600e81526020017f50726f647563747320616464656400000000000000000000000000000000000081525091505092915050565b60606001600083815260200190815260200160002060009054906101000a900460ff1615610242576040518060400160405280600d81526020017f41757468656e7469636174656400000000000000000000000000000000000000815250905061027b565b6040518060400160405280600b81526020017f436f756e7465726665697400000000000000000000000000000000000000000081525090505b919050565b6000604051905090565b600080fd5b600080fd5b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b60006102bf82610294565b9050919050565b6102cf816102b4565b81146102da57600080fd5b50565b6000813590506102ec816102c6565b92915050565b600080fd5b6000601f19601f8301169050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b610340826102f7565b810181811067ffffffffffffffff8211171561035f5761035e610308565b5b80604052505050565b6000610372610280565b905061037e8282610337565b919050565b600067ffffffffffffffff82111561039e5761039d610308565b5b602082029050602081019050919050565b600080fd5b6000819050919050565b6103c7816103b4565b81146103d257600080fd5b50565b6000813590506103e4816103be565b92915050565b60006103fd6103f884610383565b610368565b905080838252602082019050602084028301858111156104205761041f6103af565b5b835b81811015610449578061043588826103d5565b845260208401935050602081019050610422565b5050509392505050565b600082601f830112610468576104676102f2565b5b81356104788482602086016103ea565b91505092915050565b600080604083850312156104985761049761028a565b5b60006104a6858286016102dd565b925050602083013567ffffffffffffffff8111156104c7576104c661028f565b5b6104d385828601610453565b9150509250929050565b600081519050919050565b600082825260208201905092915050565b60005b838110156105175780820151818401526020810190506104fc565b83811115610526576000848401525b50505050565b6000610537826104dd565b61054181856104e8565b93506105518185602086016104f9565b61055a816102f7565b840191505092915050565b6000602082019050818103600083015261057f818461052c565b905092915050565b60006020828403121561059d5761059c61028a565b5b60006105ab848285016103d5565b91505092915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052603260045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b600061061d826103b4565b91507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff8214156106505761064f6105e3565b5b60018201905091905056fea264697066735822122078c26b7d6e52e5ba3bb2a3a26021a433367334f6ffef977d3ac9de10c2635f1d64736f6c63430008090033";

    public static final String FUNC_ADDPRODUCTS = "addProducts";

    public static final String FUNC_VERIFYPRODUCT = "verifyProduct";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected Company_Smart_Contract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Company_Smart_Contract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Company_Smart_Contract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Company_Smart_Contract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Company_Smart_Contract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _owner) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner)));
        return deployRemoteCall(Company_Smart_Contract.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Company_Smart_Contract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _owner) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner)));
        return deployRemoteCall(Company_Smart_Contract.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Company_Smart_Contract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _owner) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner)));
        return deployRemoteCall(Company_Smart_Contract.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Company_Smart_Contract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _owner) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_owner)));
        return deployRemoteCall(Company_Smart_Contract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public RemoteCall<TransactionReceipt> addProducts(String _ownerAddress, List<BigInteger> _products) {
        final Function function = new Function(
                FUNC_ADDPRODUCTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_ownerAddress), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.Utils.typeMap(_products, org.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Type> verifyProduct(BigInteger _hashcode) {
        final Function function = new Function(
                FUNC_VERIFYPRODUCT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_hashcode)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<org.web3j.abi.datatypes.Utf8String>() {}));
        		return executeRemoteCallSingleValueReturn(function);
    }

    @Deprecated
    public static Company_Smart_Contract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Company_Smart_Contract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Company_Smart_Contract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Company_Smart_Contract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Company_Smart_Contract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Company_Smart_Contract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Company_Smart_Contract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Company_Smart_Contract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
