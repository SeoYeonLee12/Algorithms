package math1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1929 {
    public static boolean isPrime[];

    public static void getPrime(){
        isPrime[0]=true;
        isPrime[1]=true;

        for(int i=2;i<Math.sqrt(isPrime.length);i++){
            if(isPrime[i]){
              continue;
            }
            for(int j=i*i;j<isPrime.length;j+=i){
                isPrime[j]=true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        isPrime= new boolean[N+1];
        getPrime();
        for (int i = M; i <= N; i++) {
            if(!isPrime[i]){
                bw.write(i+"");
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
        bf.close();
    }
}
