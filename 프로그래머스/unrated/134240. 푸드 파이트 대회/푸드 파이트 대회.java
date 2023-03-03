class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder("0");
        for (int i = food.length - 1; i > -1; i--) {
            int count = food[i];
            setFood(i, count, sb);
        }
        return sb.toString();
    }
    
    private void setFood(int food, int count, StringBuilder sb) {
        for (int i = 0; i < count / 2; i++) {
            sb.insert(0, food);
            sb.insert(sb.length(), food);
        }
    }
}