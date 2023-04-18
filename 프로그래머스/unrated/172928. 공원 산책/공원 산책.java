class Solution {
    boolean[][] map;
    public int[] solution(String[] park, String[] routes) {
        int x = 0;
        int y = 0;
        
        map = new boolean[park.length][park[0].length()];
        
        for(int i = 0; i < park.length; i++) {
            for(int j = 0; j < park[i].length(); j++) {
                char ch = park[i].charAt(j);
                if (ch == 'S') {
                    x = j;
                    y = i;
                }
                map[i][j] = ch != 'X';
            }
        }
        
        for (String route : routes) {
            String[] s = route.split(" ");
            String dir = s[0];
            int distance = Integer.parseInt(s[1]);
            int dx = x;
            int dy = y;

            switch (dir) {
                case "E":
                    dx += distance;
                    break;
                case "W":
                    dx -= distance;
                    break;
                case "S":
                    dy += distance;
                    break;
                case "N":
                    dy -= distance;
                    break;
                default:
                    break;
            }
            
            if (!isOnMap(dx, dy) || !isMoveable(x, y, dx, dy)) continue;
            x = dx;
            y = dy;
        }
        
        return new int[]{y, x};
    }
    
    private boolean isOnMap(int x, int y) {
        return x < map[0].length
            && y < map.length
            && x > -1
            && y > -1;
    }
    
    private boolean isMoveable(int x, int y, int dx, int dy) {
        for (int i = Math.min(x, dx); i <= Math.max(x, dx); i++) {
            if (!map[y][i]) return false;
        }
        
        for (int i = Math.min(y, dy); i <= Math.max(y, dy); i++) {
            if (!map[i][x]) return false;
        }
        
        return true;
    }
}