import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int cash = Integer.parseInt(br.readLine());
        
        BNP bnp = new BNP(cash);
        TIMING timing = new TIMING(cash);
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for (int i = 0; i < 14; i++) {
            int price = Integer.parseInt(st.nextToken());
            bnp.updatePrice(price);
            timing.updatePrice(price);
        }
        
        int diff = bnp.getTotal() - timing.getTotal();
        
        if (diff == 0) System.out.print("SAMESAME");
        else if (diff > 0) System.out.print("BNP");
        else System.out.print("TIMING");
    }
    
    static class BNP {
        private int cash;
        private int stock;
        private int price;
        private boolean signal;
        
        BNP(int cash) {
            this.cash = cash;
        }
        
        void updatePrice(int price) {
            this.price = price;
            judge();
            if (signal) buy();
        }
        
        private void judge() {
            if (cash >= price) signal = true;
            else signal = false;
        }
        
        private void buy() {
            stock += cash / price;
            cash = cash % price;
        }
        
        int getTotal() {
            return cash + price * stock;
        }
    }
    
    static class TIMING {
        private int cash;
        private int stock;
        private int price;
        private byte increase;
        private byte decrease;
        private Sign signal = Sign.STAY;
        
        TIMING(int cash) {
            this.cash = cash;
        }
        
        void updatePrice(int price) {
            if (this.price < price) {
                decrease = 0;
                increase++;
            } else if (this.price > price) {
                decrease++;
                increase = 0;
            }
            this.price = price;
            
            judge();
            
            switch (signal) {
                case BUY :
                    buy();
                    break;
                    
                case SELL :
                    sell();
                    break;
                    
                case STAY :
                default:
                    break;
            }
        }
        
        private void judge() {
            if (decrease > 2) signal = Sign.BUY;
            else if (increase  > 2) signal = Sign.SELL;
            else signal = Sign.STAY;
        }
        
        private void buy() {
            stock += cash / price;
            cash = cash % price;
        }
        
        private void sell() {
            cash += stock * price;
            stock = 0;
        }
        
        int getTotal() {
            return cash + price * stock;
        }
        
        enum Sign {
            BUY, STAY, SELL;
        }
    }
}
