import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int T = Integer.parseInt(br.readLine());

            for (int i = 0; i < T; i++) {
                int N = Integer.parseInt(br.readLine());
                int[][] sticker = new int[2][N + 1];
                int[][] dp = new int[2][N + 1];
                StringTokenizer st;
                for (int j = 0; j < 2; j++) {
                    st = new StringTokenizer(br.readLine());
                    for (int k = 1; k <= N; k++) {
                        sticker[j][k] = Integer.parseInt(st.nextToken());
                    }
                }

                dp[0][1] = sticker[0][1];
                dp[1][1] = sticker[1][1];

                for (int j = 2; j <= N; j++) {
                    int a;
                    int b;
                    a = sticker[0][j] + dp[1][j - 1];
                    b = sticker[0][j] + Math.max(dp[0][j - 2], dp[1][j - 2]);

                    dp[0][j] = Math.max(a, b);

                    a = sticker[1][j] + dp[0][j - 1];
                    b = sticker[1][j] + Math.max(dp[0][j - 2], dp[1][j - 2]);

                    dp[1][j] = Math.max(a, b);
                }

                bw.write(Math.max(dp[0][N], dp[1][N]) + "\n");
            }

            bw.flush();
        }
    }
}
