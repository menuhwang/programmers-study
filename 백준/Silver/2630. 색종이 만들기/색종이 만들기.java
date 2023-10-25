import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static boolean[][] PAPER;
    private static int WHITE = 0;
    private static int BLUE = 0;

    public static void main(String[] args) throws IOException {

        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            int N = Integer.parseInt(br.readLine());
            PAPER = new boolean[N][N];

            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    PAPER[i][j] = "1".equals(st.nextToken());
                }
            }

            recursive(0, 0, N);

            bw.write(WHITE + "\n");
            bw.write(BLUE + "\n");

            bw.flush();
        }
    }

    private static void recursive(int row, int col, int len) {
        if (isComplete(row, col, len)) {
            if (PAPER[row][col])
                BLUE++;
            else
                WHITE++;
            return;
        }

        int newLen = len / 2;
        recursive(row, col, newLen);
        recursive(row, col + newLen, newLen);
        recursive(row + newLen, col, newLen);
        recursive(row + newLen, col + newLen, newLen);
    }

    // 완전한 색인지 판별
    private static boolean isComplete(int row, int col, int len) {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (PAPER[row][col] ^ PAPER[row + i][col + j])
                    return false;
            }
        }

        return true;
    }
}
