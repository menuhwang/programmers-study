import java.io.*;

class Main {
    private static final long[] memo = new long[101];

    static {
        memo[1] = 1;
        memo[2] = 1;
        memo[3] = 1;
        memo[4] = 2;
        memo[5] = 2;
    }

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            int T = Integer.parseInt(br.readLine());

            for (int i = 0; i < T; i++) {
                int N = Integer.parseInt(br.readLine());
                bw.write(dp(N) + "\n");
            }

            bw.flush();
        }
    }

    private static long dp(int n) {
        if (memo[n] > 0) return memo[n];

        memo[n] = dp(n - 1) + dp(n - 5);

        return memo[n];
    }
}
