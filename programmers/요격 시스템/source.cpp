#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(const vector<int>& v1, const vector<int>& v2) {
    if (v1[0] == v2[0])
        return v1[1] < v2[1];

    return v1[0] < v2[0];
}

int solution(vector<vector<int>> targets) {
    int launchRange = 0;
    int answer = 0;

    // 오름차순 정렬
    sort(targets.begin(), targets.end(), compare);

    for (auto& target : targets) {
        // 두 폭격 미사일이 걸쳐있다면 겹치는 범위로 좁힌다.
        if (target[0] < launchRange) {
            if (target[1] < launchRange)
                launchRange = target[1];

            continue;
        }

        // 두 미사일은 걸쳐있지 않아 요격 미사일을 새로 발사한다.
        launchRange = target[1];
        ++answer;
    }

    return answer;
}

int main(void) {
    solution({ {4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4} });
    solution({ {0,4}, {1,2}, {1,3}, {3,4} });
    solution({ {0,4}, {0,1}, {2,3} });


    return 0;
}