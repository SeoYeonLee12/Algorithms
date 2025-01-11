import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N1051 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int input[][] = new int[N][M];

        // 입력 값 저장
        for(int i = 0; i<N; i++) {
            String num= br.readLine();
            for(int j = 0; j<M; j++) {
                input[i][j] = Integer.parseInt(String.valueOf(num.charAt(j)));
            }
        }

        int size = Math.min(N, M);
        while (size>1) {
            for (int i = 0; i <= N - size; i++) {
                for (int j = 0; j <= M - size; j++) {
                    // 시작값
                    int startPoint = input[i][j];
                    // 사각형 시작 값과 다른 모서리 세 값 비교
                    if (input[i][j + (size - 1)] == startPoint && input[i + (size - 1)][j] == startPoint &&
                            input[i + size - 1][j + (size - 1)] == startPoint) {
                        bw.write(String.valueOf(size*size));
                        bw.flush();
                        bw.close();
                        br.close();
                        return;
                    }
                }
            }
            size--;
        }
        bw.write(String.valueOf(size*size));
        bw.flush();
        bw.close();
        br.close();
    }
}

/**
 * 3 5
 * 42101
 * 22100
 * 22101
 */