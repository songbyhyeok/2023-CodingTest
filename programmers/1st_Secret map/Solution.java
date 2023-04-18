class Solution {
    private static boolean[][] convertBinary(final int len, int[] arr) {
        boolean binaryArr[][] = new boolean[len][len];

        for(int i = 0; i < len; i++) {
            int n = arr[i];
            for(int j = len - 1; j >= 0; j--) {
                binaryArr[i][j] = n % 2 == 1;
                n /= 2;
            }
        }

        return binaryArr;
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        boolean map1[][] = convertBinary(n, arr1);
        boolean map2[][] = convertBinary(n, arr2);
        final char ch[] = new char[]{' ', '#'};
        
        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++) 
                sb.append(ch[map1[i][j] || map2[i][j] ? 1 : 0]);

            answer[i] = sb.toString();
        }
        
        return answer;
    }

    public static void main(String[] args) {
       solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
       solution(6, new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10});
    }
}