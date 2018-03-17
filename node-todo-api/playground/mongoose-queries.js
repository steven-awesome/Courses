const { mongoose } = require('./../server/db/mongoose');
const { Todo } = require('./../server/models/todo');
const { ObjectID } = require('mongodb');

var id = '598272b1d41d41079d30f0d7';

if (!ObjectID.isValid(id)) {
    console.log('ID not valid');
}

/* Todo.find({
    _id: id
}).then((todos) => {
    console.log('Todos', todos);
});

Todo.findOne({
    _id: id
}).then((todo) => {
    console.log('Todos', todo);
}); */

Todo.findById(id).then((todo) => {
    if (!todo) {
        console.log('ID not found!')
    } else {
        console.log(todo);
    }
}).catch((e) => {
    console.log(e);
});