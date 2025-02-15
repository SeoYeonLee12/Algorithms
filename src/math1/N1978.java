package math1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));

        int N= Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int prime=0;
        int count=0;

        for(int i=0;i<N;i++){
            prime= Integer.parseInt(st.nextToken());
            for(int j=2;j<=prime;j++){
                if(j == prime){
                    count++;
                }
                else if(prime % j == 0) {
                    break;
                }
            }
        }
        bw.write(count+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
