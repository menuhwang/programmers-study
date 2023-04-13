import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        LinkedList<int[]> list = new LinkedList<>();
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new int[]{start, end});
        }

        list.sort((s1, s2) -> {
            if (s1[1] == s2[1]) return Integer.compare(s1[0], s2[0]);
            return Integer.compare(s1[1], s2[1]);
        });

        int[] curr;
        int prevEnd = 0;
        int currStart = 0;
        Iterator<int[]> iterator = list.iterator();
        while (iterator.hasNext()) {
            curr = iterator.next();
            currStart = curr[0];
            if (prevEnd > currStart) iterator.remove();
            else prevEnd = curr[1];
        }

        System.out.print(list.size());
    }
}