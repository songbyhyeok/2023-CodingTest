#include <string>
#include <vector>

using namespace std;

bool checkTree(const string& tree, const string& skill) {
    size_t prev = 0;
    bool flag = false;

    for (const auto& s : skill) {
        size_t cur = tree.find(s);
        if (cur != string::npos) {
            if (flag || 
                cur < prev)
                return false;
            else
                prev = cur;
        }
        else
            flag = true;
    }

    return true;
}

int solution(string skill, vector<string> skill_trees) {
    int answer = 0;
    for (const auto& tree : skill_trees) {
        if (checkTree(tree, skill))
            ++answer;
    }

    return answer;
}


int main() {
    solution("CBD", { "BDA" });
}
