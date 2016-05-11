
//////////// creating objects but not the best way to declare objects
// always use the dot operator to declare objects
var person = new Object();

person["firstname"] = "Tony";
person["lastname"] = "Alicea";

var firstNameProperty = "firstname";
var lastNameProperty = "lastname";

console.log(person);
//also gives tony and his last name
console.log(person[firstNameProperty] + person[lastNameProperty]);

//also gives tony
console.log(person.firstname);
// give the last name
console.log(person.lastname);

person.address = new Object();
// member access
//left most dot runs first , go to person object, look for property
//address then on the object found look for property street 
// and give it the initial value
person.address.street = "111 main street.";
person.address.city = "New york.";
person.address.state = "NY.";

console.log(person.address.street);
console.log(person.address.city);
//does the same thing as the dot above to access data
console.log(person["address"]["state"]);

/////////////////////////////////////////////////
/////////////////////////////////////////////////

//////////object literals////////////////////////
//same as new object
var Tony ={
    firstname: 'Tony',
    lastname: 'barber',
    address: {
         street: '111 main street',
         city: 'New york',
         state: 'NY',
             }
};

Tony.address ={}

function greet(person){
    console.log('Hi ' + person.lastname);
    
}
greet(Tony);
greet({
    firstname: 'mary', 
    lastname: 'doe'});

Tony.address2 ={
    street: '333 block st'   
};

/////////////////////////////////////////////////
/////////////////////////////////////////////////



