import java.util.Stack;

public class Solution {
    public static String solution(String p) {
        // 1. 빈 문자열인 경우 반환
        if (p.isEmpty())
            return "";

        // 2. u, v 알고리즘에 필요 변수들
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        Stack<Character> s = new Stack<>();
        int i;
        final char firstBracket = p.charAt(0);
        boolean flag = firstBracket == '(' ? true : false;

        // 2. u, v 분리 알고리즘
        for (i = 0; i < p.length(); i++) {
            final char next = p.charAt(i);
            u.append(next);

            // 첫 괄호와 같다면 짝이 아니기 때문에 계속 삽입한다.
            if (next == firstBracket)
                s.push(next);
            // 짝 괄호이기 때문에 이전 삽입 괄호를 삭제한다.
            else {
                s.pop();
                // 스택에 들어있는 괄호가 첫 번째 괄호였다면 하나의 괄호 집합이 끝난 것
                if (s.isEmpty())
                    break;
            }
        }

        // 2. 나머지 괄호들을 v에 옮긴다.
        for (i = i + 1; i < p.length(); i++)
            v.append(p.charAt(i));

        // 3. 올바른 괄호 문자열에 해당하므로 v에 대해 u, v 분리 알고리즘 재수행
        if (flag)
            // 3-1. 수행 결과를 u에 이어 붙인 후 반환
            return u.toString() + solution(v.toString());

        // 4. 문자열 u가 올바른 괄호 문자열이 아니기 때문에 문제가 요구한 알고리즘 수행
        
        // 4-1 빈 문자열에 첫 번째 '('를 붙인다.
        // 4-2 문자열 v에 대해 1단계부터 재귀적 수행 결과 문자열을 answer에 이어 붙인다.
        // 4-3 ')'f를 다시 붙인다.
        StringBuilder answer = new StringBuilder('(' + solution(v.toString()) + ')');

        // 4-4 u idx start, end 제외하고 나머지 역괄호로 붙이기
        for (int j = 1; j < u.length() - 1; j++)
            answer.append(u.charAt(j) == '(' ? ')' : '(');

        // 4-5 조합된 문자열 answer 반환
        return answer.toString();
    }

    public static void main(String[] args) throws Exception {
        solution("(()())()");
        solution(")(");
        solution("()))((())(");
    }
}