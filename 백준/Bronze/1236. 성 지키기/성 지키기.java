import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] coveredRows = new boolean[N];
        boolean[] coveredCols = new boolean[M];

        for (int r = 0; r < N; r++) {
            String row = br.readLine();
            for (int c = 0; c < M; c++) {
                if (!coveredRows[r] && row.charAt(c) == 'X')
                    coveredRows[r] = true;

                if (!coveredCols[c] && row.charAt(c) == 'X')
                    coveredCols[c] = true;
            }
        }

        int needRows = 0;
        int needCols = 0;

        for (boolean flag : coveredRows)
            if (!flag) needRows++;

        for (boolean flag : coveredCols)
            if (!flag) needCols++;

        System.out.print(needRows + needCols - Math.min(needRows, needCols));
    }
}