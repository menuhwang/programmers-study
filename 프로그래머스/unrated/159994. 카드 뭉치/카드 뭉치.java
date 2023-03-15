class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int pointer1 = 0;
        int pointer2 = 0;
        int pointerGoal = 0;
        
        while (pointerGoal < goal.length) {
            String word = goal[pointerGoal++];
            String card1 = pointer1 < cards1.length ? cards1[pointer1] : "";
            String card2 = pointer2 < cards2.length ? cards2[pointer2] : "";
                        
            if (word.equals(card1)) {
                pointer1++;
            } else if (word.equals(card2)) {
                pointer2++;
            } else {
                return "No";
            }
        }
        
        return "Yes";
    }
}