import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp = new int[12];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int N;
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            System.out.println(recurs(N));
        }
    }

    private static int recurs(int n) {
        if (n < 1) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        if (dp[n] > 0) return dp[n];
        dp[n] = recurs(n - 1) + recurs(n - 2) + recurs(n - 3);
        return dp[n];
    }
}