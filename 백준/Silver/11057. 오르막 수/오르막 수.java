import java.io.*;

class Main {
    /*
    * dp
    *          0  1  2  3  4  ..  9
    *       i  0  1  2  3  ..  8  9
    *    N   ---------------------------
    * 0  1  |  1  1  1  1  ..  1  1  ... 10
    * 1  2  |  1  2  3  4  ..  8  10 ... 55
    * 2  3  |  1  3  6  10 ..  ?  ?  ... 220
    * */
    private static int[][] dp;
    public static void main(String[] args) throws IOException {

        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            int N = Integer.parseInt(br.readLine());
            dp = new int[N][10];
            for (int i = 0; i < 10; i++) {
                dp[0][i] = 1;
            }

            for (int n = 1; n < N; n++) {
                dp[n][0] = 1;
                for (int i = 1; i < 10; i++) {
                    dp[n][i] = (dp[n][i - 1] + dp[n - 1][i]) % 10_007;
                }
            }

            int sum = 0;
            for (int num : dp[N - 1]) {
                sum += num;
                sum %= 10_007;
            }

            bw.write(sum + "\n");

            bw.flush();
        }
    }
}
