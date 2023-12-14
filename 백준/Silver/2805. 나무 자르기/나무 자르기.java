import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int from = 0;
            int to = 0;
            
            st = new StringTokenizer(br.readLine());
            int[] trees = new int[N];
            for (int i = 0; i < N; i++) {
                int tree = Integer.parseInt(st.nextToken());
                trees[i] = tree;
                to = Math.max(to, tree);
            }

            int result = 0;

            while (from <= to) {
                long high = 0;

                int mid = (from + to) / 2;
                for (int tree : trees) {
                    if (tree > mid)
                        high += tree - mid;
                }

                if (high >= M) {
                    from = mid + 1;
                    result = Math.max(result, mid);
                } else {
                    to = mid - 1;
                }
            }

            bw.write(result + "\n");

            bw.flush();
        }
    }
}
