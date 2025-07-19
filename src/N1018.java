import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N1018 {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        char [][] board = new char[N][M];

        for(int i=0; i<N; i++){
            String color = br.readLine();
            for(int j=0; j<M; j++){
                board[i][j]= color.charAt(j);
            }
        }

        int count=0;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                // i: 1~N-2 j: 1~M-2
                if((i>=1 && i<=N-2) && (j>=1 && j<=M-2)) {
                    if (board[i][j] == board[i + 1][j] || board[i][j] == board[i - 1][j] ||
                            board[i][j] == board[i][j - 1] || board[i][j] == board[i][j + 1]) {
                        count++;
                    }
                }
                // 가장 윗 줄 가운데
                else if(i==0 && j>=1 && j<=M-2){
                    if (board[i][j] == board[i+1][j] || board[i][j] == board[i][j + 1] || board[i][j] == board[i][j - 1]) {
                        count++;
                    }
                }
                //가장 왼쪽 줄 가운데
                else if(j==0 && i>=1 && i<=N-2){
                    if(board[i][j] == board[i][j+1] || board[i][j] == board[i+1][j] || board[i][j] == board[i-1][j]){
                        count++;
                    }
                }
                // 가장 오른쪽 줄 가운데
                else if(j==M-1 && i>=1 && i<=N-2){
                    if(board[i][j] == board[i][j-1] || board[i][j] == board[i+1][j] || board[i][j] == board[i-1][j]){
                        count++;
                    }
                }
                // 가장 아랫줄 가운데
                else if (i == N-1 &&  j>=1 && j<=M-2) {
                    if(board[i][j] == board[i][j-1] || board[i][j] == board[i-1][j] || board[i][j] == board[i][j+1]){
                        count++;
                    }
                }
                // 양쪽 모서리
                else{
                    // 위-왼
                    if((i==0 && j==0)) {
                        if (board[i][j] == board[i + 1][j] || board[i][j] == board[i][j + 1]) {
                            count++;
                        }
                    }
                    // 아래-왼
                    else if ((i==N-1 && j==0)) {
                        if (!(board[i][j] == board[i][j + 1] && board[i][j] == board[i - 1][j])) {
                            count++;
                        }
                    }
                    // 아래 오
                    else if (i==N-1 && j==M-1) {
                        if (board[i][j] == board[i-1][j] || board[i][j] == board[i][j-1]) {
                            count++;
                        }
                    }
                    // 위-오
                    else{
                        count++;
                    }
                }
            }
        }
        System.out.println(count);


    }
}
/**
 * 8 8
 WBWBWBWB
 BWBWBWBW
 WBWBWBWB
 BWBBBWBW
 WBWBWBWB
 BWBWBWBW
 WBWBWBWB
 BWBWBWBW
 */