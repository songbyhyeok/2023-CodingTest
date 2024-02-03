#include <iostream>
#include <algorithm>

using namespace std;

int Ropes[10000];
int N;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL), cout.tie(NULL);

	cin >> N;
	for (int i = 0; i < N; i++)
		cin >> Ropes[i];

	// 오름차순
	sort(Ropes, Ropes + N);

	int maxW = Ropes[N - 1];
	for (int i = 0; i < N; i++) {
		const int curW = Ropes[i] * (N - i);
		maxW = max(maxW, curW);
	}

	cout << maxW;
	
	return 0;
}