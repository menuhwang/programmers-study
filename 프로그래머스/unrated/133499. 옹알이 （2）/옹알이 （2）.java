import java.util.regex.*;

class Solution {
    public int solution(String[] babbling) {
        Pattern impossiblePattern = Pattern.compile("ayaaya|yeye|woowoo|mama");
        Pattern possiblePattern = Pattern.compile("^(aya|ye|woo|ma)*$");
        
        int answer = 0;
        
        for (int i = 0; i < babbling.length; i++) {
            Matcher impossible = impossiblePattern.matcher(babbling[i]);
            if (impossible.find()) continue;
            Matcher possible = possiblePattern.matcher(babbling[i]);
            if (possible.matches()) answer++;
        }
        
        return answer;
    }
}