// 백준전용...
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
   public static void main(String[] args) throws Exception {
      Stack<Integer> stack = new Stack();
      int cnt = 0;
      int n, k;

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      // 입력
      String[] input = br.readLine().split(" ");
      n = Integer.parseInt(input[0]);
      k = Integer.parseInt(input[1]);

      // n개의 동전 가치 입력
      for(int i = 0; i < n; i++) 
         stack.push(Integer.parseInt(br.readLine()));

      // k가 거스름돈으로 모두 걸러질 때까지
      while(0 < k) {
         // 스택에 가장 마지막 동전이 나온다.
         final int coin = stack.peek();

         // 동전이 현재 돈보다 크다면 거슬러줄 수 없기 때문에 그 다음 가치가 낮은 동전으로 바꾼다.
         if (k < coin) {
            stack.pop();
            continue;
         }
         
         k -= coin;
         ++cnt;
      }

      bw.write(String.valueOf(cnt) + '\n');
      bw.flush();
      bw.close();
   }
}