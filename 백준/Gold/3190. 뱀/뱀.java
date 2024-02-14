import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            StringTokenizer st;

            int N = Integer.parseInt(br.readLine());
            SnakeGame game = new SnakeGame(N);
            int time = 0;

            int K = Integer.parseInt(br.readLine());
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                game.setApple(r, c);
            }

            int L = Integer.parseInt(br.readLine());
            loop:
            for (int i = 0; i < L; i++) {
                st = new StringTokenizer(br.readLine());
                int sec = Integer.parseInt(st.nextToken());
                String dir = st.nextToken();

                while (time < sec) {
                    if (!game.move()) {
                        break loop;
                    }
                    time++;
                }

                game.turn(dir);
            }

            do {
                time++;
            } while (game.move());

            bw.write(time + "\n");

            bw.flush();
        }
    }

    static class SnakeGame {
        private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        private final int[][] board;
        private final Deque<int[]> snake = new LinkedList<>(List.of(new int[]{1, 1}));
        private int direction = 0;

        SnakeGame(int size) {
            this.board = new int[size + 2][size + 2];
            for (int i = 0; i < board.length; i++) {
                board[0][i] = 1;
                board[i][0] = 1;
                board[board.length - 1][i] = 1;
                board[i][board.length - 1] = 1;
            }
            board[1][1] = 1;
        }

        void setApple(int r, int c) {
            board[r][c] = 2;
        }

        /**
         * 바라보고 있는 방향으로 한 칸 이동한다.
         * 벽 또는 몸에 부딪치면 이동할 수 없다.
         * 사과를 먹은 경우 몸 길이가 한 칸 길어진다.
         * @return 정상 이동하면 true를 반환한다. 이동하지 못하면 false를 반환한다.
         */
        boolean move() {
            int[] head = getHead();
            int nr = head[0] + DIRECTIONS[direction][0];
            int nc = head[1] + DIRECTIONS[direction][1];

            int[] newHead = {nr, nc};

            if (isBump(newHead))
                return false;

            if (!eatApple(newHead)) {
                int[] tail = getTail();
                mark(tail, 0);
                snake.pollFirst();
            }

            snake.offerLast(newHead);
            mark(newHead, 1);

            return true;
        }

        void turn(String dir) {
            if (dir.equals("D")) {
                direction++;
            } else if (dir.equals("L")) {
                direction--;
                if (direction < 0)
                    direction = 3;
            }
            direction %= DIRECTIONS.length;
        }

        private boolean isBump(int[] head) {
            assert head.length == 2;

            int r = head[0];
            int c = head[1];

            return board[r][c] == 1;
        }

        private boolean eatApple(int[] head) {
            assert head.length == 2;

            int r = head[0];
            int c = head[1];

            return board[r][c] == 2;
        }

        private void mark(int[] pos, int n) {
            int r = pos[0];
            int c = pos[1];
            board[r][c] = n;
        }


        private int[] getHead() {
            return snake.peekLast();
        }

        private int[] getTail() {
            return snake.peekFirst();
        }
    }
}
