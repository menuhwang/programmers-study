import java.io.*;
import java.util.*;

public class Main {
    private static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // input init
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N == K) {
            bw.write(0 + "");
            bw.flush();
            br.close();
            bw.close();
            return;
        }

        // solution
        Queue<Integer> queue = new LinkedList<>();
        LinkedHashSet<Integer> temp = new LinkedHashSet<>();
        queue.add(N);

        int second = 1;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            visited[num] = true;
            int a = num - 1;
            int b = num + 1;
            int c = 2 * num;

            if (valid(a)) temp.add(a);
            if (valid(b)) temp.add(b);
            if (valid(c)) temp.add(c);

            if (a == K || b == K || c == K) {
                break;
            }

            if (queue.isEmpty()) {
                second++;
                queue.addAll(temp);
                temp.clear();
            }
        }

        bw.write(second + "");
        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean valid(int pos) {
        return pos >= 0 && pos <= 100000 && !visited[pos];
    }
}
