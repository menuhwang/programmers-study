import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        System.out.println(factorial(N));
    }
    
    private static long factorial(int n) {
        if (n == 0) return 1L;
        return n * factorial(n - 1);
    }
}