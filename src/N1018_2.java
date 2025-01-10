import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N1018_2 {
    public static int searchMin(boolean[][] input, int x, int y) {

        int count=0;
        // 탐색 시작 색
        boolean startColor = input[x][y];

        // 시작 점부터 x+7까지
        for(int i = x ; i <x+8 ;i++){
            for(int j = y ; j <y+8 ;j++){
                if(input[i][j] != startColor){
                    count++;
                }
                // 다음 칸은 다른 색
                startColor= (!startColor);
            }
            // 다음행이 아니라 이 다음부터 탐색하는 값은 다시 원래로 바꾸는 과정인 거 같음.
            startColor= (!startColor);
        }

        return Math.min(count, 64 - count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        boolean [][] input = new boolean[N][M];

        for(int i=0; i<N; i++){
            String color = br.readLine();
            for(int j=0; j<M; j++){
                if(color.charAt(j)=='B'){
                    input[i][j]=false;
                }
                else{
                    input[i][j]=true;
                }
            }
        }
        br.close();

        int min = 64; //(8*8)

        // 모든 8*8 체스판 탐색
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                min = Math.min(min, searchMin(input, i, j));
            }
        }
        bw.write(String.valueOf(min));
        bw.flush();
        br.close();
        bw.close();
    }
}

/**
 * WBWBWBWB
 * BWBWBWBW
 * WBWBWBWB
 * BWBBBWBW
 * WBWBWBWB
 * BWBWBWBW
 * WBWBWBWB
 * BWBWBWBW
 */
