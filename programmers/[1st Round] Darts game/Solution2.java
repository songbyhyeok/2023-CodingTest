import java.util.Stack;

class Solution {
    public static int solution(String dartResult) {
        Stack<Integer> s = new Stack<>();    
        int answer = 0;

        for(int i = 0; i < dartResult.length(); i++) {
            final char res = dartResult.charAt(i);
            if (Character.isDigit(res)) {
                int currScore = res - '0';
                if (currScore == 1 && dartResult.charAt(i + 1) == '0') {
                    currScore = 10;
                    ++i;
                }

                s.push(currScore);

                continue;
            } 

            int data = s.pop();
            switch(res) {
                case 'D':
                data = (int)Math.pow(data, 2);
                break;
                case 'T':
                data = (int)Math.pow(data, 3);
                break;

                case '*':
                data *= 2;
                if(!s.isEmpty())
                    s.push(s.pop() * 2);
                break;
                case '#':
                data *= -1;
                break;
            }

            s.push(data);
        }

        while(!s.isEmpty())
            answer += s.pop();

        return answer;
    }

    public static void main(String[] args) {
        solution("1S2D*3T");
        solution("1D2S#10S");
        solution("1D2S0T");
        solution("1S*2T*3S");
        solution("1D#2S*3S");
        solution("1T2D3D#");
        solution("1D2S3T*");
    }
}