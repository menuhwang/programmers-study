import java.util.regex.*;

class Solution {
    final String REGEX = "(\\d{1,2})([S|D|T]{1})([*|#]?)";
    final Pattern PATTERN = Pattern.compile(REGEX);
    final String BONUS = " SDT";
    
    public int solution(String dartResult) {
        
        int[] score = new int[4];
        int answer = 0;
        
        Matcher m = PATTERN.matcher(dartResult);
        
        for (int i = 1; i < 4 && m.find(); i++) {
            String round = m.group();
            RoundResult roundResult = new RoundResult(round);
            score[i] = roundResult.getScore();
            switch (roundResult.getOption()) {
                case "*":
                    score[i - 1] *= 2;
                    score[i] *= 2;
                    break;
                case "#":
                    score[i] *= -1;
                    break;
                default:
                    break;
            }
        }
        
        for (int i = 1; i < 4; i++) {
            answer += score[i];
        }
        
        return answer;
    }
    
    class RoundResult {     
        private int score;
        private int bonus;
        private String option;
        
        public RoundResult(String roundResultStr) {
            Matcher roundMatcher = PATTERN.matcher(roundResultStr);
            if (roundMatcher.find()) {
                this.score = Integer.parseInt(roundMatcher.group(1));
                this.bonus = BONUS.indexOf(roundMatcher.group(2));
                this.option = roundMatcher.group(3);
            }
        }
        
        public int getScore() {
            return (int) Math.pow(score, bonus);
        }
        
        public String getOption() {
            return this.option;
        }
    }
}