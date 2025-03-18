package dp.dp1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N9095 {

    static int[] dp;

    private static void add() {
        for(int i = 3; i<=dp.length-1; i++){
            dp[i]= dp[i-1]+dp[i-2]+dp[i-3];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dp = new int[11];
        dp[0] = dp[1] = 1;
        dp[2]= 2;
        add();
        int number = 0;

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            number = Integer.parseInt(br.readLine());
            bw.write(dp[number] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
