import java.io.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int n = Integer.parseInt(br.readLine());
            int[] wine = new int[n + 1];
            int[] dp = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                wine[i] = Integer.parseInt(br.readLine());
            }

            if (n == 1) {
                bw.write(wine[1] + "\n");
                bw.flush();
                return;
            }

            dp[1] = wine[1];
            dp[2] = wine[1] + wine[2];

            for (int i = 3; i <= n; i++) {
                int max = dp[i - 1];
                max = Math.max(max, dp[i - 2] + wine[i]);
                max = Math.max(max, dp[i - 3] + wine[i - 1] + wine[i]);

                dp[i] = max;
            }

            bw.write(dp[n] + "\n");

            bw.flush();
        }
    }
}
