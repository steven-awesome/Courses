const fs = require('fs');
const _ = require('lodash');
const yargs = require('yargs');

const notes = require('./notes.js');


const argv = yargs.command('add', 'Add a new note', {
        title: {
            describe: 'Title of note',
            demand: true
        }
    }).command('list', 'List all notes')
    .command('read', 'Read a note').help().argv;
var command = argv._[0];

if (command === 'add') {
    var note = notes.addNote(argv.title, argv.body);
    if (note) {
        console.log('Note added: ', note);
    } else {
        console.log('No new note added');
    }
} else if (command === 'list') {
    var allNotes = notes.getAll();
    console.log(allNotes);
} else if (command === 'read') {
    var note = notes.getNote(argv.title);
    if (note) {
        console.log('Note found! -- ', note);
    } else {
        console.log('Note NOT found!');
    }

} else if (command === 'remove') {
    var isNoteRemoved = notes.remove(argv.title);
    var message = isNoteRemoved ? 'Note was removed' : 'Note NOT found';
    console.log(message);
} else {
    console.log('Command not recognized');
}