import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            char[] S = new char[M];
            int num = br.read(S);

            assert (M == num);

            int[] dp = new int[M];
            int block = 2 * N + 1;
            for (int i = block - 1; i < M; i++) {
                dp[i] = io(S, i - block + 1, block) ? dp[i - 1] + 1 : dp[i - 1];
            }

            bw.write(dp[M - 1] + "\n");

            bw.flush();
        }
    }

    private static boolean io(char[] chars, int start, int block) {
        if (chars[start] == 'O')
            return false;

        for (int i = start; i < start + block - 1; i++) {
            if (chars[i] == chars[i + 1])
                return false;
        }

        return true;
    }
}
