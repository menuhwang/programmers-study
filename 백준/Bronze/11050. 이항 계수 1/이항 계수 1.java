import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dp = new int[N + 1];
        for (int i = 0; i <= N; i++) factorial(i);

        int answer = factorial(N) / factorial(K) / factorial(N - K);
        System.out.println(answer);
    }

    private static int factorial(int n) {
        if (dp[n] > 0) return dp[n];
        if (n < 2) {
            dp[n] = 1;
            return 1;
        }
        dp[n] = n * factorial(n - 1);
        return dp[n];
    }
}