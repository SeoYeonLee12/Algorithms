package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N14888 {
    // 클래스 필드
    static int N;
    static int[] operand;
    static int[] operator = new int[4];
    static int min= Integer.MAX_VALUE;
    static int max= Integer.MIN_VALUE;

    // num은 연산된 결과 idx는 숫자들의 인덱스
    public static void findNumber(int num, int idx){
        if(idx == N){
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for(int i = 0; i<operator.length; i++){
            if(operator[i] > 0){
                operator[i]--;

                switch (i){
                    case 0:
                        findNumber(num+operand[idx], idx+1);
                        break;
                    case 1:
                        findNumber(num-operand[idx], idx+1);
                        break;
                    case 2:
                        findNumber(num*operand[idx], idx+1);
                        break;
                    case 3:
                        findNumber(num/operand[idx], idx+1);
                        break;
                }
                // 연산자 수 복귀
                operator[i]++;
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 초기화 반드시 필요
        operand = new int[N];
        for (int i = 0; i<N; i++){
            operand[i] = Integer.parseInt(st.nextToken());
        }
        st= new StringTokenizer(br.readLine());
        for(int j = 0; j<4; j++) {
            operator[j] = Integer.parseInt(st.nextToken());
        }

        findNumber(operand[0], 1);
        bw.write(String.valueOf(max));
        bw.newLine();
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
        br.close();

    }
}
