import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int N = Integer.parseInt(br.readLine());

            int[] distances = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N; i++) {
                distances[i] = Integer.parseInt(st.nextToken());
            }

            int[] prices = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }

            int[] minPriceTo = new int[N];
            int min = prices[0];
            minPriceTo[1] = min;
            for (int i = 2; i < N; i++) {
                min = Math.min(min, prices[i - 1]);
                minPriceTo[i] = min;
            }
            
            long answer = 0;
            for (int i = 1; i < N; i++) {
                answer += (long) minPriceTo[i] * distances[i];
            }

            bw.write(answer + "\n");


            bw.flush();
        }
    }
}
