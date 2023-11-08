import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final TreeMap<Integer, Integer> numbers = new TreeMap<>();
    private static int N;
    private static int M;
    private static int[] array;

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            array = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                numbers.put(num, numbers.getOrDefault(num, 0) + 1);
            }

            permutation(0, 0);

            bw.flush();
        }
    }

    private static void permutation(int depth, int prev) throws IOException {
        if (depth == M) {
            for (int num : array)
                bw.write(num + " ");
            bw.write("\n");
            return;
        }

        for (int num : numbers.keySet()) {
            if (numbers.get(num) < 1) continue;
            if (prev > num) continue;

            array[depth] = num;
            numbers.put(num, numbers.get(num) - 1);
            permutation(depth + 1, num);
            numbers.put(num, numbers.get(num) + 1);
        }
    }
}
