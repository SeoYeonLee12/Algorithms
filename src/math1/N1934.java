package math1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int a;
        int b;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            int gcd = getGDC(a, b);
            bw.write((a * b) / gcd + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static int getGDC(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return getGDC(b, a % b);
        }
    }
}
