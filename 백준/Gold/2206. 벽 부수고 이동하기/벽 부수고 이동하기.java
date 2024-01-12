import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static boolean[][] map;
    private static int[][][] visited;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new boolean[N][M];
            visited = new int[N][M][2];

            for (int i = 0; i < N; i++) {
                char[] row  = br.readLine().toCharArray();
                for (int j = 0; j < M; j++) {
                    map[i][j] = row[j] == '0';
                }
            }

            bfs(0, 0);


            int result = -1;
            if (isVisited(N - 1, M - 1, 0) && isVisited(N - 1, M - 1, 1)) {
                result = Math.min(visited[N - 1][M - 1][0], visited[N - 1][M - 1][1]);
            } else if (isVisited(N - 1, M - 1, 0)) {
                result = visited[N - 1][M - 1][0];
            } else if (isVisited(N - 1, M - 1, 1)) {
                result = visited[N - 1][M - 1][1];
            }

            bw.write(result + "\n");

            bw.flush();
        }
    }

    private static final int[][] DIRECTIONS = {
            {-1, 0}, // 상
            {1, 0}, // 하
            {0, -1}, // 좌
            {0, 1}, // 우
    };

    private static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c, 0});
        visited[r][c][0] = 1;

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            for (int[] direction : DIRECTIONS) {
                int nr = pos[0] + direction[0];
                int nc = pos[1] + direction[1];

                if (onMap(nr, nc) && !isVisited(nr, nc, pos[2])) {
                    if (isLoad(nr, nc)) {
                        q.add(new int[]{nr, nc, pos[2]});
                        visited[nr][nc][pos[2]] = visited[pos[0]][pos[1]][pos[2]] + 1;
                    } else if (!isDrilled(pos)) {
                        q.add(new int[]{nr, nc, 1});
                        visited[nr][nc][1] = visited[pos[0]][pos[1]][pos[2]] + 1;
                    }
                }
            }
        }
    }

    private static boolean isTarget(int r, int c) {
        return r == N - 1 && c == M - 1;
    }

    private static boolean isDrilled(int[] pos) {
        return pos[2] == 1;
    }

    private static boolean isVisited(int r, int c, int drilled) {
        return visited[r][c][drilled] > 0;
    }

    private static boolean isLoad(int r, int c) {
        return map[r][c];
    }

    private static boolean onMap(int r, int c) {
        return r > -1
                && c > -1
                && r < N
                && c < M;
    }
}
