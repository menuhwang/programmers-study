import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        int num;
        
        boolean flag;
        
        int sum;
        
        for (int n = 0; n < N; n++) {
            num = Integer.parseInt(br.readLine());
            flag = false;
            
            for (int i = 1; i <= 1000 && !flag; i++) {
                for (int j = 1; j <= 1000 && !flag; j++) {
                    for (int k = 1; k <= 1000 && !flag; k++) {
                        sum = sigma(i) + sigma(j) + sigma(k);
                        if (num == sum) flag = true;
                        else if (num < sum) break;
                    }
                }
            }

            bw.write(flag ? "1\n" : "0\n");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
    
    private static int sigma(int n) {
        return n * (n + 1) / 2;
    }
}