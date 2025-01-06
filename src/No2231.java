import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2231 {

    // 생성자 구하는 함수
    public static int getConstructor(String N){
        int num = Integer.parseInt(N); // 부분합
        int sum=0;
        // constructor 찾기
        for(int constructor = 1 ; constructor < num ; constructor++){
            char [] chars = new char[0];
            sum=constructor;
            // 자리수 분할(0번째부터 constructor의 수만큼)
            for(int i = 0 ; i <= String.valueOf(constructor).length()-1 ; i++){
                chars = String.valueOf(constructor).toCharArray();
            }
            for(char ch : chars){
//                System.out.println(constructor+", "+ch);
                sum+=Integer.parseInt(String.valueOf(ch));
            }
            if(sum==num) {
                return constructor;
            }

        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        System.out.println(getConstructor(N));

    }
}