import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] intTriangle = new int[N][N];
        int[][] dp = new int[N][N];

        // input init
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                intTriangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // solution
        dp[0][0] = intTriangle[0][0];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                int left = j - 1 >= 0 ? dp[i - 1][j - 1] : 0;
                int right = j < i ? dp[i - 1][j] : 0;
                dp[i][j] = Math.max(left + intTriangle[i][j], right + intTriangle[i][j]);
            }
        }

        int answer = 0;
        for (int num : dp[N - 1]) {
            answer = Math.max(answer, num);
        }

        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
