//Recursive multiple using addition and subtraction
function multiply(m, n) {
	if (n > 1)
		return (m + multiply(m, n-1));
	else if (m == 0 || n == 0)
		return 0;
	else if (n == 1)
		return m;
	else if (n == -1)
		return -m;
	else
		return -(m + multiply(m, Math.abs(n)-1));
}

console.log(multiply(2, 3));
console.log(multiply(2, 0));
console.log(multiply(0, 3));
console.log(multiply(0, 0));
console.log(multiply(5, -3));
console.log(multiply(-6, -4));
console.log(multiply(-2, 13));

//Recursive divide using addition and subtraction
function divide(m,n) {
	if (n == 0)
		return undefined;
	//if m < n, quotient is 0....TODO: further logic for decimals
	else if (m == 0 || Math.abs(m) < Math.abs(n))
		return 0;
	else
		return (1 + divide(m-n, n));
}

console.log(divide(2,0));
console.log(divide(0,2));
console.log(divide(0,0));
console.log(divide(2,-10));
console.log(divide(2,3));
console.log(divide(5,2));
console.log(divide(90,7));