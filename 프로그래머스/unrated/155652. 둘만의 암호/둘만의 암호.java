class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        for (char ch : s.toCharArray()) { // 50
            char crypto = ch;
            for (int i = 0; i < index; i++) { // 20
                crypto = (char)(crypto + 1) > 'z' ? (char)(crypto + 1 - 26) : (char)(crypto + 1);
                for (int j = 0; j < skip.length(); j++) { // 10
                    if (crypto == skip.charAt(j)) {
                        i--;
                        break;
                    }
                }
            }
            answer.append(crypto);
        } // 50 * 20 * 10 = 10,000;
        return answer.toString();
    }
}