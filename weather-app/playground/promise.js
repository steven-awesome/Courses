var asyncAdd = (a, b) => {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            if (typeof a === 'number' && typeof b === 'number') {
                resolve(a + b);
            } else {
                reject('Arguments must be numbers');
            }
        }, 1500);
    })
}

asyncAdd(3, 5).then((result) => {
    console.log('Result: ', result);
    return asyncAdd(result, 33);
}).then((res) => {
    console.log('REsult2: ', res);
}).catch((errorMessage) => {
    console.log(errorMessage);
});

var somePromise = new Promise((resolve, reject) => {
    setTimeout(() => {
        resolve('Hey, it worked');
        reject('Unable to promise');
    }, 2500);

});

somePromise.then((message) => {
    console.log('success:', message);
}, (errorMessage) => {
    console.log('Error: ', errorMessage)
});