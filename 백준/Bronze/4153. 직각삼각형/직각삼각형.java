import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            String str = br.readLine();

            while (!str.equals("0 0 0")) {
                int[] num = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();

                int max = Math.max(num[0], num[1]);
                max = Math.max(max, num[2]);

                int sum = 0;
                for (int n : num) {
                    if (n != max) {
                        sum += n * n;
                    }
                }

                bw.write((max * max == sum) ? "right\n" : "wrong\n");

                str = br.readLine();
            }

            bw.flush();
        }
    }
}
