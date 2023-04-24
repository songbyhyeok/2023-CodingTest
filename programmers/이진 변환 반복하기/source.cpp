#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(string s) {
    vector<int> answer(2, 0);

    // s의 길이가 1이고, s의 값이 '1'은 최종 이진 변환 결과가 1이란 것이다.
    while (!(s.length() == 1 && s[0] == '1')) {
        // 회차 누적
        ++answer[0];

        // 전체 길이
        const int previousLen = s.length();

        // 제거한 0의 개수
        int zeroCnt = 0;

        // 1. 0을 제거한다.
        for (const auto& ch : s)
            zeroCnt += (ch == '0');

        // 0의 개수 누적
        answer[1] += zeroCnt;

        // 0을 제거한 현재 길이
        int removedLen = previousLen - zeroCnt;

        // 현재 길이를 다시 2진법으로 변환한다.
        string binary;
        binary.reserve(removedLen);
        while (0 < removedLen) {
            binary.push_back((removedLen % 2) + '0');
            removedLen /= 2;
        }

        // 만든 2진법을 원래 s에 잘라 넣는다.
        s = move(binary);
    }

    return answer;
}

int main(void) {
    solution("110010101001");

    return 0;
}
