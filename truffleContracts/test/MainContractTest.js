const Main_Smart_Contract = arifacts.require('Main_Smart_Contract');

contract('Main_Smart_Contract', () => {
    it(`Should create a child smart contract`, async () => {
        const mainContract = new Main_Smart_Contract.new();
        await mainContract.createSmartContract();
        const data = mainContract.walletAddresses.length;
        assert(data.toNumber() === 1);
    })
})