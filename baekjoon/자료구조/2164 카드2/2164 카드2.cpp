#include <iostream>
#include <queue>

using namespace std;

// ���� 2164 ī��2
// �� �� ī��� ������ �� ���� �� �� �� ī��� �Ʒ��� �ٲپ�
// �� ���� ī�尡 ���� ������ �ݺ��ϴ� ����
// �ݺ� ������ queue�� Ǯ�� �Ǵ� ������.

int N, K;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL), cout.tie(NULL);

	queue<int> queue;
	int cnt = 0;

	cin >> N;
	// N��ŭ queue�� ��´�.
	for (int i = 1; i <= N; i++) {
		queue.emplace(i);
	}

	// ������ ���ڰ� ���� ������
	while (queue.size() > 2) {
		// ���� ���� ���ڸ� ������.
		queue.pop();
		// �� �Ʒ��� ���ڸ� �� �ڷ� ������.
		queue.emplace(queue.front());
		queue.pop();
	}

	cout << queue.back();
	
	return 0;
}