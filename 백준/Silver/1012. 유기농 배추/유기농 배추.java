import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] matrix;

    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            // 테스트 케이스
            int T = Integer.parseInt(br.readLine());

            // 가로
            int M;
            // 세로
            int N;
            // 배추
            int K;

            int answer;

            StringTokenizer st;
            for (int t = 0; t < T; t++) {
                st = new StringTokenizer(br.readLine());
                M = Integer.parseInt(st.nextToken());
                N = Integer.parseInt(st.nextToken());
                K = Integer.parseInt(st.nextToken());
                answer = 0;

                // init matrix
                matrix = new boolean[M][N];

                for (int k = 0; k < K; k++) {
                    st = new StringTokenizer(br.readLine());
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    matrix[x][y] = true;
                }
                //

                for (int i = 0; i < M; i++) {
                    for (int j = 0; j < N; j++) {
                        if (matrix[i][j]) {
                            answer++;
                            dfs(i, j);
                        }
                    }
                }

                bw.write(answer + "\n");
            }
            bw.flush();
        }
    }

    // 맵에 방문 처리
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    private static void dfs(int x, int y) {
        matrix[x][y] = false;

        int nx;
        int ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= matrix.length || ny >= matrix[0].length) // 맵의 밖
                continue;

            if (matrix[nx][ny])
                dfs(nx, ny);
        }
    }
}
