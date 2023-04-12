import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] memo = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            memo[i] = Integer.parseInt(st.nextToken()) + memo[i - 1];
        }
        
        int e;
        int s;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            e = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            bw.write(memo[s] - memo[e - 1] + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}