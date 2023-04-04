import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        long A = sc.nextLong();
        long B = sc.nextLong();
        
        System.out.print("1".repeat((int) gcd(A, B)));
    }
    
    private static long gcd(long A, long B) {
        long a = Math.max(A, B);
        long b = Math.min(A, B);
        
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }
}