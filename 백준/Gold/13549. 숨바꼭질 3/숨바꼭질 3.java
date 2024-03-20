import java.io.*;
import java.util.*;
import java.util.function.Function;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N;
    private static int K;
    private static final int[] time = new int[100_001];
    private static final boolean[] visited = new boolean[100_001];

    static {
        Arrays.fill(time, Integer.MAX_VALUE);
    }

    private static final List<List<Function<Integer, Integer>>> DELTA = List.of(
            List.of((i) -> i + 1, (t) -> t + 1),
            List.of((i) -> i - 1, (t) -> t + 1),
            List.of((i) -> i * 2, (t) -> t)
    );

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> q = new PriorityQueue<>((item1, item2) -> Integer.compare(time[item1], time[item2]));

            q.add(N);
            time[N] = 0;

            while (!q.isEmpty()) {
                int pos = q.poll();
                if (pos == K) {
                    break;
                }

                visited[pos] = true;
                int t = time[pos];

                for (List<Function<Integer, Integer>> delta : DELTA) {
                    int newPos = delta.get(0).apply(pos);
                    if (newPos < 0 || newPos > 100_000)
                        continue;

                    if(!visited[newPos]) {
                        q.add(newPos);
                        time[newPos] = Math.min(time[newPos], delta.get(1).apply(t));
                    }
                }
            }

            bw.write(time[K] + "\n");

            bw.flush();
        }
    }
}
