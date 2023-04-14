class Solution {
    public String solution(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        boolean flag = true;
        
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                flag = true;
                continue;
            }
            if (flag) {
                if (chars[i] >= 'a' && chars[i] <= 'z') {
                    chars[i] = (char) (chars[i] - 32);
                }
                flag = false;
            }
        }
        
        return String.valueOf(chars);
    }
}