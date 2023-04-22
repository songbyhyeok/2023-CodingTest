class Solution {
    public static String solution(String new_id) {
        // 1단계
        StringBuilder sb = 
            new StringBuilder(new_id.toLowerCase().toString());
  
        // 2단계
        for(int i = 0; i < sb.length(); i++){
            final char ch = sb.charAt(i);            
            if (Character.isLowerCase(ch) || 
                Character.isDigit(ch) ||
                ch == '-' ||
                ch == '_' ||
                ch == '.')
                continue;

                sb.deleteCharAt(i);
                --i;
        }
   
        // 3단계
        for(int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '.') {
                while(i + 1 < sb.length() && sb.charAt(i + 1) == '.')
                    sb.deleteCharAt(i + 1);
            }                                   
        }

        // 4단계
        if (sb.charAt(0) == '.')
            sb.deleteCharAt(0);

        if (sb.length() != 0 && 
            sb.charAt(sb.length() - 1) == '.')
            sb.deleteCharAt(sb.length() - 1);

        // 5단계
        if (sb.length() == 0)
            sb.append('a');

        // 6단계
        if (16 <= sb.length()) {
            sb.delete(15, sb.length());

            // 제거 후 마지막 위치에 '.'가 있다면 제거
            if (sb.charAt(sb.length() - 1) == '.')
                sb.deleteCharAt(sb.length() - 1);
        }

        // 7단계
        if (sb.length() < 3) {
            final char lastCh = sb.charAt(sb.length() - 1);
            while(sb.length() < 3)
                sb.append(lastCh);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(solution("z-+.^."));
        System.out.println(solution("=.="));
        System.out.println(solution("123_.def"));
        System.out.println(solution("abcdefghijklmn.p"));
    }
}