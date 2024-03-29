import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int N = Integer.parseInt(br.readLine());

            boolean[] visited = new boolean[N + 1];
            int[] arr = new int[N];

            dfs(N, visited, 0, arr);

            bw.flush();
        }
    }

    private static void dfs(int len, boolean[] visited, int depth, int[] arr) throws IOException {
        if (depth == arr.length) {
            for (int n : arr) {
                bw.write(n + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = 1; i <= len; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                dfs(len, visited, depth + 1, arr);
                visited[i] = false;
            }
        }
    }
}
