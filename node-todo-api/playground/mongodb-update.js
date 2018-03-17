//const MongoClient = require('mongodb').MongoClient;
const { MongoClient, ObjectID } = require('mongodb');

var obj = new ObjectID();

console.log(obj);

//ES6 Object destructuring used above for mongo client
//var user = {name: 'Steven', age: 31};
//var {name} = user

MongoClient.connect('mongodb://localhost:27017/test', (error, db) => {
    if (error) {
        return console.log('Unable to connect to MongoDB');
    }
    console.log('Connected to MongoDB server');

    db.collection('Todos').findOneAndUpdate({ _id: new ObjectID('597feade504efd2f9e93a08c') }, {
        $set: {
            completed: true
        }
    }, {
        returnOriginal: false
    }).then((result) => {
        console.log(result);
    });

    //db.close();
});