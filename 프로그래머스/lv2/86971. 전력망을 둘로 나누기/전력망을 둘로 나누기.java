import java.util.*;

class Solution {
    static boolean[][] matrix;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();
    
    public int solution(int n, int[][] wires) {
        matrix = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];
        for (int i = 0; i < wires.length; i++) {
            connect(wires[i]);
        }
        
        int answer = n;
        
        for (int i = 0; i < wires.length; i++) {
            disconnect(wires[i]);
            int count = bfs(wires[i][0]);
            answer = Math.min(Math.abs(n - 2 * count), answer);
            connect(wires[i]);
        }
        
        return answer;
    }
    
    private int bfs(int node) {
        int count = 1;
        queue.offer(node);
        visited[node] = true;
        while(!queue.isEmpty()) {
            boolean[] wire = matrix[queue.poll()];
            for (int i = 1; i < wire.length; i++) {
                if (wire[i] && !visited[i]) {
                    visited[i] = true;
                    count++;
                    queue.offer(i);
                }
            }
        }
        initVisited();
        return count;
    }
    
    private void initVisited() {
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
    }
    
    private void connect(int[] wire) {
        matrix[wire[0]][wire[1]] = true;
        matrix[wire[1]][wire[0]] = true;
    }
    
    private void disconnect(int[] wire) {
        matrix[wire[0]][wire[1]] = false;
        matrix[wire[1]][wire[0]] = false;
    }
}