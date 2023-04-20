import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[N + 1];

        int index = 0;
        loop:
        for (int i = 2; i <= N; i++) {
            if (check[i]) continue;
            int num = i;
            while (num <= N) {
                if (!check[num]) {
                    index++;
                    check[num] = true;
                }

                if (index == K) {
                    System.out.println(num);
                    break loop;
                }

                num += i;
            }
        }
        
        br.close();
    }
}