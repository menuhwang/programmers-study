import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            long k = Long.parseLong(br.readLine());

            bw.write(recurse(k - 1) ? "1" : "0");
            bw.newLine();

            bw.flush();
        }
    }

    private static boolean recurse(long num) {
        if (num == 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }

        long div = 2L;
        while (div * 2 < num) {
            div *= 2;
        }

        return !recurse(num % div);
    }
}
