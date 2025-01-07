import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2309 {

    // 정렬 함수
    public static int[] sort(int[] intArr) {
        for (int i = 0; i <= intArr.length - 2; i++) {
            for (int j = 1 ; j < intArr.length-i  ; j++) {
                if (intArr[j] < intArr[j-1]) {
                    int temp = intArr[j];
                    intArr[j] = intArr[j-1];
                    intArr[j-1] = temp;
                }
            }
        }
        return intArr;
    }

    // 난쟁이 찾는 함수
    public static void findDwarf(int[] height) {
        int sum = 0;
        int a = 0;
        int b = 0;
        for (int i = 0; i <= height.length - 1; i++) {
            sum+=height[i];
        }
        for (int i = 0; i < height.length - 1; i++) {
            for(int j=i+1; j < height.length ; j++){
                if (sum - height[i] - height[j] == 100) {
                    a=i;
                    b=j;
                    break;
                }
            }
        }
        for(int k=0;k<height.length;k++) {
            if(k!=a && k!=b) {
                System.out.println(height[k]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int [] heights = new int[9];
        for (int i = 0 ; i<9 ; i++){
            heights[i]= Integer.parseInt(br.readLine());
        }
        br.close();
        findDwarf(sort(heights));

    }
}