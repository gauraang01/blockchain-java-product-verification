package io.minor.blockchain;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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
public class Main_Smart_Contract extends Contract {
    private static final String BINARY = "0x608060405234801561001057600080fd5b506113fe806100206000396000f3fe608060405234801561001057600080fd5b50600436106100885760003560e01c80634d581a371161005b5780634d581a371461014d5780637221a26a1461015757806386559fb2146101735780639b7ff3eb146101a357610088565b80630a79309b1461008d5780631469d5d4146100bd57806325a0f0d0146100ed5780633e0920f61461011d575b600080fd5b6100a760048036038101906100a29190610592565b6101d3565b6040516100b491906105ce565b60405180910390f35b6100d760048036038101906100d2919061061f565b6101dd565b6040516100e491906105ce565b60405180910390f35b61010760048036038101906101029190610592565b61021c565b60405161011491906105ce565b60405180910390f35b610137600480360381019061013291906107a5565b610285565b604051610144919061089c565b60405180910390f35b610155610322565b005b610171600480360381019061016c919061061f565b61043e565b005b61018d60048036038101906101889190610592565b610448565b60405161019a91906105ce565b60405180910390f35b6101bd60048036038101906101b891906108be565b61047b565b6040516101ca919061089c565b60405180910390f35b6000819050919050565b600081815481106101ed57600080fd5b906000526020600020016000915054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050919050565b60608273ffffffffffffffffffffffffffffffffffffffff166320bf63ac85846040518363ffffffff1660e01b81526004016102c29291906109bc565b600060405180830381600087803b1580156102dc57600080fd5b505af11580156102f0573d6000803e3d6000fd5b505050506040513d6000823e3d601f19601f820116820180604052508101906103199190610a92565b90509392505050565b60003360405161033190610513565b61033b91906105ce565b604051809103906000f080158015610357573d6000803e3d6000fd5b5090506000819080600181540180825580915050600190039060005260206000200160009091909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b8060028190555050565b60016020528060005260406000206000915054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60608273ffffffffffffffffffffffffffffffffffffffff1663524e8462836040518263ffffffff1660e01b81526004016104b69190610aea565b60006040518083038186803b1580156104ce57600080fd5b505afa1580156104e2573d6000803e3d6000fd5b505050506040513d6000823e3d601f19601f8201168201806040525081019061050b9190610a92565b905092915050565b6108c380610b0683390190565b6000604051905090565b600080fd5b600080fd5b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b600061055f82610534565b9050919050565b61056f81610554565b811461057a57600080fd5b50565b60008135905061058c81610566565b92915050565b6000602082840312156105a8576105a761052a565b5b60006105b68482850161057d565b91505092915050565b6105c881610554565b82525050565b60006020820190506105e360008301846105bf565b92915050565b6000819050919050565b6105fc816105e9565b811461060757600080fd5b50565b600081359050610619816105f3565b92915050565b6000602082840312156106355761063461052a565b5b60006106438482850161060a565b91505092915050565b600080fd5b6000601f19601f8301169050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b61069a82610651565b810181811067ffffffffffffffff821117156106b9576106b8610662565b5b80604052505050565b60006106cc610520565b90506106d88282610691565b919050565b600067ffffffffffffffff8211156106f8576106f7610662565b5b602082029050602081019050919050565b600080fd5b600061072161071c846106dd565b6106c2565b9050808382526020820190506020840283018581111561074457610743610709565b5b835b8181101561076d5780610759888261060a565b845260208401935050602081019050610746565b5050509392505050565b600082601f83011261078c5761078b61064c565b5b813561079c84826020860161070e565b91505092915050565b6000806000606084860312156107be576107bd61052a565b5b60006107cc8682870161057d565b93505060206107dd8682870161057d565b925050604084013567ffffffffffffffff8111156107fe576107fd61052f565b5b61080a86828701610777565b9150509250925092565b600081519050919050565b600082825260208201905092915050565b60005b8381101561084e578082015181840152602081019050610833565b8381111561085d576000848401525b50505050565b600061086e82610814565b610878818561081f565b9350610888818560208601610830565b61089181610651565b840191505092915050565b600060208201905081810360008301526108b68184610863565b905092915050565b600080604083850312156108d5576108d461052a565b5b60006108e38582860161057d565b92505060206108f48582860161060a565b9150509250929050565b600081519050919050565b600082825260208201905092915050565b6000819050602082019050919050565b610933816105e9565b82525050565b6000610945838361092a565b60208301905092915050565b6000602082019050919050565b6000610969826108fe565b6109738185610909565b935061097e8361091a565b8060005b838110156109af5781516109968882610939565b97506109a183610951565b925050600181019050610982565b5085935050505092915050565b60006040820190506109d160008301856105bf565b81810360208301526109e3818461095e565b90509392505050565b600080fd5b600067ffffffffffffffff821115610a0c57610a0b610662565b5b610a1582610651565b9050602081019050919050565b6000610a35610a30846109f1565b6106c2565b905082815260208101848484011115610a5157610a506109ec565b5b610a5c848285610830565b509392505050565b600082601f830112610a7957610a7861064c565b5b8151610a89848260208601610a22565b91505092915050565b600060208284031215610aa857610aa761052a565b5b600082015167ffffffffffffffff811115610ac657610ac561052f565b5b610ad284828501610a64565b91505092915050565b610ae4816105e9565b82525050565b6000602082019050610aff6000830184610adb565b9291505056fe608060405234801561001057600080fd5b506040516108c33803806108c3833981810160405281019061003291906100dc565b80600260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050610109565b600080fd5b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b60006100a98261007e565b9050919050565b6100b98161009e565b81146100c457600080fd5b50565b6000815190506100d6816100b0565b92915050565b6000602082840312156100f2576100f1610079565b5b6000610100848285016100c7565b91505092915050565b6107ab806101186000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c806320bf63ac1461005157806328a7b7a714610081578063524e8462146100b1578063dba3f6aa146100e1575b600080fd5b61006b6004803603810190610066919061053b565b610111565b604051610078919061061f565b60405180910390f35b61009b60048036038101906100969190610641565b610253565b6040516100a89190610689565b60405180910390f35b6100cb60048036038101906100c69190610641565b610273565b6040516100d8919061061f565b60405180910390f35b6100fb60048036038101906100f69190610641565b610316565b60405161010891906106b3565b60405180910390f35b6060600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff161461016d57600080fd5b60005b825181101561021457600083828151811061018e5761018d6106ce565b5b6020026020010151908060018154018082558091505060019003906000526020600020016000909190919091505560018060008584815181106101d4576101d36106ce565b5b6020026020010151815260200190815260200160002060006101000a81548160ff021916908315150217905550808061020c9061072c565b915050610170565b6040518060400160405280600e81526020017f50726f647563747320616464656400000000000000000000000000000000000081525091505092915050565b60016020528060005260406000206000915054906101000a900460ff1681565b60606001600083815260200190815260200160002060009054906101000a900460ff16156102d8576040518060400160405280600d81526020017f41757468656e74696361746564000000000000000000000000000000000000008152509050610311565b6040518060400160405280600b81526020017f436f756e7465726665697400000000000000000000000000000000000000000081525090505b919050565b6000818154811061032657600080fd5b906000526020600020016000915090505481565b6000604051905090565b600080fd5b600080fd5b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b60006103798261034e565b9050919050565b6103898161036e565b811461039457600080fd5b50565b6000813590506103a681610380565b92915050565b600080fd5b6000601f19601f8301169050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b6103fa826103b1565b810181811067ffffffffffffffff82111715610419576104186103c2565b5b80604052505050565b600061042c61033a565b905061043882826103f1565b919050565b600067ffffffffffffffff821115610458576104576103c2565b5b602082029050602081019050919050565b600080fd5b6000819050919050565b6104818161046e565b811461048c57600080fd5b50565b60008135905061049e81610478565b92915050565b60006104b76104b28461043d565b610422565b905080838252602082019050602084028301858111156104da576104d9610469565b5b835b8181101561050357806104ef888261048f565b8452602084019350506020810190506104dc565b5050509392505050565b600082601f830112610522576105216103ac565b5b81356105328482602086016104a4565b91505092915050565b6000806040838503121561055257610551610344565b5b600061056085828601610397565b925050602083013567ffffffffffffffff81111561058157610580610349565b5b61058d8582860161050d565b9150509250929050565b600081519050919050565b600082825260208201905092915050565b60005b838110156105d15780820151818401526020810190506105b6565b838111156105e0576000848401525b50505050565b60006105f182610597565b6105fb81856105a2565b935061060b8185602086016105b3565b610614816103b1565b840191505092915050565b6000602082019050818103600083015261063981846105e6565b905092915050565b60006020828403121561065757610656610344565b5b60006106658482850161048f565b91505092915050565b60008115159050919050565b6106838161066e565b82525050565b600060208201905061069e600083018461067a565b92915050565b6106ad8161046e565b82525050565b60006020820190506106c860008301846106a4565b92915050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052603260045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b60006107378261046e565b91507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff82141561076a576107696106fd565b5b60018201905091905056fea26469706673582212200e9fba290c9709fae6bcd90782b80ee3e509735827dec204c969531e1e02e7d964736f6c63430008090033a2646970667358221220abbe7e5c2c729bcc3d4994376476af3019f563e8113531c49d4dec0a049d489264736f6c63430008090033";

