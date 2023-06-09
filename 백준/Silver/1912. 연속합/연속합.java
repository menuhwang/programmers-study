import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N + 1];

        // input init
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        // solution
        for (int i = 1; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1] + numbers[i], numbers[i]);
        }
        
        int max = dp[1];
        for (int i = 2; i <= N; i++) {
            max = Math.max(max, dp[i]);
        }

        bw.write(max + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
