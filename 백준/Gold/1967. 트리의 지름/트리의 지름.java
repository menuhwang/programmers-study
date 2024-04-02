import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Node {
        private final int element;
        private final int distance;

        public Node(int element, int distance) {
            this.element = element;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int n = Integer.parseInt(br.readLine());
            if (n == 1) {
                bw.write("0\n");
                bw.flush();
                return;
            }
            
            List<List<Node>> tree = new ArrayList<>();
            tree.add(null);
            for (int i = 0; i < n; i++) {
                tree.add(new ArrayList<>());
            }

            StringTokenizer st;
            for (int i = 0; i < n - 1; i++) {
                st = new StringTokenizer(br.readLine());

                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                int distance = Integer.parseInt(st.nextToken());

                tree.get(parent).add(new Node(child, distance));
                tree.get(child).add(new Node(parent, distance));
            }

            int[] dijkstra1 = dijkstra(tree, 1);
            int idx = 0;
            int max = 0;
            for (int i = 1; i <= n; i++) {
                if (dijkstra1[i] > max) {
                    idx = i;
                    max = dijkstra1[i];
                }
            }

            int[] dijkstra2 = dijkstra(tree, idx);
            int diameter = 0;
            for (int i = 1; i <= n; i++) {
                diameter = Math.max(diameter, dijkstra2[i]);
            }

            bw.write(diameter + "\n");

            bw.flush();
        }
    }

    private static int[] dijkstra(List<List<Node>> tree, int startNode) {
        assert (startNode > 0 && startNode <= tree.size());

        int[] result = new int[tree.size()];
        boolean[] visited = new boolean[tree.size()];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[startNode] = 0;

        for (Node n : tree.get(startNode)) {
            result[n.element] = n.distance;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> Integer.compare(result[n1.element], result[n2.element]));
        pq.addAll(tree.get(startNode));

        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            visited[poll.element] = true;

            for (Node n : tree.get(poll.element)) {
                if (visited[n.element])
                    continue;

                result[n.element] = Math.min(result[n.element], result[poll.element] + n.distance);
                pq.add(n);
            }
        }

        return result;
    }
}
