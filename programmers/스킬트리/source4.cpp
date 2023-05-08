#include <string>
#include <vector>

using namespace std;

int solution(string skill, vector<string> skill_trees) {
    int skills[26]{};
    int answer = 0;
    
    for (int i = 0; i < skill.length(); i++)
        skills[skill[i] - 'A'] = i + 1;

    for (const auto& st : skill_trees) {
        int cnt = 1;
        bool flag = true;

        for (const auto& stCh : st) {
            const int skillVal = skills[stCh - 'A'];
            if (skillVal == 0)
                continue;
            else if (skillVal == cnt)
                ++cnt;
            else {
                flag = false;
                break;
            }
        }

        answer += (flag);
    }

    return answer;
}

int main() {
    solution("CBD", { "BACDE", "CBADF", "AECB", "BDA" });
}
