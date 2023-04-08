import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        int num = 666;
        int index = 1;
        
        while (index < N) {
            num++;
            if (conclusionNum(num)) index++;
        }
        
        System.out.print(num);
        
        sc.close();
    }
    
    private static boolean conclusionNum(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 10 == 6) count++;
            else count = 0;
            if (count > 2) return true;
            num /=10;
        }
        return false;
    }
}
