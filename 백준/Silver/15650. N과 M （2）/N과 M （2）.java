import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] array;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            array = new int[M];

            permutation(1, 0);

            bw.flush();

        } finally {
            br.close();
            bw.close();
        }

    }

    private static void permutation(int n, int depth) throws IOException {
        if (depth == M) {
            for (int num : array)
                bw.write(num + " ");

            bw.write("\n");
            return;
        }

        for (int i = n; i <= N; i++) {
            array[depth] = i;
            permutation(i + 1, depth + 1);
        }
    }
}
