class Solution {
    public int solution(String s) {
        return split(s);
    }
    
    public int split(String s) {
        if (s.length() == 0) return 0;
        
        int same = 1;
        int diff = 0;
        char ch = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (ch == s.charAt(i)) same++;
            else diff ++;
            if (same == diff) return split(s.substring(i + 1)) + 1;
        }
        
        return 1;
    }
}