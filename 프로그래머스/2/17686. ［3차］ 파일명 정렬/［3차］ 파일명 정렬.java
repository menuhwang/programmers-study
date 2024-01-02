import java.util.*;

class Solution {
    public String[] solution(String[] origins) {
        return Arrays.stream(origins)
            .map(File::new)
            .sorted()
            .map(File::getOrigin)
            .toArray(String[]::new);
    }
    
    class File implements Comparable<File> {
        private static final String NUM_REG = "[0-9]{1,5}";
        private String origin;
        private String head;
        private int number;
        
        File(String origin) {
            String[] temp = origin.split(NUM_REG, 2);
            int numberBeginIndex = temp[0].length();
            int numberEndIndex;
            if (temp.length < 2) {
                numberEndIndex = origin.length();
            } else {
                numberEndIndex = origin.lastIndexOf(temp[1]);
            }
            
            this.origin = origin;
            this.head = temp[0];
            this.number = Integer.parseInt(origin.substring(numberBeginIndex, numberEndIndex));
        }
        
        public String getOrigin() {
            return this.origin;
        }
        
        @Override
        public String toString() {
            return String.format("File(origin=%s, head=%s, number=%d)", this.origin, this.head, this.number);
        }
        
        @Override
        public int compareTo(File f) {
            int result = head.compareToIgnoreCase(f.head);
            if (result == 0) {
                result = Integer.compare(number, f.number);
            }
            return result;
        }
    }
}