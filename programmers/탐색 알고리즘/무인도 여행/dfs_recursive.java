import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;

class Solution {
    static int cumDays = 0;

    private static void dfs_recursive(int i, int j, String[] maps, boolean[][] visited) {
        // 섬 밖인지, X(바다)인지 체크
        if (i < 0 || i >= maps.length || j < 0 || j >= maps[i].length() || maps[i].charAt(j) == 'X' || visited[i][j]) {
            return;
        }

        // 방문처리
        visited[i][j] = true;
        
        cumDays += maps[i].charAt(j) - '0';

        // 우 하 좌 상 방향 처리
        dfs_recursive(i, j + 1, maps, visited);
        dfs_recursive(i + 1, j, maps, visited);
        dfs_recursive(i, j - 1, maps, visited);
        dfs_recursive(i - 1, j, maps, visited);
    }
    
    public static int[] solution(String[] maps) {
        final int rowLen = maps.length;
        final int colLen = maps[0].length();

        List<Integer> answer = new ArrayList<>(); 
        boolean visited[][] = new boolean[rowLen][colLen];
        
        for(int i = 0; i < maps.length; i++) {
            final String row = maps[i];
            for(int j = 0; j < row.length(); j++) {
                final char column = row.charAt(j);
                if (column != 'X') {
                    dfs_recursive(i, j, maps, visited);

                    if (cumDays > 0) {
                        answer.add(cumDays);
                        cumDays = 0;
                    }
                }
            }
        }

        // list에 아무 것도 없다면 섬이 존재하지 않는다.
        if (answer.isEmpty())
            return new int[]{-1};
        
        // 오름차순 정렬
        Collections.sort(answer);

        // 배열 변환
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
