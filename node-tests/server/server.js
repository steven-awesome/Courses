const express = require('express');
var app = express();

app.get('/', (req, res) => {
    res.status(200).send({
        error: 'Page not found',
        name: 'testing'
    });
});

app.get('/users', function(req, res) {
    res.send([{
        name: 'test1',
        age: 30
    }, {
        name: 'steven',
        age: 31
    }]);
});

app.listen(3000);

module.exports.app = app;