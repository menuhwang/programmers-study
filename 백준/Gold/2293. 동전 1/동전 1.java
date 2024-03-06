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

            int[] dp = new int[k + 1];
            dp[0] = 1;

            int[] coin = new int[n];
            for (int i = 0; i < coin.length; i++) {
                coin[i] = Integer.parseInt(br.readLine());
            }

            for (int i = 0; i < coin.length; i++) {
                for (int j = coin[i]; j <= k; j++) {
                    dp[j] += dp[j - coin[i]];
                }
            }

            bw.write(dp[k] + "\n");

            bw.flush();
        }
    }
}
