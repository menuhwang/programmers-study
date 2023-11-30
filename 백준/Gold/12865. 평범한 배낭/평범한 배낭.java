import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] dp = new int[N + 1][K + 1];

            int[][] items = new int[N + 1][2];
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                int w = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                items[i][0] = w;
                items[i][1] = v;
            }

            for (int w = 1; w <= K; w++) {
                for (int i = 1; i <= N; i++) {
                    int a = 0; // (가능한 경우)i번 아이템을 넣고 나머지 무게를 채우는 경우
                    if (items[i][0] <= w) a = items[i][1] + dp[i - 1][w - items[i][0]]; // i번 아이템을 넣을 수 있는 경우

                    int b = dp[i - 1][w]; // i번 아이템을 넣지 않고 그 전 아이템까지만 고려한 경우
                    dp[i][w] = Math.max(a, b);
                }
            }

            bw.write(dp[N][K] + "\n");

            bw.flush();
        }
    }
}
