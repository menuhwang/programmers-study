import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int N;
    private static int M;
    private static boolean[][] paper;

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            paper = new boolean[N][M];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int leftBottomCol = Integer.parseInt(st.nextToken());
                int leftBottomRow = Integer.parseInt(st.nextToken());
                int rightTopCol = Integer.parseInt(st.nextToken());
                int rightTopRow = Integer.parseInt(st.nextToken());

                for (int j = leftBottomRow; j < rightTopRow; j++) {
                    for (int k = leftBottomCol; k < rightTopCol; k++) {
                        paper[j][k] = true;
                    }
                }
            }

            int section = 0;
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!paper[i][j]) {
                        result.add(dfs(i, j));
                        section++;
                    }
                }
            }

            result.sort(Comparator.naturalOrder());

            bw.write(section + "\n");
            for (int n : result) {
                bw.write(n + " ");
            }

            bw.flush();
        }
    }

    private static final int[][] DIRECTIONS = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    private static int dfs(int r, int c) {
        int result = 1;
        paper[r][c] = true;
        for (int[] dir : DIRECTIONS) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (isOut(nr, nc) || paper[nr][nc])
                continue;

            result += dfs(nr, nc);
        }

        return result;
    }

    private static boolean isOut(int r, int c) {
        return r < 0
            || c < 0
            || r >= N
            || c >= M;
    }
}
