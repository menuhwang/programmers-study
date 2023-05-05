import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<List<Integer>> set = new ArrayList<>();
        
        String sub = s.substring(s.indexOf("{") + 1, s.lastIndexOf("}"));
        
        boolean flag = false;
        List<Integer> list = new ArrayList<>();;
        StringBuilder sb = new StringBuilder();
        for (char ch : sub.toCharArray()) {
            switch (ch) {
                case '{':
                    list = new ArrayList<>();
                    flag = true;
                    break;
                case '}':
                    list.add(Integer.parseInt(sb.toString()));
                    sb = new StringBuilder();
                    set.add(list);
                    flag = false;
                    break;
                case ',':
                    if (flag) {
                        list.add(Integer.parseInt(sb.toString()));
                        sb = new StringBuilder();
                    }
                    break;
                default:
                    sb.append(ch);
                    break;
            }
        }
        
        Collections.sort(set, Comparator.comparing(List::size));
                
        List<Integer> answerList = new ArrayList<>();
        
        for (int i = 0; i < set.size(); i++) {
            set.get(i).removeAll(answerList);
            answerList.add(set.get(i).get(0));
        }
        
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}