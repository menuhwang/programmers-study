import java.io.*;
import java.util.*;

class Main {
    private static Map<Integer, Map<Integer, Integer>> cost;
    private static int[] dp;
    private static boolean[] visited;
    private static int V;
    private static int E;
    private static int K;

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(br.readLine()) - 1;
            cost = new HashMap<>();

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken()) - 1;
                int v = Integer.parseInt(st.nextToken()) - 1;
                int w = Integer.parseInt(st.nextToken());

                if (Objects.isNull(cost.get(u))) cost.put(u, new HashMap<>());

                cost.get(u).put(v,
                        Math.min(w, cost.get(u).getOrDefault(v, Integer.MAX_VALUE))
                );
            }

            dijkstra();

            for (int v : dp)
                bw.write((v == Integer.MAX_VALUE ? "INF" : v) + "\n");

            bw.flush();
        }
    }

    private static void dijkstra() {
        dp = new int[V];
        for (int i = 0; i < V; i++) {
            int c = Integer.MAX_VALUE;
            if (Objects.nonNull(cost.get(K)) && Objects.nonNull(cost.get(K).get(i)))
                c = cost.get(K).get(i);
            dp[i] = c;
        }
        dp[K] = 0;

        visited = new boolean[V];
        visited[K] = true;

        int node = getMinCostNode();
        while (node > -1) {
            visited[node] = true;

            if (Objects.nonNull(cost.get(node))) {
                for (int child : cost.get(node).keySet()) {
                    int c = cost.get(node).get(child);
                    dp[child] = Math.min(dp[child], dp[node] + c);
                }
            }

            node = getMinCostNode();
        }
    }

    private static int getMinCostNode() {
        int min = Integer.MAX_VALUE;
        int node = -1;

        for (int i = 0; i < dp.length; i++) {
            if (!visited[i] && min > dp[i]) {
                min = dp[i];
                node = i;
            }
        }

        return node;
    }
}
