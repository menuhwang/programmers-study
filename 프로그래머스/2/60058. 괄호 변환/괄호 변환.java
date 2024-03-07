class Solution {
    public String solution(String p) {
        return renew(p);
    }
    
    private String renew(String w) {
        if (w.isEmpty())
            return w;
        
        int idx = indexOfBalanced(w);
        String u = w.substring(0, idx);
        String v = w.substring(idx);
        
        if (validate(u)) {
            return u + renew(v);
        }
        
        return "(" + renew(v) + ")" + generate(u);
    }
    
    private int indexOfBalanced(String str) {
        int brackets = 0;
        int idx = 1;
        
        if (str.charAt(0) == '(')
            brackets += 1;
        else if (str.charAt(0) == ')')
            brackets -= 1;
        
        while (brackets != 0) {
            if (str.charAt(idx) == '(')
                brackets += 1;
            else if (str.charAt(idx) == ')')
                brackets -= 1;
            
            idx++;
        }
        
        return idx;
    }
    
    private boolean validate(String str) {
        int brackets = 0;
        
        for (char ch : str.toCharArray()) {
            if (brackets <= 0 && ch == ')')
                return false;
            
            if (ch == '(')
                brackets++;
            else if (ch == ')')
                brackets--;
        }
        
        return brackets == 0;
    }
    
    private String generate(String str) {
        StringBuilder sb = new StringBuilder(str);
        
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(')
                sb.setCharAt(i, ')');
            else if (sb.charAt(i) == ')')
                sb.setCharAt(i, '(');
        }
        
        return sb.substring(1, sb.length() - 1);
    }
}