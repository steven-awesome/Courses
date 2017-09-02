const utils = require('./utils');
const expect = require('expect');

describe('Utils', () => {
    it('should add two numbers', () => {
        var res = utils.add(4, 7);
        expect(res).toBe(11, 'Should be 11')
            .toBeA('number');
    });

    it('should async add', (done) => {
        utils.asyncAdd(4, 3, (sum) => {
            expect(sum).toBe(7).toBeA('number');
            done();
        });
    });

    it('should async square number', function(done) {
        utils.asyncSquare(4, function(square) {
            expect(square).toBe(16).toBeA('number');
            done();
        })
    });

    it('should just test', () => {
        expect(12).toNotBe(11);
    });
});