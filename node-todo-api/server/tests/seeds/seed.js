const {Todo} = require('./../../models/todo');
const {User} = require('../../models/user');
const { ObjectID } = require('mongodb');
const jwt = require('jsonwebtoken');

const userOneId = new ObjectID();
const userTwoId = new ObjectID();
const users = [{
    _id: new ObjectID(),
    email: 'user1@test.com',
    password: 'userOnePass',
    tokens: [{
        access: 'auth',
        token: jwt.sign({_id: userOneId, access: 'auth'}, 'abc123').toString()
    }]
}, {
    _id: userTwoId,
    email: 'user2@test.com',
    password: 'userTwoPass'
}];

const todos = [{
    _id: new ObjectID(),
    text: 'First todo'
}, {
    _id: new ObjectID(),
    text: 'second todo',
    completed: true,
    completedAt: 123
}];

const populateUsers = (done) => {
    User.remove({}).then(() => {
      var userOne = new User(users[0]).save();
      var userTwo = new User(users[1]).save();
  
      return Promise.all([userOne, userTwo])
    }).then(() => done());
  };

  const populateTodos = (done) => {
    Todo.remove({}).then(() => {
      return Todo.insertMany(todos);
    }).then(() => done());
  };

module.exports = { users, todos, populateTodos, populateUsers };