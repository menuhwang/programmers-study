import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] lan = new int[K];

        long left = 0;
        long right = 0;
        for (int i = 0; i < K; i++) {
            lan[i] = Integer.parseInt(br.readLine());
            right = Math.max(lan[i], right);
        }

        right++;

        long middle;
        while (left < right) {
            long temp = 0;
            middle = (left + right) / 2;

            for (int i = 0; i < K; i++) {
                temp += lan[i] / middle;
            }

            if (temp < N) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        System.out.println(left - 1);
    }
}