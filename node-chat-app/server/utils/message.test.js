var expect = require('expect');

var {generateMessage} = require('./message');

describe('generateMessage', () => {
    it('should generate correct message object', () => {
        var message = generateMessage('me', 'you text');

        expect(message.from).toEqual('me');
        assert(message.text).toEqual('you text');
    });
});