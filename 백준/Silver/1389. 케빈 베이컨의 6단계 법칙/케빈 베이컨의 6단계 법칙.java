import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {
        try (br; bw) {
            // 초기화
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] kevin = new int[N + 1][N + 1];
            for (int[] row : kevin) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                kevin[a][b] = 1;
                kevin[b][a] = 1;
            }
            // 초기화 end

            // 플로이드 워셜
            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= N; j++) {
                        if (kevin[i][k] == Integer.MAX_VALUE || kevin[k][j] == Integer.MAX_VALUE)
                            continue;
                        kevin[i][j] = Math.min(kevin[i][j], kevin[i][k] + kevin[k][j]);
                    }
                }
            }
            // 플로이드 워셜 end

            // 결과 도출
            int min = Integer.MAX_VALUE;
            int idx = -1;
            for (int i = 1; i <= N; i++) {
                int kevinNum = Arrays.stream(kevin[i]).sum();
                if (min > kevinNum) {
                    min = kevinNum;
                    idx = i;
                }
            }
            // 결과 도출 end

            bw.write(idx + "\n");

            bw.flush();
        }
    }
}
