import java.util.HashMap;

class Solution {
    public static int solution(String s) {      
        HashMap<String, Character> hashMap = new HashMap<>();
        hashMap.put("zero", '0');
        hashMap.put("one", '1');
        hashMap.put("two", '2');
        hashMap.put("three", '3');
        hashMap.put("four", '4');
        hashMap.put("five", '5');
        hashMap.put("six", '6');
        hashMap.put("seven", '7');
        hashMap.put("eight", '8');
        hashMap.put("nine", '9');

        StringBuilder sB = new StringBuilder();
        StringBuilder tempSB = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            final Character ch = s.charAt(i);
            if (Character.isDigit(ch))
                sB.append(ch);
            else {
                tempSB.append(ch);
                if (hashMap.get(tempSB.toString()) != null) {
                    sB.append(hashMap.get(tempSB.toString()));
                    tempSB.delete(0, tempSB.length());
                }
            }
        }
        
        return Integer.parseInt(sB.toString());
    }

    public static void main(String[] args) {
        solution("one4seveneight");
        solution("23four5six7");
        solution("2three45sixseven");
        solution("123");
    }
}