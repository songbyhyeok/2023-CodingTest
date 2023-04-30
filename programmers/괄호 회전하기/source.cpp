#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(string s) {
    stack<char> stack;
    const int sLen = s.length();
    int answer = 0;

    // 홀수는 올바른 괄호로 만들 수가 없다.
    if (sLen % 2 == 0) {
        for (int i = 0; i < sLen; i++) {      
            // 올바른 괄호 문자열인지 체크
            bool flag = false;
            for (const auto& ch : s) {
                // 비어있다면 삽입
                if (stack.empty()) {
                    // 비어있는데 역괄호가 나온다면 올바른 괄호가 아님
                    if (ch == ']' || ch == ')' || ch == '}') {
                        flag = true;
                        break;
                    }

                    stack.emplace(ch);
                }
                else {
                    switch (ch) {
                        // 닫힌 괄호들이 먼저 나오면 스택에 삽입
                    case '[': case '(': case '{':
                        stack.emplace(ch);
                        break;
                    case ']': case ')': case '}':
                        const char& bracket = stack.top();
                        if ((bracket == '[' && ch == ']') ||
                            (bracket == '{' && ch == '}') ||
                            (bracket == '(' && ch == ')'))
                            stack.pop();
                        else
                            flag = true;
                        break;
                    }

                    // 스택의 마지막 값과 붙였을 때 닫히지 않는다면 올바른 괄호가 아니다.
                    if (flag)
                        break;
                }
            }

            if (stack.empty() && !flag)
                ++answer;

            while (!stack.empty())
                stack.pop();

            // x가 마지막이라면 더이상 회전할 필요가 없다.
            if (i < sLen - 1) {
                // 왼쪽으로 회전
                char temp = s[0];
                for (int i = 1; i < sLen; i++)
                    s[i - 1] = s[i];

                s[sLen - 1] = temp;
            }
        }
    }

    return answer;
}

int main(void) {
    solution("[)(]");
    solution(")(][");
    solution("(][)");
    solution("][)(");

    return 0;
}
