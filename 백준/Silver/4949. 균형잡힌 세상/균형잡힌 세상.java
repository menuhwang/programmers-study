import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Stack<Character> stack;
        
        String st;
        
        while((st = br.readLine()).length() > 1) {
            stack = new Stack<>();
            for (char ch : st.toCharArray()) {
                if (!isBracket(ch)) continue;
                if (stack.isEmpty()) {
                    stack.push(ch);
                    if (isClosingBracket(ch)) break;
                    else continue;
                }
                if (isPair(stack.peek(), ch)) {
                    stack.pop();
                    continue;
                }
                stack.push(ch);
            }
            bw.write(stack.isEmpty() ? "yes\n" : "no\n");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
    private static boolean isBracket(char ch) {
        return ch == '(' || ch == ')' || ch == '[' || ch == ']';
    }
    
    private static boolean isClosingBracket(char ch) {
        return ch == ')' || ch == ']';
    }
    
    private static boolean isPair(char ch1, char ch2) {
        return (ch1 == '(' && ch2 == ')') || (ch1 == '[' && ch2 == ']');
    }
}