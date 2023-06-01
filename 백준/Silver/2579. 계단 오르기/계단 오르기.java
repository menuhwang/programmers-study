import java.io.*;

public class Main {
    private static int[] stair;
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        stair = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            stair[i] = Integer.parseInt(br.readLine());
        }

        bw.write(dp(N) + "");
        bw.flush();
        br.close();
        bw.close();
    }

    private static int dp(int n) {
        if (n == 0) return 0;
        if (n == 1) {
            dp[1] = stair[1];
            return dp[1];
        }
        if (n == 2) {
            dp[2] = stair[2] + dp(1);
            return dp[2];
        }
        if (dp[n] > 0) return dp[n];
        dp[n] = Math.max(stair[n] + dp(n - 2), stair[n] + stair[n - 1] + dp(n - 3));
        return dp[n];
    }
}