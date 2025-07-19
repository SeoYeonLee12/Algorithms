import java.util.*;
import java.io.*;

public class N1475 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        int arr[] = new int[10];
        for (int i = 0; i < N.length(); i++) {
            arr[(N.charAt(i) - '0')] += 1;
        }

        int max = 0;
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            temp = (arr[6] + arr[9]);
            if (temp % 2 == 1) {
                temp /= 2;
                temp += 1;
                arr[6] = temp;
                arr[9] = temp;
            } else {
                temp /= 2;
                arr[6] = temp;
                arr[9] = temp;
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }
}

// 9와 6처리 어떻게? 절반으로 나누며 출력 근데 하나 이상 있을 땐? 절반으로 나눈 것에 + 그 다른 게 몇 개 있는 지 그 값을 더하면
// 됨 9999 이미 6과 9가 나와있다. 그러면 이건 통하지 않나? 6699면 6->2 9->2 4/2 66699 5/2 666699