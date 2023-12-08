import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int N = Integer.parseInt(br.readLine());

            int max = 0;
            float sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int grade = Integer.parseInt(st.nextToken());
                max = Math.max(max, grade);
                sum += grade;
            }

            bw.write(sum / max / N * 100 + "\n");

            bw.flush();
        }
    }
}
