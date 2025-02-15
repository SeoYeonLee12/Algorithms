package math1;

// 24 18

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 1 2 3 4 6 8 12 24
 * 1 2 3 6 9 18
 * <p>
 * 24 48 72 96
 * 18 36 54 72
 */
public class N2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        int gcd = getGCD(num1, num2);

        //최대공약수 출력
        bw.write(gcd + "");
        bw.newLine();
        //최소공배수 출력
        bw.write(((num1 * num2) / gcd) + "");

        bw.flush();
        bw.close();
        br.close();
    }

    public static int getGCD(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return getGCD(b, a % b);
        }
    }
}
