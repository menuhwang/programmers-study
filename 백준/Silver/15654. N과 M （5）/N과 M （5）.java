import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static int M;
    private static int[] numbers;
    private static int[] array;
    private static boolean[] flag;

    public static void main(String[] args) throws IOException {
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            numbers = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(numbers);

            flag = new boolean[N];

            array = new int[M];

            permutation(0);

        } finally {
            br.close();
            bw.close();
        }
    }

    private static void permutation(int depth) throws IOException {
        if (array.length == depth) {
            for (int num : array) {
                bw.write(num + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (flag[i]) continue;

            array[depth] = numbers[i];
            flag[i] = true;
            permutation(depth + 1);
            flag[i] = false;
        }
    }
}
