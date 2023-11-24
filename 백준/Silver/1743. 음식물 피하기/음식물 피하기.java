import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static boolean[][] lobby;
    private static int N;
    private static int M;
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            lobby = new boolean[N][M];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken()) - 1;

                lobby[r][c] = true;
            }

            int result = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (lobby[i][j]) {
                        count = 0;
                        dfs(i, j);
                        result = Math.max(result, count);
                    }
                }
            }

            bw.write(result + "\n");

            bw.flush();
        }
    }

    private static final int[][] DIRECTION = {
            {-1, 0}, // 상
            {1, 0}, // 하
            {0, 1}, // 좌
            {0, -1} // 우
    };

    private static void dfs(int r, int c) {
        lobby[r][c] = false;
        count++;

        for (int i = 0; i < DIRECTION.length; i++) {
            int nr = r + DIRECTION[i][0];
            int nc = c + DIRECTION[i][1];

            if (!onLobby(nr, nc)) continue;
            if (lobby[nr][nc]) dfs(nr, nc);
        }
    }

    private static boolean onLobby(int r, int c) {
        return r > -1
                && c > -1
                && r < N
                && c < M;
    }
}
