import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            boolean[] eratosthenes = new boolean[N + 1];
            Arrays.fill(eratosthenes, true);

            eratosthenes[0] = false;
            eratosthenes[1] = false;

            for (int i = 2; i <= N; i++) {
                if (eratosthenes[i]) {
                    for (int j = 2 * i; j <= N; j += i) {
                        eratosthenes[j] = false;
                    }
                }
            }

            for (int i = M; i <= N; i++) {
                if (eratosthenes[i]) {
                    bw.write(i + "\n");
                }
            }

            bw.flush();
        }
    }
}
