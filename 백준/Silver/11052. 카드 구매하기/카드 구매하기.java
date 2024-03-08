import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int n = Integer.parseInt(br.readLine());

            int[] dp = new int[n + 1];

            int[] price = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= price.length; i++) {
                for (int j = i; j <= n; j++) {
                    dp[j] = Math.max(dp[j], price[i] + dp[j - i]);
                }
            }

            bw.write(dp[n] + "\n");

            bw.flush();
        }
    }
}
