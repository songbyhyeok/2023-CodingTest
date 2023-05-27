import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collection;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int Customers[];
    static int N;
    static int Sum, Total;

    public static void main(String[] args) throws Exception {
        // 입력
        N = Integer.parseInt(br.readLine());
        String inputs[] = br.readLine().split(" ");

        // 초기화
        Customers = new int[N];
        for(int i = 0; i < N; i++) 
            Customers[i] = Integer.parseInt(inputs[i]);
        
        // 오름차순 정렬
        Arrays.sort(Customers);

        for(int i = 0; i < Customers.length; i++) {
            Sum += Customers[i]; // 1, 3, 6, 9, 13
            Total += Sum; // 1, 4, 10, 19, 32
        }
        
        bw.write(String.valueOf(Total) + '\n');
        bw.flush();
        bw.close();
    }
}