import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] dp = new int[n + 1][k + 1];
            for (int i = 0; i < dp.length; i++) {
                dp[i][0] = 1;
            }

            int[] coin = new int[n + 1];
            for (int i = 1; i < coin.length; i++) {
                coin[i] = Integer.parseInt(br.readLine());
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= k; j++) {
                    int result = dp[i - 1][j];
                    for (int l = 1; j - coin[i] * l >= 0 ; l++) {
                        result += dp[i - 1][j - coin[i] * l];
                    }
                    dp[i][j] = result;
                }
            }

            bw.write(dp[n][k] + "\n");

            bw.flush();
        }
    }
}
