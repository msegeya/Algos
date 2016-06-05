- What is JavaScript?
Client side, light weight, interpreted programming language with OO capabilities.
-------------------------------------------------------------------------------------------------
- What is closure in Javascript. (https://www.youtube.com/watch?v=oWSQ4mWNFPU)

See example in ****** Web/cloures.html ******

Google's definition: (Search "closure in Javascript")
A closure is an inner function that has access to the outer (enclosing) function's variables—scope chain. 
The closure has three scope chains: 
	1) it has access to its own scope (variables defined between its curly brackets), 
	2) it has access to the outer function's variables, and 
	3) it has access to the global variables.

In simple we can tell it in two points,
	*) A closure is a local variable for a function - Kept alive even after the function is returned.
	*) A closure is a stack frame which does not deallocate even after the function is returned.

Any example scenario where we can use closure?
We can use closures to enforce private/public methods. As you cannot call a private method directly so that we can use a public method to call the private method.
See example in ****** Web/cloures.html ******
-------------------------------------------------------------------------------------------------
- What are the datatypes in JavaScript?
String, Number, Boolean, Function, Object, null, Undefined.

Primitve Datatypes: String, Number, Boolean, Undefined, Null
Non-Primitve Datatypes: Object, Array, RegExp
-------------------------------------------------------------------------------------------------
- How to check whether a given input is number or not?
isNaN(<input>) function
returns true if not a number else returns false.
-------------------------------------------------------------------------------------------------
- What is Math object in JS?
Math provides properties and methods for mathematical constants.
var x = Math.PI;
var s = Math.sqrt(16);
var z = Math.sin(90);
-------------------------------------------------------------------------------------------------
- Difference between "==" and "==="
	"==" check for content
	"===" checks both for content as well as type
	
	Example: 
		1 == "1"  // true
		1 === "1" // false
		null == undefined // true
		null === undefined // false	

-------------------------------------------------------------------------------------------------
- Explain "this" in JS?
In JS, this is the "context pointer" not the "object pointer". "this" is nothing but the top most context that is placed on the stack.

Example: 
	
	var obj = { outerVariable : 10};
	function greet() {
		alert(this.outerVariable);
	}
	1) If we call greet(); 				==> Will print undefined.
	2) If we call greet.apply(obj);		==> Will print 10

Refer Algos/Web/JavaScript/this.js	
-------------------------------------------------------------------------------------------------
- What are call() and apply() methods?
	call() and apply() are predefiend JS methods. Both methods can be used to invoke methods and must have owner object as first parameter.

	Difference is, call takes parameters while apply takes array as parameter.

	Refer: Algos/Web/JavaScript/CallAndApply.html
-------------------------------------------------------------------------------------------------
- What is the difference between Object and Primitive?
 Primitive is something which cannot be divided further. Ex: int a = 10; this a cannot be divided further.
 Object is something that can be divided further. Ex: Consider class Employee it has name, age, etc.
-------------------------------------------------------------------------------------------------
What is the difference between the below statements?
Statement - 1: var s1 = new String('Amarnath');
Statement - 2: var s2 = "Amarnath";

s1 is an object and s2 is a primitive String value (not an object)
But both of these will call String constructor function.

We can check that using following code,
console.log(s1.constructor, s2.constructor);
-------------------------------------------------------------------------------------------------
String s1 = "amarnath";
String s2 = s1;
s1 = null;
alert(s1 + " " + s2); // what is the output?
==> Now both s1 and s2 are pointing to "amarnath". When we say s1 = null then it means we are cutting the link of s1 that is pointing to "amarnath". But not changing any part of the string.
output will be "null amarnath"
-------------------------------------------------------------------------------------------------
- What is the output ?
  var p1 = 10;
  var p2 = 10;
  var p3 = new Number(10);

  alert(p1 === p2); // true. Both refering to same value.
  alert(p1 === p3); // false. Even though their contents are same they have different references.

  How about this one?
  var obj1 = {name : 'amarnath'};
  var obj2 = {name : 'amarnath'};
  alert(obj1 === obj2); // false
  ==> Not matter what, the objects will not be same unless they point to the same value.
  	  Each obejct is considered different.
