import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int T = Integer.parseInt(br.readLine());

            for (int t = 0; t < T; t++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int count = 0;
                int prevStartMove = 1;
                int prevEndMove = 1;

                if (end - start == 1) {
                    bw.write("1\n");
                    continue;
                }

                start += prevStartMove;
                count++;
                end -= prevEndMove;
                count++;

                while (start < end) {
                    int delta = end - start; // 남은 거리

                    if (delta <= prevStartMove + 1) { // 남은 거리가 이동할 수 있는 거리 내인 경우
                        prevStartMove = delta;
                        start += prevStartMove;
                        count++;
                        break;
                    } else { // 남은 거리가 이동할 수 있는 거리 외인 경우
                        prevStartMove = prevStartMove + 1;
                        start += prevStartMove;
                        count++;
                        delta = end - start;

                        // end pivot을 움직인다.
                        if (delta <= prevEndMove + 1) {
                            prevEndMove = delta;
                            end -= prevEndMove;
                            count++;
                            break;
                        } else {
                            prevEndMove = prevEndMove + 1;
                            end -= prevEndMove;
                            count++;
                        }
                    }
                }

                bw.write(count + "\n");
            }

            bw.flush();
        }
    }
}
