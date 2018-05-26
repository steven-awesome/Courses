var socket = io();

socket.on('connect', function() {
    console.log('Connected to server');
});

socket.on('disconnect', function() {
    console.log('Disconnected from server');
});

socket.on('newMessage', function(message) {
    console.log('newMessage', message);
    var li = jQuery('<li></li>');
    li.text(`${message.from}: ${message.text}`);

    jQuery('#messages').append(li);
});

socket.on('newUserJoined', function(message) {
    console.log(message);
});

socket.on('userJoin', function(message) {
    console.log(message);
});

/* socket.emit('createMessage', {
    from: 'tester',
    text: 'hiii'
}, function(data) {
    console.log('got it', data);
}); */

jQuery('#message-form').on('submit', function(event) {
    event.preventDefault();

    socket.emit('createMessage', {
        from: 'User',
        text: jQuery('[name=message').val()
    }, function(data) {
        console.log(data);
    });
});

var locationButton = jQuery('#send-location');
locationButton.on('click', function(event) {
    if (!navigator.geolocation) {
        return alert('Geolocation not supported by your browser');
    }

    navigator.geolocation.getCurrentPosition(function(position) {
        socket.emit('createLocationMessage', {
            latitude: position.coords.latitude,
            longitude: position.coords.longitude
        });
        console.log(position);
    }, function() {
        alert('Unable to fetch location');
    });
});