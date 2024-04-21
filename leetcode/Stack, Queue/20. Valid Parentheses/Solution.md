# 유효한 괄호 - <a href="https://leetcode.com/problems/valid-parentheses/" target="_blank">20. Valid Parentheses</a>

입력된 괄호들이 같은 유형의 쌍으로 구성되어 있는지 판별.

**Hash와 Stack을 활용한 풀이**  
**stack**  
올바른 한 쌍의 괄호인지 판별하는 문제들은 Stack을 활용하면 적절하다.  
ex input s = "(( ))" 가 주어졌을 때 stack에 순차적으로 삽입 후 그 다음 값과 비교하기 위해 출력을 반복하며 LIFO 특성을 잘 활용한다면 손쉽게 풀 수 있기 때문이다. 그러니까 1.( -> 2.( 가 닫는 괄호인가? 아니라면 또 삽입 3.) 는 닫는 괄호니까 2.(와 같은 유형이면서 한 쌍인가 검사, 이를 입력값이 끝날 때까지 반복  
**hash**  
키 구성을 역괄호로 두어 stack에 저장된 값을 꺼낼 때 한 쌍인지
검사한다면 두 자료구조를 잘 활용할 수 있다.


```java
// LIFO를 활용한 괄호 일치 여부 판별
class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> table = new HashMap<>() {{
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }};
        Deque<Character> stack = new ArrayDeque<>();
        
        for(var c : s.toCharArray()) {
          // 닫힌 괄호가 아니라면
            if (!table.containsKey(c)) {
                stack.push(c);
                // 스택이 비었을 경우
                // 1. s의 사이즈가 1인데, 닫힌 괄호
                // 테이블과 스택을 비교하는 행위는 한 쌍인지 검사하는 것
            } else if (stack.isEmpty() || table.get(c) != stack.pop()){
                return false;
            }
        }

        // 비었는지 검사 이유는 열린 괄호만 구성된 입력 값일 수 있기 때문
        // ex "(("
        return stack.isEmpty();
    }
}
```