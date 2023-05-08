#include <string>
#include <vector>

using namespace std;

int solution(string skill, vector<string> skill_trees) {
    int answer = 0;

    for (const auto& st : skill_trees) {
        int sIdx = 0;
        bool flag = true;
        for (const auto& stCh : st) {
            for (const auto& sCh : skill) {
                // 선행 스킬 요소에 속하는가?
                if (sCh == stCh) {
                    // 현재 찾은 요소가 선행 스킬인가?
                    if (skill[sIdx] == stCh)
                        ++sIdx;
                    // 불가능한 스킬트리이기 때문에 탐색 중단
                    else
                        flag = false;
                }
            }

            // 계속 찾을 필요가 없다.
            if (!flag)
                break;
        }
        
        answer += (flag);
    }
}

int main() {
    solution("CBD", { "BACDE", "CBADF", "AECB", "BDA" });
}
