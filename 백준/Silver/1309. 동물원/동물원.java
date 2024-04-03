import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int N = Integer.parseInt(br.readLine());
            int[] dp = new int[N + 1];
            dp[0] = 1;
            dp[1] = 3;

            for (int i = 2; i <= N; i++) {
                dp[i] = (2 * dp[i - 1] + dp[i - 2]) % 9901;
            }

            bw.write(dp[N] + "\n");

            bw.flush();
        }
    }
}
