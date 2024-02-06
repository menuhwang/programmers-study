import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int buy = 0;

            int bottle = getBottle(N);
            while (bottle > K) {
                buy++;
                N += 1;
                bottle = getBottle(N);
            }

            bw.write(buy + "\n");

            bw.flush();
        }
    }

    private static int getBottle(int water) {
        int result = 0;
        while (water > 0) {
            result += water % 2;
            water /= 2;
        }

        return result;
    }
}
