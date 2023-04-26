#include <string>
#include <stack>

using namespace std;

int solution(string s) {
    stack<char> stack;

    for (int i = 0; i < s.size(); i++) {
        const char& ch = s[i];
        if (stack.empty() || stack.top() != ch) {
            stack.emplace(ch);
            continue;
        }

        stack.pop();
    }

    return stack.size() == 0;
}

int main(void) {
    solution("cdcd");

    return 0;
}
