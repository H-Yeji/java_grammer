package C01Basic;

import com.sun.source.tree.WhileLoopTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class C06String {

    public static void main(String[] args) {

        // 참조자료형 : 기본 자료형을 제외한 모든 자료형
        // wrapper 클래스 : 기본형 타입을 wrapping한 클래스
        // int 와 Integer 간 형변환
        /*int a = 10;
        Integer b = new Integer(20);*/

        // 오토 언박싱 : Integer -> int 형변환
        //int c = b;
        // 오토 박싱
        //Integer d = a;

        // String과 int의 형변환
        /*int a = 10;
        // int -> String
        String st1 = Integer.toString(a);
        String st2 = String.valueOf(a);

        // String -> int
        int b = Integer.parseInt(st1);*/


        // 참조 자료형에 원시자료형을 담을 때는 wrapper 클래스를 써야한다
        List<Integer> list1 = new ArrayList<>();
        list1.add(10);

        // 숫자는 0으로 초기화
        // 문자는 null로 초기하
        // boolean false

        // String 변수 생성방법
        /*String st1 = new String("hello"); // 객체 생성 방식
        String st2 = "hello"; // 리터럴 방식*/

        // ⭐⭐
        // 배열과 기본 자료형
        // arrayList, HashMap, HashSet => wrapper 클래스 사용
        // ex) List<Integer> myList = new ArrayList<>(); 이런식으로

        // String 변수 생성 방법
        // 객체 생성
        /*String st1 = new String("hello");
        // 리터럴 방식 : 권장하는 방식
        // 문자열 pool 을 통해 성능향상
        String st2 = "hello"; // hello를 담은 주소를 가리킴
        String st3 = new String("hello");
        String st4 = "hello"; // hello를 담은 주소를 가리킴 => st2==st4가 true 출력하는 이유

        // st1과 st3가 같은가
        System.out.println(st1 == st3); // false
        // st2와 st4가 같은가
        System.out.println(st2 == st4); // true
        // st3와 st4가 같은가
        System.out.println(st3 == st4); // false
        // == 는 권장하지 않음

        // st1의 힙메모리를 가지고와서 st3 힙메모리와 비교 (equals 사용하면 값비교)
        System.out.println(st1.equals(st3)); // true
        System.out.println(st2.equals(st4)); // true
        System.out.println(st3.equals(st4)); // true */

        /*System.out.println("hello".equals("hello")); // true
        System.out.println("hello".equals("Hello")); // false -> 대소문자
        System.out.println("hello".equalsIgnoreCase("Hello")); // true (대소문자 상관없이 비교)

        // 문자열 길이 : length()
        String st1 = "hello java java";
        System.out.println(st1.length());

        // indexOf : 특정 문자열의 위치를 반환, 가장 먼저 나오는 문자열의 위치
        int index1 = st1.indexOf("java");
        System.out.println(index1);
        System.out.println(st1.lastIndexOf("java")); // 마지막 문자열의 index

        // contains : 특정 문자열이 있는지 여부를 boolean으로 리턴
        System.out.println(st1.contains("hello"));
        System.out.println(st1.contains("world"));

        // charAt : 특정 index의 문자값을 리턴
        String st = "abcbdefasdfasdf";
        char ch1 = st.charAt(1);
        char ch2 = st.charAt(3);
        System.out.println(ch1==ch2); // char 비교는 equals가 아니라 ==*/


        // 실습
        // 위의 문자열에 a의 개수가 몇개인지 count
        //String st = "abcbdefasdfasdf";
        /*int count = 0;
        for (int i = 0; i < st.length(); i++) {
            char ch = st.charAt(i);
            if (ch == 'a')
                count++;
        }
        System.out.println(count);*/

        // toCharArray() : String 문자열을 char배열로 리턴
        /*System.out.println(Arrays.toString(st.toCharArray())); // list 형태로 각 문자를 하나씩 원소로 출력

        // 실습2
        // toCharArray를 활용해서 a가 몇갠지 count, 향상된 for문 사용
        char[] stArr = st.toCharArray(); // char 형태로 받는거라 배열 선언도 char
        int count = 0;
        for (char i: stArr) {
            //System.out.println(i);
            if (i == 'a')
                count++;
        }
        System.out.println(count);*/

        // 문자열 더하기 : +=
        /*String st1 = "hello";
        st1 += " world"; // 그냥 이어서 붙여짐*/
        // 위 방법이 성능이 떨어지는 이유
        // 문자열 => 불변객체라 원본이 변하지 않는다 => +=를 하면 st1이 재선언 된 것 (재할당=> 값을 메모리에 가져다 할당하기 때문에 느림)
        // 즉, 연산 자체는 안느린데 메모리를 가져다가 재할당 하는 그 시간이 오래걸림

        // substring(a, b) : a 이상 b 미만의 index의 문자를 잘라 리턴
        /*String st1 = "hello world";
        System.out.println(st1.substring(0, 5)); // 파이썬에서 슬라이싱이랑 같음
        System.out.println(st1.substring(6, 11));*/

        // trim, strip : 문자열 양쪽 끝의 공백 제거
        /*String trimSt1 = " hello world ";
        String trimSt2 = trimSt1.trim(); // 양쪽 공백제거
        System.out.println(trimSt2); // hello world
        String trimSt3 = trimSt1.strip();
        System.out.println(trimSt3);*/

        // touppercase : 대문자로 변환/ tolowercase : 소문자로 변환
        /*String s1 = "hello";
        String s2 = s1.toUpperCase();
        System.out.println(s2);

        String s3 = s1.toLowerCase();
        System.out.println(s3);

        // char > String 변환
        char ch1 = 'a';
        String st1 = Character.toString(ch1);
        char ch2 = st1.charAt(0);
        System.out.println(ch2);*/

        // replace(a, b) : a문자열을 b 문자열로 대체
        /*String st1 = "hello world";
        String st2 = st1.replace("world", "java");
        System.out.println(st2);*/

        // replaceAll(a, b) : replace와 동일, 정규표현식을 쓸 수 있음
        //String st1 = "01abc12ABC3한aa글123"; // 숫자, 알파벳, 한글 등이 섞여있을 때

        // 실습
        // for문을 활용해서 알파벳을 제거
        /*char[] stArr = st1.toCharArray();
        String answer = "";
        for (char i: stArr) {
            if (i >= 'a' && i <= 'z')
                continue;
            else
                answer += i;
        }
        System.out.println(answer);*/

        // replaceAll과 정규표현식 활용
        // 왼쪽(대상)이 나오면 오른쪽(공백)으로 대체하겠다
        // [a-z]+ : a-z 한 개 이상의 소문자 알파벳 표현하는 정규표현식
        // [A-Za-z]+ : 대소문자 포함
        // [가-힣]+ : 한글
        // [0-9]+ : 숫자
        /*String st1 = "01abc12ABC3한aa글123";
        String answer = st1.replaceAll("[A-Za-z]+" ,"");
        System.out.println(answer);

        // String의 matches와 Pattern.matches()
        String test = "helloA";
        System.out.println(test.matches("[A-Za-z]+")); // 대소문자로 이루어져있나요 확인

        boolean b1 = Pattern.matches("[0-9]+", "12345");
        System.out.println(b1); // true*/

        // ^정규표현식의 시작, $: 정규 표현식의 끝
        /*String st1 = "01abc12ABC3한aa글123";
        boolean b2 = Pattern.matches("^[A-Za-z]+$", st1);
        System.out.println(b2);*/

        // 전화번호 패턴 검증
        /*Scanner sc = new Scanner(System.in);
        while(true) {
            String number = sc.nextLine();
            //Boolean check = false;
            if (Pattern.matches("^\\d{3}-\\d{4}-\\d{4}$", number)) {
                //check = true;
                System.out.println("올바르게 입력함");
            } else {
                System.out.println("틀림");
            }
        }*/

        // 이메일 검증 : 알파벳과 숫자로 이루어진 id@알파벳(소문자).알파벳(소문자)
        /*Scanner sc = new Scanner(System.in);
        String email = sc.nextLine();
        boolean b3 = Pattern.matches("^[a-z0-9]+@[a-z]+.com$", email);
        System.out.println(b3);*/

        // split : 특정 문자를 기준으로 문자열을 자르는 것. 문자열 배열을 return
        /*String a = "a:b:c:d";
        String[] a_Arr = a.split(":");
        System.out.println(Arrays.toString(a_Arr));

        // \s : 공백
        String b = "a b c  d";
        System.out.println(Arrays.toString(b.split("\\s+"))); // escape문 사용하고, +를 사용해서 하나 이상

        // isEmpty와 null(자료타입)
        String st1 = null;
        String st2 = "";

        // equals 관계 아님
        System.out.println(st1==st2); // false
        // 문제발생x
        System.out.println(st2.isEmpty()); // true
        // 문제발생o : NullPointerException 발생
        //System.out.println(st1.isEmpty()); // error (null이라 empty 확인x)
        // null일 때 확인 (equals 사용x, ==로 확인)
        if (st1 != null) {
            System.out.println(st1.isEmpty()); // false
        } else {
            System.out.println("null임");
        }*/

        // join : Strint[]을 하나의 String 만드는 메서드
        /*String[] arr = {"java", "python", "C++", "javascript"};
        String st = String.join(" ", arr);
        System.out.println(st);

        // StringBuffer
        StringBuffer sb1 = new StringBuffer("hello");
        sb1.append(" java");
        sb1.append(" world");
        String answer = sb1.toString(); // toString으로 형변환
        System.out.println(answer);

        sb1.insert(5, " python"); // index 넣어서 사이에 넣기
        System.out.println(sb1);

        sb1.delete(17, sb1.length()); // index로 world 자르기
        System.out.println(sb1);


        // StringBuilder -> 얘가 성능 좋음 코테에서 이거 사용
        // String += <StringBuffer < StringBuilder
        // StringBuilder는 thread safe X
        StringBuilder sb3 = new StringBuilder();
        sb3.append("hello");
        sb3.append("\n"); // 줄바꿈
        sb3.append("world");
        System.out.println(sb3);*/

        // 실습
        // StringBuilder를 사용해서
        String my_string = "hello";
        int n = 3; // hhheeellllllooo
        char[] ch = my_string.toCharArray();

        StringBuilder sb2 = new StringBuilder();
        for (char i:ch) {
            for (int j = 0; j < n; j++) {
                sb2.append(i);
            }
        }
        System.out.println(sb2.toString());

    }
}
