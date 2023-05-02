import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] materials = new int[N];
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            materials[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(materials);

        int result = 0;
        for (int i = N - 1; i > -1; i--) {
            for (int j = 0; j < i; j++) {
                if (materials[i] + materials[j] == M) result++;
                else if (materials[i] + materials[j] > M) break;
            }
        }

        System.out.println(result);
    }
}