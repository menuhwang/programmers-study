import java.util.*;

class Solution {
    public int solution(int n) {
        // 3으로 나눈 나머지를 스택에 넣는다.
        // 몫이 0이 될때까지
        // 스택에서 하나씩 꺼내 3^0 부터 3^i로 십진수로 변환한다.
        Stack<Integer> mod = new Stack<>();
        while (n > 0) {
            mod.push(n % 3);
            n /= 3;
        }
        
        int answer = 0;
        int size = mod.size();
        for (int i = 0; i < size; i++) {
            answer += (int)Math.pow(3, i) * mod.pop();
        }
        
        return answer;
    }
}