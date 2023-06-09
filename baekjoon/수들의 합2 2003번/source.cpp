#include <iostream>
#include <vector>

using namespace std;

int N, M;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N >> M;

	vector<int> a(N);
	for (int i = 0; i < N; i++)
		cin >> a[i];

	// 시작점, 끝점, 합계, 경우의 수 개수
	int s = 0, e = 0, sum = a[0], cnt = 0;
	while (true) {
		// sum이 M보다 같거나 크다면 s를 한 칸 옮긴다.
		if (M <= sum) {
			// sum이 같다면 cnt한다.
			if (sum == M)
				++cnt;

			sum -= a[s];
			++s;
		}
		// sum이 M보다 작다면 e를 한 칸 옮긴다.
		else {
			++e;
			// e가 len을 넘어갈 경우 끝낸다.
			if (N <= e)
				break;

			sum += a[e];
		}

	}

	cout << cnt;

	return 0;
}
