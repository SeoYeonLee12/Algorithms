import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10448{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int [] Ks = new int[T];

        for (int i = 0; i < T; i++) {
            Ks[i]= Integer.parseInt(br.readLine());
        }
        for (int k : Ks){
            System.out.println(getTriangular_Number(limit(),k));
        }
    }

    public static int[] limit(){
        int [] number=new int[45];
        for (int n = 1; n <=45 ; n++) {
            int num = n*(n+1)/2;
            number[n-1] = num;
        }
        return number;
    }

    public static int getTriangular_Number(int[] number, int k) {
        int result;
        for (int i = 1 ; i<45 ; i++){
            for(int j = 1; j<45 ; j++){
                for(int c = 1; c<45 ; c++){
                    result = number[i-1]+number[j-1]+number[c-1];
                    if(result==k){
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}
