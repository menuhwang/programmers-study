import java.util.*;

public class Main {
    public static void main(String[] arg) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        System.out.print(fibonacci(N));
    }
    
    private static long fibonacci(int n) {
        if (n < 2) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}