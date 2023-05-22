import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Character>[] characterListArray = new List[15];
        for (int i = 0; i < 15; i++) characterListArray[i] = new ArrayList<>();

        String str;
        for (int i = 0; i < 5; i++) {
            str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                characterListArray[j].add(str.charAt(j));
            }
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < characterListArray[i].size(); j++) {
                bw.write(characterListArray[i].get(j));
            }
        }

        bw.flush();
        bw.close();
    }
}