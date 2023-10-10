import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {

        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            int[][] matrix1;
            int[][] matrix2;

            StringTokenizer st;

            // N, M
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // init matrix
            matrix1 = new int[N][M];
            matrix2 = new int[N][M];

            // matrix1
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    matrix1[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // matrix2
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    matrix2[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // output
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    bw.write((matrix1[i][j] + matrix2[i][j]) + " ");
                }
                bw.write("\n");
            }

            bw.flush();
        }

    }
}
