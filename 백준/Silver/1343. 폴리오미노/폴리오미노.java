import java.io.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            String board = br.readLine();

            board = board.replaceAll("XXXX", "AAAA")
                        .replaceAll("XX", "BB");

            bw.write((board.contains("X") ? "-1" : board) + "\n");

            bw.flush();
        }
    }
}
