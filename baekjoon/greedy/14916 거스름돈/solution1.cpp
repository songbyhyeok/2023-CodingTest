#include <iostream>

using namespace std;

int N;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL), cout.tie(NULL);

	int cnt = 0;
	int amount = 0;

	cin >> N;
	amount = N;

	cnt = amount / 5;
	amount %= 5;
	if (amount != 0) {
		while (amount % 2 != 0) {
			if (amount + 5 > N) {
				cnt = -1;
				break;
			}

			amount += 5;
			--cnt;
		}

		if (cnt != -1)
			cnt += amount / 2;
	}

	cout << cnt << endl;

	return 0;
}