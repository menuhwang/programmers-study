class Solution {
    static int[][] DUNGEONS;
    static boolean[] CHECK;
    static int ANSWER = 0;
    
    public int solution(int k, int[][] dungeons) {
        CHECK = new boolean[dungeons.length];
        DUNGEONS = dungeons;
        
        dfs(k, 0);
        
        return ANSWER;
    }
    
    private void dfs(int k, int count) {
        ANSWER = Math.max(ANSWER, count);
        
        for (int i = 0; i < DUNGEONS.length; i++) {
            if (!CHECK[i] && k >= DUNGEONS[i][0]) {
                CHECK[i] = true;
                dfs(k - DUNGEONS[i][1], count + 1);
                CHECK[i] = false;
            }
        }
    }
}