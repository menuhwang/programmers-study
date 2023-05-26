import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] costs = new int[N][3];
        int[][] dp = new int[N][3];

        StringTokenizer st;
        // costs 초기화
        // dp INF 값으로 초기화
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                costs[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        // dp[0] 초기화
        for (int i = 0; i < 3; i++) {
            dp[0][i] = costs[0][i];
        }
        // i번 집에 x색으로 칠하는 최소값을 dp에 기록
        // i번 집에 x색으로 칠하는 최소값 판별은
        // i-1번 집에 x색을 제외한 값 중 최소값 + i번 집에 x색으로 칠하는 값
        // N - 1번까지 반복
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    if (k == j) continue;
                    min = Math.min(min, dp[i-1][k]);
                }
                dp[i][j] = min + costs[i][j];
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, dp[N-1][i]);
        }

        bw.write(min + "");
        bw.flush();
        br.close();
        bw.close();
    }
}