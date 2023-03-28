# 알고리즘

## 나만의 체크리스트

문제 풀때 '이게 왜 틀리지?' 싶은 경우 체크해 볼만한 리스트

1. 숫자 타입 체크
   > **int**의 범위 확인. int로 받아와 계산하다보면 21억이 넘어갈 수 있으니 체크
   > 
   > 그럴땐 long으로 형 변환(캐스팅) 필요.
   > 
   > tip. 파라미터 타입을 수정하는 방법도 가능!
   
## 풀이법
1. 최대 공약수: **유클리드 호제법**
2. 소수: **에라토스테네스 체**

## 백준 사용법
1. 제출

   풀이 제출 시 클래스 명은 Main으로 할 것.

   Main 클래스 안에 main(psvm) 안에 코드를 작성해서 제출!

   > 예시
   >
   >```java
   >public class Main {
   >    public static void main(String[] args) {
   >        // code
   >    }
   >}
   >```

2. 쓰기

   반복문 안에서 System.out.println()으로 출력할 경우 속도가 느릴수 있다고 한다.

   따라서 java.io 의 BufferedWriter와 OutputStreamWriter을 사용한다.

   - 주의사항
      1. `import java.io.*;` 잊지말고 반드시 추가
      2. main 메소드에 `throws IOException` 추가

   > 예시
   >
   >```java
   >import java.io.*;
   >
   >public class Main {
   >    public static void main(String[] args) throws IOException {
   >        BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
   >        bw.write("Hello World!");
   >        bw.flush();
   >        bw.close();
   >    }
   >}
   >```

3. 읽기

   Scaner로 읽어오는 것은 속도가 느리다고하니 BufferedReader를 사용하도록 한다.
   
   한 줄에 여러 단어, 숫자가 입력되 나눠야하는 경우 String.split() 보다는 StringTokenizer를 사용한다.
   
   - 주의사항
      1. StringTokenizer를 사용할때는 `java.util.*;`를 추가할 것.
      2. BufferedReader.readLine()은 반환 값이 String이므로 숫자의 경우 캐스팅이 필요.
      3. BufferedWriter.write()는 파라미터에 숫자를 넣을 수 없다고하니 String으로 변환하여 넣어줄 것.
         - StringBuilder에 append하고 StringBuilder.toString()을 써주는것도 방법이 될 수 있을 듯
   
   > 예시
   >
   > ```
   > import java.io.*;
   > import java.util.*;
   > 
   > public class Main {
   >     public static void main(String[] args) throws IOException {
   >         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   >         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
   >         
   >         StringTokenizer st = new StringTokenizer(br.readLine(), " ");
   >         
   >         int A = Integer.parseInt(st.nextToken());
   >         int B = Integer.parseInt(st.nextToken());
   >         
   >         bw.write(String.valueOf(A + B));
   >         bw.flush();
   >         bw.close();
   >     }
   >}
   > ```
