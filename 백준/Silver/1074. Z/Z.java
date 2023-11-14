import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int answer = 0;
            int pos;
            /*
            * pos:
            * 0     |     1
            *       |
            * ======|======
            *       |
            * 2     |     3
            * */
            while (N-- > 0) {
                pos = 2 * (r / (int) Math.pow(2, N)) + c / (int) Math.pow(2, N);
                answer +=  pos * (int) Math.pow(2, N * 2);
                r %= (int) Math.pow(2, N);
                c %= (int) Math.pow(2, N);
            }

            bw.write(answer + "\n");
            bw.flush();
        }
    }
}
