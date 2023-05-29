import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[] Inputs, Inputs2;
    static long[] Costs, Oils;
    static long TotalCost;
    static int N;

    public static void main(String[] args) throws Exception {
        // 입력
        N = Integer.parseInt(BR.readLine()) - 1;
        Inputs = BR.readLine().split(" ");
        Inputs2 = BR.readLine().split(" ");

        // 초기화
        Costs = new long[N];
        Oils = new long[N];
        for (int i = 0; i < N; i++) {
            Costs[i] = Integer.parseInt(Inputs[i]);
            Oils[i] = Integer.parseInt(Inputs2[i]);
        }

        long currOilPrice = Oils[0];
        for (int i = 0; i < N; i++) {
            TotalCost += currOilPrice * Costs[i];

            // 다음 도시 기름 값이 더 저렴하다면 변수 오일 값을 다음 도시 기름 값으로 변경
            if (i + 1 < N && Oils[i + 1] < currOilPrice)
                currOilPrice = Oils[i + 1];
        }

        BW.write(String.valueOf(TotalCost) + '\n');
        BW.flush();
        BW.close();
    }
}