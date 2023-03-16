class Solution {
    public String solution(String[] survey, int[] choices) {
        int[] point = {0, -3, -2, -1, 0, 1, 2, 3};
        int RT = 0;
        int CF = 0;
        int JM = 0;
        int AN = 0;
        // RT -+
        // CF -+
        // JM -+
        // AN -+
        
        for (int i = 0; i < survey.length; i++) {
            String type = survey[i];
            int choice = point[choices[i]];
            switch (type) {
                case "RT":
                case "TR":
                    RT += type.equals("RT") ? choice : -1 * choice;
                    break;
                    
                case "CF":
                case "FC":
                    CF += type.equals("CF") ? choice : -1 * choice;
                    break;
                    
                case "JM":
                case "MJ":
                    JM += type.equals("JM") ? choice : -1 * choice;
                    break;
                    
                case "AN":
                case "NA":
                    AN += type.equals("AN") ? choice : -1 * choice;
                    break;
                    
                default:
            }
        }
        
        String answer = "";
        answer += RT <= 0 ? "R" : "T";
        answer += CF <= 0 ? "C" : "F";
        answer += JM <= 0 ? "J" : "M";
        answer += AN <= 0 ? "A" : "N";
        return answer;
    }
}