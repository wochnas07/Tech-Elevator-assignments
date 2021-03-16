/*
    Example of a multi-line comment just like in C#/Java
*/

// Single line comment

/**
 * Functions start with the word function.
 * They don't have a return type and the naming convention is camel-case.
 */
function variables() {
  // Declares a variable where the value cannot be changed
  // Use const to find a variable whole value cannot be changed
  const DAYS_PER_WEEK = 7
  // console.log() is the JavaScript version of system.out.println() in Java
  // If what you want to display using console.log() contains a variable:
  //
  //        1. Enclose what you want to display in back ticks (`)
  //        2. Put the variable you want displayed inside ${}
  //
  // semi-colons at the end of a statement are usually optional in JavaScript

  console.log(`There are ${DAYS_PER_WEEK} days in a week`);


  // Declares a variable those value can be changed
  // Use a let statement to define a variable whose content maybe changed
  let daysPerMonth = 31;
  console.log(`There are ${daysPerMonth} days this month`)


  // Declares a variable that will always be an array
  // To declare an array in JavaScript, code name = []
  const WEEKDAYS = [
          "Monday",
          "Tuesday",
          "Wednesday",
          "Thursdays",
          "Friday",
          "Saturday",
          "Sunday"
          ]
  console.table(WEEKDAYS); // Display the array as a table
}

/**
 * Functions can also accept parameters.
 * Notice the parameters do not have types.
 * 
 * JavaDoc is a standard way of documenting code
 * JavaDoc is comments placed before a function to describe it
 * @words - annotations in JavaDoc to describe parts of a function
 * 
 * @param - identifies parameters passed to the function in JavaDoc notation
 * 
 * @param {Number} param1 The first number to display
 * @param {Number} param2 The second number to display
 */
function printParameters(param1, param2) {
  console.log(`The value of param1 is ${param1}`);
  console.log(`The value of param2 is ${param2}`);
}

/**
 * JavaScript has TWO types of equality
 * 
 * Compares two values x and y.
 * == is loose equality     - ignores the type of data - only looks at value
 * === is strict equality   - requires both the type and value be the same
 * 
 * 1 == '1'   - true - values represent the value one
 * 1 === '1'  - false - types don't match (number and String)
 * 
 * @param {Object} x
 * @param {Object} y
 */
function equality(x, y) {
  console.log(`x is ${typeof x}`);    // typeof returns the type of the value it is given
  console.log(`y is ${typeof y}`);

  console.log(`x == y : ${x == y}`); // true
  console.log(`x === y : ${x === y}`); // false
}



/**
 * Each value is inherently truthy or falsy.
 * 
 * Every value in JavaScript can be evaluated to true or false
 *    when used in a conditional statement
 * 
 * NaN - Not-a-Number - usually the result of arithmetic with non-numeric data
 * 
 * false, 0, '', null, undefined, and NaN are always falsy (false)
 * everything else is always truthy (true)
 * 
 * @param {Object} x The object to check for truthy or falsy,
 */
function falsy(x) {
  if (x) {     
    console.log(`${x} is truthy`);
  } else {
    console.log(`${x} is falsy`);
  }
}

/**
 *  Objects are simple key-value pairs (NOT instance of a class like in Java)
    JavaScript objects are JSON objects - JavaScriptObjectNotation


    an element in a JavaScript object:
          attribute-name: value

    - values can be primitive data types
    - values can be arrays
    - or they can be functions
*/
function objects() {
  const person = {          // attributes of a JavaScript object are enclosed in {}
    firstName: "Bill",      // code a (,) between elements
    lastName: "Lumbergh",
    age: 42,
    employees: [            // an attribute in a JavaScript object may be an array
      "Peter Gibbons",
      "Milton Waddams",
      "Samir Nagheenanajar",
      "Michael Bolton"
    ],
    // define a toString() function for the object
    toString : function() {   // identify the attribute as type function()
      return `${this.lastName}, ${this.firstName} (${this.age})`
    }
  };

  // Log the object
  console.table(person);
  console.log(person);

  // Log the first and last name
  // To reference an attribute in an object: objectName.attributeName
  console.log(`Person's name : ${person.firstName} ${person.lastName}`)

  // Log each employee
  for (let i=0; i < person.employees.length; i++) {
    console.log(`Employee #${i+1}: ${person.employees[i]}`)
  }

  console.log(person.toString());

/*
########################
Function Overloading
########################

Function Overloading is not available in Javascript. If you declare a
function with the same name, more than one time in a script file, the
earlier ones are overriden and the most recent one will be used.
*/

function Add(num1, num2) {
  return num1 + num2;
}

function Add(num1, num2, num3) {
  return num1 + num2 + num3;
}

/*
########################
Math Library
########################

A built-in `Math` object has properties and methods for mathematical constants and functions.
*/

function mathFunctions() {
  console.log("Math.PI : " + Math.PI);
  console.log("Math.LOG10E : " + Math.LOG10E);
  console.log("Math.abs(-10) : " + Math.abs(-10));
  console.log("Math.floor(1.99) : " + Math.floor(1.99));
  console.log("Math.ceil(1.01) : " + Math.ceil(1.01));
  console.log("Math.random() : " + Math.random());
}

/*
########################
String Methods
########################

The string data type has a lot of properties and methods similar to strings in Java/C#
*/

function stringFunctions(value) {
  console.log(`.length -  ${value.length}`);
  console.log(`.endsWith('World') - ${value.endsWith("World")}`);
  console.log(`.startsWith('Hello') - ${value.startsWith("Hello")}`);
  console.log(`.indexOf('Hello') - ${value.indexOf("Hello")}`);

  /*
    Other Methods
        - split(string)
        - substr(number, number)
        - substring(number, number)
        - toLowerCase()
        - trim()
        - https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String
    */
}
}