import java.util.Scanner;

class Main {
    public static void main(String args[]) {      
        Scanner scanner = new Scanner(System.in);
        int filter[] = new int[988]; // 걸러낼 수들을 취합할 용도의 자료구조
        int answer = 0; // 정답에 근접한 수들의 개수
        int n = scanner.nextInt(); // 기회 횟수
        for(int i = 0; i < n; i++) {
            final int number = scanner.nextInt(); // 민혁이가 물어본 숫자
            final int nDigits[] = convertToDigit(number, 3); // number를 길이만큼 분해, 100의 자리 수이므로 3개 길이를 넣는다. 
            final int s = scanner.nextInt(); // strike
            final int b = scanner.nextInt(); // ball
            for(int j = 123; j < 988; j++) {
                final int tDigits[] = convertToDigit(j, 3); // target을 길이만큼 분해, 100의 자리 수이므로 3개 길이를 넣는다. 
                if (filter[j] == 0) { // 0은 아직 걸러내지 않았거나 걸러낸 수다, 걸러낸 수라면 계속 걸러낼 수 있게 여지를 주는 것이다.
                    filter[j] = inferNumber(tDigits, nDigits, s, b);
                }
            }
        }

        for(int i = 123; i < 988; i++) {
            if (filter[i] == 0) {
                ++answer;
            }
        }

        System.out.print(answer);
    }

    private static final int inferNumber(final int[] tDigits, final int[] nDigits, final int s, final int b) {
        /*  1일 경우 정답과 거리가 먼 수이므로 걸러내는 것이고, 
        0이면 정답일 수 있는 경우의 수다. */

        // 0이 섞여있거나 같은 숫자가 있을 경우 제외한다.
        for(int i = 0; i < 3; i++) {
            final int tDigit = tDigits[i];
            if (tDigit == 0) {
                return 1;
            } else {
                for (int j = i + 1; j < 3; j++) {
                    if (tDigit == tDigits[j]) {
                        return 1;
                    }
                }
            }
        }
        
        // nDigits와 s, b로 만들 수 있는 경우의 수를 123 ~ 987 사이에서 구한다.
        int tempS = 0, tempB = 0;
        for(int i = 0; i < 3; i++) {
            final int nDigit = nDigits[i];
            // 같은 자리의 두 숫자가 같다는 건 스트라이크다.
            if (nDigit == tDigits[i]) {
                ++tempS;
            } else { // 스트라이크가 아니라면 해당 자리로 만들 수 있는 볼의 경우의 수를 구해 본다.
                for (int j = 0; j < 3; j++) {
                    // i와 j가 같은 위치가 아니라면 볼인지 확인할 수 있다.
                    if (i != j) {        
                        // 두 수가 같다는 건 볼이다.
                        if (nDigit == tDigits[j]) { 
                            ++tempB;
                        }
                    }
                }
            }
        }

        // 정답일 수 있는 경우의 수이므로 저장한다.
        if (s == tempS && b == tempB)
            return 0;

        return 1;
    }

    // 숫자와 숫자 자릿수를 기입하면 자릿 수에 맞게 숫자들을 분해하여 반환하는 알고리즘입니다.
    private static final int[] convertToDigit(final int number, final int nLen) {
        int digits[] = new int[nLen];

        int copiedNumber = number;
        int exponentOf10 = (int)Math.pow(10, (nLen - 1));
        int curIdx = 0;
        while(copiedNumber != 0) {
            digits[curIdx] = copiedNumber / exponentOf10;
            copiedNumber %= exponentOf10;

            ++curIdx;
            exponentOf10 = (int)Math.pow(10, (nLen - 1) - curIdx);
        }

        return digits;
    }
}