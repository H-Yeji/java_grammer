package C06EtcClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C03GenericMain {

    public static void main(String[] args) {

        String[] stArr = {"java", "python", "c"};
         // 0번째 1번째 swap
        //stChange(stArr, 0, 1);
        //System.out.println(Arrays.toString(stArr));

        Integer[] intArr = {10, 20, 30};
        //intChange(intArr, 0, 1);
        //System.out.println(Arrays.toString(intArr));

        // => 근데 두 코드가 타입만 다를 뿐, 중복이 있음
        // 어떻게 해야 공통으로 메소드를 생성할 수 있나 !
        // => Generic 사용
        genericChange(stArr, 0, 1);
        System.out.println(Arrays.toString(stArr)); // [python, java, c]

        genericChange(intArr, 0, 1);
        System.out.println(Arrays.toString(intArr)); // [20, 10, 30]


        Person p1 = new Person();
        p1.setValue("yeji"); // 이자리에 다른 타입을 넣고 싶다면 ?

        GenericPerson<String> p2 = new GenericPerson<>();
        p2.setValue("yeji");
        System.out.println(p2.getValue());

        GenericPerson<Integer> p3 = new GenericPerson<>();
        p3.setValue(1234);
        System.out.println(p3.getValue());

        // 제네릭 사용
        List<String> myList = new ArrayList<>();
        myList.add("hello");
        myList.add("java");


        // 제네릭 생성 방식
        // (1) 메서드 : 반환 타입 왼쪽 <T>
        // (2) 클래스 : 클래스명 오른쪽 <T>

        // 컴파일 후 제네릭 소거
       /* List myList = new ArrayList<>();
        myList.add("hello");
        myList.add("java");*/

    }

    // 제네릭 메서드 생성 : 반환타입 왼쪽에 <T> 선언
    // 유의점 : 제네릭은 객체 타입이 들어와야 함
    static <T>void genericChange(T[] stArr, int a, int b) {

        T tmp;
        tmp = stArr[a];
        stArr[a] = stArr[b];
        stArr[b] = tmp;
    }

    static void stChange(String[] stArr, int a, int b) {

        String tmp;
        tmp = stArr[a];
        stArr[a] = stArr[b];
        stArr[b] = tmp;
    }

    static void intChange(Integer[] intArr, int a, int b) {

        Integer tmp = intArr[a];
        intArr[a] = intArr[b];
        intArr[b] = tmp;
    }
}

// 제네릭 클래스는 클래스명 앞에 <T> 선언
class GenericPerson<T> {

    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}

class Person {
    String value;

    // getter, setter
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}


