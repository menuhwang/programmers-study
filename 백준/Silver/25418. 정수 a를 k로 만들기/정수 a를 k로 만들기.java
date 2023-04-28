import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int num = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        queue.offer(num);

        Set<Integer> set = new HashSet<>();
        List<Integer> temp;
        loop:
        while (!queue.isEmpty()) {
            count++;
            temp = new ArrayList<>();
            while (!queue.isEmpty()) {
                int n = queue.poll();
                if (set.contains(n)) continue;
                set.add(n); // 방문 처리
                if (n + 1 == target || n * 2 == target) break loop;
                if (n + 1 < target) temp.add(n + 1);
                if (n * 2 < target) temp.add(n * 2);
            }
            queue.addAll(temp);
        }

        System.out.println(count);
    }
}