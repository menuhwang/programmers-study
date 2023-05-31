import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int highest = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;
                highest = Math.max(highest, temp);
            }
        }

        int[] block = new int[highest + 1];
        int[] time = new int[highest + 1];

        // 500 * 500 * 256
        for (int b = 0; b < highest + 1; b++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int need = b - map[i][j];
                    block[b] += need;
                    time[b] += need  < 0 ? -2 * need : need;
                }
            }
            if (block[b] > B) {
                block[b] = Integer.MAX_VALUE;
                time[b] = Integer.MAX_VALUE;
            }
        }

        int answerHigh = -1;
        int answerTime = Integer.MAX_VALUE;
        for (int h = 0; h < highest + 1; h++) {
            if (time[h] <= answerTime) {
                answerTime = time[h];
                answerHigh = h;
            }
        }

        bw.write(answerTime + " " + answerHigh);
        bw.flush();
        br.close();
        bw.close();
    }
}