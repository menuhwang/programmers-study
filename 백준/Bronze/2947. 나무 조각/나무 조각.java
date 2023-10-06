import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] target = {1, 2, 3, 4, 5};
            int[] array = new int[st.countTokens()];

            for (int i = 0; i < array.length; i++)
                array[i] = Integer.parseInt(st.nextToken());

            while (!Arrays.equals(array, target)) {
                for (int i = 0; i < target.length - 1; i++) {
                    if (array[i] > array[i + 1]) {
                        swap(array, i, i + 1);
                        bw.write(arrayToString(array) + "\n");
                    }
                }
            }

            bw.flush();
        }
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1)
                sb.append(" ");
        }

        return sb.toString();
    }
}
