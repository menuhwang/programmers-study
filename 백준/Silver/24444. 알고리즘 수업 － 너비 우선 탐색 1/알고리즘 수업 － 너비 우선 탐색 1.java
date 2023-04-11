import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int R;
    static Queue<Integer> queue = new LinkedList<>();
    static PriorityQueue<Integer>[] list;
    static int[] index;
    static int num = 1;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        list = new PriorityQueue[N + 1];
        index = new int[N + 1];
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            if (list[x] == null) list[x] = new PriorityQueue<>();
            if (list[y] == null) list[y] = new PriorityQueue<>();
            
            list[x].offer(y);
            list[y].offer(x);
        }
        
        bfs(R);
        
        while(!queue.isEmpty()) bfs(queue.poll());
        
        for (int i = 1; i < index.length; i++) bw.write(index[i] + "\n");
        
        bw.flush();
        br.close();
        bw.close();
    }
    
    private static void bfs(int node) {
        if (index[node] > 0) return;
        index[node] = num++;
        
        while(list[node] != null && !list[node].isEmpty()) queue.offer(list[node].poll());
    }
}