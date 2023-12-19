class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (int i = 0; i < skill_trees.length; i++) {
            String skillTree = skill_trees[i];
            int cursor1 = 0;
            int cursor2 = 0;
            
            while (cursor1 < skill.length() && cursor2 < skillTree.length()) {
                if (skill.charAt(cursor1) == skillTree.charAt(cursor2)) {
                    cursor1++;
                    cursor2++;
                } else if (skill.indexOf(skillTree.charAt(cursor2)) == -1) {
                    cursor2++;
                } else {
                    break;
                }
            }
            
            if (cursor1 == skill.length() || cursor2 == skillTree.length())
                answer++;
        }
        
        return answer;
    }
}