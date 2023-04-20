import java.util.Stack;

class Solution {
    public static int solution(int[][] board, int[] moves) {
        Stack<Integer> s = new Stack<>();
        int ys[] = new int[board.length];
        int answer = 0;

        // 각 열의 가장 높은 위치 인형 값 저장
        for(int x = 0; x < board.length; x++) {
            for(int y = 0; y < board.length; y++) {
                if (board[y][x] != 0) {
                    ys[x] = y;
                    break;
                }
            }
        }

        for(final int m : moves) {
            final int currX = m - 1;
            final int currY = ys[currX];            
        
             // 현재 x에 y 인형 위치를 다음 인형 위치로 옮기기
             for(int y = currY + 1; y < board.length; y++) {
                ys[currX] = y;
                if (board[y][currX] != 0)
                    break;
            }

            final int currDoll = board[currY][currX];
            if(currDoll == 0)
                continue;

            // 인형을 뽑은 자리를 공백으로 처리해 주지 않을 경우 뽑았던 인형을 다시 뽑을 수 있다.
            board[currY][currX] = 0;

            // 현재 인형과 이전 인형과 같다면 두 개를 없애는 코드
            if (!s.isEmpty() && currDoll == s.peek()) {                
                s.pop();
                answer += 2;
                continue;
            }
            
            // 인형을 꺼내 담기.
            s.push(currDoll);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(
            solution(new int[][]{{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}}, 
            new int[]{1,5,3,5,1,2,5,1,4,3})
            );

        System.out.println(
            solution(new int[][]{{0,0,0,0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,0}}, 
            new int[]{1,2,3,4})
            );

        System.out.println(
            solution(new int[][]{{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}}, 
            new int[]{1,5,3,5,1,2,1,4})
            );

        System.out.println(
            solution(new int[][]{{0,0,0,0}, {0,0,0,0}, {0,4,4,0}, {1,2,2,1}}, 
            new int[]{2, 3, 1, 4, 2, 3})
            );
    }
}