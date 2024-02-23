#include <iostream>
#include <queue>

using namespace std;

// 백준 1158번 요세푸스 문제
// 양의 정수 K <= N이 주어진다. 이 수들은 원으로 형성되어 있고,
// 순서대로 돌며 K번째 사람을 제거하게 된다.
// 이 과정은 N명의 사람들이 모두 제거될 때까지 계속된다.

int N, K;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL), cout.tie(NULL);

	queue<int> queue;
	int cnt = 0;

	cin >> N;
	cin >> K;

	// N 까지의 수를 모두 담는다.
	for (int i = 1; i <= N; i++) {
		queue.emplace(i);
	}

	cout << '<';

	// N명의 사람들이 모두 말살될 때까지 진행한다.
	while (queue.size() > 1) {
		++cnt;
		if (cnt != K) {
			queue.emplace(queue.front());
		}
		else {
			cnt = 0;
			cout << queue.front() << ", ";
		}

		queue.pop();
	}

	cout << queue.front() << '>';
	
	return 0;
}