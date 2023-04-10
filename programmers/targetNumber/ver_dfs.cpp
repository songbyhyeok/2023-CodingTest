#include <iostream>
#include <vector>

using namespace std;

const int dfs(const int idx, const int end, const int sum, const int target, const vector<int> &numbers) {    
    if (idx == end) {
        if (sum == target)
            return 1;

        return 0;
    }

    return dfs(idx + 1, end, sum + numbers[idx + 1], target, numbers) + dfs(idx + 1, end, sum - numbers[idx + 1], target, numbers);
}

int solution(vector<int> numbers, int target) {
    return dfs(-1, numbers.size() - 1, 0, target, numbers);
}

void main(void) {
    cout << solution({1,1,1,1,1}, 3) << '\n';
    cout << solution({4,1,2,1}, 4) << '\n';
}