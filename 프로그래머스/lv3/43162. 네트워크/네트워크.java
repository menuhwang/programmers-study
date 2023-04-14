class Solution {
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(computers, i);
            }
        }
        return answer;
    }
    
    private void dfs(int[][] computers, int n) {
        visited[n] = true;
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i] && computers[n][i] == 1) {
                dfs(computers, i);
            }
        }
    }
}