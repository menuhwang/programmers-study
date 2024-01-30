import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static final Map<Integer, Integer> map = new HashMap<>();
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());

            numbers = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            map.computeIfPresent(0, (k, v) -> v - 1); // 부분수열 크기가 0개인 경우 제외

            bw.write(map.getOrDefault(S, 0) + "\n");

            bw.flush();
        }
    }

    private static void dfs(int depth, int num) {
        if (depth == numbers.length) {
            map.compute(num, (k, v) -> v == null ? 1 : v + 1);
            return;
        }

        dfs(depth + 1, num);
        dfs(depth + 1, num + numbers[depth]);
    }
}
