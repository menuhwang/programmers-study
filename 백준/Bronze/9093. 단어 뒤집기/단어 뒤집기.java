import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        StringBuilder sb;
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                sb = new StringBuilder(st.nextToken());
                bw.write(sb.reverse().toString() + " ");
            }
            bw.write('\n');
        }

        bw.flush();
        br.close();
        bw.close();
    }
}