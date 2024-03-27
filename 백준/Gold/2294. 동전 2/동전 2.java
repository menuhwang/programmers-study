import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            Set<Integer> coins = new HashSet<>();
            for (int i = 0; i < N; i++) {
                coins.add(Integer.parseInt(br.readLine()));
            }

            int[] dp = new int[K + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);

            for (int coin : coins) {
                if (coin < dp.length) {
                    dp[coin] = 1;
                }
            }

            for (int i = 1; i < K; i++) {
                if (dp[i] < Integer.MAX_VALUE) {
                    for (int coin : coins) {
                        int nc = i + coin;
                        if (nc < dp.length)
                            dp[i + coin] = Math.min(dp[i + coin], dp[i] + 1);
                    }
                }
            }

            bw.write(dp[K] == Integer.MAX_VALUE ? "-1\n" : dp[K] + "\n");

            bw.flush();
        }
    }
}
