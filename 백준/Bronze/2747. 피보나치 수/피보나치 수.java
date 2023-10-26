import java.io.*;

class Main {
    private static final int[] dp = new int[46];
    public static void main(String[] args) throws IOException {

        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            int N = Integer.parseInt(br.readLine());

            for (int i = 0; i < N; i++)
                fibonacci(i);

            bw.write(fibonacci(N) + "\n");
            bw.flush();
        }
    }

    static {
        dp[0] = 0;
        dp[1] = 1;
    }

    private static int fibonacci(int n) {
        if (dp[n] > 0) return dp[n];

        if (n > 1)
            dp[n] = fibonacci(n - 1) + fibonacci(n - 2);

        return dp[n];
    }
}