    public static final String FUNC_WALLETADDRESSTOSMARTCONTRACTADDRESS = "walletAddressToSmartContractAddress";

    public static final String FUNC_WALLETADDRESSES = "walletAddresses";

    public static final String FUNC_STOREVALUE = "storeValue";

    public static final String FUNC_CREATESMARTCONTRACT = "createSmartContract";

    public static final String FUNC_GETCOMPANYSMARTCONTRACTADDRESS = "getCompanySmartContractAddress";

    public static final String FUNC_ADDPRODUCT = "addproduct";

    public static final String FUNC_CHECKPRODUCT = "checkProduct";

    public static final String FUNC_RETRIEVE = "retrieve";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected Main_Smart_Contract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Main_Smart_Contract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Main_Smart_Contract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Main_Smart_Contract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<Type> walletAddressToSmartContractAddress(String param0) {
        final Function function = new Function(
                FUNC_WALLETADDRESSTOSMARTCONTRACTADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<org.web3j.abi.datatypes.Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public RemoteCall<TransactionReceipt> walletAddresses(BigInteger param0) {
        final Function function = new Function(
                FUNC_WALLETADDRESSES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> storeValue(BigInteger _value) {
        final Function function = new Function(
                FUNC_STOREVALUE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> createSmartContract() {
        final Function function = new Function(
                FUNC_CREATESMARTCONTRACT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Type> getCompanySmartContractAddress(String _walletAddress) {
        final Function function = new Function(
                FUNC_GETCOMPANYSMARTCONTRACTADDRESS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_walletAddress)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<org.web3j.abi.datatypes.Address>() {}));
        return executeRemoteCallSingleValueReturn(function);    }

    public RemoteCall<TransactionReceipt> addproduct(String _ownerAddress, String _contractAddress, List<BigInteger> _products) {
        final Function function = new Function(
                FUNC_ADDPRODUCT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_ownerAddress), 
                new org.web3j.abi.datatypes.Address(_contractAddress), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.generated.Uint256>(
                        org.web3j.abi.Utils.typeMap(_products, org.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> checkProduct(String _contractAddress, BigInteger _productHashCode) {
        final Function function = new Function(
                FUNC_CHECKPRODUCT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_contractAddress), 
                new org.web3j.abi.datatypes.generated.Uint256(_productHashCode)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Type> retrieve(String _val) {
        final Function function = new Function(
                FUNC_RETRIEVE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_val)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<org.web3j.abi.datatypes.Address>() {}));
        return executeRemoteCallSingleValueReturn(function);
    }

    public static RemoteCall<Main_Smart_Contract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Main_Smart_Contract.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Main_Smart_Contract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Main_Smart_Contract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Main_Smart_Contract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Main_Smart_Contract.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Main_Smart_Contract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Main_Smart_Contract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static Main_Smart_Contract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Main_Smart_Contract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Main_Smart_Contract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Main_Smart_Contract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Main_Smart_Contract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Main_Smart_Contract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Main_Smart_Contract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Main_Smart_Contract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
