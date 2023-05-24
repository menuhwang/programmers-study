import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while (N > 0) {
            int mod = N % B;
            N /= B;
            if (mod < 10) sb.append(mod);
            else sb.append((char) ('A' + mod - 10));
        }
        sb.reverse();
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}