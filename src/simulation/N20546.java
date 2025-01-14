package simulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class N20546 {
    // 준현이가 주식 사는 메소드
    public static int[] BNP(int money, int stockPrice){
        int stock = money / stockPrice;
        money = money - stock*stockPrice;
        return new int[] {stock, money};
    }

    //성민이가 주식 사는 메소드 (현금, 주가 3,2,1,당일)
    public static int[] TIMING(int money, int stock, int stockPrices[]){
        // 3일 연속 하락
        if(stockPrices[0]>stockPrices[1] && stockPrices[1]>stockPrices[2]){
            int buy = money / stockPrices[3];
            money -= buy * stockPrices[3];
            stock += buy;
        }
        // 3일 연속 상승
        else if(stockPrices[0]<stockPrices[1] && stockPrices[1]<stockPrices[2]){
            money += (stockPrices[3]*stock);
            stock = 0;
        }
        return new int[] {stock, money};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int money = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int stockPrice[] = new int[14];
        for(int i = 0; i<14 ; i++){
            stockPrice[i]= Integer.parseInt(st.nextToken());
        }

        //준현 돈 저장
        int bnp_money= money;
        int bnpStock = 0;
        // 성민 돈 저장
        int timing_money=money;
        int timingStock = 0;
        int four_stockPrice[] = new int[4];

        for(int i = 0; i<14 ; i++){
            int [] bnpResult = BNP(bnp_money, stockPrice[i]);
            bnpStock = bnpResult[0];
            bnp_money= bnpResult[1];

            if(i>=3){
                four_stockPrice[0] = stockPrice[i-3];
                four_stockPrice[1] = stockPrice[i-2];
                four_stockPrice[2] = stockPrice[i-1];
                four_stockPrice[3] = stockPrice[i];

                int timingResult[] = TIMING(timing_money, timingStock, four_stockPrice);
                timingStock = timingResult[0];
                timing_money= timingResult[1];
            }
        }

        // 14일 결과
        int bnpPrice = bnp_money+bnpStock*stockPrice[13];
        int timingPrice = timing_money+timingStock*stockPrice[13];

        if(bnpPrice<timingPrice){
            bw.write("TIMING");
        }
        else if (bnpPrice>timingPrice) {
            bw.write("BNP");
        }
        else {
            bw.write("SAMESAME");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
/**
 * 100
 * 10 20 23 34 55 30 22 19 12 45 23 44 34 38
 */