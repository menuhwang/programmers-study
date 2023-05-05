import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int absN = Math.abs(N);
        dp = new int[absN + 1];

        for (int i = 1; i <=absN; i++) {
            fib(i);
        }

        int answer = fib(absN);
        if (N > 0) {
            System.out.println(1);
        } else if (N < 0) {
            System.out.println(absN % 2 == 0 ? -1 : 1);
        } else if (answer == 0) {
            System.out.println(0);
        }
        System.out.println(answer);
    }

    private static int fib(int n) {
        if (dp[n] > 0) {
            return  dp[n];
        }
        if (n == 0) {
            return 0;
        }
        if (n < 3) {
            dp[n] = 1;
            return dp[n];
        }
        dp[n] = (fib(n - 1) + fib(n - 2)) % 1_000_000_000;
        return dp[n];
    }
}