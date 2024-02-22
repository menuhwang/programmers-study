import java.util.*;

class Solution {
    enum Column {
        code,
        date,
        maximum,
        remain
    }
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        final int extIdx = Column.valueOf(ext).ordinal();
        final int sortIdx = Column.valueOf(sort_by).ordinal();

        return Arrays.stream(data)
                .filter(d -> d[extIdx] < val_ext)
                .sorted(Comparator.comparingInt(d -> d[sortIdx]))
                .toArray(int[][]::new);
    }
}