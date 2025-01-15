package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N2578 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 철수 빙고판
        int bingoBoard[][] = new int[5][5];
        // 사회자가 부르는 수
        int counterNum=0;

        for(int i = 0; i<5 ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<5 ; j++){
                bingoBoard[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int bingoNum = Integer.parseInt(st.nextToken());
                counterNum++;

                // 빙고판 숫자 0으로 변경
                for (int x = 0; x < 5; x++) {
                    for (int y = 0; y < 5; y++) {
                        if (bingoBoard[x][y] == bingoNum) {
                            bingoBoard[x][y] = 0;
                        }
                    }
                }
                // 빙고 수 저장
                int bingoCount= 0;

                // 행
                for (int x = 0; x < 5; x++) {
                    boolean allZero = true;
                    for (int y = 0; y < 5; y++) {
                        if (bingoBoard[x][y] != 0) {
                            allZero = false;
                            break;
                        }
                    }
                    if (allZero) bingoCount++;
                }
                // 열
                for (int y = 0; y < 5; y++) {
                    boolean allZero = true;
                    for (int x = 0; x < 5; x++) {
                        if (bingoBoard[x][y] != 0) {
                            allZero = false;
                            break;
                        }
                    }
                    if (allZero) bingoCount++;
                }

                // 대각선 검사
                boolean diagonal1 = true; // 왼쪽 위 오른쪽 아래
                boolean diagonal2 = true; // 오른쪽 위 왼쪽 아래
                for (int x = 0; x < 5; x++) {
                    if (bingoBoard[x][x] != 0) diagonal1 = false;
                    if (bingoBoard[x][4 - x] != 0) diagonal2 = false;
                }
                if (diagonal1) bingoCount++;
                if (diagonal2) bingoCount++;

                // 빙고가 3줄 이상이면 결과 출력
                if (bingoCount >= 3) {
                    bw.write(String.valueOf(counterNum));
                    bw.flush();
                    bw.close();
                    br.close();
                    return;
                }

            }
        }
    }
}
/**
 * 11 12 2 24 10
 * 16 1 13 3 25
 * 6 20 5 21 17
 * 19 4 8 14 9
 * 22 15 7 23 18
 * 5 10 7 16 2
 * 4 22 8 17 13
 * 3 18 1 6 25
 * 12 19 23 14 21
 * 11 24 9 20 15
 */
