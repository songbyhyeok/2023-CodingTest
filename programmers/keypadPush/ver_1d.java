class Solution1 {
    public static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int leftIdx = 10; // 시작 위치 *
        int rightIdx = 12; // 시작 위치 #

        for(int n : numbers) {
            if (n == 0) // 0번은 11번으로 간주
                n = 11;
            switch(n % 3) {
                case 0: { // right turn
                    rightIdx = n;
                    answer.append("R");
                    break;
                } case 1: { // left turn
                    leftIdx = n;
                    answer.append("L");
                    break;
                } case 2: { // left or right
                    // 휴대폰 번호 값을 2차원 좌표로 변환하는 초기화 과정
                    // 값에 1을 빼는 이유는 좌표가 0부터 시작하기 때문이다.
                    final int xOfN = (n - 1) % 3;
                    final int yOfN = (n - 1) / 3;

                    final int xOfLeft = (leftIdx - 1) % 3;
                    final int yOfLeft = (leftIdx - 1) / 3;
                    final int leftDist = getDist(xOfLeft, yOfLeft, xOfN, yOfN);
                    
                    final int xOfRight = (rightIdx - 1) % 3;
                    final int yOfRight = (rightIdx - 1) / 3;
                    final int rightDist = getDist(xOfRight, yOfRight, xOfN, yOfN);
                    
                    if (leftDist < rightDist) {
                        leftIdx = n;
                        answer.append("L");
                    } else if(leftDist > rightDist) {
                        rightIdx = n;
                        answer.append("R");
                    } else {
                        if (hand.equals("right")) {
                            rightIdx = n;
                            answer.append("R");
                        } else if (hand.equals("left")) {
                            leftIdx = n;
                            answer.append("L");
                        }
                    }
                    
                    break;
                }
            }
        }

        return answer.toString();
    }

    private static final int getDist(final int xOfHand, final int yOfHand, final int xOfN, final int yOfN) {
        return Math.abs(xOfHand - xOfN) + Math.abs(yOfHand - yOfN);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
        System.out.println(solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
    }
}
