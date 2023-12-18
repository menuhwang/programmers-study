import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int N = Integer.parseInt(br.readLine());
            List<List<Integer>> tree = new ArrayList<>();
            boolean[] visited = new boolean[N + 1];
            int[] parents = new int[N + 1];

            for (int i = 0; i <= N; i++)
                tree.add(new ArrayList<>());

            StringTokenizer st;
            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                tree.get(a)
                    .add(b);

                tree.get(b)
                    .add(a);
            }

            Queue<Integer> q = new LinkedList<>();
            visited[1] = true;
            q.offer(1);

            while (!q.isEmpty()) {
                int parent = q.poll();

                for (int child : tree.get(parent)) {
                    if (visited[child]) continue;
                    visited[child] = true;
                    parents[child] = parent;
                    q.offer(child);
                }
            }

            for (int i = 2; i <= N; i++) {
                bw.write(parents[i] + "\n");
            }

            bw.flush();
        }
    }
}