-------------------------------------------------------------------------------------------------
- Which JS functions convert non-numeric values to numeric?
Number(), parseInt(), parseFloat()
-------------------------------------------------------------------------------------------------
- Does JS support automatic type conversion?
	YES.

	var str = '5';
	var num = str * 2;
	var concat = +str;

	alert(str); // 5
	alert(num); // 10
	alert(concat); // 5
-------------------------------------------------------------------------------------------------
- undefined vs null
	undefined - value of the variable with be undefined if it has no value.
	null 	  - setting a value which indicates that it does not have any value.
-------------------------------------------------------------------------------------------------
- What is event bubbling?
Describes the behavior of events in child and parent nodes in the DOM.
All child nodes events are automatically passed to the parent.
One event listener to the page's body and this will respond to all the click events.
-------------------------------------------------------------------------------------------------
- try/catch/finally in JS
Same as in Java. Refer Algos/Web/TryCatch.html

Also discuss about two more features,
throw, onerror

throw:
throw error such that it can catched in catch clause and do the necessary stuff.

onerror:
What is "onerror event"?
Example consider loading on an image.
<img src="image.gif">
What if the image is not present in the given location or the browser cannot render it properly?
The solution is to introduce the onerror event.
<img src="image.gif" onerror="myFunction()"> and 
function myFunction() {
	alert('The image could not be loaded.');
}

==> So when the image has an issue while loading then it will raise the alert.
-------------------------------------------------------------------------------------------------
- JS Prototype explanation
Refer Algos/Web/Prototype_js.html
-------------------------------------------------------------------------------------------------
- Explain JS timers

-------------------------------------------------------------------------------------------------
- Difference between window.onload and onDocumentReady?
window.onload - Does not fire until the last piece of the page is loaded that is CSS, JS, IMAGES. So this will make a huge delay.
onDocumentReady - In this case we will just wait for DOM to load and ready to manupulate.
-------------------------------------------------------------------------------------------------
- How do you change the style of an element using simple JS?
document.getElementById("myText").style.fontSize = 20px;

If you want to add a class?
document.getElementById("myText").className = "<some class name>";

If you want to add inner html
var data="Name:<input type='text' name='name'>"; 
document.getElementById('myLocation').innerHTML = data;
-------------------------------------------------------------------------------------------------
- What is UnObstructive JavaScript?
Separation of functionality from web page content. 
In simple just separate the JS logic from HTML. (We always do that.)

Example:  <input type="button" id="btn" onclick="alert('Test')" />

		  But instead of writing the JavaScript within the web page content we will write it outside,

		  <input type="button" id="btn" />
		  	var el = document.getElementById('btn');
  		  	el.onclick = function(){
		    alert('Test');
		  };
-------------------------------------------------------------------------------------------------
- JavaScript namespace?
Namespace is used to differenciate the same methods of two different modules.
How do we implement in JS?

var Student = {
	getName : function() {
	  	return "Student";
	},

	getRole : function() {
		return "Student Role";
	}
}

var Employee = {
	getName : function() {
	  	return "Employee";
	},

	getRole : function() {
		return "Employee Role";
	}
}

alert(Student.getName());
alert(Employee.getName());
alert(Employee.getRole());
alert(Student.getRole());
-------------------------------------------------------------------------------------------------
- What is the default object of a browser?
==> window
It is used to open alert dialog, confirm dialog, input dialog.
Actually we write "alert('amarnath')" but what it actually mean is "window.alert('amarnath')".
-------------------------------------------------------------------------------------------------
- What is DOM?
Document Object Model - A document representing the HTML in a hierarical model.
-------------------------------------------------------------------------------------------------
- What is history object of a browser?
history object of a browser is used to switch between history pages such as going backward forward.
Methods:
- history.back()
- history.forward()
history.go(<number>) // if the number is positive then goes forward else backward.
-------------------------------------------------------------------------------------------------
- How to create objects?
Three ways,
1) Using Object literal
	var obj = {property1 : value1, property2 : value2, property3 : value3};
