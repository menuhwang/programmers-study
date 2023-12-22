import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int TARGET = Integer.parseInt(st.nextToken());

            int invertNum = TARGET;
            int count = 1;
            while (invertNum > 0 && invertNum > N) {
                invertNum = invert(invertNum);
                count++;
            }

            bw.write((invertNum == N ? count : -1) + "\n");

            bw.flush();
        }
    }

    private static int invert(int num) {
        if (num % 2 == 0) {
            return num / 2;
        }
        if (num % 10 == 1) {
            return (num - 1) / 10;
        }
        return -1;
    }
}
