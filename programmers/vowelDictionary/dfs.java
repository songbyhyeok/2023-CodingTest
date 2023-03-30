import java.util.ArrayList;
import java.util.List;

class Solution {
    // 알파벳 모음
    static final String words = "AEIOU";    
    
    public static int solution(String word) {
        // 알파벳 사전
        List<String> dict = new ArrayList<>();
        // 찾는 단어가 몇 번째에 있는지 횟수 채워주는 변수
        int answer = 0;

        // 사전에 알파벳들을 담기.
        insertWord(0, "", dict);
        
        // 요구하는 단어가 몇 번째에 있는지 찾기
        for(final String dWord : dict) {
            if (dWord.equals(word))
                break;

            ++answer;
        }
            
        return answer;
    }

    private static void insertWord(final int cnt, final String combinedWord, List<String> dict) {
        // 단어를 수집한다.
        dict.add(combinedWord);

        if (cnt == words.length())
            return;

        // 다음 붙일 단어들 
        for(final char ch : words.toCharArray())
            insertWord(cnt + 1, combinedWord + ch, dict);
    } 
    public static void main(String[] args) {
        System.out.println(solution("AAAAE"));
        System.out.println(solution("AAAE"));
        System.out.println(solution("I"));
        System.out.println(solution("EIO"));
    }
}

