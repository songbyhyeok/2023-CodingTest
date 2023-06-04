import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static int[] solution(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Map.Entry<Integer,Integer>> list;
        int tuple[];        
        
        // 튜플 숫자들을 모두 map에 count하는 코드
        for(int i = 2; i < s.length() - 2; i++) {
            final char ch = s.charAt(i);
            if (Character.isDigit(ch)) {    
                int n = ch - '0';
                while(Character.isDigit(s.charAt(i + 1))) {
                    n *= 10;
                    n += s.charAt(i + 1) - '0';

                    ++i;
                }
                
                if (!map.containsKey(n))
                    map.put(n, 1);
                else 
                    map.put(n, map.get(n) + 1);
            }
        }
   
        // map에 데이터를 list로 옮겨서 count 기준 내림차순 하는 코드
        list = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2) {
                 return m2.getValue().compareTo(m1.getValue()); // 내림차순
            }
        });
        
        // 정렬된 숫자들을 array에 옮겨 하나의 tuple 만들기
        tuple = new int[list.size()];
        for(int i = 0; i < tuple.length; i++)
            tuple[i] = list.get(i).getKey();

        return tuple;
    }

    public static void main(String[] args) throws Exception {
        solution("{{123}}");
    }
}