import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        MyIntQueue myIntQueue = new MyIntQueue(N);
        
        for (int i = 0; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();
            int num;
            
            switch (cmd) {
                case "push":
                    num = Integer.parseInt(st.nextToken());
                    myIntQueue.push(num);
                    break;
                case "pop":
                    bw.write(myIntQueue.pop() + "\n");
                    break;
                case "size":
                    bw.write(myIntQueue.size() + "\n");
                    break;
                case "empty":
                    bw.write(myIntQueue.isEmpty() + "\n");
                    break;
                case "front":
                    bw.write(myIntQueue.front() + "\n");
                    break;
                case "back":
                    bw.write(myIntQueue.back() + "\n");
                    break;
                default:
                    break;
            }
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
    
    static class MyIntQueue {
        private final int[] elements;
        private int index = 0;
        private int pivot = 0;
        
        MyIntQueue(int n) {
            elements = new int[n];
        }
        
        void push(int num) {
            elements[index++] = num;
        }
        
        int pop() {
            return pivot < index ? elements[pivot++] : -1;
        }
        
        int size() {
            return index - pivot;
        }
        
        int isEmpty() {
            return size() == 0 ? 1 : 0;
        }
        
        int front() {
            return pivot < index ? elements[pivot] : -1;
        }
        
        int back() {
            return pivot < index ? elements[index - 1] : -1;
        }
    }
}