import java.io.*;

class Main {
    private static char[][] photo;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            int N= Integer.parseInt(br.readLine());
            photo = new char[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                char[] row = br.readLine().toCharArray();
                System.arraycopy(row, 0, photo[i], 0, N);
            }

            int section = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) continue;
                    section++;
                    dfs(i, j);
                }
            }

            visited = new boolean[N][N];
            int partialColorSection = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) continue;
                    partialColorSection++;
                    partialColorDfs(i, j);
                }
            }

            bw.write(section + " ");
            bw.write(partialColorSection + "\n");
        }
    }

    private static int DIRECTION = 4;
    // delta row
    // 상하좌우
    private static int[] dr = {-1, 1, 0, 0};
    // delta col
    // 상하좌우
    private static int[] dc = {0, 0, -1, 1};

    private static void dfs(int row, int col) {
        visited[row][col] = true;
        for (int i = 0; i < DIRECTION; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (!onMatrix(newRow, newCol) || visited[newRow][newCol])
                continue;

            if (photo[row][col] == photo[newRow][newCol])
                dfs(newRow, newCol);
        }
    }

    private static void partialColorDfs(int row, int col) {
        visited[row][col] = true;
        for (int i = 0; i < DIRECTION; i++) {
            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (!onMatrix(newRow, newCol) || visited[newRow][newCol])
                continue;

            if (isPartialColor(photo[row][col], photo[newRow][newCol]))
                partialColorDfs(newRow, newCol);
        }
    }

    private static boolean onMatrix(int row, int col) {
        return row > -1
                && col > -1
                && row < photo.length
                && col < photo[0].length;
    }

    private static boolean isPartialColor(char c1, char c2) {
        if (c1 == c2)
            return true;
        if (c1 == 'R' || c1 =='G')
            return c2 == 'R' || c2 == 'G';

        return false;
    }
}
