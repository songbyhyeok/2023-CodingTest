import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) { 
        Map<String, Integer> answer = new HashMap<>();
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        
        String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");        
        for(String word : words) {
            if (bannedSet.contains(word)) {
                continue;
            }

            answer.put(word, answer.getOrDefault(word, 0) + 1);
        }
        
        return Collections.max(answer.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}