import java.util.*;

public class Solution {
    private static int bfs(int i, int j, final int rowLen, final int colLen, String[] maps, boolean[][] visited) {
        final int dirX[] = {0, 1, 0, -1};
        final int dirY[] = {1, 0, -1, 0};
        
        int cumDays = maps[i].charAt(j) - '0';

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i, j));

        visited[i][j] = true;

        while (!q.isEmpty()) {
            final Pair coord = q.poll();
            for(int k = 0; k < 4; k++) {
                final int nextX = coord.x + dirX[k];
                final int nextY = coord.y + dirY[k];
                if (nextX < 0 || nextX >= rowLen || nextY < 0 || nextY >= colLen) {
                    continue;
                }

                final char terrain = maps[nextX].charAt(nextY);
                if (terrain == 'X' || visited[nextX][nextY]) {
                    continue;
                }

                cumDays += terrain - '0';
                q.offer(new Pair(nextX, nextY));
                visited[nextX][nextY] = true;
            }
        }

        return cumDays;
    }

    private static int[] solution(String[] maps) {
        List<Integer> list = new LinkedList<>();
        
        final int rowLen = maps.length;
        final int colLen = maps[0].length();
        boolean[][] visited = new boolean[rowLen][colLen];
        
        for(int i = 0; i < rowLen; i++) {
            for(int j = 0; j < colLen; j++) {
                final char terrain = maps[i].charAt(j);
                if (terrain == 'X' || visited[i][j]) {
                    continue;
                }

                final int days = bfs(i, j, rowLen, colLen, maps, visited);
                list.add(days);
            }
        }

        if (list.isEmpty()) {
            list.add(-1);
        } else {
          Collections.sort(list);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        
        String maps1[] = {
            "X591X",
            "X1X5X",
            "X231X", 
            "1XXX1"
        };
        String maps2[] = {
            "XXX",
            "XXX",
            "XXX"
        };

        int answer[] = solution(maps1);
        int answer2[] = solution(maps2);

        for(int mapEa : answer) {
            System.out.println(mapEa);
        }

        System.out.println("----");
        
        for(int mapEa : answer2) {
            System.out.println(mapEa);
        }
    }
}