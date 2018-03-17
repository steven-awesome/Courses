const request = require('supertest');
const expect = require('expect');

var app = require('./server.js').app;

describe('Server Tests', () => {
    describe('GET /', () => {
        it('should return hello express', (done) => {
            request(app)
                .get('/')
                .expect(200)
                .expect((res) => {
                    expect(res.body).toInclude({
                        error: 'Page not found'
                    })
                })
                .end(done);
        });
    });

    describe('GET /users', () => {
        it('should return user object', function(done) {
            request(app)
                .get('/users')
                .expect(200)
                .expect((res) => {
                    expect(res.body).toInclude({
                        name: 'steven',
                        age: 31
                    })
                })
                .end(done);
        })
    });
})