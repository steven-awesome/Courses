var getUser = (id, callback) => {
    var user = {
        id: id,
        name: 'Steven'
    };

    setTimeout(() => {
        callback(user);
    }, 3000);
};

getUser(3, (user) => {
    console.log(user);
});