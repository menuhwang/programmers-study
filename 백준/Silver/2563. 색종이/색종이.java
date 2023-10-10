import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {

        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            /*
            * 100 * 100의 도화지
            * false: 색종이 x
            * true: 색종이 o
            */
            boolean[][] board = new boolean[101][101];

            // P: paper
            int P = Integer.parseInt(br.readLine());

            // 색종이 부착
            StringTokenizer st;
            for (int p = 0; p < P; p++) {
                st = new StringTokenizer(br.readLine());
                int col = Integer.parseInt(st.nextToken());
                int row = Integer.parseInt(st.nextToken());

                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        board[row + i][col + j] = true;
                    }
                }
            }

            // 넓이 계산
            int count = 0;
            for (boolean[] row : board)
                for (boolean col : row)
                    if (col)
                        count++;

            bw.write(count +"");

            bw.flush();
        }

    }
}
