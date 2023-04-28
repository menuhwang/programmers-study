import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map = new int[5][5];

    static int[] DELTA_R = {-1, 1, 0, 0}; //상 하 좌 우
    static int[] DELTA_C = {0, 0, -1, 1}; //상 하 좌 우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(dfs(0, r, c, 0));
    }

    private static int dfs(int depth, int r, int c, int apple) {
        int temp = map[r][c]; // 기존 값 보존
        int nApple = temp == 1 ? apple + 1 : apple; // 사과 발견 처리

        if (depth > 3) return 0;
        if (nApple >= 2) return 1;

        // 방문 처리
        map[r][c] = -1;

        int result = 0;

        for (int i = 0; i < 4; i++) {
            int nr = r + DELTA_R[i];
            int nc = c + DELTA_C[i];

            if (!onMap(nr, nc) || map[nr][nc] == -1) continue;

            result = Math.max(
                    dfs(depth + 1, nr, nc, nApple),
                    result
            );
        }

        map[r][c] = temp;

        return result;
    }

    private static boolean onMap(int r, int c) {
        return r > -1
                && c > -1
                && r < map.length
                && c < map[r].length;
    }
}