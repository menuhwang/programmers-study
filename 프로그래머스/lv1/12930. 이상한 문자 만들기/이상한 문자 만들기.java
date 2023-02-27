class Solution {
    public String solution(String s) {
        char[] ch = s.toCharArray();
                
        int index = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == ' ') {
                index = 0;
                continue;
            }
            ch[i] = index++ % 2 == 0 ? Character.toUpperCase(ch[i]) : Character.toLowerCase(ch[i]);
        }
        return new String(ch);
    }
}