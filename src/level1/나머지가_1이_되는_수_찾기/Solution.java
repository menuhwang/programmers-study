package level1.나머지가_1이_되는_수_찾기;

import java.util.*;

public class Solution {
    public int solution(int n) {
        // n - 1 의 약수 중 1을 제외한 가장 작은 수?
        List<Integer> divisor = new ArrayList<>();
        for (int i = 1; i * i <= n - 1; i++) {
            if ((n - 1) % i == 0) {
                divisor.add(i);
                divisor.add(n - 1 / i);
            }
        }
        return divisor.stream()
                .filter(num -> num > 1)
                .min(Comparator.comparingInt(n2 -> n2))
                .get();
    }
}
