const yargs = require('yargs');
const request = require('request');
const geocode = require('./geocode/geocode.js');
const weather = require('./weather/weather.js');
const argv = yargs.options({
        a: {
            demand: true,
            alias: 'address',
            describe: 'Address to fetch weather for',
            string: true
        }
    })
    .help()
    .alias('help', 'h')
    .argv;

geocode.geocodeAddress(argv.a, (error, results) => {
    if (error) {
        console.log(error);
    } else {
        console.log(JSON.stringify(results, undefined, 2));
        weather.getWeather(results.latitude, results.longitude, (error, weatherResults) => {
            if (error) {
                console.log(error);
            } else {
                console.log(`It is currently ${weatherResults.temperature}, but feels like ${weatherResults.apparentTemperature}`);
            }
        });
    }
});