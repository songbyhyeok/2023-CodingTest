import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    // brute force
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        final int numsLen = nums.length;

        Arrays.sort(nums);

        for(int i = 0; i < numsLen - 2; i++) {
            final int fN = nums[i];
            if (i > 0 && nums[i - 1] == fN) {
                continue;
            }

            for(int j = i + 1; j < numsLen - 1; j++) {
                final int sN = nums[j];
                if (j > i + 1 && nums[j - 1] == sN) {
                    continue;
                }

                for(int k = j + 1; k < numsLen; k++) {
                    final int tN = nums[k];
                    if (k > j + 1 && nums[k - 1] == tN) {
                        continue;
                    }

                    final int sum = fN + sN + tN;
                    if (sum == 0) {
                        answer.add(Arrays.asList(fN, sN, tN));
                    }
                }
            }
        }

        return answer;
    }

    // twoPointer
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        
        Arrays.sort(nums);
 
        for(int i = 0; i < nums.length; i++) {
            final int fn = nums[i];
            if (i > 0 && nums[i - 1] == fn) {
                 continue;
            }
 
            int s = i + 1;
            int e = nums.length - 1;
            while(s < e) {
                final int sum = fn + nums[s] + nums[e];
                if (sum < 0) {
                    ++s;
                } else if (sum > 0) {
                    --e;
                } else {
                    answer.add(Arrays.asList(fn, nums[s], nums[e]));
 
                     while(s < e && nums[s] == nums[s + 1]) {
                         ++s;
                     }
                     while(s < e && nums[e] == nums[e - 1]) {
                         --e;
                     }
 
                    ++s;
                    --e;
                }
            }
        }
 
        return answer;
     }

    public static void main(String[] args) {
        // List<List<Integer>> answer = new Solution().threeSum1(new
        // int[]{-1,0,1,2,-1,-4});
        // answer = new Solution().threeSum1(new int[]{0, 1, 1});
        // answer = new Solution().threeSum1(new int[]{0, 0, 0});

        List<List<Integer>> answer = new Solution().threeSum2(new int[] { -1, 0, 1, 2, -1, -4 });
        answer = new Solution().threeSum2(new int[] { 0, 1, 1 });
        answer = new Solution().threeSum2(new int[] { 0, 0, 0 });
    }
}