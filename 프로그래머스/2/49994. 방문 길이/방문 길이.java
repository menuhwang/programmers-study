import java.util.*;

class Solution {
    Map<Pos, Set<Pos>> graph = new HashMap<>();
    private int x = 0;
    private int y = 0;
    
    public int solution(String dirs) {
        for (char dir : dirs.toCharArray()) {
            Pos from = new Pos(x, y);
            if(cmd(dir)) {
                Pos to = new Pos(x, y);
                // System.out.print("from: " + from + ", ");
                // System.out.println("to: " + to);
                if (Objects.isNull(graph.get(from))) graph.put(from, new HashSet<>());
                if (Objects.isNull(graph.get(to))) graph.put(to, new HashSet<>());
                
                graph.get(from).add(to);
                graph.get(to).add(from);
            }
        }
        int answer = 0;
        for (Set<Pos> value : graph.values())
            answer += value.size();
        
        return answer / 2;
    }
    
    // 움직이면 true, 움직이지 않으면 false
    private boolean cmd(char dir) {
        if (dir == 'U') {
            if (y >= 5) return false;
            y++;
        }
        if (dir == 'D') {
            if (y <= -5) return false;
            y--;
        } 
        if (dir == 'R') {
            if (x >= 5) return false;
            x++;
        } 
        if (dir == 'L') {
            if (x <= -5) return false;
            x--;
        }
        
        return true;
    }
    
    static class Pos {
        int x;
        int y;
        
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object o) {
            if (Objects.isNull(o)) return false;
            if (!(o instanceof Pos)) return false;
            Pos pos = (Pos) o;
            return this.x == pos.x
                && this.y == pos.y;
        }
        
        @Override
        public int hashCode() {
            int result = Integer.hashCode(x);
            result += 31 * Integer.hashCode(y);
            
            return result;
        }
        
        @Override
        public String toString() {
            return "(x: " + x + " y: " + y +")";
        }
    }
}