/*var obj = {
    name: 'Mee'
};

var stringObj = JSON.stringify(obj);
console.log(typeof stringObj);
console.log(stringObj);*/

var personString = '{"name": "Steven", "age": 31}';
var person = JSON.parse(personString);
console.log(personString);
console.log(person);

const fs = require('fs');

var originalNote = {
    title: 'some title',
    body: 'some body'
};

var originalNoteString = JSON.stringify(originalNote);
fs.writeFileSync('notes.json', originalNoteString);

var noteString = fs.readFileSync(notes.json);
var note = JSON.parse(noteString);