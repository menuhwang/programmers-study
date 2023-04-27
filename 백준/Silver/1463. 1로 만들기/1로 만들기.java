import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) recurs(i);
        System.out.println(recurs(N));
    }

    private static int recurs(int n) {
        if (dp[n] > 0) return dp[n];
        if (n == 1) return 0;
        if (n < 4) {
            dp[n] = 1;
            return 1;
        }

        int sol = Integer.MAX_VALUE;
        if (n % 3 == 0) sol = Math.min(sol, recurs(n / 3) + 1);
        if (n % 2 == 0) sol = Math.min(sol, recurs(n / 2) + 1);
        sol = Math.min(sol, recurs(n - 1) + 1);

        dp[n] = sol;
        return dp[n];
    }
}