#include <vector>

using namespace std;

void dfs(const int start, int& cnt, const vector<int>& unconnected, vector<bool>& visited, vector<vector<int>>& towers) {
    visited[start] = true;
    ++cnt;

    for (const auto& connectedTower : towers[start]) {
        // 두 송전탑은 연결되어 있지 않다!
        if (start == unconnected[0] && connectedTower == unconnected[1]
            || start == unconnected[1] && connectedTower == unconnected[0])
            continue;
        
        if (visited[connectedTower] == false)
            dfs(connectedTower, cnt, unconnected, visited, towers);
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
        
    for(const auto& wire : wires) {
        vector<bool> visited(n + 1);
        int connectedCnt = 0;
        // 고정적으로 노드 1번부터 시작
        dfs(1, connectedCnt, wire, visited, towers);
        
        const int unconnectedCnt = n - connectedCnt;

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
        const int diff = abs(unconnectedCnt - connectedCnt);
        answer = min(answer, diff);
    }

    return answer;
}

int main(void) {
    solution(9, { {1,3}, {2,3}, {3,4}, {4,5}, {4,6}, {4,7}, {7,8}, {7,9} });
    solution(4, { {1,2},{2,3}, {3,4} });
    solution(7, { {1,2}, {2,7}, {3,7}, {3,4}, {4,5}, {6,7} });

    return 0;
}