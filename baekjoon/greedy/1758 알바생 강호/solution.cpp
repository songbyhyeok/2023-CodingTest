#include <iostream>
#include <algorithm>

using namespace std;

int Tips[100000];
int N;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL), cout.tie(NULL);

	long long max = 0;

	cin >> N;
	for (int i = 0; i < N; i++)
		cin >> Tips[i];

	// 내림차순
	sort(Tips, Tips + N, greater<int>());

	for (int i = 0; i < N; i++) {
		const int tip = Tips[i] - i;
		if (tip > 0)
			max += tip;
		else
			break;
	}
	
	cout << max << endl;

	return 0;
}