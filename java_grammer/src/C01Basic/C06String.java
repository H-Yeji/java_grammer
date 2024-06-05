package C01Basic;

import java.util.ArrayList;
import java.util.List;

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
        int a = 10;
        // int -> String
        String st1 = Integer.toString(a);
        String st2 = String.valueOf(a);

        // String -> int
        int b = Integer.parseInt(st1);


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


    }
}
