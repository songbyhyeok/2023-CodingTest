import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = null;
        Map<String, String> ids = new HashMap<>();
        int uncountedCnt = 0;
        
        for(String r : record) {
            final String[] info = r.split(" ");
            final char cmdF = info[0].charAt(0);
            if (!(cmdF == 'L')) {
                ids.put(info[1], info[2]);
                
                if (cmdF == 'C') {
                    ++uncountedCnt;
                }
            }
        }
        
        answer = new String[record.length - uncountedCnt];
        int aIdx = -1;
        for(String r : record) {
            final String[] info = r.split(" ");
            final char cmdF = info[0].charAt(0);
            if (cmdF == 'C') {                
                continue;
            }
            
            answer[++aIdx] = ids.get(info[1]) + "님이 " + ((cmdF == 'E') ? "들어왔습니다." : "나갔습니다.");
        }
        
        return answer;
    }
}