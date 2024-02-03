#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// [1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]

vector<int> solution(vector<int> array, vector<vector<int>> commands);

int main(void) {
	ios::sync_with_stdio(false);
	cin.tie(NULL), cout.tie(NULL);

	vector<int> answer = move(solution({ 1, 5, 2, 6, 3, 7, 4 }, { {2, 5, 3}, {4, 4, 1}, {1, 7, 3} }));
	for (const auto& val : answer)
		cout << val << ',';

	return 0;
}

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
	vector<int> answer;

	// 1. 자르기
	for (const auto& command : commands) {
		const int i = command[0];
		const int j = command[1];
		const int k = command[2];

		// 자르기
		vector<int> sliced = move(vector<int>(array.begin() + i - 1, array.begin() + j));
		// 정렬
		sort(sliced.begin(), sliced.end());
		// 뽑기
		answer.emplace_back(sliced[k - 1]);
	}

	return answer;
}