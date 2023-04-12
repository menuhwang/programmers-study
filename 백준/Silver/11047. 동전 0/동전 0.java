import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int count = 0;
        
        Stack<Integer> units = new Stack<>();
        for (int i = 0; i < N; i++) {
            units.push(Integer.parseInt(br.readLine()));
        }
        
        int unit;
        while (!units.isEmpty() && K > 0) {
            unit = units.pop();
            count += K / unit;
            K %= unit;
        }
        
        System.out.print(count);
        
        br.close();
    }
}
