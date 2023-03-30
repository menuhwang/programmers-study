import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int num;
        while((num = Integer.parseInt(br.readLine())) != -1) {
            StringBuilder sb = new StringBuilder(num + " ");
            int sum = 0;
            List<Integer> factor = new ArrayList<>();
            for (int i = 2; i * i < num; i++) {
                if (num % i == 0) {
                    factor.add(i);
                    sum += i;
                    factor.add(num / i);
                    sum += num / i;
                }
            }
            double sqrt = Math.sqrt(num);
            if (sqrt == Math.floor(sqrt)) {
                factor.add((int) sqrt);
                sum += (int) sqrt;
            }
            
            factor.add(1);
            sum += 1;
            
            if (sum == num) {
                factor.sort(Comparator.naturalOrder());
                sb.append("= ");
                for (int i = 0; i < factor.size(); i++) {
                    sb.append(factor.get(i));
                    if (i < factor.size() - 1) sb.append(" + ");
                }
            } else {
                sb.append("is NOT perfect.");
            }
            
            sb.append("\n");
            
            bw.write(sb.toString());
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}