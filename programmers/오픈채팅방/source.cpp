#include <string>
#include <sstream>
#include <vector>
#include <unordered_map>
#include <iostream>

using namespace std;

vector<string> generateSplit(string input, char delimiter) {
    vector<string> splits;
    stringstream ss(move(input));
    string tmp;

    while (getline(ss, tmp, delimiter))
        splits.emplace_back(move(tmp));

    return move(splits);
};

vector<string> solution(vector<string> record) {
    // 입장, 퇴장 시점 ID 기록들 
    vector<pair<string, string>> idRecords;

    // ID TO NICKNAME
    unordered_map<string, string> nicks;

    vector<string> answer;

    // 기록 3분할 하기
    for (const auto& r : record) {
        auto splits = move(generateSplit(r, ' '));
        auto& command = splits[0];
        auto& id = splits[1];
        auto& nick = splits[2];

        // 입장, 변경 명령어가 나올 경우 ID에 NICK을 변경한다.
        if (command == "Enter" || command == "Change")
            nicks[id] = move(splits[2]);

        // 입장, 퇴장 명령어가 나올 경우 기록한다.
        if (command == "Enter" || command == "Leave")
            idRecords.emplace_back(move(command), move(id));
    }


    // 입, 퇴장 저장 기록들을 다시 꺼내 결과를 도출한다.
    answer.reserve(idRecords.size());
    for (const auto& r : idRecords)
        answer.emplace_back(nicks[r.second] + "님이 " + (r.first == "Enter" ? "들어왔습니다." : "나갔습니다."));

    return answer;
}

int main() {
    solution({ "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan" });
}
