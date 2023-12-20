import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            while (N > 0 && M > 0) {
                int[] cd = new int[N];
                for (int i = 0; i < N; i++) {
                    cd[i] = Integer.parseInt(br.readLine());
                }

                int result = 0;
                for (int i = 0; i < M; i++) {
                    int target = Integer.parseInt(br.readLine());
                    int begin = 0;
                    int end = N - 1;
                    while (begin <= end) {
                        int mid = (begin + end) / 2;
                        if (cd[mid] < target) {
                            begin = mid + 1;
                        } else if (cd[mid] > target) {
                            end = mid - 1;
                        } else {
                            result++;
                            break;
                        }
                    }
                }

                bw.write(result + "\n");
                st = new StringTokenizer(br.readLine());
                N = Integer.parseInt(st.nextToken());
                M = Integer.parseInt(st.nextToken());
            }


            bw.flush();
        }
    }
}