2) Using Object instance
	var obj = new Object();
	obj.property1 = value1;	
	obj.property2 = value2;
3) Using Object Constructor.
	function Employee(id, name, salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	var emp = new Employee(1, 'amarnath', 25000);
-------------------------------------------------------------------------------------------------
- How to create array?
Three ways,
1) Using Array literal
	var arr = ["one", "two", "three"];
2) Using Array Object
	var arr = new Array();
	arr.push('one'); arr.push('two'); arr.push('three'); 
3) Using Array constructor
	var arr = new Array("one", "two", "three");

In JS, Arrays are associative that is we can push any type in to the array.	
-------------------------------------------------------------------------------------------------
- What is negative infinity?
Negative Infinity in JS can be derived when we divide the negative number with zero.
-------------------------------------------------------------------------------------------------
- How to get the OS using JavaScript?
console.log(window.navigator);

This will show all the attributes under navigation. Then goto "appVersion" attribute.
-------------------------------------------------------------------------------------------------
- How to submit form?
	Get the form name and submit it.

<form name="myForm" action="getNames.htm">
	// some more code
	<a href="javascript : submitform()"> submit </a>
</form>

<script>
function submitform() {
	document.myForm.submit();
}
</script>
-------------------------------------------------------------------------------------------------
- How to validate email in JS?
Regex will be something like below, (NOTE: This is simple one not the most efficient one.) 
	regex = /\S+@\S+\.\S+/	

where, \S is "Find a non-whitespace character"

Now validate using a function,
function validateEmail(email) 
{
    var re = /\S+@\S+\.\S+/;
    return re.test(email);
}
-------------------------------------------------------------------------------------------------
- Event Bubbling vs Capturing
DOM elements can be nested inside each other. And somehow the handler of the parent works even when you click on it's child.
==> That is nothing but "Event Bubbling".
Consider the below example,
	
	___________________________________________________________________________________
	<div onclick="alert('Div handler worked!')">
  		<em>Click here triggers on nested <code>EM</code>, not on <code>DIV</code></em>
	</div>
	___________________________________________________________________________________

Now even when you click on text you still the event onClick will be triggered. You can try this on an HTML page.
The reason is simple Event Bubbling. So what is Event Bubbling?

*** Event Bubbling ***: After an event triggers on the deepest possible element, it then triggers on parents in nesting order. 
Consider one more example,
	___________________________________________________________________________________
	<body>
		<div class="d1" onclick="alert('d1')">
			Outer - d1
			<div class="d2" onclick="alert('d2')">
				------------ > Outer - d2
				<div class="d3" onclick="alert('d3')">
					-----------------------> Outer - d3
				</div>
			</div>			
		</div>
	</body>
	___________________________________________________________________________________

When you click on the inner most that is d3 even then its parent (d2 and d1) events will be triggered.
In simple, any event that is triggered will be passes to its parent. If they have any events for them then they too gets triggered.


*** Event Capturing ***: It is the reverse of the event bubbling. That is when the any element is clicked all the outer events will be called before calling the inner events.

	___________________________________________________________________________________
	<body>
		<div id="d1">
			Outer - d1
			<div id="d2">
				------------ > Outer - d2
				<div id="d3">
					-----------------------> Outer - d3
				</div>
			</div>			
		</div>
	</body>

	<script>
		var divs = document.getElementsByTagName("div");
		for(i = 0; i < divs.length; i++) {
			divs[i].addEventListener("click", clickHandler, true); // true means event capturing. That is top down.

			// When we say false then it will be event bubbling.
			// divs[i].addEventListener("click", clickHandler, false);
		}

		function clickHandler() {
			alert(this.getAttribute("id") + " is been clicked.");
		}
	</script>
	___________________________________________________________________________________
