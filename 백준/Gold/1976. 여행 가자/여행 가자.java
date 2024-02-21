import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int[] unf;
    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());

            unf = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                unf[i] = i;
            }

            StringTokenizer st;
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    if ("1".equals(st.nextToken())) {
                        union(i, j);
                    }
                }
            }

            st = new StringTokenizer(br.readLine());
            int standard = find(Integer.parseInt(st.nextToken()));
            boolean flag = true;
            for (int i = 1; i < M; i++) {
                int find = find(Integer.parseInt(st.nextToken()));
                if (standard != find) {
                    flag = false;
                    break;
                }
            }

            bw.write(flag ? "YES\n" : "NO\n");

            bw.flush();
        }
    }

    private static int find(int a) {
        if (unf[a] == a)
            return a;

        return find(unf[a]);
    }

    private static void union(int n1, int n2) {
        int a = find(n1);
        int b = find(n2);

        if (a != b) {
            unf[a] = n2;
        }
    }
}
