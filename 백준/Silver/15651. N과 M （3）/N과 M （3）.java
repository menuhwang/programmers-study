import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] array;

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[M];

        dfs(0);

        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int depth) throws IOException {
        if (depth == M) {
            for (int num : array) {
                bw.write(num + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            array[depth] = i;
            dfs(depth + 1);
        }
    }
}