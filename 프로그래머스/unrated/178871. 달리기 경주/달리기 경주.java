import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> board1 = new HashMap<>(); // 이름 등수
        HashMap<Integer, String> board2 = new HashMap<>(); // 등수 이름
        for (int i = 0; i < players.length; i++) {
            board1.put(players[i], i);
            board2.put(i, players[i]);
        }
        
        for (String name : callings) {
            int rank = board1.get(name); // 불린사람의 현재 등수
            String front = board2.get(rank - 1); // 불린사람의 앞 사람 이름
            
            board1.put(front, rank); // 앞 사람 등수를 불린사람의 현재 등수로 바꾸고
            board1.put(name, rank - 1); // 불린사람의 등수를 앞으로 땡긴다.
            board2.put(rank, front);
            board2.put(rank - 1, name);
        }
        String[] answer = new String[players.length];
        
        for (int rank : board2.keySet()) {
            answer[rank] = board2.get(rank);
        }
        return answer;
    }
}