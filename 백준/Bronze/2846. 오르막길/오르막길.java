import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] high = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            high[i] = Integer.parseInt(st.nextToken());
        }

        int diff = 0;
        int start = 0;
        int end = 1;
        while (start < N && end < N) {
            if (high[end - 1] < high[end]) {
                diff = Math.max(diff, high[end] - high[start]);
                end++;
            } else {
                start = end++;
            }
        }

        bw.write(diff + "");
        bw.flush();
        br.close();
        bw.close();
    }
}