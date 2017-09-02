const { ObjectID } = require('mongodb');
const { mongoose } = require('./../server/db/mongoose');
const { Todo } = require('./../server/models/todo');
const { User } = require('./../server/models/user');

/* Todo.remove({}).then((res) => {
    console.log(res);
}); */

Todo.findByIdAndRemove('59828e684fd3b50b9769f20c').then((todo) => {
    console.log(todo);
});