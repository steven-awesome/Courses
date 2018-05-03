const {SHA256} = require('crypto-js');
const jwt = require('jsonwebtoken');

var data = {
    id: 10
}

var token = jwt.sign(data, '123abc');

var decoded = jwt.verify(token, '123abc');

console.log(decoded);

/* var msg = 'I am a user';
var hash = SHA256(msg + 'somesecret').toString();
console.log(`Orig: ${msg}`)
console.log(`Message: ${hash}`)

var data = {
    id: 4
}

var token = {
    data,
    hash: SHA256(JSON.stringify(data) + 'somesecret').toString()
}

var resultHash = SHA256(JSON.stringify(token.data) + 'somesecret').toString();

console.log(resultHash); */