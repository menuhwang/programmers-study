import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] map = new boolean[100][100];
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int x;
        int y;
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            for (int i = y; i < y + 10; i++) {
                for (int j = x; j < x + 10; j++) {
                    map[i][j] = true;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j]) result++;
            }
        }

        System.out.println(result);
    }
}