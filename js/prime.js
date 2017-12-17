function isPrime(n) {
	if (n < 2) 
		return false;
	if (n == 2)
		return true;

	for (var i = 2; i <= n/2; i++) {
		if (n % i == 0)
			return false;
	}

	return true;
}

var cache = {};
var nthPrimes = [];

function getNthPrime(n) {
	var count = 0;
	var prime = 2;

	if (nthPrimes.length >= n) {
		return nthPrimes[n-1];
	}
	else {
		count = nthPrimes.length;
		prime = nthPrimes[nthPrimes.length-1];
	}

	var check = 2;

	while (count < n) {
		var result = false;

		if (cache[check] != null) {
			result = cache[check];
		}
		else {
			result = isPrime(check);
			cache[check] = result;
		}

		if(result) {
			prime = check;
			check++;
			count++;
		}
		else {
			check++;
		}
	}

	return prime;
}

console.log(isPrime(2));
console.log(isPrime(3));
console.log(isPrime(4));
console.log(isPrime(1));

console.log(getNthPrime(2));
console.log(getNthPrime(10));
console.log(getNthPrime(10000));
console.log(getNthPrime(15000));