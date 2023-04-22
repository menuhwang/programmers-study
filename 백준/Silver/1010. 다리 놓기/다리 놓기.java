import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int R = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            sb.append(comb(N, R)).append("\n");
        }
        System.out.println(sb);
    }

    private static long comb(int n, int r) {
        r = Math.min(r, n - r);
        long[] dp = new long[r + 1];
        dp[0] = 1;
        for (int i = 1; i <= r; i++) {
            dp[i] = dp[i - 1] * (n - i + 1) / i;
        }
        return dp[r];
    }
}