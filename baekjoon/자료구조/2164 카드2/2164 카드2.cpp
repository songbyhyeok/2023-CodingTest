#include <iostream>
#include <queue>

using namespace std;

// 백준 2164 카드2
// 맨 위 카드는 버리고 그 다음 맨 위 밑 카드는 아래에 바꾸어
// 한 장의 카드가 남을 때까지 반복하는 문제
// 반복 패턴이 queue로 풀면 되는 문제다.

int N, K;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL), cout.tie(NULL);

	queue<int> queue;
	int cnt = 0;

	cin >> N;
	// N만큼 queue에 담는다.
	for (int i = 1; i <= N; i++) {
		queue.emplace(i);
	}

	// 최후의 숫자가 남을 때까지
	while (queue.size() > 2) {
		// 제일 위에 숫자를 버린다.
		queue.pop();
		// 그 아래에 숫자를 맨 뒤로 보낸다.
		queue.emplace(queue.front());
		queue.pop();
	}

	cout << queue.back();
	
	return 0;
}