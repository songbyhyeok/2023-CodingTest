class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int dC = 0, pC = 0;
        
        for(int i = n - 1; i >= 0; i--) {
            dC += deliveries[i];
            pC += pickups[i];
            while(0 < dC || 0 < pC) {
                dC -= cap;
                pC -= cap;
                answer += (i + 1) * 2;
            }
        }
        
        return answer;
    }
}