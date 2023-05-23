import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] dp = new int[B + 1];

        int index = 1;
        int num = 1;
        int count = 0;
        while (index < dp.length) {
            if (count < num) {
                dp[index] = dp[index - 1]+ num;
                index++;
                count++;
            } else {
                count = 0;
                num++;
            }
        }

        System.out.println(dp[B] - dp[A - 1]);
    }
}