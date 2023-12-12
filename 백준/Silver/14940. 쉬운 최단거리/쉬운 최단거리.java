import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int[][] map;
    private static int[][] distance;

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            int[] target = new int[2]; // {n, m};

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int flag = Integer.parseInt(st.nextToken());
                    if (flag == 2) {
                        target = new int[]{i, j};
                    }
                    map[i][j] = flag;
                }
            }

            distance = new int[N][M];

            bfs(target);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1) {
                        distance[i][j] = -1;
                    }
                }
            }

            for (int[] row : distance) {
                for (int col : row) {
                    bw.write(col + " ");
                }
                bw.write("\n");
            }

            bw.flush();
        }
    }

    private static final int[][] DIRECTIONS = {
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1}
    };

    private static void bfs(int[] target) {
        Queue<int[]> q = new LinkedList<>();
        q.add(target);
        map[target[0]][target[1]] = -1;

        int breadth = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] next = q.poll();

                int r = next[0];
                int c = next[1];
                for (int[] direction : DIRECTIONS) {
                    int nr = r + direction[0];
                    int nc = c + direction[1];

                    if (isOut(nr, nc)) continue;
                    if (map[nr][nc] < 1) continue;

                    map[nr][nc] = -1;
                    q.add(new int[]{nr, nc});
                    distance[nr][nc] = breadth;
                }
            }
            breadth++;
        }
    }

    private static boolean isOut(int r, int c) {
        return r < 0
                || c < 0
                || r > map.length - 1
                || c > map[0].length - 1;
    }
}
