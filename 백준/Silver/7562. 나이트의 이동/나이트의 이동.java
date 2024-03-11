import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static final int[][] KNIGHT = {
            {-1, -2},
            {-2, -1},
            {-2, 1},
            {-1, 2},
            {1, 2},
            {2, 1},
            {2, -1},
            {1, -2}
    };

    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int T = Integer.parseInt(br.readLine());

            for (int t = 0; t < T; t++) {
                int L = Integer.parseInt(br.readLine());
                visited = new boolean[L][L];
                int[] start = new int[2];
                int[] target = new int[2];
                StringTokenizer st = new StringTokenizer(br.readLine());
                start[0] = Integer.parseInt(st.nextToken());
                start[1] = Integer.parseInt(st.nextToken());

                st = new StringTokenizer(br.readLine());
                target[0] = Integer.parseInt(st.nextToken());
                target[1] = Integer.parseInt(st.nextToken());

                Queue<int[]> q = new LinkedList<>();
                q.add(start);
                int result = 0;

                loop: while (!q.isEmpty()) {
                    int size = q.size();
                    for (int i = 0; i < size; i++) {
                        int[] current = q.poll();
                        if (target[0] == current[0] && target[1] == current[1]) {
                            break loop;
                        }
                        for (int[] delta : KNIGHT) {
                            int nr = current[0] + delta[0];
                            int nc = current[1] + delta[1];
                            if (isOnBoard(L, nr, nc) && !visited[nr][nc]) {
                                visited[nr][nc] = true;
                                q.add(new int[]{nr, nc});
                            }
                        }
                    }
                    result++;
                }

                bw.write(result + "\n");
            }

            bw.flush();
        }
    }

    private static boolean isOnBoard(int boardSize, int r, int c) {
        return r > -1
            && c > -1
            && r < boardSize
            && c < boardSize;
    }
}
