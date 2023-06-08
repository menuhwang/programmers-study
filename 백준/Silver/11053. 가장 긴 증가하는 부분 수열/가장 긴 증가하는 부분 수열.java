import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        dp[0] = 1;

        for (int i = 1; i < N; i++) {
            int max = 0;

            for (int j = i - 1; j > -1; j--) {
                if (numbers[i] > numbers[j]) {
                    max = Math.max(max, dp[j]);
                }
            }

            dp[i] = max + 1;
        }

        int answer = 0;
        for (int num : dp) {
            answer = Math.max(answer, num);
        }

        bw.write(answer + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
