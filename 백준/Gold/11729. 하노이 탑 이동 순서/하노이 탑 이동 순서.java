import java.io.*;

class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int counter;

    public static void main(String[] args) throws IOException {

        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ) {
            int N = Integer.parseInt(br.readLine());

            recursive(N, 1, 3);

            bw.write(counter + "\n");
            bw.write(sb + "\n");

            bw.flush();
        }
    }

    private static void recursive(int board, int from, int to) {
        if (board == 1) {
            counter++;
            sb.append(from)
                    .append(" ")
                    .append(to)
                    .append("\n");
            return;
        }

        int upperTarget = 1;
        for (int i = 1; i < 4; i++) {
            if (i != from && i != to) {
                upperTarget = i;
                break;
            }
        }

        recursive(board - 1, from, upperTarget);
        recursive(1, from, to);
        recursive(board - 1, upperTarget, to);
    }
}
