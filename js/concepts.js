//Demonstrate difference between == and ===
function comparisonDiff(){
	var x = 2;
	var y = '2';

	if (x == y)
		console.log("x == y is true");
	else
		console.log("x == y is false");

	if (x === y)
		console.log("x === y is true");
	else
		console.log("x === y is false");
}

comparisonDiff();

//function to add space between characters of string
function spacify(str) {
	return str.split('').join(' ');
}
console.log(spacify('hello world'));

//Modified String object to add space between characters of string
String.prototype.spacify = function() {
	return this.split('').join(' ');
}
console.log('hello world'.spacify());

//Will return 8 - return will not exit and bar is modified, last function will execute
function foo() {
	function bar() {
		return 3;
	}

	return bar();

	function bar(){
		return 8;
	}
}
console.log(foo());

//Demonstrate the context of this
var user = {
	count: 1,
	getCount: function() {
		return this.count;
	}
};
//1
console.log(user.getCount());
var func = user.getCount;
//Undefined
console.log(func());
//[Function]
console.log(func);

/*Closure inside loop - setTimeout is executed when the call stack is over and i is 10
  10 will be printed ten times
for (var i = 0; i < 10; i++) {
	setTimeout(function() {
		console.log(i);
	}, 10);
}*/

//Solution 1:
for (var i = 0; i < 10; i++) {
	setTimeout((function() {
		console.log(i);
	})(i), 10);
}

//Solution 2
for (var i = 0; i < 10; i++) {
	setTimeout(console.log.bind(console, i), 10);
}