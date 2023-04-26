#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

vector<int> solution(int n, vector<string> words) {
    // 중복 검사 목적 자료구조
    unordered_set<string> uSet;
    
    // 끝말잇기 시작

    // 첫 참여자가 말한 단어를 넣는 이유는 아래 규칙 두 가지에 얽매이지 않기 때문에 미리 넣어 성능을 높이기 위함
    uSet.insert(words[0]);
    for (int i = 1; i < words.size(); i++) {        
        // 참여자 식별자, 말한 횟수
        const vector<int> talkerInfo{ (i % n) + 1, (i / n) + 1 };

        // 내뱉은 단어
        const string& spokenWord = { words[i] };

        // 이전 참여자가 말한 단어의 마지막 문자로 시작하는지 확인
        const string& beforeWord{ words[i - 1] };
        if (i != 0 && beforeWord[beforeWord.length() - 1] != spokenWord[0])
            return talkerInfo;

        // 이전에 등장했던 단어가 있다는 말이므로 해당 참여자를 탈락시킨다.
        if (uSet.find(spokenWord) != uSet.end())
            return talkerInfo;

        // 앞 사람이 말한 단어와 대조하기 위해 set에 저장
        uSet.insert(words[i]);
    }

    return {0, 0};
}

int main(void) {
    solution(3, { "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" });
    solution(5, { "hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive" });
    solution(2, { "hello", "one", "even", "never", "now", "world", "draw" });

    return 0;
}
