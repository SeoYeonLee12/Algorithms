package dp.dp1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N15990 {
    private static long[][] dp;
    private static int mod= 1000000009;

    private static void add(){
        for(int i=4; i<=100000; i++){
            dp[i][1]= (dp[i-1][2]+dp[i-1][3])%mod;
            dp[i][2]= (dp[i-2][1]+dp[i-2][3])%mod;
            dp[i][3]= (dp[i-3][2]+dp[i-3][1])%mod;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dp = new long[100001][4];
        dp[1][1]=dp[2][2]=dp[3][1]=dp[3][2]=dp[3][3]=1;
        add();

        int T= Integer.parseInt(br.readLine());
        int number=0;
        for(int i = 0; i < T; i++){
            number = Integer.parseInt(br.readLine());
            long remainder= (dp[number][1]+ dp[number][2]+ dp[number][3])%mod;
            bw.write(remainder+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
