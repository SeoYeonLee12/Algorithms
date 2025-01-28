package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N2748 {
    static long[] dp;

    public static long findFibonacciNumber(int num) {
        if(dp[num]==0){
            dp[num]= findFibonacciNumber(num-2)+findFibonacciNumber(num-1);
        }
        return dp[num];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N= Integer.parseInt(br.readLine());
        dp = new long[N+1];
        // 초기화
        dp[0] = 0;
        dp[1] = 1;
        if(N>=2) {
            dp[2] = dp[0] + dp[1];
        }
         bw.write(findFibonacciNumber(N)+"");
         bw.flush();
         bw.close();
         br.close();
    }
}
