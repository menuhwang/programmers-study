import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int[][] bus;
    private static int[][] cost;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int n = Integer.parseInt(br.readLine());
            bus = new int[n + 1][n + 1];
            cost = new int[n + 1][n + 1];
            for (int i = 0; i < n + 1; i++) {
                Arrays.fill(bus[i], Integer.MAX_VALUE);
                Arrays.fill(cost[i], Integer.MAX_VALUE);
                bus[i][i] = 0;
                cost[i][i] = 0;
            }

            int m = Integer.parseInt(br.readLine());
            StringTokenizer st;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                bus[a][b] = Math.min(bus[a][b], c);
                cost[a][b] = Math.min(cost[a][b], c);
            }

            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    for (int k = 0; k < n + 1; k++) {
                        if (cost[j][i] == Integer.MAX_VALUE || cost[i][k] == Integer.MAX_VALUE)
                            continue;

                        cost[j][k] = Math.min(cost[j][k], cost[j][i] + cost[i][k]);
                    }
                }
            }

            for (int i = 1; i < cost.length; i++) {
                int[] row = cost[i];
                for (int j = 1; j < cost.length; j++) {
                    int col = row[j];
                    if (col == Integer.MAX_VALUE)
                        bw.write("0 ");
                    else 
                        bw.write(col + " ");
                }
                bw.newLine();
            }

            bw.flush();
        }
    }
}
