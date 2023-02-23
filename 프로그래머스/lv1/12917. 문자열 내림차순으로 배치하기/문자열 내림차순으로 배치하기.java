import java.util.*;

class Solution {
    public String solution(String s) {
        char[] sorted = s.toCharArray();
        Arrays.sort(sorted);
        StringBuilder sb = new StringBuilder();
        for (int i = sorted.length - 1; i > -1; i--) {
            sb.append(sorted[i]);
        }
        return sb.toString();
    }
}