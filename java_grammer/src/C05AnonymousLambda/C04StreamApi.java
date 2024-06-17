package C05AnonymousLambda;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class C04StreamApi {

    public static void main(String[] args) {

        int[] arr = {20, 10, 4, 12};

        // 전통적인 방식의 데이터 접근 방식 : 메모리 주소 접근
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        System.out.println("==============streamAPI===============");
        // 함수형 프로그래밍 방식 : 데이터와 객체 중심이 아닌, 입력에 따른 출력만 존재
        // java에서 함수형 프로그래밍을 지원하기 위한 라이브러리가 streamAPI
        // foreach : 스트림의 각 요소를 소모하면서 동작을 수행
        Arrays.stream(arr).forEach(a-> System.out.println(a));
        // stream이라는 가상의 흐름을 가져와서 arr의 원본이 아니라 복사본을 사용하는 것 => 데이터의 안정성 향상
        IntStream arr2 = Arrays.stream(arr).map(a->a*10);
        System.out.println(Arrays.toString(arr2.toArray()));


        // 스트림의 생성
        String[] stArr = {"html", "css", "java", "python", "javascript"};
        Stream<String> stream1 = Arrays.stream(stArr); // 배열로 스트림 생성

        List<String> stList = new ArrayList<>(Arrays.asList(stArr));
        Stream<String> stream2 = stList.stream(); // 리스트로 스트림 생성

        // 기본형 자료 (int)는 별도의 stream 제공
        int[] intArr = {10, 20, 30, 40, 50};
        // Stream<Integer> stream3 = Arrays.stream(intArr); 이렇게 말고
        IntStream stream3 = Arrays.stream(intArr); // IntStream을 제공

        // List<Integer>의 경우 -> int가 아니라 Integer이기 때문에 가능
        List<Integer> myList = new ArrayList<>();
        myList.add(10);
        myList.add(20);
        myList.add(30);
        Stream<Integer> stream4 = myList.stream(); // Integer라 가능

        // stream 변환 (중개연산) : filter, map, sorted, distinct, limit
        // filter : 특정 기준으로 대상을 filtering 하는 것
        // 참조 변수의 스트림변환의 경우 제네릭의 타입소거 문제 발생
        // 제네릭의 타입 소거란 => 제네릭 타입을 런타임 시점에는 제거하는 것을 의미
        // 그래서, 타입이 소거된 Stream 객체에서 배열로 변환하려면 => 타입이 뭔지 명시해줘야 함 (타입 캐스팅)
        String[] newArr = Arrays.stream(stArr) // 여기까지 stream 생성
                .filter(a->a.length()<=4) // a에는 stArr 값 하나씩 들어옴 (길이가 <=4인 것만 필터링)
                .toArray(a->new String[a]); // a변수에는 stream 요소의 개수 ( 타입 캐스팅 )
        System.out.println(Arrays.toString(newArr)); // [html, css, java]

        String[] newArr2 = Arrays.stream(stArr)
                .filter(a->a.length() <= 4)
                .toArray(String[]::new); // 메소드 참조 방식 => 클래스::메소드
        // (매개변수가 하나만 있을 때 매개변수를 생략하는 방식)
        System.out.println(Arrays.toString(newArr2)); // [html, css, java]

        // int일 때 사용
        int[] newIntArr = Arrays.stream(intArr)
                .filter(a->a<=30)
                .toArray(); // IntStream 자체를 사용하기 때문에 toArray 사용 가능
        System.out.println(Arrays.toString(newIntArr)); // [10, 20, 30]

        int[] newIntArr2 = Arrays.stream(intArr)
                .distinct() // 중복제거
                .toArray();
        System.out.println(Arrays.toString(newIntArr2)); // [10, 20, 30, 40, 50]

        // map : 기존의 스트림을 조작하여 새로운 스트림 반환
        int[] newMapArr = Arrays.stream(intArr).map(a->a*10).toArray(); // 새로운 배열에 넣어짐
        System.out.println(Arrays.toString(newMapArr)); // [100, 200, 300, 400, 500]


        // 실습
        // 홀수 찾기 filter 사용
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int[] newArrr = Arrays.stream(arr1)
                .filter(a->a%2!=0)
                .toArray();
        System.out.println(Arrays.toString(newArrr)); // [1, 3, 5]

        // filter와 map 사용
        int[] newArrrr = Arrays.stream(arr1)
                .filter(a->a%2!=0)
                .map(a->a*a)
                .toArray();
        System.out.println(Arrays.toString(newArrrr)); // [1, 9, 25]

        int[] aa = Arrays.stream(arr1)
                .filter(a->a%2!=0)
                .map(a->a*a)
                .sorted() // 오름차순 (comparator로 내림차순하는게 int는 안됨)
                .toArray();
        System.out.println(Arrays.toString(aa)); // [1, 9, 25]

        // mapToInt : intStream 형태로 변환해주는 map
        // stArr가지고와서 각 문자열의 길이를 담은 새로운 int배열 생성
        // String[] stArr = {"html", "css", "java", "python", "javascript"};
        int[] bb = Arrays.stream(stArr)
                .mapToInt(a->a.length()) // 그냥 map 사용하면 안되고, 매핑해서 int로 바꿔주는 mapToInt를 사용해야 길이가 정수로 변함
                .limit(3)
                .toArray();
        System.out.println(Arrays.toString(bb)); // limit 없을 때 : [4, 3, 4, 6, 10] // limit붙이면 : [4, 3, 4]


        System.out.println("=============스트림의 소모===============");
        // 스트림의 소모 -> sum : 합계, reduce : 누적연산, foreacrh(출력) 등

        // foreach
        int[] intArr2 = {10, 20, 30, 40};
        //Arrays.stream(intArr2).forEach(System.out::println); // 클래스::메소드
        //Arrays.stream(intArr2).forEach(a-> System.out.println(a)); // 위랑 같음

        // reduce
        // reduce(초기값, 연산식);
        int allMultiply = Arrays.stream(intArr2).reduce(1, (a, b) -> a * b); // 240000
        int allAdd = Arrays.stream(intArr2).reduce(0, (a, b) -> a + b); // 100
        System.out.println(allMultiply);
        System.out.println(allAdd);

        String stAllAdd = Arrays.stream(stArr).reduce("", (a, b) -> a + b);
        System.out.println(stAllAdd); // htmlcssjavapythonjavascript


        int intArrSum = Arrays.stream(intArr2).sum();
        // optional 객체 : 값이 있을 수도 있고, 없을 수도 있음을 명시한 객체
        int intArrMax = Arrays.stream(intArr2).max().getAsInt(); // 값을 꺼내겠다
        int intArrMin = Arrays.stream(intArr2).min().getAsInt();
        int intArrCnt = (int)Arrays.stream(intArr2).count(); // long타입이라 -> int로 변경


        // findFirst, findAny
        List<Student> students = new ArrayList<>();
        students.add(new Student("kim", 20));
        students.add(new Student("choi", 32));
        students.add(new Student("lee", 35));
        students.add(new Student("park", 22));

        // 나이가 30이 넘는 학생 중에 첫번째 index 값을 가지는 학생 객체 생성
        Student s1 = students.stream()
                .filter(a->a.getAge() >= 30)
                .findFirst()
                .get();
        System.out.println(s1); // 이름 : choi, 나이 : 32 (Student 클래스에 toString으로 출력 형식 만들었음)

        // student 객체 실습
        // (1) 모든 객체의 평균 나이
        int avgAge = (int)students.stream()
                .mapToInt(a->a.getAge())
                .average()
                .getAsDouble();
        System.out.println("나이 평균 : " + avgAge); // 27


        // (2) 가장 나이 어린 사람 찾기
        Student s2 = students.stream()
                .sorted((a, b) -> a.getAge() - b.getAge()) // 나이를 기준으로 오름차순 (대부분 sort엔 comparator식 사용 가능)
                .findFirst()
                .get();
        System.out.println(s2); // 이름 : kim, 나이 : 20

        // (3) 30대가 몇명인지
        int num = (int)students.stream()
                .filter(a->a.getAge()>= 30)
                .count();
        System.out.println("30대 : " + num); // 30대 : 2

        // (4) 30대 배열의 이름을 String 배열에 담기
        String[] name = students.stream()
                .filter(a->a.getAge()>=30)
                .map(a->a.getName())
                .toArray(String[]::new);
        System.out.println(Arrays.toString(name)); // [choi, lee]


        // Optional 객체 : 특정 객체에 값이 없을지도 모른다는 것을 명시적으로 표현
        // ofNullable : null이 있을 수도 있는 경우에 optional 객체를 생성하는 메소드
        Optional<String> opt = Optional.ofNullable(null);
        String st1 = null;
        if (opt.isPresent()) {
            System.out.println(opt.get().compareTo("hello"));
        } else {
            System.out.println("값이 없습니다.");
        }

        Optional<String> opt1 = Optional.empty();
        Optional<String> opt2 = Optional.of("hello"); // null이 못들어감 -> 값이 있을 때만 of를 사용
        Optional<String> opt3 = Optional.ofNullable("hello"); // null이 들어갈 수 있음 -> 만약 null이 있을 수도 있다면 ofNullable 사용

        // Optional 객체 처리 방법 4가지
        // 방법1 isPresent() 확인 후 get()
        if (opt2.isPresent()) {
            System.out.println(opt2.get().length());
        }

        // 방법2 orElse() : 값이 있으면 있는 값 return, 없음녀 지정값 return
        System.out.println(opt3.orElse("").length());
        // 방법3 orElseGet() : 값이 있으면 있는값 return, 없으면 람다함수 실행
        System.out.println(opt3.orElseGet(()->new String("")).length());
        // 방법4 orElseThrow() : 가장 중요 ⭐
        System.out.println(opt3.orElseThrow(() -> new NoSuchElementException("값이 없습니다.")).length());



       /* List<Student> students = new ArrayList<>();
        students.add(new Student("kim", 20));
        students.add(new Student("kim1", 21));
        students.add(new Student("kim2", 23));
        students.add(new Student("kim3", 25));

        // 방법1 -> null일 경우 예외처리
        OptionalDouble answer = students.stream().filter(a->a.getAge()>=29).mapToInt(a->a.getAge()).average();
        if (answer.isPresent()) {
            System.out.println(answer.getAsDouble());
        } else {
            System.out.println("값이 없습니다. ");
        }

        // 방법2
        double answer2 = students.stream()
                .filter(a->a.getAge()>=29)
                .mapToInt(a->a.getAge())
                .average()
                .orElseThrow(()->new NoSuchElementException("값이 없습니다."));*/
    }
}
