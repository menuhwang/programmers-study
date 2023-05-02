import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        Set<Integer> set = new HashSet<>();
        set.add(array[0] + array[0]);
        for (int n = 1; n < N; n++) {
            for (int i = 0; i < n; i++) {
                if (set.contains(array[n] - array[i])) {
                    result++;
                    break;
                }
            }
            for (int i = 0; i <= n; i++) {
                set.add(array[n] + array[i]);
            }
        }
        
        System.out.println(result);
    }
}