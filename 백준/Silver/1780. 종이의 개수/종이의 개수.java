import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int[][] paper;
    private static final int[] count = new int[3];

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int N = Integer.parseInt(br.readLine());
            paper = new int[N][N];

            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    paper[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            recurse(0, 0, N);

            for (int c : count) {
                bw.write(c + "\n");
            }

            bw.flush();
        }
    }

    private static void recurse(int r, int c, int length) {
        if (check(r, c, length)) {
            int i = paper[r][c] + 1;
            count[i] += 1;
            return;
        }

        int nextLength = length / 3;
        for (int i = r; i < r + length; i += nextLength) {
            for (int j = c; j < c + length; j += nextLength) {
                recurse(i, j, nextLength);
            }
        }
    }

    private static boolean check(int r, int c, int length) {
        for (int i = r; i < r + length; i++) {
            for (int j = c; j < c + length; j++) {
                if (paper[r][c] != paper[i][j])
                    return false;
            }
        }

        return true;
    }
}
