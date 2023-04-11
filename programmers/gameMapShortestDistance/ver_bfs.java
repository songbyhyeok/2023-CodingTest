import java.util.LinkedList;
import java.util.Queue;

class Pos {
    public int x;
    public int y;
    public int dist;

    Pos(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

class Solution {
    private final int bfs(int[][] maps) {
        Queue<Pos> q = new LinkedList<>();        
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        // 상, 좌, 하, 우
        final Pos[] directions = new Pos[]{new Pos(-1, 0, 0), new Pos(0, -1, 0), new Pos(1, 0, 0), new Pos(0, 1, 0)};        
        final Pos dest = new Pos(maps[0].length - 1, maps.length - 1, 0);
        int answer = -1;
        
        q.add(new Pos(0, 0, 1));
        visited[0][0] = true;
        while(!q.isEmpty()) {
            final Pos currPos = q.poll();
            if (currPos.x == dest.x && currPos.y == dest.y) {
                answer = currPos.dist;
                break;
            }

            for(final Pos dir : directions) {
                final Pos nextPos = new Pos(currPos.x + dir.x, currPos.y + dir.y, currPos.dist + 1);
                if (nextPos.y < 0 || nextPos.x < 0 || nextPos.y > dest.y || nextPos.x > dest.x)
                    continue;
                else if (maps[nextPos.y][nextPos.x] == 0)
                    continue;
                else if (visited[nextPos.y][nextPos.x])
                    continue;
                    
                q.add(nextPos);
                visited[nextPos.y][nextPos.x] = true;
            }
        }
        
        return answer;
    }

    public int solution(int[][] maps) {
        return bfs(maps);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(new int[][]{{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}});
        s.solution(new int[][]{{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,0}, {0,0,0,0,1}});
    }
}