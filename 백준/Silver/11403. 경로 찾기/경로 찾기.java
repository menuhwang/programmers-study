import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        // 방문 확인 배열
        boolean[] visited;
        // 큐
        Queue<Integer> queue;
        // 그래프
        boolean[][] matrix = new boolean[N][N];
        // 결과
        boolean[][] result = new boolean[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = st.nextToken().equals("1");
            }
        }

        // 0번 부터 N-1까지 반복
        for (int n = 0; n < N; n++) {
            // 방문 초기화
            visited = new boolean[N];
            // 큐 초기화
            queue = new LinkedList<>();
            // 큐에 n번 노드를 추가한다.
            queue.add(n);
            while (!queue.isEmpty()) {
                int v = queue.poll();
                // 이미 방문한 노드라면 패스한다.
                if (visited[v]) continue;

                // 방문 처리한다.
                visited[v] = true;

                // matrix v번째 줄을 가져온다.
                boolean[] matrixRow = matrix[v];
                boolean[] resultRow = result[n];
                for (int i = 0; i < N; i++) {
                    // result의 n번째 줄과 or 연산을 한다.
                    resultRow[i] |= matrixRow[i];
                    // matrix n번째 줄에서 다음 갈 수 있는 정점을 찾아 큐에 추가한다.
                    if (matrixRow[i]) queue.add(i);
                }
            }
            // 큐가 빌때까지 반복한다.
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(result[i][j] ? "1 " : "0 ");
            }
            bw.write("\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}