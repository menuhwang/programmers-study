import java.io.*;
import java.util.*;

public class Main {
    static boolean[] flag;
    static int[] relation;
    static boolean[][] matrix;

    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            StringTokenizer st;

            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int target1 = Integer.parseInt(st.nextToken());
            int target2 = Integer.parseInt(st.nextToken());

            int M = Integer.parseInt(br.readLine());

            // init flag and matrix
            flag = new boolean[N + 1];
            relation = new int[N + 1];
            matrix = new boolean[N + 1][N + 1];
            for (int m = 0; m < M; m++) {
                st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                matrix[p][c] = true;
                matrix[c][p] = true;
            }
            //

            // bfs
            int count = 1;

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(target1);
            flag[target1] = true;

            while (!queue.isEmpty()) {
                Queue<Integer> temp = new LinkedList<>();
                while (!queue.isEmpty()) {
                    int next = queue.poll();
                    for (int i = 1; i <= N; i++) {
                        if (matrix[next][i] && !flag[i]) {
                            temp.offer(i);
                            flag[i] = true;
                            relation[i] = count;
                        }
                    }
                }
                if (!temp.isEmpty()) count++;
                queue.addAll(temp);
            }

            bw.write((relation[target2] == 0 ? -1 : relation[target2]) + "");
            bw.flush();
        }
    }
}
