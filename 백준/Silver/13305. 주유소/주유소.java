import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int N = Integer.parseInt(br.readLine());

            long[] distanceFromStart = new long[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N; i++) {
                long distance = Long.parseLong(st.nextToken());
                distanceFromStart[i] = distanceFromStart[i - 1] + distance;
            }

            int[] prices = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }

            long[] cost = new long[N];
            Arrays.fill(cost, Long.MAX_VALUE);
            cost[0] = 0;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    long distance = distanceFromStart[j] - distanceFromStart[i]; // 도착 - 출발
                    cost[j] = Math.min(cost[j], prices[i] * distance + cost[i]);
                }
            }

            bw.write(cost[N - 1] + "\n");

            bw.flush();
        }
    }
}
