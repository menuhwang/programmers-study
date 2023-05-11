import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int V;
        int E;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            char[] group = new char[V + 1];
            List<List<Integer>> matrix = new ArrayList<>();
            for (int i = 0; i <= V; i++) matrix.add(new ArrayList<>());

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                matrix.get(a).add(b);
                matrix.get(b).add(a);
            }

            String result = "YES";
            Queue<Integer> queue = new LinkedList<>();

            for (int i = 1; i <= V; i++) {
                if (group[i] != '\0') continue;

                char marker = 'A';
                group[i] = marker;
                queue.add(i);

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    if (group[node] != '\0') {
                        List<Integer> nearNodes = matrix.get(node);
                        marker = group[node] == 'A' ? 'B' : 'A';
                        for (int near : nearNodes) {
                            if (group[near] == '\0') {
                                group[near] = marker;
                                queue.add(near);
                            } else if (group[near] != marker) {
                                result = "NO";
                                queue.clear();
                                break;
                            }
                        }
                    }
                }
            }

            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}