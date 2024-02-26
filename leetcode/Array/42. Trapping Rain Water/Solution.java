import java.util.Arrays;
import java.util.Stack;

class Solution {
    // Bruteforce 1
    public int trap(int[] height) {
        int answer = 0;
        
        for(int i = 1; i < height.length; i++) {
            final int currH = height[i];
            int leftMax = height[0];
            int rightMax = height[height.length - 1];    
            
            for(int j = 1; j <= i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }

            for(int k = height.length - 2; k >= i; k--) {
                rightMax = Math.max(rightMax, height[k]);
            }

            final int minH = Math.min(leftMax, rightMax);
            final int water = minH - currH;
            answer += water;
        }   

        return answer;     
    }

    // Bruteforce 2
    public int trap2(int[] height) {
        int answer = 0;
        int lMaxH[] = new int[height.length];
        int rMaxH[] = new int[height.length];

        lMaxH[0] = height[0];
        rMaxH[height.length - 1] = height[height.length - 1];

        for(int i = 1; i < height.length; i++) {
            lMaxH[i] = Math.max(lMaxH[i - 1], height[i]);
        }

        for(int i = height.length - 2; i >= 0; i--) {
            rMaxH[i] = Math.max(rMaxH[i + 1], height[i]);
        }

        for(int i = 0; i < height.length; i++) {
            final int minH = Math.min(lMaxH[i], rMaxH[i]);
            answer += minH - height[i];
        }

        return answer;
    }

    // Prefix Sum
    public int trap3(int[] height) {
        int answer = 0;
        int lMaxArr[] = new int[height.length];
        int rMaxArr[] = new int[height.length];

        lMaxArr[0] = height[0];
        for(int i = 1; i < height.length; i++) {
            lMaxArr[i] = Math.max(height[i], lMaxArr[i - 1]);
        }

        rMaxArr[height.length - 1] = height[height.length - 1];
        for(int i = height.length - 2; i >= 0; i--) {
            rMaxArr[i] = Math.max(height[i], rMaxArr[i + 1]);
        }

        for(int i = 0; i < height.length; i++) {
            final int waterVol = Math.min(lMaxArr[i], rMaxArr[i]) - height[i];
            answer += waterVol;
        }

        return answer;
    }

    // Stack
    public int trap4(int[] height) {
        Stack<Integer> s = new Stack<>();
        int answer = 0;

        for(int i = 0; i < height.length; i++) {
            final int currH = height[i];
            while(!s.isEmpty() && height[s.peek()] < currH) {
                final int ele = s.pop();
                if (s.isEmpty())
                    break;

                final int distance = i - s.peek() - 1;
                final int waterV = Math.min(height[s.peek()], currH) - height[ele];
                answer += waterV * distance;
            }

            s.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        new Solution().trap4(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}