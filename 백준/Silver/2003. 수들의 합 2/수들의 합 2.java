import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] numbers = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            int result = 0;
            int start = 0;
            int end = 0;
            int sum = 0;
            while (start < N) {
                while (sum < M && end < N) {
                    sum += numbers[end++];
                }
                if (sum == M) {
                    result++;
                }
                sum -= numbers[start++];
            }

            bw.write(result + "\n");

            bw.flush();
        }
    }
}
