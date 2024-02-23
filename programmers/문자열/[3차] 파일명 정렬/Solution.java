import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String[] solution(String[] files) {
        List<String> answer = new ArrayList<>(Arrays.asList(files));
        
        // 0. 두 문자열을 정렬하기 위해 sort comparator 사용
        answer.sort((s1, s2) -> {
            // 1. split를 사용한 정렬
            // Head, Number, Tail로 각각 분리하여 구조화
            // 긍정형 전방탐색 positive lookbehind chat gpt가 알려줌
            // 숫자나 문자 기준으로 분리할 수 있게 해준다.
            String[] s1Parts = s1.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
            String[] s2Parts = s2.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");

            // 2. Head는 문자열 비교 (통일하기 위해 소문자 변환 후 진행)
            final int comparedHead = s1Parts[0].toLowerCase().compareTo(s2Parts[0].toLowerCase());
            // 2-1 Number에서 크기 비교 (두 문자열이 같을 때, 숫자 크기 비교하기 위해 숫자 변환 후 진행)
            if (comparedHead == 0) {
                return Integer.compare(Integer.parseInt(s1Parts[1]), Integer.parseInt(s2Parts[1]));
            }

            // 2-2 같지 않기 때문에 문자열 사전순 기준으로 정렬
            return comparedHead;
        });

        return answer.stream().toArray(String[]::new);
    }

    public static void main(String[] args) {
        for (String str : new Solution().solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})) {
            System.out.println(str + ", ");
        }

        System.out.println();
        
        for (String str : new Solution().solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})) {
            System.out.println(str + ", ");
        }
    }
}