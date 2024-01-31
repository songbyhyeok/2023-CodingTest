#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, K;
int Arr[1000000];

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL), cout.tie(NULL);

	int ans = 0;

	cin >> N >> K;
	for (int i = 0; i < N; i++) {
		cin >> Arr[i];
	}

	for (int i = N - 1; i >= 0; i--) {
		const auto& coin = Arr[i];
		if (coin <= K) {
			ans += K / coin;
			K %= coin;

			if (K == 0)
				break;
		}
	}

	cout << ans;

	return 0;
}