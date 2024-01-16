import java.util.Arrays;

class Solution {
    public int[] solution(int[] origin, int k) {
        int[] sequence = Arrays.copyOf(origin, origin.length + 1);
        
        int begin = 0;
        int end = 0;
        
        int[] answer = new int[]{begin, end};
        int last = sequence.length - 1;
        int minLen = Integer.MAX_VALUE;
        int sum = sequence[0];
        while (end < last) {
            if (sum < k) {
                sum += sequence[++end];
            } else if (sum > k) {
                sum -= sequence[begin++];
            } else {
                if (minLen > end - begin) {
                    minLen = end - begin;
                    answer[0] = begin;
                    answer[1] = end;
                }
                sum += sequence[++end];
            }
        }
        
        return answer;
    }
}