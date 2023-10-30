import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static long[][] map;
    public static void main(String[] args) throws IOException {

        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            map = new long[N + 1][M + 1];
            map[0][0] = 1;

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    map[i][j] = (map[i - 1][j] + map[i][j - 1] + map[i - 1][j - 1]) % 1_000_000_007;
                }
            }

            bw.write(map[N][M] + "\n");
            bw.flush();
        }
    }
}
