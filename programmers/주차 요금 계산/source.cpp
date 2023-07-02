#include <iostream>
#include <map>
#include <vector>
#include <sstream>
#include <cmath>

using namespace std;

vector<int> solution(vector<int> fees, vector<string> records) {
	map<string, vector<int>> map;
    vector<int> answer;
	stringstream ss;

	// ' ' 기준 자르기
	for (const auto& record : records) {
		string v, k;

		ss.str(record);
		ss >> v;
		ss >> k;
		ss.clear();

		// 입/출차 숫자 값으로 전환하여 저장
		map[move(k)].emplace_back(stoi(v.substr(0, 2)) * 60 + stoi(v.substr(3, 6)));
	}

	answer.reserve(map.size());

	// 주차 요금 계산
	for (auto& item : map) {
		const int itemSize = item.second.size();

		// 홀수라면 23:59 출차된 것 간주 
		if (itemSize & 1)
			item.second.emplace_back(1439);

		// 누적 주차시간 계산
		int cumTime = 0;
		for (int i = 0; i < itemSize; i += 2)
			cumTime += (item.second[i + 1] - item.second[i]);
		
		// 기본 시간 초과 경우와 그렇지 않은 경우 계산	 
		answer.emplace_back(fees[0] < cumTime ? fees[1] + ceil(static_cast<double>(cumTime - fees[0]) / fees[2]) * fees[3] : fees[1]);
	}

    return answer;
}

int main(void) {
	solution({ 180, 5000, 10, 600 }, { "05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" } );
	solution({ 120, 0, 60, 591 }, { "16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN" } );
	solution({ 1, 461, 1, 10 }, { "00:00 1234 IN" } );

	return 0;
}