import java.util.Arrays;

public class Solution {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            final int command[] = commands[i];
            int temp[] = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(temp);
            answer[i] = temp[command[2] - 1];
        }

        return answer;
    }

    public static void main(String[] args) throws Exception {
        solution(new int[] { 1, 5, 2, 6, 3, 7, 4 }, new int[][] { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } });
    }
}