import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class N14717_2 {
    public static void main(String[] args) throws IOException {
        DecimalFormat df = new DecimalFormat("0.000");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st= new StringTokenizer(br.readLine());
        br.close();
        int [] cards = new int[2];
        int a = 0;
        int b = 0;

        for(int i = 0 ; i<2 ; i++){
            cards[i] = Integer.parseInt(st.nextToken());
            a= cards[0];
            b= cards[1];
        }
        int one=(a+b)%10;

        int count= 0;
        // 18개 중 2개
        int pickAll= 153;
        if(a==b){
            count = pickAll-(10-a);
            bw.write(df.format(count /(pickAll*1.0)));
            bw.flush();
        }
        else{
            for(int i= 1; i<=10; i++){
                for(int j= i+1; j<=10; j++){
                    int sum = i+j;
                    // 내가 이길 확률
                    if(sum % 10 < one){
                        if(i==a || i==b || j==a || j==b){
                            count+=2;
                        }
                        else {
                            count+=4;
                        }
                    }
                }
            }
            bw.write(df.format(count/(pickAll*1.0)));
            bw.flush();
            bw.close();
        }
    }
}
