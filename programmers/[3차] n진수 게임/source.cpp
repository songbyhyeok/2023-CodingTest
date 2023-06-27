#include <iostream>
#include <string>

using namespace std;

string solution(int n, int t, int m, int p) {
	string answer = "";
	string convertedStr = "0";

	// 만들 조합 개수
	const int comLen = t * m;
	// 튜브가 말할 차례
	int s = p - 1;
	// 튜브가 말한 횟수
	int cnt = 0;

	for (int i = 1; convertedStr.length() < comLen; i++) {
		string temp = "";
		int number = i;

		// n진법 변환 과정
		while (number != 0) {
			int r = number % n;
			number /= n;

			// 10이 넘어가면 A ~ F 변환
			temp += r < 10 ? r + '0' : r + 55;
		}

		// 역으로 조합에 담기
		for (int j = temp.length() - 1; j >= 0; j--)
			convertedStr += temp[j];
	}

	// 튜브 차례에 말한 숫자들 answer에 담기
	while (cnt < t) {
		answer += convertedStr[s];
		s += m;
		++cnt;
	}

	return answer;
}

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	cout << solution(2, 4, 2, 1) << '\n';
	cout << solution(16, 16, 2, 1) << '\n';
	cout << solution(16, 16, 2, 2) << '\n';

	return 0;
}