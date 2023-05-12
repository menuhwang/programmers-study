package etc.dijkstra;

import java.io.*;
import java.util.*;

public class Solution1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        int[][] matrix = new int[V + 1][V + 1];
        for (int i = 0; i <= V; i++) {
            Arrays.fill(matrix[i], Integer.MAX_VALUE);
            matrix[i][i] = 0;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            matrix[a][b] = cost; // 단 방향
        }

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <=V; j++) {
                System.out.printf("%10d\t", matrix[i][j]);
            }
            System.out.println();
        }

        int[] distance = Arrays.copyOf(matrix[start], V + 1);
        boolean[] visited = new boolean[V + 1];
        visited[start] = true;

        for (int i = 0; i < V - 1; i++) {
            int index = getCloseNode(distance, visited);
            visited[index] = true;
            for (int j = 1; j <= V; j++) {
                if (matrix[index][j] == Integer.MAX_VALUE) continue;
                distance[j] = Math.min(distance[j], distance[index] + matrix[index][j]);
            }
        }

        System.out.println();

        for (int j = 1; j <=V; j++) {
            System.out.printf("%10d\t", distance[j]);
        }
    }

    private static int getCloseNode(int[] distance, boolean[] visited) {
        int index = 0;
        for (int i = 1; i < distance.length; i++) {
            if (!visited[i] && distance[i] < distance[index]) index = i;
        }
        return index;
    }
}

/*
6 20
1
1 2 2
2 1 2
1 3 5
3 1 5
1 4 1
4 1 1
2 3 3
3 2 3
2 4 2
4 2 2
3 4 3
4 3 3
3 5 1
5 3 1
3 6 5
6 3 5
4 5 1
5 4 1
5 6 2
6 5 2
*/

/*
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
*/