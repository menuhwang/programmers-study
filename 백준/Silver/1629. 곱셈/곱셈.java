import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static int A;
    private static int B;
    private static int C;

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            bw.write(recurse(A, B) + "\n");

            bw.flush();
        }
    }

    private static long recurse(int target, int n) {
        if (n == 1) return target % C;
        long result = recurse(target, n / 2) % C;
        if (n % 2 == 0)
            return result * result % C;
        else
            return result * result % C * target % C;
    }
}
