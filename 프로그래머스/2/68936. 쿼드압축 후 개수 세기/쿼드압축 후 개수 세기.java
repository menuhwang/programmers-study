class Solution {
    private int[][] ARRAY;
    private boolean[][] ZIP;
    private int[] COUNT = new int[2];
    private int ZERO = 0;
    private int ONE = 1;
    
    /*
    ltr: left top row
    ltc: left top col
    rbr: right bottom row
    rbc: right bottom col
    */
    
    public int[] solution(int[][] arr) {
        int len = arr.length;
        ARRAY = arr;
        ZIP = new boolean[len][len];
        
        for (int[] row : arr) {
            for (int col : row) {
                if (col == ZERO) {
                    COUNT[ZERO]++;
                } else {
                    COUNT[ONE]++;
                }
            }
        }
        
        while (len >= 2) {
            for (int ltr = 0; ltr < arr.length; ltr += len) {
                for (int ltc = 0; ltc < arr[ltr].length; ltc += len) {
                    if (!ZIP[ltr][ltc] && canZip(ltr, ltc, len)) {
                        zip(ltr, ltc, len);
                    }
                }
            }
            len /= 2;
        }
        
        return COUNT;
    }
    
    private void zip(int ltr, int ltc, int length) {
        int rbr = ltr + length - 1;
        int rbc = ltc + length - 1;
        for (int r = ltr; r <= rbr; r++) {
            for (int c = ltc; c <= rbc; c++) {
                ZIP[r][c] = true;
            }
        }
        
        int decrease = length * length - 1;
        if (ARRAY[ltr][ltc] == ZERO) {
            COUNT[ZERO] -= decrease;
        } else {
            COUNT[ONE] -= decrease;
        }
    }
    
    private boolean canZip(int ltr, int ltc, int length) {
        int rbr = ltr + length - 1;
        int rbc = ltc + length - 1;
        for (int r = ltr; r <= rbr; r++) {
            for (int c = ltc; c <= rbc; c++) {
                if (ARRAY[ltr][ltc] != ARRAY[r][c]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}