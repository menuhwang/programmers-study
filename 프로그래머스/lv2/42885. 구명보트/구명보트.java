import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        LinkedList<Integer> list = new LinkedList<>();
        
        for (int person : people) {
            list.add(person);
        }
        
        Collections.sort(list);
        
        int weight = 0;
        while (!list.isEmpty()) {
            weight += list.pollLast(); // 무거운 한 명 태움
            if (list.isEmpty()) { // 더 태울 사람이 없으면
                answer++; // 배 출발
                break; // 종료
            }
            if (weight + list.peekFirst() > limit) { // 가벼운 사람 한 명 더 탈 수 없으면
                weight = 0; // 현재 무게 초기화
                answer++; // 배 출발
                continue; // 다음 차례
            }
            // 탈 수 있으면
            list.pollFirst(); // 한 명 더 태움
            weight = 0; // 무게 초기화
            answer++; // 배 출발
        }
        
        return answer;
    }
}