#include <iostream>
#include <vector>
#include <queue>

using namespace std;

const int bfs(const int target, vector<int>& numbers) {
    queue<pair<int, int>> q;
    const int len = numbers.size();
    int answer = 0;

    q.emplace(numbers[0], 1);
    q.emplace(-numbers[0], 1);
    while (!q.empty()) {
        const pair<int, int> pValue = q.front();
        q.pop();

        if (len == pValue.second) {
            if (pValue.first == target)
                ++answer;

            continue;
        }
             
        q.emplace(pValue.first + numbers[pValue.second], pValue.second + 1);
        q.emplace(pValue.first - numbers[pValue.second], pValue.second + 1);
    }

    return answer;
}

int solution(vector<int> numbers, int target) {
    return bfs(target, numbers);
}

void main(void) {
    cout << solution({ 1,1,1,1,1 }, 3) << '\n';
    cout << solution({ 4,1,2,1 }, 4) << '\n';
}