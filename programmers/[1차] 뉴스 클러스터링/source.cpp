#include <iostream>
#include <string>
#include <unordered_map>

using namespace std;

bool isAlphabet(char& ch) {
	// 대문자라면 소문자로 자동 변환 후 true 
	// (더하는 연산이기 때문에 역 변환인 소 to 대의 빼는 연산보다 성능적 이점이 있어 선택)
	if ('A' <= ch && ch <= 'Z') {
		ch += 32;
		return true;
	}
	// 소문자라도 반환 true
	else if ('a' <= ch && ch <= 'z')
		return true;
	
	// 알파벳이 아니기 때문에 false
	return false;
}

// 슬라이딩 윈도우
void functionSlidingWindow(string& str, unordered_map<string, pair<int, int>>& uMap, bool flag = true) {
	int s = 0, e = 1;
	while (e < str.length()) {
		auto& sCh = str[s];
		auto& eCh = str[e];

		// 둘다 알파벳이라면 해시에 문자 개수를 누적
		if (isAlphabet(sCh) && isAlphabet(eCh)) {
			string comStr;
			comStr += sCh;
			comStr += eCh;
			flag == true ? ++uMap[comStr].first : ++uMap[comStr].second;
			++s, ++e;
		}
		// 시작점만 알파벳이 아니라면 시작점과 끝점을 한 칸씩 이동한다.
		else if (!isAlphabet(sCh) && isAlphabet(eCh))
			++s, ++e;
		// 그게 아니라면 시작점과 끝점이 둘 다 알파벳이 아니거나 끝점만 알파벳이 아니기 때문에 두 칸씩 이동시킨다.
		else
			s += 2, e += 2;
	}
}

int solution(string str1, string str2) {
	unordered_map<string, pair<int, int>> uMap;
	// 교집합
	int isn = 0;
	// 합집합
	int sum = 0;

	// 각 문자열 슬라이딩 윈도우 사용하여 원소집합 만들기
	functionSlidingWindow(str1, uMap);
	functionSlidingWindow(str2, uMap, false);

	// 공집합이면 1이다.
	if (uMap.size() == 0)
		return 65536;

	// map 데이터를 꺼내 교집합, 합집합 계산
	for (auto& e : uMap) {			
		isn += min(e.second.first, e.second.second);
		sum += max(e.second.first, e.second.second);
	}

	return (static_cast<double>(isn) / sum) * 65536;
}

int main(void) {
	cout << solution("france", "french") << '\n';
	cout << solution("handshake", "shake hands") << '\n';
	cout << solution("aa1+aa2", "aaaa12") << '\n';
	cout << solution("e=m*c^2", "e=m*c^2") << '\n';

	return 0;
}