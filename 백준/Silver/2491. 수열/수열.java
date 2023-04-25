import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int prevNum = Integer.parseInt(st.nextToken());
        int naturalOrder = 1;
        int reverseOrder = 1;
        int max = 1;

        for (int n = 0; n < N - 1; n++) {
            int currNum = Integer.parseInt(st.nextToken());
            if (prevNum <= currNum) naturalOrder++;
            else naturalOrder = 1;
            if (prevNum >= currNum) reverseOrder++;
            else reverseOrder = 1;

            max = Math.max(max, Math.max(naturalOrder, reverseOrder));

            prevNum = currNum;
        }

        System.out.println(max);
    }
}