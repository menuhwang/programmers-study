import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N;
    private static int M;
    private static int[][] COST;

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());

            COST = new int[N + 1][N + 1];
            for (int[] row : COST)
                Arrays.fill(row, Integer.MAX_VALUE);
            for (int i = 0; i < N; i++) {
                COST[i][i] = 0;
            }

            StringTokenizer st;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int arri = Integer.parseInt(st.nextToken());
                int dest = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                COST[arri][dest] = Math.min(COST[arri][dest], cost);
            }

            st = new StringTokenizer(br.readLine());
            int arri = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());

            int[] dp = Arrays.copyOf(COST[arri], COST[arri].length);
            boolean[] visited = new boolean[N + 1];
            visited[arri] = true;

            int index = getMinCostIndex(dp, visited);
            while (index > -1) {
                visited[index] = true;
                for (int i = 1; i <= N; i++) {
                    if (COST[index][i] == Integer.MAX_VALUE) continue;
                    dp[i] = Math.min(dp[i], dp[index] + COST[index][i]);
                }

                index = getMinCostIndex(dp, visited);
            }

            bw.write(dp[dest] + "\n");

            bw.flush();
        }
    }

    private static int getMinCostIndex(int[] cost, boolean[] visited) {
        int index = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < cost.length; i++) {
            if (visited[i]) continue;
            if (min > cost[i]) {
                min = cost[i];
                index = i;
            }
        }

        return index;
    }
}
