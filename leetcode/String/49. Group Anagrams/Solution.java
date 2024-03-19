import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> answer = new HashMap<>();

        for(String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String strKey = String.valueOf(chars);
            
            if (!answer.containsKey(strKey)) {
                answer.put(strKey, new ArrayList<>());
            }

            answer.get(strKey).add(str);
        }

        return new ArrayList<>(answer.values());
    }
}