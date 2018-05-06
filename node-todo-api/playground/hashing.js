const {SHA256} = require('crypto-js');
const jwt = require('jsonwebtoken');
const bcrypt = require('bcryptjs');

var data = {
    id: 10
}

var password = '123abc!';
/* 
bcrypt.genSalt(10, (err, salt) => {
    bcrypt.hash(password, salt, (err, hash) => {
        console.log(hash);
    });
}); */

var hashed = '$2a$10$cblJFLg8HijzYmVGmFf2cuBBi9L30e34NCTMBINc9km6qWGZiIW2m';

bcrypt.compare(password, hashed, (err, res) => {
    console.log(res);
});


/* var token = jwt.sign(data, '123abc');

*/var decoded = jwt.verify('eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1YWVkMjU5ZGRmZDQxODI5NTViMmY5MzYiLCJhY2Nlc3MiOiJhdXRoIiwiaWF0IjoxNTI1NDkxMTAxfQ.doS0FEXfsenTVmYfHN9RC_lkJjXDz8MtoxfOO0beG3U', '123abc');

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