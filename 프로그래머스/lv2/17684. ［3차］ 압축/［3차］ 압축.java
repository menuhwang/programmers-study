import java.util.*;

class Solution {
    public int[] solution(String msg) {
        // 1. 문자 하나를 뽑아와서 맵에 있는지 확인
        // 2. 있으면 색인 저장
        // 3. 다음 글자와 함께 확인
        // 3-1. 있으면 그 다음 글자부터 1번부터 반복
        // 3-2. 없으면 맵에 등록 후 색인 번호 출력
        List<Integer> index = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            map.put(String.valueOf(ch), map.size() + 1);
        }
        
        int pivot = 0;
        while (pivot < msg.length()) {
            int next = 0;
            int temp = 0;
            for (int j = 1; pivot + j <= msg.length(); j++) {
                String str = msg.substring(pivot, pivot + j);
                if (map.getOrDefault(str, -1) < 0) {
                    map.put(str, map.size() + 1);
                    break;
                }
                next = pivot + j;
                temp = map.get(str);
            }
            index.add(temp);
            pivot = next;
        }
        
        int[] answer = new int[index.size()];
        for (int j = 0; j < answer.length; j++) answer[j] = index.get(j);
        return answer;
    }
}