import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] switchStatus;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        switchStatus = new boolean[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            switchStatus[i] = st.nextToken().equals("1");
        }

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String gender = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if (gender.equals("1")) boy(num);
            else girl(num);
        }

        for (int i = 1; i <= N; i++) {
            sb.append(switchStatus[i] ? 1 : 0).append(" ");
            if (i % 20 == 0) sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void boy(int num) {
        for (int i = 1; i * num < switchStatus.length; i++){
            toggle(i * num);
        }
    }

    private static void girl(int num) {
        toggle(num);
        for (int i = 1; num - i > 0 && num + i < switchStatus.length; i++) {
            boolean left = switchStatus[num - i];
            boolean right = switchStatus[num + i];
            if (left != right) break;
            toggle(num - i);
            toggle(num + i);
        }
    }

    private static void toggle(int num) {
        switchStatus[num] = !switchStatus[num];
    }
}