import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String string = br.readLine();
        
        int[][] memo = new int[string.length() + 1][26];
        
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            for (int j = i; j < string.length(); j++) {
                memo[j + 1][ch-97]++;
            }
        }
        
        int Q = Integer.parseInt(br.readLine());
        char ch;
        int s;
        int e;
        StringTokenizer st;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            ch = st.nextToken().charAt(0);
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            
            bw.write((memo[e + 1][ch-97] - memo[s][ch-97]) + "\n");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}