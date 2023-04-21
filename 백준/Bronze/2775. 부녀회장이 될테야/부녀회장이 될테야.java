import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] apt;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());

            apt = new int[K + 1][N + 1];
            for (int ho = 0; ho <= N; ho++) apt[0][ho] = ho;

            for (int f = 1; f <= K; f++) {
                for (int h = 1; h <= N; h++) {
                    apt[f][h] = apt[f][h - 1] + apt[f - 1][h];
                }
            }

            System.out.println(apt[K][N]);
        }
    }
}