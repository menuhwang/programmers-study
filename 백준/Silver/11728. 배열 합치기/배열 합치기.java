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

            int[] arr1 = new int[N];
            int[] arr2 = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr1[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                arr2[i] = Integer.parseInt(st.nextToken());
            }

            int[] result = new int[N + M];
            int cursor1 = 0;
            int cursor2 = 0;
            int index = 0;
            while (cursor1 < N || cursor2 < M) {
                if (cursor1 == N) {
                    result[index++] = arr2[cursor2++];
                } else if (cursor2 == M) {
                    result[index++] = arr1[cursor1++];
                } else {
                    int num;
                    if (arr1[cursor1] <= arr2[cursor2]) {
                        num = arr1[cursor1++];
                    } else {
                        num = arr2[cursor2++];
                    }
                    result[index++] = num;
                }
            }

            for (int num : result)
                bw.write(num + " ");

            bw.flush();
        }
    }
}
