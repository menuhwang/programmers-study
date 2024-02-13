import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static int M;

    enum Tetromino {
        I(new int[][][]{
                {{0, 0}, {1, 0}, {2, 0}, {3, 0}},
                {{0, 0}, {0, 1}, {0, 2}, {0, 3}},
                {{0, 0}, {-1, 0}, {-2, 0}, {-3, 0}},
                {{0, 0}, {0, -1}, {0, -2}, {0, -3}}
        }),
        O(new int[][][]{
                {{0, 0}, {1, 0}, {0, 1}, {1, 1}},
                {{0, 0}, {1, 0}, {0, -1}, {1, -1}},
                {{0, 0}, {-1, 0}, {0, -1}, {-1, -1}},
                {{0, 0}, {-1, 0}, {0, 1}, {-1, 1}}
        }),
        T(new int[][][]{
                {{0, 0}, {1, 0}, {2, 0}, {1, 1}},
                {{0, 0}, {0, 1}, {0, 2}, {-1, 1}},
                {{0, 0}, {-1, 0}, {-2, 0}, {-1, -1}},
                {{0, 0}, {0, -1}, {0, -2}, {1, -1}}
        }),
        J(new int[][][]{
                {{0, 0}, {1, 0}, {2, 0}, {2, 1}},
                {{0, 0}, {0, 1}, {0, 2}, {-1, 2}},
                {{0, 0}, {-1, 0}, {-2, 0}, {-2, -1}},
                {{0, 0}, {0, -1}, {0, -2}, {1, -2}}
        }),
        L(new int[][][]{
                {{0, 0}, {1, 0}, {2, 0}, {0, 1}},
                {{0, 0}, {0, 1}, {0, 2}, {-1, 0}},
                {{0, 0}, {-1, 0}, {-2, 0}, {0, -1}},
                {{0, 0}, {0, -1}, {0, -2}, {1, 0}}
        }),
        S(new int[][][]{
                {{0, 0}, {1, 0}, {1, -1}, {2, -1}},
                {{0, 0}, {0, 1}, {1, 1}, {1, 2}},
                {{0, 0}, {-1, 0}, {-1, 1}, {-2, 1}},
                {{0, 0}, {0, -1}, {-1, -1}, {-1, -2}}
        }),
        Z(new int[][][]{
                {{0, 0}, {1, 0}, {1, 1}, {2, 1}},
                {{0, 0}, {0, 1}, {-1, 1}, {-1, 2}},
                {{0, 0}, {-1, 0}, {-1, -1}, {-2, -1}},
                {{0, 0}, {0, -1}, {1, -1}, {1, -2}}
        });

        final int[][][] shape;

        Tetromino(int[][][] shape) {
            this.shape = shape;
        }
    }

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            int[][] board = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    for (Tetromino tetromino : Tetromino.values()) {
                        int[][][] shape = tetromino.shape;

                        shapeLoop: for(int[][] point : shape) {
                            int sum = 0;
                            for (int[] delta : point) {
                                int nr = i + delta[0];
                                int nc = j + delta[1];

                                if (out(nr, nc))
                                    continue shapeLoop;

                                sum += board[nr][nc];
                            }

                            max = Math.max(max, sum);
                        }
                    }
                }
            }

            bw.write(max + "\n");

            bw.flush();
        }
    }

    private static boolean out(int r, int c) {
        return r < 0
            || c < 0
            || r >= N
            || c >= M;
    }
}
