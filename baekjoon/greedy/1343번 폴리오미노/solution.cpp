#include <iostream>

using namespace std;

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL), cout.tie(NULL);

	string board, result;
	int xCnt = 0;

	cin >> board;
	for (int i = 0; i < board.length(); i++) {
		const char ch = board[i];
		if (ch == 'X') {
			++xCnt;

			if ((i == board.length() - 1) || board[i + 1] == '.') {
				if (xCnt != 0) {
					if (xCnt % 2 != 0) {
						cout << -1;
						return 0;
					}

					const int aCnt = xCnt / 4;
					xCnt %= 4;
					for (int i = 0; i < aCnt; i++) {
						result += "AAAA";
					}

					const int bCnt = xCnt / 2;
					xCnt %= 2;
					for (int i = 0; i < bCnt; i++) {
						result += "BB";
					}
				}
			}
		}
		else if (ch == '.') {
			result += '.';
		}
	}

	cout << result;
	
	return 0;
}