import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer stN = new StringTokenizer(br.readLine());
        
        int M = Integer.parseInt(br.readLine());
        StringTokenizer stM = new StringTokenizer(br.readLine());
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(stN.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(stM.nextToken());
            st.append(map.getOrDefault(num, 0))
                .append(" ");
        }
        
        System.out.println(st);
    }
}