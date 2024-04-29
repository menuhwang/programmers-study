import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int N = Integer.parseInt(br.readLine());
            int[][] history = new int[N + 1][6];
            StringTokenizer st;
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= 5; j++) {
                    history[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            boolean[][] check = new boolean[N + 1][N + 1];
            for (int grade = 1; grade <= 5; grade++) {
                for (int student1 = 1; student1 <= N; student1++) {
                    int clazz = history[student1][grade];
                    for (int student2 = 1; student2 <= N; student2++) {
                        if (history[student2][grade] == clazz) {
                            check[student1][student2] = true;
                        }
                    }
                }
            }

            int leader = 1;
            int leaderPoint = 0;
            for (int i = 1; i <= N; i++) {
                boolean[] row = check[i];
                int point = 0;
                for (boolean col : row) {
                    if (col)
                        point++;
                }

                if (point > leaderPoint) {
                    leaderPoint = point;
                    leader = i;
                }
            }

            bw.write(leader + "\n");

            bw.flush();
        }
    }
}
