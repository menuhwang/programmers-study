import java.io.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        try (br; bw) {
            int X = Integer.parseInt(br.readLine());
            String binary = Integer.toBinaryString(X);

            int count = 0;
            for (int i = 0; i < binary.length(); i++) {
                if (binary.charAt(i) == '1') {
                    count++;
                }
            }

            bw.write(count + "\n");

            bw.flush();
        }
    }
}
