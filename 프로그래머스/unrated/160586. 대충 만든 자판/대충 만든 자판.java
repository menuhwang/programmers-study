class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        for (int t = 0; t < targets.length; t++) {
            String target = targets[t];
            int count = 0;
            
            for (int c = 0; c < target.length(); c++) {
                char ch = target.charAt(c);
                int temp = -1;
                
                for (String key : keymap) {
                    int index = key.indexOf(ch);
                    if (index > -1) temp = temp > -1 ? Math.min(index + 1, temp) : index + 1;
                }
                
                if (temp == -1) { // 최소 클릭 수가 없는 경우 : 입력이 불가능한 경우
                    count = temp;
                    break;
                }
                
                count += temp;
            }
            answer[t] = count;
        }
        
        return answer;
    }
}