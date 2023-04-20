class Solution {
    public static int solution(String dartResult) {
        int scores[] = new int[4];        
        int scoresIdx = 0;
        int currScore = 0;
        int answer = 0;

        for(int i = 0; i < dartResult.length(); i++) {
            final char res = dartResult.charAt(i);
            if (Character.isDigit(res)) {
                currScore = res - '0';
                if (currScore == 1 && dartResult.charAt(i + 1) == '0') {
                    currScore = 10;
                    ++i;
                }

                ++scoresIdx;
                scores[scoresIdx] = 1;
                
                continue;
            }

            switch(res) {
                case 'S':
                scores[scoresIdx] *= Math.pow(currScore, 1);
                break;
                case 'D':
                scores[scoresIdx] *= Math.pow(currScore, 2);
                break;
                case 'T':
                scores[scoresIdx] *= Math.pow(currScore, 3);
                break;

                case '*':
                scores[scoresIdx] *= 2;
                if (scoresIdx != 1)
                    scores[scoresIdx - 1] *= 2;
                break;
                case '#':
                scores[scoresIdx] *= -1;
                break;
            }
        }

        for(int i = 1; i < scores.length; i++)
            answer += scores[i];

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