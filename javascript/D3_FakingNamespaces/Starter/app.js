
// first class functions
// in javascript functions are objects
// everything you can do with other types you can do with functions.
// funtions name is greet
// code is console.log('hi);(invocable)

// when it sees(javascript) finction it puts into mem
function greet(){
    console.log('hi');
}

greet.language = 'english';
console.log(greet.language);


greet();

function greet2()
{
    console.greet2('hi');
}


var anonymousGreet = function(){
    console.log('hi');
}

anonymousGreet();

function log(a){
    a();
}

log(function(){
    console.log('hi');
});


// by value(primitives)
var c = 3;
var b;

b = c;
c = 2;

console.log(c);
console.log(b);

// by reference (all objects (including functions))
var c = { greeting: 'hi' };
var d;

d = c;
c.greeting = 'hello'; //mutable
console.log(c);
console.log(d);