import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Float> stagesFail = new HashMap<>();
        // 스테이지 오름차순으로 정렬 nlogn n:200,000
        List<Integer> sorted = new ArrayList<>();
        for (int stage : stages) {
            sorted.add(stage);
        }
        sorted.sort(Comparator.naturalOrder());
        // for O(500)
        for (int i = 1; i <= N; i++) {
            // Map, 스테이지, 실패율
            float fail = 0F;
            int indexOf = sorted.indexOf(i);
            int lastIndexOf = sorted.lastIndexOf(i);
            if (indexOf > -1 && lastIndexOf > -1) {
                // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 : lastIndexOf(n) - indexOf(n) + 1
                int failedPlayer = lastIndexOf - indexOf + 1;
                // 스테이지에 도달한 플레이어 수 : stages.length - indexOf(n)
                int totalPlayer = stages.length - indexOf;
                fail = (float) failedPlayer / totalPlayer;
            }
            stagesFail.put(i, fail);
        }
        
        // entrySet을 실패율 내림차순, 스테이지 오름차순으로 정렬
        List<Map.Entry<Integer, Float>> entries = new ArrayList<>(stagesFail.entrySet());
        entries.sort((e1, e2) -> {
            if (e1.getValue().equals(e2.getValue())) return e1.getKey() - e2.getKey();
            return e2.getValue() - e1.getValue() > 0 ? 1 : -1;
        });
        // 반환.
        int[] answer = new int[N];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = entries.get(i).getKey();
        }
        return answer;
    }
}
