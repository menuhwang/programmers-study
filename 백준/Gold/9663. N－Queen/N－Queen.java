import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static int[][] board;
    private static int N;
    private static int count;

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            N = Integer.parseInt(br.readLine());
            board = new int[N][N];
            count = 0;

            for (int i = 0; i < N; i++) {
                queen(0, i, 1);
            }

            bw.write(count + "\n");

            bw.flush();
        }
    }

    private static void queen(int row, int col, int n) {
        if (row > N) return;
        if (n >= N) {
            count++;
            return;
        }

        board[row][col] = -1;

        maskVertically(row, col);
        maskHorizontally(row, col);
        maskDiagonally(row, col);

        for (int i = 0; i < N; i++) {
            if (isBlank(row + 1, i)) {
                queen(row + 1, i, n + 1);
            }
        }

        unmaskVertically(row, col);
        unmaskHorizontally(row, col);
        unmaskDiagonally(row, col);

        board[row][col] = 0;
    }

    private static void maskVertically(int row, int col) {
        for (int i = 0; i < N; i++) {
            if (board[i][col] > -1) board[i][col]++;
        }
    }

    private static void unmaskVertically(int row, int col) {
        for (int i = 0; i < N; i++) {
            if (board[i][col] > -1) board[i][col]--;
        }
    }

    private static void maskHorizontally(int row, int col) {
        for (int i = 0; i < N; i++) {
            if (board[row][i] > -1) board[row][i]++;
        }
    }

    private static void unmaskHorizontally(int row, int col) {
        for (int i = 0; i < N; i++) {
            if (board[row][i] > -1) board[row][i]--;
        }
    }

    private static void maskDiagonally(int row, int col) {
        // 대각선1
        for (int i = 0; i < N; i++) {
            int nr = row - i;
            int nc = col + i;
            if (outOfBoard(nr, nc)) break;
            if (board[nr][nc] > -1) board[nr][nc]++;
        }
        // 대각선2
        for (int i = 0; i < N; i++) {
            int nr = row - i;
            int nc = col - i;
            if (outOfBoard(nr, nc)) break;
            if (board[nr][nc] > -1) board[nr][nc]++;
        }
        // 대각선3
        for (int i = 0; i < N; i++) {
            int nr = row + i;
            int nc = col - i;
            if (outOfBoard(nr, nc)) break;
            if (board[nr][nc] > -1) board[nr][nc]++;
        }
        // 대각선4
        for (int i = 0; i < N; i++) {
            int nr = row + i;
            int nc = col + i;
            if (outOfBoard(nr, nc)) break;
            if (board[nr][nc] > -1) board[nr][nc]++;
        }
    }

    private static void unmaskDiagonally(int row, int col) {
        // 대각선1
        for (int i = 0; i < N; i++) {
            int nr = row - i;
            int nc = col + i;
            if (outOfBoard(nr, nc)) break;
            if (board[nr][nc] > -1) board[nr][nc]--;
        }
        // 대각선2
        for (int i = 0; i < N; i++) {
            int nr = row - i;
            int nc = col - i;
            if (outOfBoard(nr, nc)) break;
            if (board[nr][nc] > -1) board[nr][nc]--;
        }
        // 대각선3
        for (int i = 0; i < N; i++) {
            int nr = row + i;
            int nc = col - i;
            if (outOfBoard(nr, nc)) break;
            if (board[nr][nc] > -1) board[nr][nc]--;
        }
        // 대각선4
        for (int i = 0; i < N; i++) {
            int nr = row + i;
            int nc = col + i;
            if (outOfBoard(nr, nc)) break;
            if (board[nr][nc] > -1) board[nr][nc]--;
        }
    }

    private static boolean outOfBoard(int row, int col) {
        return row < 0
                || col < 0
                || row >= N
                || col >= N;
    }

    private static boolean isBlank(int row, int col) {
        return board[row][col] == 0;
    }
}
