import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            recurs(i);
        }

        System.out.println(dp[N]);
    }

    private static int recurs(int n) {
        if (n < 3) {
            dp[n] = n;
            return dp[n];
        }
        if (dp[n] > 0) return dp[n];
        dp[n] = (recurs(n - 1) + recurs(n - 2)) % 10007;
        return dp[n];
    }
}