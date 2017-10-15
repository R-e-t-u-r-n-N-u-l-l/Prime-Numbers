#include <iostream>
#include <cmath>
#include <vector>

std::vector<int> primes;
long index = 1;

int searchPrime() {
	index++;

	for(size_t i = 0; i < primes.size(); i++) {
		if(primes[i] > std::ceil(index / 2))
			break;
		if(index % primes[i] == 0)
			return searchPrime();
	}

	return index;
}

int main() {
	std::cout << "Enter the amount of prime numbers you want to generate (0 for infinite): " << std::flush;
	size_t i;
	bool infinite;
	bool running = true;
	std::cin >> i;
	if(i == 0)
		infinite = true;

	while(running) {
		primes.push_back(searchPrime());
		std::cout << primes[primes.size() - 1] << std::endl;
		if(primes.size() >= i && !infinite)
			running = false;
	}

	return 0;
}
