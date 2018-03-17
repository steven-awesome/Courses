/*var square = x => x * x;
console.log(square(9));*/

var user = {
    name: 'Steven',
    sayHi: () => {
        /*
                console.log(`Hi. I'm ${name}`);*/
    },
    sayHiAlt() {
        console.log(`Hi. I'm ${this.name}`);
    }
}

user.sayHiAlt();