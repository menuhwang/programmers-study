import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int R;
    static PriorityQueue<Integer>[] list;
    static int[] index;
    static int num = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // matrix 크기
        M = Integer.parseInt(st.nextToken()); // 간선 개수 : 인접행렬을 초기화할 횟수
        R = Integer.parseInt(st.nextToken()); // 시작 노드

        list = new PriorityQueue[N + 1];
        index = new int[N + 1];

        // list 초기화
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (list[x] == null) list[x] = new PriorityQueue<>();
            if (list[y] == null) list[y] = new PriorityQueue<>();
            list[x].offer(y);
            list[y].offer(x);
        }

        dfs(R);

        for(int i = 1; i < index.length; i++) {
            bw.write(index[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void dfs(int start) {
        // 방문 확인
        if (index[start] > 0) return;
        // 순서 표기
        index[start] = num++;

        while (list[start] != null && !list[start].isEmpty()) dfs(list[start].poll());
    }
}
