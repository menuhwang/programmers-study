class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int count = 0;
        while (sb.length() < t) {
            String number = Integer.toString(index++, n).toUpperCase();
            for (int i = 0; i < number.length(); i++) {
                if (count % m == p - 1 && sb.length() < t) {
                    sb.append(number.charAt(i));
                }
                count++;
            }
        }
        return sb.toString();
    }
}