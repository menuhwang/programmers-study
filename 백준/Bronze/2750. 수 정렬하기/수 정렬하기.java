import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 버블 정렬
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            int N = Integer.parseInt(br.readLine());
            int[] array = new int[N];
            for (int i = 0; i < array.length; i++)
                array[i] = Integer.parseInt(br.readLine());

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length - i - 1; j++) {
                    if (array[j] > array[j + 1])
                        swap(array, j, j + 1);
                }
            }

            for (int num : array)
                bw.write(num + "\n");

            bw.flush();
        }
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
