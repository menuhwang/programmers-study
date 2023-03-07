import java.util.regex.*;

class Solution {
    final String SCORE_REGEX = "\\d{1,2}";
    final String BONUS_REGEX = "[S,D,T]{1}";
    final String OPTION_REGEX = "[*,#]?";
    final Pattern SCORE_PATTERN = Pattern.compile(SCORE_REGEX);
    final Pattern BONUS_PATTERN = Pattern.compile(BONUS_REGEX);
    final Pattern OPTION_PATTERN = Pattern.compile(OPTION_REGEX);
    final String BONUS = " SDT";
    
    public int solution(String dartResult) {
        
        int[] score = new int[4];
        int answer = 0;
        
        Pattern p = Pattern.compile(SCORE_REGEX + BONUS_REGEX + OPTION_REGEX);
        Matcher m = p.matcher(dartResult);
        
        for (int i = 1; i < 4; i++) {
            if (m.find()) {
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
            Matcher roundMatcher = SCORE_PATTERN.matcher(roundResultStr);
            if (roundMatcher.find()) this.score = Integer.parseInt(roundMatcher.group());
            
            roundMatcher.usePattern(BONUS_PATTERN);
            if (roundMatcher.find()) this.bonus = BONUS.indexOf(roundMatcher.group());
            
            roundMatcher.usePattern(OPTION_PATTERN);
            if (roundMatcher.find()) this.option = roundMatcher.group();
        }
        
        public int getScore() {
            return (int) Math.pow(score, bonus);
        }
        
        public String getOption() {
            return this.option;
        }
    }
}