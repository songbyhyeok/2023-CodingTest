#include <iostream>
#include <vector>

using namespace std;

void dfs(int& towerCnt, const int start, vector<bool>& visited, vector<vector<int>>& towers) {
    visited[start] = true;
    for (const auto& tower : towers[start]) {
        if (visited[tower] == false) {
            ++towerCnt;
            dfs(towerCnt, tower, visited, towers);
        }
    }
}

int solution(int n, vector<vector<int>> wires) {
    // 송전탑 연결 용도
    vector<vector<int>> towers(n + 1);
    int answer = n + 1;

    // 두 송전탑의 전선을 서로 연결하기
    for (int i = 0; i < wires.size(); i++) {
        towers[wires[i][0]].emplace_back(wires[i][1]);
        towers[wires[i][1]].emplace_back(wires[i][0]);
    }
    
    // dfs를 통해 두 전력망의 송전탑 개수 구하기
    for (int i = 1; i <= n; i++) {
        for (const auto& target : towers[i]) {
            vector<bool> visited(n + 1);
            visited[i] = true;
            int targetTowerCnt = 1;
            dfs(targetTowerCnt, target, visited, towers);
            const int towerCnt = n - targetTowerCnt;

            /*  두 전력망 개수 차이가 적을수록 비슷한 개수이다.
                8:1 7
                7:2 5
                6:3 3
                5:4 1
                4:5 1
                3:6 3
                2:7 5
                1:8 7
            */
            const int diff = abs(targetTowerCnt - towerCnt);
            answer = min(answer, diff);
        }
    }

    return answer;
}

int main(void) {
    solution(9, { {1,3}, {2,3}, {3,4}, {4,5}, {4,6}, {4,7}, {7,8}, {7,9} });
    solution(4, { {1,2},{2,3}, {3,4} });
    solution(7, { {1,2}, {2,7}, {3,7}, {3,4}, {4,5}, {6,7}});

    return 0;
}