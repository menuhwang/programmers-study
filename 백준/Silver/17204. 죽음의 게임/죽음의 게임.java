import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int BS = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N];
        int[] select = new int[N];

        for (int i = 0; i < N; i++) {
            select[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        int next = select[0];
        visited[0] = true;
        while (true) {
            count++;
            if (next == BS) {
                break;
            }
            if (visited[next]) {
                count = -1;
                break;
            }
            visited[next] = true;
            next = select[next];
        }
        System.out.println(count);
    }
}