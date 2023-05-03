import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] number = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        String result = "-1";
        for (int i = N - 2; i > -1; i--) {
            if (number[i] > number[i + 1]) {
                for (int j = N - 1; j > i; j--) {
                    if (number[i] > number[j]) {
                        int temp = number[j];
                        number[j] = number[i];
                        number[i] = temp;
                        break;
                    }
                }
                int[] ordering = reversOrder(Arrays.copyOfRange(number, i + 1, N));
                System.arraycopy(ordering, 0, number, i + 1, N - 1 - i);

                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < N; j++) {
                    stringBuilder.append(number[j] + " ");
                }
                result = stringBuilder.toString();
                break;
            }
        }
        System.out.println(result);
    }

    private static int[] reversOrder(int[] array) {
        int[] ordering = new int[array.length];
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            ordering[i] = array[array.length - 1 - i];
        }
        return ordering;
    }
}