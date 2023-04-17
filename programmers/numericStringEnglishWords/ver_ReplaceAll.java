import java.util.HashMap;

class Solution {
    public static int solution(String s) {   
        String[] engWords = {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
        };        
        for(int i = 0; i < engWords.length; i++)
            s = s.replace(engWords[i], Integer.toString(i));
        
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        solution("one4seveneight");
        solution("23four5six7");
        solution("2three45sixseven");
        solution("123");
    }
}