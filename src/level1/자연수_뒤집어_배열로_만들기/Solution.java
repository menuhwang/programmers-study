package level1.자연수_뒤집어_배열로_만들기;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(long n) {
        List<Integer> digits = new ArrayList<>();
        while (n > 0) {
            digits.add((int) (n % 10)); // 형 변환 주의
            n = n / 10;
        }
        return digits.stream().mapToInt(num -> num).toArray();
    }

    public int[] solution2(long n) {
        List<Integer> digits = new ArrayList<>();
        while (n > 0) {
            digits.add((int) n % 10); // 형 변환 주의
            n = n / 10;
        }
        return digits.stream().mapToInt(num -> num).toArray();
    }
}