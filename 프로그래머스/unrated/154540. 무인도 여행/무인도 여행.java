import java.util.*;

class Solution {
    static int[][] map;
    static int sum;

    public int[] solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] row = maps[i].split("");
            for (int j = 0; j < m; j++) {
                String ch = row[j];
                if (ch.equals("X"))
                    map[i][j] = 0;
                else
                    map[i][j] = Integer.parseInt(ch);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (map[r][c] > 0) {
                    sum = 0;
                    dfs(r, c);
                    list.add(sum);
                }
            }
        }
        
        if (list.isEmpty()) return new int[]{-1};
        
        Collections.sort(list);

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    private void dfs(int r, int c) {
        sum += map[r][c];
        map[r][c] = 0;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (isOnMap(nr, nc) && map[nr][nc] > 0) {
                dfs(nr, nc);
            }
        }
    }

    private boolean isOnMap(int r, int c) {
        return r > -1
                && c > -1
                && r < map.length
                && c < map[0].length;
    }
}