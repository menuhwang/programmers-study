import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Node {
        private final int element;
        private final int weight;

        public Node(int element, int weight) {
            this.element = element;
            this.weight = weight;
        }
    }

    private static List<List<Node>> tree;
    private static boolean[] visited;
    private static int[] memo;

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int V = Integer.parseInt(br.readLine());
            tree = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                tree.add(null);
            }

            for (int i = 0; i < V; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int parent = Integer.parseInt(st.nextToken());

                List<Node> children = new ArrayList<>();
                int childElement;
                while ((childElement = Integer.parseInt(st.nextToken())) > 0) {
                    int childWeight = Integer.parseInt(st.nextToken());

                    children.add(new Node(childElement, childWeight));
                }

                tree.set(parent, children);
            }
            // 초기화 끝.

            visited = new boolean[V + 1];
            memo = new int[V + 1];

            visited[1] = true;
            dfs(1, 0);

            int farNode = 0;
            int farDistance = 0;
            for (int i = 1; i <= V; i++) {
                if (farDistance < memo[i]) {
                    farDistance = memo[i];
                    farNode = i;
                }
            }

            visited = new boolean[V + 1];
            memo = new int[V + 1];

            visited[farNode] = true;

            dfs(farNode, 0);

            int result = 0;
            for (int i = 1; i <= V; i++) {
                result = Math.max(result, memo[i]);
            }

            bw.write(result + "\n");

            bw.flush();
        }
    }

    private static void dfs(int node, int weight) {
        for (Node child : tree.get(node)) {
            if (!visited[child.element]) {
                visited[child.element] = true;
                memo[child.element] = weight + child.weight;
                dfs(child.element, weight + child.weight);
                visited[child.element] = false;
            }
        }
    }
}
