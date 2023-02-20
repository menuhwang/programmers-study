package level1.나머지가_1이_되는_수_찾기;

public class SolutionTest {
    private static final Solution solution = new Solution();

    public static void main(String[] args) {
        int NUM1 = 10;
        int EXPECTED1 = 3;

        int result = solution.solution(NUM1);

        assert result == EXPECTED1 : "case1 failed";

        System.out.println("case1 passed");
    }
}
