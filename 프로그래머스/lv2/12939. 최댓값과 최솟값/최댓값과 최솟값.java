class Solution {
    public String solution(String s) {
        String[] stringNums = s.split(" ");
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (String stringNum : stringNums) {
            int num = Integer.parseInt(stringNum);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        return String.format("%d %d", min, max);
    }
}