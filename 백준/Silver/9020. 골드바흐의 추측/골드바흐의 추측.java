import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        boolean[] nonPrimeNumbers = new boolean[10001];
        
        nonPrimeNumbers[0] = true;
        nonPrimeNumbers[1] = true;
        
        for (int i = 2; i < nonPrimeNumbers.length; i++) {
            if (nonPrimeNumbers[i]) continue;
            nonPrimeNumbers[i] = isNotPrimeNumber(i);
            for (int j = 2; j * i < nonPrimeNumbers.length; j++) {
                nonPrimeNumbers[j * i] = true;
            }
        }
        
        int N = sc.nextInt();
        
        int num;
        int a = 0;
        int b = 0;
        for (int i = 0; i < N; i++) {
            num = sc.nextInt();
            for (int j = 2; j <= num / 2; j++) {
                if (!nonPrimeNumbers[j] && !nonPrimeNumbers[num - j]) {
                    a = j;
                    b = num - j;
                }
            }
            sb.append(String.format("%d %d\n", a, b));
        }
        
        System.out.print(sb.toString());
    }
    
    private static boolean isNotPrimeNumber(int num) {
        if (num < 2) return true;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return true;
        }
        return false;
    }
}