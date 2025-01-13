package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N1547 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        int ballPosition = 1;

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            /**
             * 공의 위치와 바꾼 컵 중 하나가 같은 경우 위치 변경
             *
             * 지금 공이 들어있던 위치가 1일 때, x와 공의 위치가 같으면, y로 바뀔 것이므로 ball position을 갱신한다.
             */
            if(ballPosition==x){
                ballPosition=y;
            }
            else if(ballPosition==y){
                ballPosition=x;
            }

        }

        bw.write(String.valueOf(ballPosition));
        bw.flush();
        bw.close();
        br.close();
    }
}

/**
 * 4
 * 3 1
 * 2 3
 * 3 1
 * 3 2
 *
 * 2
 * 1 2
 * 3 1
 *
 * 5
 * 2 3
 * 1 3
 * 2 3
 * 2 1
 * 3 1
 */
