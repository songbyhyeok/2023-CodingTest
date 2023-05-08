#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

int solution(string skill, vector<string> skill_trees) {
    // skill을 담을 용도
    unordered_map<char, int> skills;

    int answer = 0;

    // skill을 순차적으로 담는다.
    for (int i = 0; i < skill.size(); i++)
        skills.emplace(skill[i], i);

    // 스킬 트리들 중에 가능한 것들 선정하기
    for (const auto& skillTree : skill_trees) {
        int n = 0;
        bool flag = true;
        for (const auto& s : skillTree) {
            if (skills.find(s) != skills.end()) {
                if (skills[s] != n) {
                    flag = false;
                    break;
                }

                n += (skills[s] == n);
            }
        }

        answer += (flag == true);
    }

    return answer;
}

int main() {
    solution("CBD", { "BACDE", "CBADF", "AECB", "BDA" });
}