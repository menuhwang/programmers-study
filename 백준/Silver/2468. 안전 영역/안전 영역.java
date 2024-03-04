import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N;
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            int max = 1;
            int min = 100;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int h = Integer.parseInt(st.nextToken());
                    max = Math.max(max, h);
                    min = Math.min(min, h);
                    map[i][j] = h;
                }
            }

            int sections = 1;
            for (int i = min; i <= max; i++) {
                sections = Math.max(sections, getSafeSection(i));
            }

            bw.write(sections + "\n");

            bw.flush();
        }
    }

    private static int getSafeSection(int rain) {
        visited = new boolean[N][N];

        int sections = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] > rain) {
                    sections++;
                    dfs(i, j, rain);
                }
            }
        }

        return sections;
    }

    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static void dfs(int r, int c, int rain) {
        visited[r][c] = true;

        for (int[] direction : DIRECTIONS) {
            int nr = r + direction[0];
            int nc = c + direction[1];

            if (!onMap(nr, nc))
                continue;

            if (visited[nr][nc])
                continue;

            if (map[nr][nc] > rain) {
                dfs(nr, nc, rain);
            }
        }
    }

    private static boolean onMap(int r, int c) {
        return r > -1
            && c > -1
            && r < N
            && c < N;
    }
}
