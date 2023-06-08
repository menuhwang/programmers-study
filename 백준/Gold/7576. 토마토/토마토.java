import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[][] box = new int[N][M];

        // input init
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // solution
        List<int[]> temp = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 1) temp.add(new int[]{i, j});
            }
        }

        int day = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.addAll(temp);
        temp.clear();

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = pos[0] + dy[i];
                int nx = pos[1] + dx[i];

                if (inBox(ny, nx) && box[ny][nx] == 0) {
                    box[ny][nx] = 1;
                    temp.add(new int[]{ny, nx});
                }
            }

            if (queue.isEmpty() && !temp.isEmpty()) {
                day++;
                queue.addAll(temp);
                temp.clear();
            }
        }

        loop:
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    day = -1;
                    break loop;
                }
            }
        }

        bw.write(day + "");
        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean inBox(int y, int x) {
        return y > -1
            && x > -1
            && y < N
            && x < M;
    }
}
