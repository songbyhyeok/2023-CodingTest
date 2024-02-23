#include <iostream>
#include <queue>

using namespace std;

int N;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	queue<int> queue;

	cin >> N;

	string cmd = "";
	for (int i = 0; i < N; i++) {
		cin >> cmd;
		if (cmd == "push") {
			int val = 0;
			cin >> val;
			queue.emplace(val);
		}
		else if (cmd == "pop") {
			if (queue.empty() == true) {
				cout << -1 << '\n';
			}
			else {
				cout << queue.front() << '\n';
				queue.pop();
			}
		}
		else if (cmd == "size") {
			cout << queue.size() << '\n';
		}
		else if (cmd == "empty") {
			cout << ((queue.empty() == true) ? 1 : 0) << '\n';
		}
		else if (cmd == "front") {
			cout << ((queue.empty() == true) ? -1 : queue.front()) << '\n';
		}
		else if (cmd == "back") {
			cout << ((queue.empty() == true) ? -1 : queue.back()) << '\n';
		}
	}

	return 0;
}