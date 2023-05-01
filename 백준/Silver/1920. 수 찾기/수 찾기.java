import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            bw.write(set.contains(Integer.parseInt(st.nextToken())) ? "1\n" : "0\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}