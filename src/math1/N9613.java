package math1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N9613 {
    static int[] intArr;
    static int sum=0;
    public static int getGCD(int a, int b) {
        if(a % b == 0){
            return b;
        }
        else{
            return getGCD(b, a % b);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스 수
        int N= Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int inputNum = Integer.parseInt(st.nextToken());
            intArr = new int[inputNum+1];
            for(int j=0; j < intArr.length; j++){
                intArr[j] = Integer.parseInt(st.nextToken());
            }
            for(int k=1; k <= intArr.length; k++){
                sum+=getGCD(intArr[k-1],intArr[k]);
                bw.write(sum+"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
/**
 * 3
 * 4 10 20 30 40
 * 3 7 5 12
 * 3 125 15 25
 *
 * 70
 * 3
 * 35
 */