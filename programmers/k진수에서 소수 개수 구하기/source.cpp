#include <iostream>
#include <string>
#include <cmath>

using namespace std;

bool isPrime(long long ll) {
	if (ll <= 1)
		return false;

	for (long long i = 2; i <= static_cast<long long>(sqrt(ll)); i++)
		if (ll % i == 0)
			return false;

	return true;
}

// 10진법 to K진법 
void convertToK(int n, int k, string& kStr) {
	string temp;
	while (0 < n) {
		temp += ((n % k) + '0');
		n /= k;
	}

	for (int i = temp.length() - 1; i >= 0; i--)
		kStr += temp[i];
}

int solution(int n, int k) {
	string kStr = "", comStr = "";
	int answer = 0;

	convertToK(n, k, kStr);

	for (const auto& k : kStr) {
		if (k == '0' && !comStr.empty()) {
			answer += isPrime(stoll(comStr));
			comStr.clear();

			continue;
		}

		comStr += k;
	}

	if (!comStr.empty())
		answer += isPrime(stoll(comStr));

	return answer;
}

int main(void) {
	solution(110, 10);
	solution(437674, 3);
	solution(110011, 10);

	return 0;
}