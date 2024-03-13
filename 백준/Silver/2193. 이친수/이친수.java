import java.io.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int N = Integer.parseInt(br.readLine());
            long[] memo = new long[N + 1];
            memo[1] = 1;
            for (int i = 2; i <= N; i++) {
                memo[i] = memo[i - 1] + memo[i - 2];
            }

            bw.write(memo[N] + "\n");

            bw.flush();
        }
    }
}