-------------------------------------------------------------------------------------------------
- What is callback function?
A JS callback function is a function that is passed to another function as an argument. As a result a callback function is called via an another function.
In simple, A callback function is executed after the current effect is finished.

Conside the below examples: 
	$("button").click(function(){
	    $("p").hide("slow", function(){
	        alert("The paragraph is now hidden");
	    });
	});
==> Now when the button is clicked above then the paragraph gets hidden and then a callback function is called which opens an alert.

Now below example is not a callback. Here both hide and alert are independent to each other. Whereas in above function example they are not.
	$("button").click(function() {
	    $("p").hide(1000);
	    alert("The paragraph is now hidden");
	});
-------------------------------------------------------------------------------------------------
- How much can a URL length be?
2048 characters as of new browsers.
-------------------------------------------------------------------------------------------------
- What is the output of the below code?
	var x = 10;
	var s = "hello";
	var m = x * s;
	console.log(m);
	
==> NaN
-------------------------------------------------------------------------------------------------
- Is JavaScript an Object Oriented Programming? If so how?
JavaScript supports object oriented programming but not same as OOP languages like Java, C++, PHP etc.
The main difference is that JavaScript does not support classes concept which is very important in OOPs. But we can simulate the same in JavaScript using functions.

Following are the principles of OOPs.
Object, Class, Constructor, Inheritance, Encapsulation, Abstraction, Polymorphism.
###################################
Object: Any real time entity is considered as an Object.
var obj = {}; or var obj = new Object(); then you can say obj.name = "amarnath"; obj.age = 10;
###################################
Class: There are no classes in JavaScript as it is Prototype based language. But we can simulate the class concept using JavaScript functions. 

function Person() {
	this.name = "amarnath";
	this.age = "29";
	this.getName = function() { return this.name; }
	this.getAge = function() {return this.age; }
	this.setName= function(name) { this.name = name; }
	this.setAge= function(age) { this.age = age; }
}
var per = new Person();
alert(per.getName());
###################################
Constructor: Since constructor comes under classes we can also do the same using functions in JavaScript.

function Employee(id) { 
	this.id = id; 
}
var emp = new Employee(100);
###################################
Inheritance: Inheritance is a process of getting the properties and function of one class to other class. We use prototype or Object.create to achieve the same.

// Parent class
function Person() { this.sayHi() { return "Hi"; } }
// child class.
function Student() {}
// Using PROTOTYPE method.
Student.prototype = new Person();

// Using Object.create
Student.prototype = Object.create(Person);

// testing
var stu = new Student();
alert(stu.sayHi()); // sayHi method is the property of the Person object which was inherited by the Student Object.
###################################
Encapsulation: Before going on to Encapsulation and Abstraction first we need to know what Data Hiding is and how can we achieve it in JavaScript. Date hiding is protecting the data form accessing it outside the scope.
For example, In Person class we have Date of Birth (dob) properties which should be protected. Let's see how to do it.

function Person() {
	// this is a private variable. As its scope is only inside the method.
	var dob = "8 June 2012";

	return : {
		age: "29",
		name: "amarnath",
		getDob: function() { return dob; }
	}
}

var per = new Person();
console.log(per.dob); // UNDEFINED
console.log(per.getDob()); // "8 June 2012"
###################################
Abstraction: Abstraction means hiding the inner implementation details and showing only outer details.
Suppose say we want to have an element data in the DOM then using JQuery we will get it as, $("ele")
But we don't know internally how this is actually selecting the "ele" tag i.e, document.getElementById("ele").
###################################
Polymorphism: 
The word Polymorphism in OOPs means having more than one form. In JavaScript a Object, Property, Method can have more than one form. Polymorphism is a very cool feature for dynamic binding or late binding. 

function Person(){
 this.sayHI=function(){}
};

//This will create Student Class
function Student() { };

