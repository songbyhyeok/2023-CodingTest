#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(string s) {
    vector<int> answer(2, 0);

    // s�� ���̰� 1�̰�, s�� ���� '1'�� ���� ���� ��ȯ ����� 1�̶� ���̴�.
    while (!(s.length() == 1 && s[0] == '1')) {
        // ȸ�� ����
        ++answer[0];

        // ��ü ����
        const int previousLen = s.length();

        // ������ 0�� ����
        int zeroCnt = 0;

        // 1. 0�� �����Ѵ�.
        for (const auto& ch : s)
            zeroCnt += (ch == '0');

        // 0�� ���� ����
        answer[1] += zeroCnt;

        // 0�� ������ ���� ����
        int removedLen = previousLen - zeroCnt;

        // ���� ���̸� �ٽ� 2�������� ��ȯ�Ѵ�.
        string binary;
        binary.reserve(removedLen);
        while (0 < removedLen) {
            binary.push_back((removedLen % 2) + '0');
            removedLen /= 2;
        }

        // ���� 2������ ���� s�� �߶� �ִ´�.
        s = move(binary);
    }

    return answer;
}

int main(void) {
    solution("110010101001");

    return 0;
}
