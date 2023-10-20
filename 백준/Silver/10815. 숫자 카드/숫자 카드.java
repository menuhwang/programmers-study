import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {

        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] array = new int[N];
            for (int i = 0; i < array.length; i++)
                array[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(array);

            N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                int target = Integer.parseInt(st.nextToken());

                if (binarySearch(array, target) > -1)
                    bw.write("1 ");
                else
                    bw.write("0 ");
            }

            bw.flush();
        }
    }

    private static int binarySearch(int[] array, int target) {
        int result = -1;

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int cur = (left + right) / 2;

            if (array[cur] == target) {
                result = cur;
                return result;
            }
            if (array[cur] < target) {
                left = cur + 1;
            } else if (array[cur] > target) {
                right = cur - 1;
            }
        }

        return result;
    }
}
