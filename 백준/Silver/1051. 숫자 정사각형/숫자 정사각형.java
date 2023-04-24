import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        matrix = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }
        int len = 1;
        loop:
        for (int n = Math.min(N, M); n > 1; n--) {
            for (int i = 0; i <= N - n; i++) {
                for (int j = 0; j <= M - n; j++) {
                    if (isSquare(i, j, n)) {
                        len = n;
                        break loop;
                    }
                }
            }
        }

        System.out.println(len * len);
    }

    private static boolean isSquare(int i, int j, int n) {
        return matrix[i][j] == matrix[i][j + n - 1]
                && matrix[i][j] == matrix[i + n - 1][j + n - 1]
                && matrix[i][j] == matrix[i + n - 1][j];
    }
}