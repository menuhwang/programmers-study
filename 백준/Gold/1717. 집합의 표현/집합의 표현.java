import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int[] unf;

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            unf = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                unf[i] = i;
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());

                if (cmd == 0) {
                    union(n1, n2);
                } else if (cmd == 1) {
                    int a = find(n1);
                    int b = find(n2);
                    bw.write(a == b ? "YES\n" : "NO\n");
                }
            }

            bw.flush();
        }
    }

    private static int find(int num) {
        if (num == unf[num])
            return num;
        return unf[num] = find(unf[num]);
    }

    private static void union(int n1, int n2) {
        int a = find(n1);
        int b = find(n2);

        if (a == b)
            return;

        unf[a] = b;
    }
}
