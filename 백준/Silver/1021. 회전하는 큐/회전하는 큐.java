import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                q.add(i);
            }

            st = new StringTokenizer(br.readLine());
            int result = 0;
            for (int i = 0; i < M; i++) {
                int target = Integer.parseInt(st.nextToken());

                int cnt = 0;
                while (!q.isEmpty() && (target != q.peek())) {
                    q.offer(q.poll());
                    cnt++;
                }

                result += Math.min(cnt, q.size() - cnt);

                q.poll();
            }

            bw.write(result + "\n");

            bw.flush();
        }
    }
}
