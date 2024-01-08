import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] bridge = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                bridge[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int answer = -1;
            int count = 0;
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[N + 1];
            q.add(a);

            loop: while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int curr = q.poll();
                    if (visited[curr]) {
                        continue;
                    }
                    visited[curr] = true;
                    if (curr == b) {
                        answer = count;
                        break loop;
                    }
                    for (int j = 1; curr + j * bridge[curr] <= N; j++) { // 앞
                        q.add(curr + j * bridge[curr]);
                    }
                    for (int j = 1; curr - j * bridge[curr] > 0; j++) { // 뒤
                        q.add(curr - j * bridge[curr]);
                    }
                }
                count++;
            }

            bw.write(answer + "\n");
            bw.flush();
        }
    }
}
