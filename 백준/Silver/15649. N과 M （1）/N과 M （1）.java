import java.io.*;
import java.util.StringTokenizer;

class Main {
    private static boolean[] flag;
    private static StringBuilder sb;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        try {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            flag = new boolean[N];

            sb = new StringBuilder();

            permutation(M);

            bw.flush();

        } finally {
            br.close();
            bw.close();
        }

    }

    private static void permutation(int len) throws IOException {
        if (sb.length() == len) {
            for (int i = 0; i < sb.length(); i++) {
                bw.write(sb.charAt(i) + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < flag.length; i++) {
            if (flag[i]) continue;

            sb.append(i + 1);
            flag[i] = true;
            permutation(len);
            sb.deleteCharAt(sb.length() - 1);
            flag[i] = false;
        }
    }
}
