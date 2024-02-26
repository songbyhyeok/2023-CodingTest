class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int[] lArr = new int[nums.length];
        int[] rArr = new int[nums.length];
        int l = 0;
        int r = nums.length - 1;

        lArr[l++] = 1;
        rArr[r--] = 1;

        while(l < nums.length || r > -1) {
            lArr[l] = lArr[l - 1] * nums[l - 1];
            ++l;

            rArr[r] = rArr[r + 1] * nums[r + 1];
            --r;
        }

        for(int i = 0; i < nums.length; i++) {
            answer[i] = lArr[i] * rArr[i];
        }
        
        return answer;
    }
}