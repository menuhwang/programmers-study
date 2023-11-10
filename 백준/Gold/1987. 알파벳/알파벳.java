import java.io.*;
import java.util.*;

class Main {
    private static final Set<Character> visited = new HashSet<>();
    private static int max;
    private static char[][] map;

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            map = new char[R][C];

            for (int i = 0; i < R; i++) {
                char[] row = br.readLine().toCharArray();
                System.arraycopy(row, 0, map[i], 0, map[i].length);
            }

            dfs(0, 0);

            bw.write(max + "\n");

            bw.flush();
        }
    }

    private static final int DIRECTION = 4;
    private static final int[] dc = {0, 0, -1, 1};
    private static final int[] dr = {-1, 1, 0, 0};


    private static int count = 0;
    private static void dfs(int r, int c) {
        visited.add(map[r][c]);
        count++;

        for (int i = 0; i < DIRECTION; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (!isOnMap(nr, nc)) continue;
            if (visited.contains(map[nr][nc])) continue;

            dfs(nr, nc);

            visited.remove(map[nr][nc]);
            count--;
        }

        max = Math.max(max, count);
    }

    private static boolean isOnMap(int r, int c) {
        return r > -1
                && c > -1
                && r < map.length
                && c < map[0].length;
    }
}
