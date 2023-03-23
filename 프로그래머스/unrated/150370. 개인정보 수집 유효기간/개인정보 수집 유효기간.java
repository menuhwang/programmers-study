import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termMap = new HashMap<>();
        
        for (String term : terms) {
            String[] typeAndTerm = term.split(" ");
            termMap.put(typeAndTerm[0], Integer.parseInt(typeAndTerm[1]));
        }
        
        Date todayDate = new Date(today);
        
        List<Integer> answerTemp = new ArrayList<>();
        
        for (int i = 0; i < privacies.length; i++) {
            Privacy privacy = new Privacy(privacies[i]);
            Date privacyDate = privacy.getDate();
            privacyDate.plusMonth(termMap.get(privacy.getType()));
            // 오늘 날짜와 유효기간 비교 : 오늘 날짜가 같거나 크면 파기해야함 
            if (todayDate.compareTo(privacyDate) > -1) answerTemp.add(i + 1);
        }
        
        int[] answer = new int[answerTemp.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerTemp.get(i);
        }
        
        return answer;
    }
    
    class Privacy {
        private String type;
        private Date date;
        
        Privacy(String privacy) {
            String[] temp = privacy.split(" ");
            this.date = new Date(temp[0]);
            this.type = temp[1];
        }
        
        public Date getDate() {
            return this.date;
        }
        
        public String getType() {
            return this.type;
        }
    }
    
    class Date {
        private int year;
        private int month;
        private int day;
        
        Date(String date) {
            String[] temp = date.split("\\.");
            this.year = Integer.parseInt(temp[0]);
            this.month = Integer.parseInt(temp[1]);
            this.day = Integer.parseInt(temp[2]);
        }
        
        // 비교 : 인스턴스가 인자보다 크면 1, 같으면 0 작으면 -1 
        int compareTo(Date date) {
            int temp = 0;
            temp += (this.year - date.year) * 10000;
            temp += (this.month - date.month) * 100;
            temp += this.day - date.day;
            return temp > 0 ? 1 : temp == 0 ? 0 : -1;
        }
        
        Date plusMonth(int month) {
            this.month += month;
            if (this.month > 12) {
                year += (this.month - 1) / 12;
                this.month = (this.month - 1) % 12 + 1;
            }
            
            return this;
        }
    }
}