import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        int num;
        for (int n = 0; n < N; n++) {
            num = Integer.parseInt(br.readLine());
            sum += num;
            list.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Collections.sort(list);

        int mean = Math.round((float) sum / N);
        int median = list.get(N / 2);

        int max = 0;
        for (int count : map.values()) {
            max = Math.max(max, count);
        }

        Integer mode = null;
        for (int n : list) {
            if (map.get(n) == max) {
                if (mode == null) {
                    mode = n;
                } else if (mode != n) {
                    mode = n;
                    break;
                }
            }
        }

        int range = list.get(list.size() - 1) - list.get(0);

        System.out.println(mean);
        System.out.println(median);
        System.out.println(mode);
        System.out.println(range);
    }
}