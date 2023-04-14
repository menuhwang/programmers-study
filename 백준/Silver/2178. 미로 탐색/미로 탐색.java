import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{-1, 1, 0, 0};
    static boolean[][] map;
    static int[][] breadthMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int ROW = Integer.parseInt(st.nextToken());
        int COL = Integer.parseInt(st.nextToken());

        map = new boolean[ROW][COL];
        breadthMap = new int[ROW][COL];

        String line;
        for (int i = 0; i < ROW; i++) {
            line = br.readLine();
            for (int j = 0; j < COL; j++) {
                map[i][j] = line.charAt(j) == '1';
            }
        }

        bfs(0, 0);

        System.out.print(breadthMap[ROW-1][COL-1]);
    }

    private static void bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        breadthMap[row][col] = 1;
        int breadth = 2;


        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            map[pos[0]][pos[1]] = false;

            for (int i = 0; i < 4; i++) {
                int newRow = pos[0] + dy[i];
                int newCol = pos[1] + dx[i];

                if (isOnMap(newRow, newCol) && map[newRow][newCol]) {
                    breadthMap[newRow][newCol] = breadthMap[pos[0]][pos[1]] + 1;
                    map[newRow][newCol] = false;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }

    private static boolean isOnMap(int row, int col) {
        return row < map.length
                && col < map[0].length
                && row > -1
                && col > -1;
    }
}