import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            int N = Integer.parseInt(br.readLine());
            int[] array = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int num = i + 1;
                int over = Integer.parseInt(st.nextToken()); // 큰 사람 수
                int empty = 0; // 배열의 빈 칸 수
                int index = 0; // 배열 인덱스

                // 빈 공간의 개수가 주어진 값과 같아질 때까지 인덱스 증가.
                while (empty < over) {
                    if (array[index++] == 0) empty++;
                }
                //  그 위치에 숫자를 넣는다.
                // 단, 그 위치가 비어있지 않으면 비어있을때까지 인덱스를 증가.
                while (array[index] > 0) index++;
                array[index] = num;
            }

            for (int num : array)
                bw.write(num + " ");

            bw.flush();
        }
    }
}
