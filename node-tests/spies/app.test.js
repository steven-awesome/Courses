const expect = require('expect');
const rewire = require('rewire');

var app = rewire('./app');

describe('App', () => {
    var db = {
        saveUser: expect.createSpy()
    };
    app.__set__('db', db);

    it('should call the spy correctly', () => {
        var spy = expect.createSpy();
        spy('Steven', 25);
        expect(spy).toHaveBeenCalledWith('Steven', 25);
    });

    it('should call save user with user obj', () => {
        var email = 'test@4null.com';
        var pw = '123abc';

        app.handleSignup(email, pw);
        expect(db.saveUser).toHaveBeenCalledWith({ email, pw })
    });
})