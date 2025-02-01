package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N15486 {
    static int[] price;
    static int[] time;
    static int[] dp;

    public static int findMax(int N) {
        for (int i = 1; i <= N; i++) {
            // 현재까지의 최대 이익을 갱신
            dp[i] = Math.max(dp[i], dp[i - 1]);

            // 상당끝
            int nextDay = i + time[i];
            if (nextDay <= N + 1) {
                dp[nextDay] = Math.max(dp[nextDay], dp[i] + price[i]);
            }
        }

        // 마지막 날까지의 최대 이익을 갱신
        dp[N + 1] = Math.max(dp[N + 1], dp[N]);
        return dp[N+1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        price = new int[N + 2];
        time = new int[N + 2];
        dp = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(findMax(N) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}