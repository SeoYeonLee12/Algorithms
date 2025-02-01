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
        for (int i = 0; i < N; i++) {
            // 현재까지의 최대 수익을 갱신
            if (i > 0) {
                dp[i] = Math.max(dp[i], dp[i - 1]);
            }

            // 상담이 끝나는 날짜 계산
            int day = i + time[i];

            // 상담이 유효한 경우 dp[day] 갱신
            if (day <= N) {
                dp[day] = Math.max(dp[day], dp[i] + price[i]);
            }
        }

        // 마지막 날까지 최대 수익 갱신
        return Math.max(dp[N - 1], dp[N]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        price = new int[N];
        time = new int[N];
        dp = new int[N + 1]; // 0-based로 계산하므로 N+1 크기

        for (int i = 0; i < N; i++) {
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