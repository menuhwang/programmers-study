import java.io.*;
import java.util.*;

class Main {
    private static boolean[][] placard;

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            placard = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    placard[i][j] = "1".equals(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (placard[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            bw.write(count + "\n");

            bw.flush();
        }
    }

    private static final int[][] DIRECTIONS = { // {d-row, d-col}
            {-1, 0}, // 12시
            {-1, 1}, // 1시
            {0, 1}, // 3시
            {1, 1}, // 5시
            {1, 0}, // 6시
            {1, -1}, // 7시
            {0, -1}, // 9시
            {-1, -1}, // 11시
    };

    private static void dfs(int row, int col) {
        placard[row][col] = false;

        for (int[] direction : DIRECTIONS) {
            int nr = row + direction[0];
            int nc = col + direction[1];

            if (onPlacard(nr, nc) && placard[nr][nc])
                dfs(nr, nc);
        }
    }

    private static boolean onPlacard(int row, int col) {
        return row > -1
                && col > -1
                && row < placard.length
                && col < placard[0].length;
    }
}
