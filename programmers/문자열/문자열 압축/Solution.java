class Solution {
    public int solution(String s) {
        final int strLen = s.length();
        // 길이가 1인 경우 
        if (strLen == 1) {
            return 1;
        }

        int answer = 1000;
        StringBuilder combStr = new StringBuilder();
        
        for (int i = 0; i < strLen; i++) {
            final int len = i + 1;
            String sp = s.substring(0, len);
            int cnt = 1;
            int j = len;

            // 현재 가리키는 길이가 절반 아래일 경우에만
            if (len > strLen / 2) {
                break;
            }

            for (; j < strLen; j += len) {

                // 비교 지점 길이가 범위를 넘어설 경우
                if (j + len > strLen) {
                    break;
                }

                final String ep = s.substring(j, j + len);
                // 두 값이 같다면
                if (sp.equals(ep)) {
                    ++cnt;
                } else { // 같지 않다면
                    // combStr에 문자열을 누적
                    // cnt가 2개 이상일 때 cnt도 누적
                    final String cntStr = 1 < cnt ? Integer.toString(cnt) : "";
                    combStr.append(cntStr + sp);

                    // ep 지점에서 다시 연산 처리를 하기 위한 코드
                    cnt = 1;
                    sp = ep;
                }
            }

            // combStr에 문자열을 누적
            // cnt가 2개 이상일 때 cnt도 누적
            final String cntStr = 1 < cnt ? Integer.toString(cnt) : "";
            combStr.append(cntStr + sp);
            final int compactLen = (combStr.toString() + s.substring(j, strLen)).length();
            answer = Math.min(answer, compactLen);

            // 조합 문자열 초기화
            combStr.setLength(0);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("a"));
        System.out.println(new Solution().solution("aabbaccc"));
    }
}