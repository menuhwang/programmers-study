import java.util.*;

class Solution {
    public String solution(int a, int b) {
        String[] day = {"", "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        Calendar cal = new Calendar.Builder().setDate(2016, a - 1, b).build();
        return day[cal.get(Calendar.DAY_OF_WEEK)];
    }
}