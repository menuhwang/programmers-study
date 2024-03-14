import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static final Set<Integer> troubleButtons = new HashSet<>();

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int standard = 100;
            int target = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());

            int manual = Math.abs(target - standard);

            if (N > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i = 0; i < N; i++) {
                    troubleButtons.add(Integer.parseInt(st.nextToken()));
                }
            }

            if (manual <= numOfDigit(target)) {
                bw.write(manual + "\n");
                bw.flush();
                return;
            }

            int inputCnt = Integer.MAX_VALUE;
            int gap = 0;
            while (inputCnt == Integer.MAX_VALUE) {
                int down = target - gap;
                int up = target + gap;

                if (down == standard - numOfDigit(down) || up == standard - numOfDigit(up)) {
                    break;
                }

                if (down >= 0 && accessible(down)) {
                    inputCnt = Math.min(inputCnt, numOfDigit(down) + (target - down));
                }
                if (accessible(up)) {
                    inputCnt = Math.min(inputCnt, numOfDigit(up) + (up - target));
                }
                gap++;
            }

            bw.write(Math.min(manual, inputCnt) + "\n");

            bw.flush();
        }
    }

    private static int numOfDigit(int channel) {
        if (channel == 0) {
            return 1;
        }

        int result = 0;
        while (channel > 0) {
            result++;
            channel /= 10;
        }

        return result;
    }

    private static boolean accessible(int channel) {
        if (channel == 0 && troubleButtons.contains(0)) {
            return false;
        }
        while (channel > 0) {
            int mod = channel % 10;
            channel /= 10;
            if (troubleButtons.contains(mod)) {
                return false;
            }
        }

        return true;
    }
}
