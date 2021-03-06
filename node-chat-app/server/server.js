const path = require('path');
const http = require('http');
const publicPath = path.join(__dirname, '../public');
const express = require('express');
const port = process.env.PORT || 3000;
const socketIO = require('socket.io');
const {generateMessage} = require('./utils/message');

var app = express();
var server = http.createServer(app);
var io = socketIO(server);

app.use(express.static(publicPath));

io.on('connection', (socket) => {
    console.log('new user connected');

    socket.emit('userJoin', generateMessage('Admin', 'Welcome to the chat app'));
    socket.broadcast.emit('newUserJoined', generateMessage('Admin', 'New user joined'));

    socket.on('createMessage', (message, callback) => {
        console.log('server message: ', message);
        io.emit('newMessage', generateMessage(message.from, message.text));
        callback('This is from the server');
        /* socket.broadcast.emit('createMessage', {
            from: message.from, 
            text: message.text, 
            createdAt: new Date().getTime()
        }); */
    });

    socket.on('createLocationMessage', (coords) => {
        io.emit('newMessage', generateMessage('Admin', `${coords.latitude}, ${coords.longitude}`));
    });
});

app.get('/', (req, res) => {
    res.render(index.html);
});

server.listen(port, () => {
    console.log(`Started up at port ${port}`);
});

console.log(publicPath);