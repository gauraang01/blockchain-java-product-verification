package io.minor.blockchain;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
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
    private static final String BINARY = "0x608060405234801561001057600080fd5b506040516108c33803806108c3833981810160405281019061003291906100dc565b80600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050610109565b600080fd5b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b60006100a98261007e565b9050919050565b6100b98161009e565b81146100c457600080fd5b50565b6000815190506100d6816100b0565b92915050565b6000602082840312156100f2576100f1610079565b5b6000610100848285016100c7565b91505092915050565b6107ab806101186000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c806320bf63ac1461005157806328a7b7a714610081578063524e8462146100b1578063dba3f6aa146100e1575b600080fd5b61006b6004803603810190610066919061053b565b610111565b604051610078919061061f565b60405180910390f35b61009b60048036038101906100969190610641565b610253565b6040516100a89190610689565b60405180910390f35b6100cb60048036038101906100c69190610641565b610273565b6040516100d8919061061f565b60405180910390f35b6100fb60048036038101906100f69190610641565b610316565b60405161010891906106b3565b60405180910390f35b6060600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff161461016d57600080fd5b60005b825181101561021457600083828151811061018e5761018d6106ce565b5b6020026020010151908060018154018082558091505060019003906000526020600020016000909190919091505560018060008584815181106101d4576101d36106ce565b5b6020026020010151815260200190815260200160002060006101000a81548160ff021916908315150217905550808061020c9061072c565b915050610170565b6040518060400160405280600e81526020017f50726f647563747320616464656400000000000000000000000000000000000081525091505092915050565b60016020528060005260406000206000915054906101000a900460ff1681565b60606001600083815260200190815260200160002060009054906101000a900460ff16156102d8576040518060400160405280600d81526020017f41757468656e74696361746564000000000000000000000000000000000000008152509050610311565b6040518060400160405280600b81526020017f436f756e7465726665697400000000000000000000000000000000000000000081525090505b919050565b6000818154811061032657600080fd5b906000526020600020016000915090505481565b6000604051905090565b600080fd5b600080fd5b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b60006103798261034e565b9050919050565b6103898161036e565b811461039457600080fd5b50565b6000813590506103a681610380565b92915050565b600080fd5b6000601f19601f8301169050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b6103fa826103b1565b810181811067ffffffffffffffff82111715610419576104186103c2565b5b80604052505050565b600061042c61033a565b905061043882826103f1565b919050565b600067ffffffffffffffff821115610458576104576103c2565b5b602082029050602081019050919050565b600080fd5b6000819050919050565b6104818161046e565b811461048c57600080fd5b50565b60008135905061049e81610478565b92915050565b60006104b76104b28461043d565b610422565b905080838252602082019050602084028301858111156104da576104d9610469565b5b835b8181101561050357806104ef888261048f565b8452602084019350506020810190506104dc565b5050509392505050565b600082601f830112610522576105216103ac565b5b81356105328482602086016104a4565b91505092915050565b6000806040838503121561055257610551610344565b5b600061056085828601610397565b925050602083013567ffffffffffffffff81111561058157610580610349565b5b61058d8582860161050d565b9150509250929050565b600081519050919050565b600082825260208201905092915050565b60005b838110156105d15780820151818401526020810190506105b6565b838111156105e0576000848401525b50505050565b60006105f182610597565b6105fb81856105a2565b935061060b8185602086016105b3565b610614816103b1565b840191505092915050565b6000602082019050818103600083015261063981846105e6565b905092915050565b60006020828403121561065757610656610344565b5b60006106658482850161048f565b91505092915050565b60008115159050919050565b6106838161066e565b82525050565b600060208201905061069e600083018461067a565b92915050565b6106ad8161046e565b82525050565b60006020820190506106c860008301846106a4565b92915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052603260045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b60006107378261046e565b91507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff82141561076a576107696106fd565b5b60018201905091905056fea26469706673582212200e9fba290c9709fae6bcd90782b80ee3e509735827dec204c969531e1e02e7d964736f6c63430008090033";

    public static final String FUNC_PRODUCTS = "Products";

    public static final String FUNC_HASHCODETOTRUE = "hashcodeToTrue";

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

    public RemoteCall<TransactionReceipt> Products(BigInteger param0) {
        final Function function = new Function(
                FUNC_PRODUCTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> hashcodeToTrue(BigInteger param0) {
        final Function function = new Function(
                FUNC_HASHCODETOTRUE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
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

    public RemoteCall<TransactionReceipt> verifyProduct(BigInteger _hashcode) {
        final Function function = new Function(
                FUNC_VERIFYPRODUCT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_hashcode)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
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
