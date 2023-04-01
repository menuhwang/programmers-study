import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] Ti = new int[N + 1];
        int[] Pi = new int[N + 1];

        boolean[] check = new boolean[N + 1];
        int[] max = new int[N + 1];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            Ti[i] = Integer.parseInt(st.nextToken());
            Pi[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            max[i] = max[i - 1];
            for (int j = 1; j <= i; j++) {
                if (!check[j] && j + Ti[j] -1 == i) {
                    check[j] = true;
                    max[i] = Math.max(Pi[j] + max[j - 1], max[i]);
                }
            }
        }

        System.out.println(max[N]);
    }
}