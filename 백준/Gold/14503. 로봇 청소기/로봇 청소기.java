import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Room {
        static final int WALL = 1;
        static final int DIRTY = 0;
        static final int CLEAN = -1;

        private final int[][] map;

        Room(int[][] map) {
            this.map = map;
        }

        // 세정
        void clean(int n, int m) {
            map[n][m] = CLEAN;
        }

        // 탐색
        boolean isWall(int n, int m) {
            return map[n][m] == WALL;
        }

        boolean isDirty(int n, int m) {
            return map[n][m] == DIRTY;
        }

        int getState(int n, int m) {
            if (!isOn(n, m))
                return Room.WALL;

            return map[n][m];
        }

        // 좌표 유효성
        boolean isOn(int n, int m) {
            return n > -1
                && m > -1
                && n < map.length
                && m < map[0].length;
        }
    }

    static class Robot {
        private static final int[][] DIRECTIONS = {
                {-1, 0},
                {0, 1},
                {1, 0},
                {0, -1}
        };

        private final Room room;
        private int n;
        private int m;
        private int direction;
        private int cleanCnt = 0;

        Robot(Room room, int n, int m, int direction) {
            this.room = room;
            this.n = n;
            this.m = m;
            this.direction = direction;
        }

        public void run() {
            if (room.isDirty(n, m))
                clean();

            if (!hasDirtyArea()) {
                if (back()) {
                    run();
                    return;
                }
                return;
            }

            do {
                rotate();
            } while (getForwardState() != Room.DIRTY);

            forward();
            run();
        }

        // 청소
        private void clean() {
            cleanCnt++;
            room.clean(n, m);
        }

        // 탐색
        private boolean hasDirtyArea() {
            for (int[] dir : DIRECTIONS) {
                int nn = n + dir[0];
                int nm = m + dir[1];

                if (room.isOn(nn, nm) && room.isDirty(nn, nm)) {
                    return true;
                }
            }
            return false;
        }

        private int getForwardState() {
            // Forward n
            int fn = n + DIRECTIONS[direction][0];
            // Forward m
            int fm = m + DIRECTIONS[direction][1];

            return room.getState(fn, fm);
        }

        // 회전
        private void rotate() {
            this.direction = (this.direction + 4 - 1) % 4;
        }

        // 전진
        private boolean forward() {
            int nn = this.n + DIRECTIONS[direction][0];
            int nm = this.m + DIRECTIONS[direction][1];
            if (!room.isOn(nn, nm) || room.isWall(nn, nm))
                return false;

            this.n = nn;
            this.m = nm;

            return true;
        }

        // 후진
        private boolean back() {
            int nn = this.n - DIRECTIONS[direction][0];
            int nm = this.m - DIRECTIONS[direction][1];

            if (!room.isOn(nn, nm) || room.isWall(nn, nm))
                return false;

            this.n = nn;
            this.m = nm;

            return true;
        }

        public int getCleanCnt() {
            return cleanCnt;
        }
    }

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][M];

            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            for (int k = 0; k < N; k++) {
                st = new StringTokenizer(br.readLine());
                for (int l = 0; l < M; l++) {
                    map[k][l] = Integer.parseInt(st.nextToken());
                }
            }

            Room room = new Room(map);
            Robot robot = new Robot(room, i, j, d);

            robot.run();

            bw.write(robot.getCleanCnt() + "\n");

            bw.flush();
        }
    }

}
