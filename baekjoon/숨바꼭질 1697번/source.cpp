#include <iostream>
#include <queue>

using namespace std;

int N, K;
int DirX[3]{ -1, 1, 2 };

const int bfs() {
	queue<int> q;
	int distance[100001]{};

	q.emplace(N);
	while (!q.empty()) {
		const int currPosX = q.front();
		q.pop();

		for (const int X : DirX) {
			const int nextX = (X == -1 || X == 1) ? currPosX + X : currPosX * 2;
			if (0 <= nextX && nextX < 100001 && nextX != N) {
				if (!distance[nextX] && nextX != N) {
					q.emplace(nextX);
					distance[nextX] = distance[currPosX] + 1;

					if (nextX == K)
						return distance[nextX];
				}
			}
		}
	}

	return 0;
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N >> K;

	cout << bfs();

	return 0;
}