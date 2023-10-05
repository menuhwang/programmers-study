import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        int half = nums.length / 2;

        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);

        return Math.min(half, set.size());
    }
}