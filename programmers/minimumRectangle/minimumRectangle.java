class Solution {
    public static int solution(int[][] sizes) {
        // 모든 명함을 담을 수 있는 명함의 크기 변수
        int maxX = 0, maxY =0;
        for(final int[] wl : sizes) {
            // 세로가 더 길다면 가로로 눕힌다.
            if (wl[0] < wl[1]) {
                final int temp = wl[0];
                wl[0] = wl[1];
                wl[1] = temp;
            }
            
            maxX = Math.max(maxX, wl[0]);
            maxY = Math.max(maxY, wl[1]);
        }

        return maxX * maxY;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
        System.out.println(solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}));
        System.out.println(solution(new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}));
    }
}