import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    private static String[][][] tomato;
    private static int M;
    private static int N;
    private static int H;

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            tomato = new String[H][N][M];

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < N; j++) {
                    st = new StringTokenizer(br.readLine());
                    for (int k = 0; k < M; k++) {
                        tomato[i][j][k] = st.nextToken();
                    }
                }
            }

            Queue<Pos> queue = new LinkedList<>();
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < M; k++) {
                        if (tomato[i][j][k].equals("1")) {
                            queue.add(new Pos(k, j, i));
                        }
                    }
                }
            }

            int DIRECTION = 6;
            // 동 서 남 북 상 하
            int[] dx = {1, -1, 0, 0, 0, 0};
            int[] dy = {0, 0, 1, -1, 0, 0};
            int[] dz = {0, 0, 0, 0, 1, -1};

            int day = -1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Pos pos = queue.poll();
                    for (int j = 0; j < DIRECTION; j++) {
                        int nx = pos.x + dx[j];
                        int ny = pos.y + dy[j];
                        int nz = pos.z + dz[j];

                        if (!isInBox(nx, ny, nz)) continue;
                        if (tomato[nz][ny][nx].equals("-1")) continue;
                        if (tomato[nz][ny][nx].equals("1")) continue;

                        queue.add(new Pos(nx, ny, nz));
                        tomato[nz][ny][nx] = "1";
                    }
                }
                day++;
            }

            loop:
            for (String[][] layer : tomato)
                for (String[] row : layer)
                    for (String col : row)
                        if (col.equals("0")) {
                            day = -1;
                            break loop;
                        }

            bw.write(day + "\n");

            bw.flush();
        }
    }

    static class Pos {
        final int x;
        final int y;
        final int z;

        public Pos(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    private static boolean isInBox(int x, int y, int z) {
        return x > -1
                && y > -1
                && z > -1
                && x < M
                && y < N
                && z < H;
    }
}
