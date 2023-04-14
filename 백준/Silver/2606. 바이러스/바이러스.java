import java.io.*;
import java.util.*;

public class Main {
    static boolean[] check;
    static List<Integer>[] list;
    static int count = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        
        check = new boolean[N + 1];
        list = new ArrayList[N + 1];
        for (int l = 1; l <= N; l++) list[l] = new ArrayList<>();
        
        StringTokenizer st;
        int node1;
        int node2;
        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine(), " ");
            node1 = Integer.parseInt(st.nextToken());
            node2 = Integer.parseInt(st.nextToken());
            
            list[node1].add(node2);
            list[node2].add(node1);
        }
        
        bfs(1);
        
        System.out.print(count);
        
        br.close();
    }
    
    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        check[node] = true;
        
        int currentNode;
        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            
            for (int connectedNode : list[currentNode]) {
                if (!check[connectedNode]) {
                    queue.offer(connectedNode);
                    check[connectedNode] = true;
                    count++;
                }
            }
        }
    }
}