import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        int constNum = 0;
        
        for (int i = 1; i <= N; i++) {
            if (divSum(i) == N) {
                constNum = i;
                break;
            }
        }
        
        System.out.print(constNum);
        
        sc.close();
    }
    
    private static int divSum(int n) {
        int sum = 0;

        sum += n;
        
        while(n > 0) {
            sum += n % 10;
            n /= 10;
        }
        
        return sum;
    }
}