class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        for (int i = 0; i + p.length() - 1 < t.length(); i++) {
            String subStr = t.substring(i, i + p.length());
            if (subStr.compareTo(p) < 1) answer++;
        }
        
        return answer;
    }
}