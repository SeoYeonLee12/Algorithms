package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N2579 {
    static int[] dp;
    static int[] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N= Integer.parseInt(br.readLine());
        dp = new int[N];
        score = new int[N];

        for(int i = 0; i < score.length; i++){
            score[i] = Integer.parseInt(br.readLine());
        }
        dp[0]= score[0];
        if (N > 1) {
            dp[1] = score[0] + score[1]; // 두 번째 계단
        }
        if (N > 2) {
            dp[2] = Math.max(score[0] + score[2], score[1] + score[2]); // 세 번째 계단
        }

        bw.write(findMaxScore(N-1)+"");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int findMaxScore(int N) {

        if (dp[N] == 0) {
            dp[N] = Math.max(findMaxScore(N - 2), findMaxScore(N - 3) + score[N - 1]) + score[N];
        }

        return dp[N];
    }
}
