import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            boolean[][] dimension = new boolean[H][W];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < W; i++) {
                int h = Integer.parseInt(st.nextToken());
                for (int j = 1; j <= h; j++) {
                    dimension[H - j][i] = true;
                }
            }

            int count = 0;
            for (int i = 0; i < H; i++) {
                boolean closed = false;
                int temp = 0;
                for (boolean block : dimension[i]) {
                    if (closed && !block) {
                        temp++;
                    } else if (block) {
                        closed = true;
                        count += temp;
                        temp = 0;
                    }
                }
            }

            bw.write(count + "\n");

            bw.flush();
        }
    }
}
