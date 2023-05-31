import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));    

    // 상하좌우 방향 이동에 사용 변수들
    static int DirY[] = new int[]{-1, 0, 1, 0};
    static int DirX[] = new int[]{0, -1, 0, 1};

    // 맵 크기
    static int N, M;

    private static final class Pair {
        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }

        int x;
        int y;
    }

    private static int bfs(boolean map[][]) {
        int distances[][] = new int[N][M];
        Queue<Pair> q = new LinkedList<>();
        final Pair destPos = new Pair(N - 1, M - 1);
        boolean flag = false;

        q.add(new Pair(0, 0));
        distances[0][0] = 1;

        while(!q.isEmpty() && !flag) {
            final Pair currPos = q.poll();
            for(int i = 0; i < 4; i++) {
                final Pair nextPos = new Pair(currPos.y + DirY[i], currPos.x + DirX[i]);
                if (0 <= nextPos.y && nextPos.y < N && 0 <= nextPos.x && nextPos.x < M) {
                    if (map[nextPos.y][nextPos.x] && distances[nextPos.y][nextPos.x] == 0) {
                        // 다음 위치에 갈 수 있다면 현재 위치에서 거릿값을 하나 더 올린다.
                        distances[nextPos.y][nextPos.x] = distances[currPos.y][currPos.x] + 1;

                        // 도착지라면 빠져나오기
                        if (nextPos.y == destPos.y && nextPos.x == destPos.x) {
                            flag = true;
                            break;
                        }
                        
                        q.add(nextPos);
                    }
                }

            }
        }

        return distances[destPos.y][destPos.x];
    }

    public static void main(String[] args) throws Exception {
        // 입력
        String matrix[] = BR.readLine().split(" ");

        // 초기화
        N = Integer.parseInt(matrix[0]);
        M = Integer.parseInt(matrix[1]); 
        boolean map[][] = new boolean[N][M];

        // 입력
        for(int i = 0; i < N; i++) {
            String mapData = BR.readLine();
            for(int j = 0; j < M; j++) {
                if (mapData.charAt(j) == '1')
                    map[i][j] = true;
            }
        }
        
        BW.write(String.valueOf(bfs(map)) + '\n');
        BW.flush();
        BW.close();
    }
}