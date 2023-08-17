import java.io.*;
import java.util.*;

public class Main {
    private static HashMap<String, Float> gradeTable = new HashMap<>();

    static {
        gradeTable.put("A+", 4.5F);
        gradeTable.put("A0", 4.0F);
        gradeTable.put("B+", 3.5F);
        gradeTable.put("B0", 3.0F);
        gradeTable.put("C+", 2.5F);
        gradeTable.put("C0", 2.0F);
        gradeTable.put("D+", 1.5F);
        gradeTable.put("D0", 1.0F);
        gradeTable.put("F", 0.0F);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        float sumUnits = 0.0F;
        float sumPoints = 0.0F;

        StringTokenizer st;
        String subject;
        float unit;
        String grade;
        float gradePoint;
        for (int i = 0; i < 20 ; i++) {
            st = new StringTokenizer(br.readLine());
            subject = st.nextToken();
            unit = Float.parseFloat(st.nextToken());
            grade = st.nextToken();
            if (grade.equals("P")) continue;

            gradePoint = gradeTable.get(grade);

            sumUnits += unit;
            sumPoints += unit * gradePoint;
        }

        System.out.println(sumPoints / sumUnits);
    }
}