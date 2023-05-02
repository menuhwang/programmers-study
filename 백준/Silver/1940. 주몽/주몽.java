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

        int left = 0;
        int right = N - 1;
        while (left < right) {
            int armor = materials[left] + materials[right];
            if (armor < M) {
                left++;
            } else if (armor > M) {
                right--;
            } else {
                result++;
                left++;
            }
        }

        System.out.println(result);
    }
}