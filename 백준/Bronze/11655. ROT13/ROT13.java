import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch + 13);
                ch = ch <= 'z' ? ch : (char) (ch - 26);
            } else if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 13);
                ch = ch <= 'Z' ? ch : (char) (ch - 26);
            }

            bw.write(ch);
        }
        bw.flush();
        br.close();
        bw.close();
    }
}