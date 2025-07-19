import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class N14717 {
    // 족보 배열로 저장하는 함수
    public static int[] getPedigree(){
        int [] pedigree = new int [20];
        for(int i =9; i>=0; i--){
            pedigree[9-i]= (i*2)+2;
        }
        for(int j =9; j>=0; j--){
            pedigree[(10-j-2)+11]= j;
        }
        return pedigree;
    }

    // 족보 계산 함수
    public static int find_MyPedigree(int[] cards, int[] pedigree) {
        int ddangIndex = -1; // 땡 족보의 인덱스
        int kkeusIndex = -1; // 끗 족보의 인덱스

        // 땡 족보
        if (cards[0] == cards[1]) {
            int ddang = cards[0] * 2;
            for (int p = 0; p < pedigree.length; p++) {
                if (pedigree[p] == ddang) {
                    ddangIndex = p;
                }
            }
            return ddangIndex;
        }
        // 끗 족보 계산
        else {
            int kkeus = (cards[0] + cards[1]) % 10;
            for (int p = 0; p < pedigree.length; p++) {
                if (pedigree[p] == kkeus) {
                    kkeusIndex = p;
                }
            }
            return kkeusIndex;
        }
    }

    // 영학이 뽑은 카드 제외한 카드 반환 함수
    public static int[] cardDeque(int[] yCards){
        int [] cards= new int[18];

        for(int i = 0; i<10 ; i++){
            if(yCards[0]!=(i+1) && yCards[1]!=(i+1)){
                cards[i]= i+1;
            }
        }
        for(int j = 0; j<10; j++){
            cards[j+8] = j+1;
        }
        return cards;
    }

    // 비교하고 확률 구하는 함수
    public static double findAnswer(int yPedigree, int[]cards, int[] pedigree){
        int cases= 153; // 2개의 카드를 뽑을 확률
        int winCount=0;
        DecimalFormat df = new DecimalFormat("0.000");

        int [] otherCards=new int[2];
        int otherPedigree=0;
        for(int i = 0 ; i<cards.length; i++){
            for(int j = i+1; j<cards.length; j++){
                otherCards[0]= cards[i];
                otherCards[1]= cards[j];
                otherPedigree= find_MyPedigree(otherCards, pedigree);
            }
            if(otherPedigree>=yPedigree){
                winCount++;
            }
        }
        return Double.parseDouble(df.format(winCount/ (double)cases));

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] yCards = new int[2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i<yCards.length ; i++){
            yCards[i] = Integer.parseInt(st.nextToken()); // 나누어진 문자열을 문자열 변수에 저장
        }

        int[] pedigree = getPedigree();
        int yPedigree = find_MyPedigree(yCards, pedigree);
        int[] cards = cardDeque(yCards);
        System.out.println(findAnswer(yPedigree, cards, pedigree));

    }
}
