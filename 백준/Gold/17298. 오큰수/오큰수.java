import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {

        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            // 배열 초기화
            int N = Integer.parseInt(br.readLine());
            int[] array = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }

            Stack<Integer> result = new Stack<>();
            result.push(-1);

            Stack<Integer> temp = new Stack<>();
            temp.push(array[array.length - 1]);

            // 마지막 -1 원소부터
            // 오른쪽 원소와 비교
            // 피벗 < 오른쪽 원소 -> temp.push(오른쪽), result.push(오른쪽)
            // 피벗 >= 오른쪽
            // temp.peek > 피벗 -> result.push(temp.peek)
            // temp.peek <= 피벗 -> temp.isEmpty OR temp.peek > 피벗 까지 temp.pop
            // temp.isEmpty -> result.push(-1)
            // !temp.isEmpty -> result.push(temp.peek)
            for (int i = N - 2; i >= 0; i--) {
                int pivot = array[i];
                int right = array[i + 1];
                if (pivot < right) {
                    temp.push(right);
                    result.push(right);
                    continue;
                }

                if (!temp.isEmpty() && temp.peek() > pivot) {
                    result.push(temp.peek());
                    continue;
                }

                while (!temp.isEmpty() && temp.peek() <= pivot) {
                    temp.pop();
                }

                if (temp.isEmpty()) {
                    result.push(-1);
                } else {
                    result.push(temp.peek());
                }

            }

            // 스택 출력
            while (!result.isEmpty()) {
                bw.write(result.pop() + " ");
            }

            bw.flush();
        }
    }
}
