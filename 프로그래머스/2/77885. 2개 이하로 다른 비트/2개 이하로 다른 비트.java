class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            answer[i] = function(numbers[i]);
        }
        
        return answer;
    }
    
    private long function(long num) {
        int rightZero = 0;
        while (true) {
            long temp = 1L << rightZero;
            if (num != (num | temp))
                break;
            rightZero++;
        }
        
        long result = num;
        long temp = 1L << rightZero;
        result |= temp;
        if (rightZero > 0) {
            temp = temp >> 1;
            result ^= temp;
        }
        
        return result;
    }
}