import java.io.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int N = Integer.parseInt(br.readLine());

            int count = 1;

            int begin = N / 2;
            int end = begin + 1;

            while (begin > 0) {
                int sum = sum(begin, end);

                if (sum > N) {
                    begin--;
                    end--;
                } else if (sum == N) {
                    end++;
                    count++;
                } else {
                    end++;
                }
            }

            bw.write(count + "\n");

            bw.flush();
        }
    }

    /**
     * @param begin 계산 시작 값
     * @param end 계산 끝 값
     * @return begin부터 end까지의 합산. begin, end 모두 포함.
     */
    private static int sum(int begin, int end) {
        int result = 0;
        for (int i = begin; i <= end; i++)
            result += i;

        return result;
    }
}
