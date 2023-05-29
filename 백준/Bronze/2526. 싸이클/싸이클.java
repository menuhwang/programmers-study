import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        // 전체 결과를 담는 Set : total
        Set<Integer> total = new HashSet<>();
        // 싸이클을 담는 Set : cycle
        Set<Integer> cycle = new HashSet<>();

        // total 초기화
        // total 에 이미 존재하는 요소가 나올때까지 x * N % P 결과를 추가
        int result = N;
        while (!total.contains(result)) { // O(P)
            total.add(result);
            result = result * N % P;
        }
        // 중복되는 값을 cycle 에 추가

        // cycle 초기화
        // 마찬가지로 이미 존재하는 요소가 나올때까지 반복 추가
        while (!cycle.contains(result)) { // O(P)
            cycle.add(result);
            result = result * N % P;
        }

        // cycle 개수 출력
        bw.write(cycle.size() + "");
        bw.flush();
        br.close();
        bw.close();
    }
}