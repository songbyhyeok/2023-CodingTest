class Solution {
    public static int[] solution(int brown, int yellow) {
        // 두 격자를 합치면 카페트 면적이 나온다.
        final int area = brown + yellow;

        // 면적을 제곱근 시 거의 근접한 세로 길이가 나온다.
        int height = (int)Math.sqrt(area);
        int width = area / height;

        // 만에 하나 세로 길이가 가로 길이보다 긴 경우 바꾼다.
        if (width < height) {
            final int temp = width;
            width = height;
            height = temp;
        }

        // 추측으로 도출된 가로, 세로 길이로 카펫트를 만들었을 때
        // brown, yellow 개수가 맞아떨어지는지 확인하는 알고리즘        
        while(true) {
            final int derivedY = (width - 2) * (height - 2);
            final int derivedX = area - derivedY;
            if (derivedX == brown && derivedY == yellow)
                break;

            if (area % (++width) == 0) 
                height = area / width;
        }
        
        return new int[]{width, height};
    }
    
    public static void main(String[] args) {
        solution(10, 2);
        solution(8, 1);
        solution(24, 24);
        solution(16, 8);
        solution(18, 6);
    }
}