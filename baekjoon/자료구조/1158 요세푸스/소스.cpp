#include <iostream>
#include <queue>

using namespace std;

// ���� 1158�� �似Ǫ�� ����
// ���� ���� K <= N�� �־�����. �� ������ ������ �����Ǿ� �ְ�,
// ������� ���� K��° ����� �����ϰ� �ȴ�.
// �� ������ N���� ������� ��� ���ŵ� ������ ��ӵȴ�.

int N, K;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL), cout.tie(NULL);

	queue<int> queue;
	int cnt = 0;

	cin >> N;
	cin >> K;

	// N ������ ���� ��� ��´�.
	for (int i = 1; i <= N; i++) {
		queue.emplace(i);
	}

	cout << '<';

	// N���� ������� ��� ����� ������ �����Ѵ�.
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