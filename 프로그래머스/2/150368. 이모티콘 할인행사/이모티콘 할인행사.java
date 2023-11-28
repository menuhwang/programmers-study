class Solution {
    private int[] ratios;
    private int[] answer = new int[2];
    
    public int[] solution(int[][] users, int[] emoticons) {
        ratios = new int[emoticons.length];
        
        dfs(0, users, emoticons);
        
        return answer;
    }
    
    private void dfs(int depth, int[][] users, int[] emoticons) {
        if (depth == ratios.length) {
            batch(users, emoticons, ratios);
            return;
        }
        
        for (int i = 1; i <= 4; i++) {
            ratios[depth] = i * 10;
            dfs(depth + 1, users, emoticons);
        }
    }
    
    private void batch(int[][] users, int[] emoticons, int[] ratios) {
        int[] result = new int[]{0, 0};
        for (int[] user : users) {
            int[] userResult = job(user, emoticons, ratios);
            result[0] += userResult[0];
            result[1] += userResult[1];
        }
        
        if (answer[0] < result[0]) answer = result;
        if (answer[0] == result[0]) answer[1] = Math.max(answer[1], result[1]);
    }
    
    private int[] job(int[] user, int[] emoticons, int[] ratios) {
        int userStandardRatio = user[0];
        int userStandardPrice = user[1];
        int totalPrice = 0;
        
        int len = emoticons.length;
        for (int i = 0; i < len; i++) {
            int ratio = ratios[i];
            int emoticon = emoticons[i];
            
            if (userStandardRatio > ratio) continue;
            
            totalPrice += emoticon * (100 - ratio) / 100;
        }
        
        if (totalPrice < userStandardPrice) return new int[]{0, totalPrice};
        
        return new int[]{1, 0};
    }
}