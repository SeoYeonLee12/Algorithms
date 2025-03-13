package dp.dp1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N11727 {
    static long dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        dp = new long[n + 1];

        dp[0]=dp[1]=1;
        for (int i = 2; i <= n; i++) {
            dp[i]= (dp[i-1]+(2*dp[i-2]))%10007;
        }
        bw.write(dp[n] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
