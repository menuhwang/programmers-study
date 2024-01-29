import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            int start = 0;
            int end = L - 1;
            int sum = sum(start, end);
            int minLen = Integer.MAX_VALUE;
            int[] answer = new int[2];
            while (end - start + 1 >= L) {
                while (sum < N) {
                    sum += ++end;
                }
                if (sum == N && end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    answer[0] = start;
                    answer[1] = end;
                }
                sum -= start++;
            }

            if (minLen <= 100) {
                for (int i = answer[0]; i <= answer[1]; i++) {
                    bw.write(i + " ");
                }
                bw.newLine();
            } else {
                bw.write(-1 + "\n");
            }

            bw.flush();
        }
    }

    private static int sum(int s, int e) {
        int result = 0;
        for (int i = s; i <= e; i++) {
            result += i;
        }

        return result;
    }
}
