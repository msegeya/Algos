/*
	In other languages like Java this refers to the current object.

	In JS, if there is no current object then this refers to the global object.
	In web browser that's window represents the window.
*/

// Global Scope
alert(window === this); // true

/****************************************************************/

// Calling a Function
// this remains the global object if you are calling a function.
function test() {
	alert(window === this); // true
}

test();

/****************************************************************/

// Calling object methods. 
// When calling an object constructor or any of its methods, 'this' refers to the instance of the object.
function testObj() {
	this.check1 = function() {
		alert("Check1 Method");
	}
	this.check2 = function() {
		alert("Check2 Method");
	}
}

var t = new testObj();
t.check1();
t.check2();

/****************************************************************/


