import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[][] box = new char[N][N];

        String st;
        for (int i = 0; i < N; i++) {
            st = br.readLine();
            for (int j = 0; j < N; j++) {
                box[i][j] = st.charAt(j);
            }
        }

        int max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                hswap(box, i, j);
                max = Math.max(count(box), max);
                hswap(box, i, j);
            }
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                vswap(box, i, j);
                max = Math.max(count(box), max);
                vswap(box, i, j);
            }
        }

        System.out.println(max);
    }

    private static int count(char[][] box) {
        int result = 0;

        int count;

        for (int i = 0; i < box.length; i++) {
            count = 1;
            for (int j = 1; j < box.length; j++) {
                if (box[i][j - 1] == box[i][j]) {
                    count++;
                } else {
                    result = Math.max(result, count);
                    count = 1;
                }
                result = Math.max(result, count);
            }

            count = 1;
            for (int j = 1; j < box.length; j++) {
                if (box[j - 1][i] == box[j][i]) {
                    count++;
                } else {
                    result = Math.max(result, count);
                    count = 1;
                }
                result = Math.max(result, count);
            }
        }
        return result;
    }

    private static void hswap(char[][] box, int row, int col) {
        char temp = box[row][col];
        box[row][col] = box[row][col + 1];
        box[row][col + 1] = temp;
    }


    private static void vswap(char[][] box, int row, int col) {
        char temp = box[row][col];
        box[row][col] = box[row + 1][col];
        box[row + 1][col] = temp;
    }
}