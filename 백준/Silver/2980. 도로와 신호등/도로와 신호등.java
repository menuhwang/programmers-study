import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    // 현재 위치
    static int POS = 0;
    // 현재 시간
    static int SEC = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int D;
        int R;
        int G;
        // 신호등 객체를 만든다.
        // 리스트에 신호등 객체를 추가한다.
        // 현재 시간에 따라 신호등 상태를 판별하는 메소드 필요.
        List<Signal> signals = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            D = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());
            signals.add(new Signal(D, R, G));
        }

        for (Signal signal : signals) {
            // 리스트에서 신호등을 가져온다.
            // 신호등 위치를 가져온다.
            // 현재 시간을 갱신한다.
            SEC += signal.getPosition() - POS; // 이동 시간
            // 현재 위치를 갱신한다.
            POS = signal.getPosition();
            // 신호등 대기 시간 추가
            SEC += signal.getWaitingTime(); // 대기 시간 green일 경우 0
        }
        // 다음 신호등 반복.

        // 목표 지점까지 이동시간 추가
        SEC += L - POS;
        POS = L;

        bw.write(SEC + "");
        bw.flush();
        br.close();
        bw.close();
    }

    static class Signal {
        private final int position;
        private final int red;
        private final int green;

        public Signal(int position, int red, int green) {
            this.position = position;
            this.red = red;
            this.green = green;
        }

        // 신호등 상태를 판별하는 메소드
        private boolean isRed() {
            // 현재 시간을 red + green으로 나눈 나머지가
            int mod = SEC % (red + green);
            // red 보다 작으면 red
            // 크면 green
            return mod <= red;
            // ex) 현재 시간 11초
            // red:5 green:5
            // red
            // ex) 현재 시간 4초
            // red:2 green:4
            // green
        }

        // 남은 시간 계산 메소드
        public int getWaitingTime() {
            if (!isRed()) return 0;
            // 현재 시간을 red + green으로 나눈 나머지를 red에서 뺀 값
            return red - SEC % (red + green);
        }

        public int getPosition() {
            return position;
        }
    }
}