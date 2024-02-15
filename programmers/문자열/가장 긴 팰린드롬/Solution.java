
class Solution {
    public static int solution(String s) {
        int answer = 1;
        final int sLen = s.length();
        // 길이가 1인 경우 처리
        if (sLen == 1) {
            return 1;
        }

        for(int i = 0; i < sLen; i++) {
            final char sp = s.charAt(i);
            for(int j = sLen - 1; j > i; j--) {
                // i와 비교 대상인 j가 같다면 two pointer 알고리즘을 수행한다.
                if (sp == s.charAt(j)) {
                    int start = i;
                    int end = j;
                    boolean isSuccess = true;

                    while(start < end) {
                        if (s.charAt(start) != s.charAt(end)) {
                            isSuccess = false;
                            break;
                        }

                        ++start;
                        --end;
                    }

                    if (isSuccess) {
                        answer = Math.max(answer, (j - i) + 1);
                        // 최대 길이를 구하는 문제이기 때문에 그 이하의 값을 찾는 비교는 성능 낭비다.
                        j = i;
                    }                
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        solution("a");
        solution("aa");
        solution("abcdcba");
        solution("abacde");
        solution("abacedde");
    }
}