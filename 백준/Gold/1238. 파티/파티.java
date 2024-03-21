import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Node {
        private final int element;
        private final int cost;

        public Node(int element, int cost) {
            this.element = element;
            this.cost = cost;
        }

        public int getElement() {
            return element;
        }

        public int getCost() {
            return cost;
        }
    }

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            List<List<Node>> ways = new ArrayList<>();
            List<List<Node>> reverseWays = new ArrayList<>();

            for (int i = 0; i <= N; i++) {
                ways.add(new ArrayList<>());
                reverseWays.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());

                ways.get(start).add(new Node(end, time));
                reverseWays.get(end).add(new Node(start, time));
            }

            int[] go = dijkstra(reverseWays, X);
            int[] come = dijkstra(ways, X);

            int result = 0;
            for (int i = 1; i <= N; i++) {
                result = Math.max(result, go[i] + come[i]);
            }

            bw.write(result + "\n");

            bw.flush();
        }
    }

    private static int[] dijkstra(List<List<Node>> ways, int start) {
        int[] result = new int[ways.size()];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[start] = 0;
        boolean[] visited = new boolean[result.length];

        PriorityQueue<Node> q = new PriorityQueue<>((node1, node2) -> Integer.compare(result[node1.getElement()], result[node2.getElement()]));
        q.add(new Node(start, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            int idx = node.getElement();
            visited[idx] = true;

            for (Node n : ways.get(idx)) {
                int i = n.getElement();
                if (visited[i])
                    continue;

                result[i] = Math.min(result[i], result[idx] + n.getCost());
                q.add(n);
            }
        }

        return result;
    }
}
