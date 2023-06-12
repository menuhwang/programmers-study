import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input init
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N > 1 ? N + 1 : 3];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;

        // solution
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2] % 10_007) % 10_007;
        }

        bw.write(dp[N] + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
