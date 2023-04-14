import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] visited;
    static boolean[][] matrix;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        
        matrix = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1];
        
        int n1;
        int n2;
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine(), " ");
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());
            
            matrix[n1][n2] = true;
            matrix[n2][n1] = true;
        }
        
        dfs(V);
        
        Arrays.fill(visited, false);
        sb.append("\n");
        
        bfs(V);
        
        System.out.print(sb.toString());
        
        br.close();
    }
    
    private static void dfs(int node) {
        visited[node] = true;
        sb.append(node + " ");
        for (int i = 1; i <= N; i++) {
            if (matrix[node][i] && !visited[i]) {
                dfs(i);
            }
        }
    }
    
    private static void bfs(int node) {
        visited[node] = true;
        sb.append(node + " ");
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        
        int n;
        while (!queue.isEmpty()) {
            n = queue.poll();
            for (int i = 1; i <= N; i++) {
                if (matrix[n][i] && !visited[i]) {
                    visited[i] = true;
                    sb.append(i + " ");
                    queue.offer(i);
                }
            }
        }
    }
}