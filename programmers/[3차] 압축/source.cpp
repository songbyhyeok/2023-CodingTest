#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

vector<int> solution(string msg) {
	unordered_map<string, int> dict;
	vector<int> output;
	string comStr;
	int addN = 27;
	int w = 0, c = 1;

	// 투 포인터 
	comStr += msg[w];
	while (w < msg.length()) {
		// 해당 조합이 사전에 있는가?
		if (dict.find(comStr + msg[c]) != dict.end()) {
			// 조합을 만든다.
			comStr += msg[c];
			++c;
		}
		else {
			cout << comStr << '\n';

			// 길이가 하나라면 아스키코드 대문자 값에서 빼서 숫자를 만들어 넣기
			if (comStr.length() == 1) {
				output.emplace_back(msg[w] - 64);
				++w;
			}
			// 그게 아니라면 사전에 있는 조합의 숫자를 넣기
			else {
				output.emplace_back(dict[comStr]);
				w = c;
			}

			// 사전에 없는 조합을 사전에 넣기
			dict[comStr + msg[c]] = addN;
			++addN;

			++c;

			// 조합 초기화
			comStr.clear();
			comStr += msg[w];
		}
	}
	
	return output;
}

int main(void) {
	solution("TOBEORNOTTOBEORTOBEORNOT");
	solution("KAKAO");
	solution("ABABABABABABABAB");

	return 0;
}