console.log('Starting app');

setTimeout(() => {}, 5000);

setTimeout(() => {
    console.log('Inside of callback');
}, 2000);

setTimeout(() => {
    console.log('Second setTimeout');
}, 0);



console.log('Finishing up');