import java.io.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[n + 1][12];

            dp[1] = new int[]{0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0};

            for (int i = 2; i <= n; i++) {
                for (int j = 0; j <= 9; j++) {
                    dp[i][j + 1] = (dp[i - 1][j] + dp[i - 1][j + 2]) % 1_000_000_000;
                }
            }

            int result = 0;
            for (int i = 0; i <= 9; i++) {
                result = (result + dp[n][i + 1]) % 1_000_000_000;
            }

            bw.write(result + "\n");

            bw.flush();
        }
    }
}
