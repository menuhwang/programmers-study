import java.util.*;

class Solution {
    List<List<Character>> block;
    int[][] CLOSED = {
        {0, 1},
        {1, 0},
        {1, 1}
    };
    char REMOVE = 'x';
    
    public int solution(int m, int n, String[] board) {
        block = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            block.add(new ArrayList<>());
        }
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                block.get(j).add(board[i].charAt(j));
            }
        }
        
        Queue<int[]> q = new LinkedList<>(); // [r, c];
        int answer = 0;
        do {
            while (!q.isEmpty()) {
                int[] pos = q.poll();
                block.get(pos[0]).set(pos[1], REMOVE);
                for (int i = 0; i < CLOSED.length; i++) {
                    int nr = pos[0] + CLOSED[i][0];
                    int nc = pos[1] + CLOSED[i][1];

                    block.get(nr).set(nc, REMOVE);
                }
            }

            for (int i = 0; i < n; i++) {
                Iterator<Character> it = block.get(i).iterator();
                while (it.hasNext()) {
                    if (it.next() == REMOVE) {
                        answer++;
                        it.remove();
                    }
                }
            }
            
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < m - 1; j++) {
                    boolean flag = true;
                    for (int k = 0; k < CLOSED.length; k++) {
                        int r = i + CLOSED[k][0];
                        int c = j + CLOSED[k][1];
                        
                        if (!isAccessable(r, c)) {
                            flag = false;
                            break;
                        }
                        
                        flag &= block.get(i).get(j) == block.get(r).get(c);
                    }
                    if (flag) {
                        q.add(new int[]{i, j});
                    }
                }
            }
        } while (!q.isEmpty());
        
        return answer;
    }
    
    private boolean isAccessable(int r, int c) {
        return r > -1
            && c > -1
            && r < block.size()
            && c < block.get(r).size();
    }
}