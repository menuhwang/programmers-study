import java.io.*;
import java.util.*;

class Main {
    private static final List<List<Integer>> NODES = new ArrayList<>();
    private static final Set<Integer> VISITED = new HashSet<>();

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            for (int i = 0; i <= N; i++) {
                NODES.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                NODES.get(a).add(b);
            }
            int breadth = 0;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(X);
            VISITED.add(X);

            while (!queue.isEmpty() && breadth < K) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int node = queue.poll();

                    NODES.get(node).stream()
                            .filter(num -> !VISITED.contains(num))
                            .forEach(num -> {
                                queue.offer(num);
                                VISITED.add(num);
                            });
                }
                breadth++;
            }

            if (queue.isEmpty()) {
                bw.write("-1\n");
            } else {
                List<Integer> answer = new ArrayList<>(queue);
                Collections.sort(answer);
                for (int num : answer)
                    bw.write(num + "\n");
            }
            bw.flush();
        }
    }
}
