package level1.자연수_뒤집어_배열로_만들기;

import java.util.Arrays;

public class SolutionTest {
    private static final Solution solution = new Solution();

    public static void main(String[] args) {
        long case1 = 12_341_234_123L;
        int[] EXPECTED = new int[]{3, 2, 1, 4, 3, 2, 1, 4, 3, 2, 1};

        assert Arrays.equals(solution.solution(case1), EXPECTED) : "solution1 failed";
        assert Arrays.equals(solution.solution2(case1), EXPECTED) : "solution2 failed";

        System.out.println("case1 passed!");
    }
}