Student.prototype = new Person();
Student.prototype.sayHI=function(l) {
 	return "Hi! I am a Student";
}

//This will create Teacher Object
function Teacher() { };

Teacher.prototype=new Person();
Teacher.prototype.sayHI=function(){
 	return "Hi! I am a Teacher";
}

var sObj=new Student();
//This will check if the student object is instance of Person or not if not it won't execute our alert code.
if (sObj instanceof Person) {
    alert("Hurry! JavaScript supports OOps");
}
-------------------------------------------------------------------------------------------------
- Advantages and Disadvantages of JavaScript?
Advantages: Less Server Interaction, Increased interactivity.
Disadvantages: Works only on client side. Does not allow reading or writing to files.
-------------------------------------------------------------------------------------------------
- Is Java case sensitive language? 
YES
-------------------------------------------------------------------------------------------------
- How to create a object in JS?
var emp = {
				name : "amarnath", age : 29
		  };
-------------------------------------------------------------------------------------------------
- Static and Dynamic Array
Static: var numbers = [1, 2, 3, 4];
Dynamic: var numbers = []; number.push(1); number.push(2); number.push(3);
-------------------------------------------------------------------------------------------------
- Two types of functions ?
a) Named and b) Anonymous.
a) Named Function: function add(x, y) { return x + y; } and call it as add(1, 2)
b) Anonymous Function: var add = function(x, y) { return x + y; } and call it in the same way as above add(1, 2)
In the above functions one has the name and the other does not have the name.
-------------------------------------------------------------------------------------------------
- Since we don't have type for an identifiers in JS. How do we know what is the object type.
Using typeof
Example: 
	function func(x) {
		console.log(typeof x, arguments.length);
	}
	func() 			=> o/p is undefined, 0
	func(1) 		=> o/p is number, 1
	func("1", "2") 	=> o/p is String, 2

- How to get the reference of a caller function?
function func() {
	return arguments.calle;
}

func() 		=> o/p will be func
-------------------------------------------------------------------------------------------------
How do you check if a variable is an object?
We can use typeof to determine whether the variable is an object or not.
if(bar && typeof bar === "object") {
	console.log('bar is object and is not null');
}
-------------------------------------------------------------------------------------------------
What is lexical scoping in Javascript? (https://spin.atomicobject.com/2014/10/20/javascript-scope-closures/)
The scope of variables is defined by their position in source code. In order to resolve variables, JavaScript starts at the innermost scope and searches outwards until it finds the variable it was looking for. Lexical scoping is nice, because we can easily figure out what the value of a variable will be by looking at the code; whereas in dynamic scoping, the meaning of a variable can change at runtime, making it more difficult.

Example: 
var outerFunction  = function(){
 
   if(true){
      var x = 5;
      //console.log(y); //line 1, ReferenceError: y not defined
   }
 
   var nestedFunction = function() {
 
      if(true){
         var y = 7;
         console.log(x); //line 2, x will still be known prints 5
      }
 
      if(true){
         console.log(y); //line 3, prints 7
       }
   }
   return nestedFunction;
}
 
var myFunction = outerFunction();
myFunction();
-------------------------------------------------------------------------------------------------
What is Strict Mode in JavaScript

It is not a statement, but a literal expression, ignored by earlier versions of JavaScript.
The purpose of "use strict" is to indicate that the code should be executed in "strict mode".
Strict mode is declared by adding "use strict"; to the beginning of a JavaScript or a JavaScript function.
Declared at the beginning of a JavaScript file, it has global scope (all code will execute in strict mode):

Ex:
"use strict";
x = 3.14; // This will cause an error (x is not defined) ==> We need to write "var x" not just "x".
##################
x = 3.14;       // This will not cause an error. Since we haven't introuduced "use strict" yet.
myFunction();

function myFunction() {
   "use strict";
    y = 3.14;   // This will cause an error (y is not defined)
}
-------------------------------------------------------------------------------------------------
How to access user profile using JavaScript

-------------------------------------------------------------------------------------------------