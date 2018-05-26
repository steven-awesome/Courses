require('./config/config');
var env = process.env.NODE_ENV || 'development';
console.log(env);

var express = require('express');
var bodyParser = require('body-parser');
var { mongoose } = require('./db/mongoose.js');
var { Todo } = require('./models/todo');
var { User } = require('./models/user');
const { ObjectID } = require('mongodb');
var {authenticate} = require('./middleware/authenticate');

var app = express();
const port = process.env.PORT;

app.use(bodyParser.json());

app.get('/', (req, res) => {
    res.render('index.html');
});

/*
    TODOS
*/
app.post('/todos', authenticate, (req, res) => {
    var todo = new Todo({
        text: req.body.text,
        completed: req.body.completed,
        _creator: req.user._id
    });
    todo.save().then((doc) => {
        res.status(200).send(doc);
    }, (e) => {
        res.status(400).send(e);
    });
});

app.get('/todos', authenticate, (req, res) => {
    Todo.find({
        _creator: req.user._id
    }).then((todos) => {
        res.send({ todos });
    }, (e) => {
        console.log(e);
    });
});

app.get('/todos/:id', authenticate, (req, res) => {
    var id = req.params.id;

    if (!ObjectID.isValid(id)) {
        return res.status(404).send();
    }

    Todo.findOne({
        _id: id,
        _creator: req.user._id
    }).then((todo) => {
        if (!todo) {
            console.log(todo);
            return res.status(404).send(todo);
        }
        res.status(200).send({ todo });
    }).catch((e) => {
        res.status(400).send();
        console.log(e);
    });

});

app.delete('/todos/:id', authenticate, (req, res) => {
    var id = req.params.id;
    if (!ObjectID.isValid(id)) {
        res.status(404).send();
    }

    Todo.findOneAndRemove({
        _id: id,
        _creator: req.user._id
    }).then((todo) => {
        if (!todo) {
            return res.status(404).send();
        }
        res.status(200).send(todo);
    }).catch((e) => {
        res.status(400).send();
    })
})

/*
    USERS
*/
app.post('/users', (req, res) => {
    var user = new User({
        email: req.body.email,
        password: req.body.password
    });

    User.find({email: user.email}).then((result) => {
        if (result.length > 0) {
            res.status(400).send('account exists with that email');
        } else {
            user.save()
            .then(() => {
                return user.generateAuthToken();
            }).then((token) => {
                res.header('x-auth', token).send(user);
            }).catch((e) => {
                res.status(400).send(e);
            });
        }
    })
    .catch((e) => {
        console.log('Issue with finding if user exist', e);
    });
});

app.get('/users/me', authenticate, (req, res) => {
    res.send(req.user);
});

app.post('/users/login', (req, res) => {
    User.findByCredentials(req.body.email, req.body.password).then((user) => {
        return user.generateAuthToken().then((token) => {
            res.header('x-auth', token).send(user);
        });
        res.send(user);
    }).catch((e) => {
        res.status(400).send(e);
    });
});

app.delete('/users/me/token', authenticate, (req, res) => {
    req.user.removeToken(req.token).then(() => {
        res.status(200).send();
    }).catch(() => {
        res.status(400).send();
    })
});

app.listen(port, () => {
    console.log(`Started on port ${port}`);
});

module.exports = { app };