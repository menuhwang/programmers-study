import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] map = new int[n + 1][n + 1];
        for (int[] row : map)
            Arrays.fill(row, Integer.MAX_VALUE);
        for (int i = 1; i <= n; i++)
            map[i][i] = 0;
        
        for (int[] fare : fares) {
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];
            
            map[from][to] = cost;
            map[to][from] = cost;
        }
        
        int answer = Integer.MAX_VALUE;
        int[] commonCost = dijkstra(map, s);
        int[] aCost = dijkstra(map, a);
        int[] bCost = dijkstra(map, b);
        
        for (int i = 1; i <= n; i++) {
            int temp;
            if (commonCost[i] == Integer.MAX_VALUE
               || aCost[i] == Integer.MAX_VALUE
               || bCost[i] == Integer.MAX_VALUE) {
                temp = Integer.MAX_VALUE;
            } else {
                temp = commonCost[i] + aCost[i] + bCost[i];
            }
            answer = Math.min(answer, temp);
        }
        
        return answer;
    }
    
    private int[] dijkstra(int[][] map, int position) {
        int[] copy = Arrays.copyOf(map[position], map[position].length);
        boolean[] flag = new boolean[copy.length];
        flag[0] = true;
        
        int index = getMinCostIndex(copy, flag);
        while (index > -1) {
            flag[index] = true;
            for (int i = 0; i < map[index].length; i++) {
                int fare = map[index][i];
                if (fare == Integer.MAX_VALUE)
                    continue;
                copy[i] = Math.min(copy[i], copy[index] + fare);
            }
            index = getMinCostIndex(copy, flag);
        }
        
        return copy;
    }
    
    private int getMinCostIndex(int[] cost, boolean[] flag) {
        int index = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < cost.length; i++) {
            if (flag[i]) continue;
            if (min > cost[i]) {
                index = i;
                min = cost[i];
            }
        }
        
        return index;
    }
}