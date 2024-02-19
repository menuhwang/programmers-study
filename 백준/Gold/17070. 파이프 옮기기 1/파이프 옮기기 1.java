import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N;
    private static boolean[][] room;
    private static int count = 0;

    enum Direction {
        RIGHT(new int[]{0, 1}, new int[][]{{0, 1}}, new int[]{0, 1}),
        RIGHT_DOWN(new int[]{1, 1}, new int[][]{{0, 1}, {1, 1}, {1, 0}}, new int[]{0, 1, 2}),
        DOWN(new int[]{1, 0}, new int[][]{{1, 0}}, new int[]{1, 2});

        private final int[] deltaHead;
        private final int[][] emptySpace;
        private final int[] next;

        Direction(int[] deltaHead, int[][] emptySpace, int[] next) {
            this.deltaHead = deltaHead;
            this.emptySpace = emptySpace;
            this.next = next;
        }

        public int[] getDeltaHead() {
            return deltaHead;
        }

        public int[][] getEmptySpace() {
            return emptySpace;
        }

        public List<Direction> getNext() {
            Direction[] values = Direction.values();
            List<Direction> directions = new ArrayList<>();
            for (int idx : next) {
                directions.add(values[idx]);
            }

            return directions;
        }
    }

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            N = Integer.parseInt(br.readLine());
            room = new boolean[N + 2][N + 2];

            StringTokenizer st;
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    room[i][j] = "0".equals(st.nextToken());
                }
            }

            dfs(1, 2, Direction.RIGHT);

            bw.write(count + "\n");

            bw.flush();
        }
    }

    private static void dfs(int headRow, int headCol, Direction dir) {
        if (headRow == N && headCol == N) {
            count++;
            return;
        }

        dirLoop:
        for (Direction next : dir.getNext()) {
            int[][] emptySpace = next.getEmptySpace();
            for (int[] space : emptySpace) {
                int nextEmptySpaceRow = headRow + space[0];
                int nextEmptySpaceCol = headCol + space[1];

                if (isWall(nextEmptySpaceRow, nextEmptySpaceCol)) {
                    continue dirLoop;
                }
            }
            int[] deltaHead = next.getDeltaHead();
            int nextHeadRow = headRow + deltaHead[0];
            int nextHeadCol = headCol + deltaHead[1];

            dfs(nextHeadRow, nextHeadCol, next);
        }
    }

    private static boolean isWall(int r, int c) {
        return !room[r][c];
    }
}
