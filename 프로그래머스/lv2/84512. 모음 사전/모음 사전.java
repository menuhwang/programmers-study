class Solution {
    public int solution(String word) {
        dfs(0,  "", word);
        return answer;
    }

    char[] alphabet = {'A', 'E', 'I', 'O', 'U'};

    int count = 0;
    int answer = -1;

    private void dfs(int depth, String prefix, String target) {
        if (prefix.equals(target))
            answer = count;
        if (depth == 5) return;
        for (char ch : alphabet) {
            count++;
            dfs(depth + 1, prefix + ch, target);
        }
    }
}