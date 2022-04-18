# COUNTERFEIT_DETECTION_USING_BLOCKCHAIN
A counterfeit Detection Project Using Blockchain, Each company can register to get their unique smart contract. This smart contract will contain list of all the products created by them. The address to this smart contract will be made public, so any new user can access this smart contract to check whether a given product exists on their smart contract or not. Hence verifying its authenticity

# Code Structure
The code is built with frontend on node.js and backend on the springboot and is divided into differrent branches:
<h2> frontend-production </h2>

<hi>API:</h1>
<ul>
  <li>/register : Here company can register themselves using their crypto wallet address, and get a unique smart contract alloted to them</li>
  <li>/addProducts : Here company can add their products by scaaaning the QR-Code, the QR-Code will be converted to a unique hash code and storred on the company's smart contract</li>
  <li>/verifyProducts : This for the users who want to check whether their product is authentic or not, they can go to this portal provide details about company's smart contractt, scan QR-Code of the product, which will then be compared with existing hash codes</li>
<h2> backend-springboot </h2>
  <li> Code for connecting to etherium blockchain</li>
  <li> Host contract on the blockchain</li>
  <li> Convert QR-code to hash code</li>  
