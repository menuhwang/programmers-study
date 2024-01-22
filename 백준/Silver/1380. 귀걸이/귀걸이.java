import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int n = Integer.parseInt(br.readLine());

            int scenario = 1;
            while (n > 0) {
                String[] students = new String[n + 1];
                boolean[] check = new boolean[n + 1];
                for (int i = 1; i <= n; i++) {
                    students[i] = br.readLine();
                }

                for (int i = 0; i < 2 * n - 1; i++) {
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    int index = Integer.parseInt(st.nextToken());
                    check[index] = !check[index];
                }

                for (int i = 1; i <= n; i++) {
                    if (check[i]) {
                        bw.write(String.format("%d %s\n", scenario++, students[i]));
                    }
                }

                n = Integer.parseInt(br.readLine());
            }

            bw.flush();
        }
    }
}
