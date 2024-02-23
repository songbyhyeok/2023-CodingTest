import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    static Queue<Integer> Que = new LinkedList<>();
    static List<Integer> AdjList[];
    static int Distance[];

    private static int bfs() {
        int maxDist = 0;

        Que.offer(1);
        Distance[1] = maxDist;
        
        while(!Que.isEmpty()) {
            // 시작점 노드를 꺼낸다.
            final int sNode = Que.poll();
            // 시작점 노드의 이웃 노드들을 꺼내 현재 거리 + 1을 기입한다.
            for(int eNode : AdjList[sNode]) {
                // 한 번도 방문하지 않았다면
                if (Distance[eNode] == -1) {
                    Distance[eNode] = Distance[sNode] + 1;
                    Que.add(eNode);

                    // 최대 거리 값 갱신
                    maxDist = Math.max(maxDist, Distance[eNode]);
                }
            }
        }

        return maxDist;
    }

    public static int solution(int n, int[][] edge) {
        AdjList = new ArrayList[n + 1];
        Distance = new int[n + 1];
        int answer = 0;

        // 각 노드 거리 값 초기화 및 인접리스트 생성
        for (int i = 1; i <= n; i++) {
            Distance[i] = -1;
            AdjList[i] = new ArrayList<>();
        }

        // 1. 양방향 간선 관계 구축
        for (int i = 0; i < edge.length; i++) {
            final int sNode = edge[i][0];
            final int eNode = edge[i][1];
            AdjList[sNode].add(eNode);
            AdjList[eNode].add(sNode);
        }

        // 2. bfs 알고리즘을 통해 1번 기점에서 각 노드의 거리 값을 구한다.
        final int maxDist = bfs();

        // 3. 가장 먼 거리 값에 해당하는 노드들을 찾아 개수를 누적한다.
        for(int i = 2; i <= n; i++) {
            if (Distance[i] == maxDist) {
                ++answer;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        solution(6, new int[][] { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } });
    }
}