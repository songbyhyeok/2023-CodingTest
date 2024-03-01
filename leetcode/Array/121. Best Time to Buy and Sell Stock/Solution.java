class Solution {
    public int maxProfit(int[] prices) {
        int answer = 0;
        int min = prices[0];
        
        for(int i = 1; i < prices.length; i++) {
            final int val = prices[i];
            min = Math.min(min, val);
            answer = Math.max(answer, val - min);
        }

        return answer;
    }
}