package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N14501 {
    public static int findMaxValue(int N, int plan[][]) {
        // 최대 수익을 저장
        int[] maxValue = new int[N + 2];

        // 역순으로 반복문을 순회 (마지막 날부터 시작)
        for (int i = N; i > 0; i--) {
            // 다음날의 최대 수익을 현재 날로 전달
            maxValue[i] = Math.max(maxValue[i], maxValue[i + 1]);

            // 상담 진행 가능한 경우 최대 수익 갱신
            if (i + plan[i][0] <= N + 1) {
                maxValue[i] = Math.max(maxValue[i], maxValue[i + plan[i][0]] + plan[i][1]);
            }
        }
        return maxValue[1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int plan[][] = new int[N+1][2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            plan[i][0] = Integer.parseInt(st.nextToken());
            plan[i][1] = Integer.parseInt(st.nextToken());
        }

        bw.write(String.valueOf(findMaxValue(N, plan)));
        bw.flush();
        bw.close();
        br.close();
    }
}
