import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main {
    private static boolean[][] map;
    private static int tempApt;

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            int N = Integer.parseInt(br.readLine());
            map = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                char[] row = br.readLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    map[i][j] = row[j] == '1';
                }
            }

            List<Integer> dan = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!map[i][j]) continue;
                    tempApt = 0;
                    dfs(i, j);
                    dan.add(tempApt);
                }
            }

            Collections.sort(dan);
            
            bw.write(dan.size() + "\n");
            for (int apt : dan)
                bw.write(apt + "\n");

            bw.flush();
        }
    }

    private static final int DIRECTION = 4;
    private static final int[] dc = {0, 0, -1, 1};
    private static final int[] dr = {-1, 1, 0, 0};

    private static void dfs(int r, int c) {
        map[r][c] = false;
        tempApt++;

        for (int i = 0; i < DIRECTION; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (!isOnMap(nr, nc)) continue;
            if (!map[nr][nc]) continue;

            dfs(nr, nc);
        }
    }

    private static boolean isOnMap(int r, int c) {
        return r > -1
                && c > -1
                && r < map.length
                && c < map[0].length;
    }
}
