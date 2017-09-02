module.exports.add = (a, b) => a + b;

module.exports.asyncAdd = (a, b, callback) => {
    setTimeout(() => {
        callback(a + b);
    }, 1000);
}

module.exports.asyncSquare = function(a, callback) {
    setTimeout(function() {
        callback(a * a);
    }, 1000);
}