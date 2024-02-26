import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        boolean isZero = true;
        for (int num : numbers)
            isZero &= num == 0;
        
        if (isZero)
            return "0";
        
        
        String[] stringArr = Arrays.stream(numbers).mapToObj(String::valueOf).sorted(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.charAt(0) == s2.charAt(0)) {
                    int n1 = Integer.parseInt(s1 + s2);
                    int n2 = Integer.parseInt(s2 + s1);
                    return n2 - n1;
                }
                return s2.charAt(0) - s1.charAt(0);
            }
        }).toArray(String[]::new);
        return String.join("", stringArr);
    }
}